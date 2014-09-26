package com.github.k0zka.finder4j.backtrack.termination;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.TerminationStrategy;

@RunWith(MockitoJUnitRunner.class)
public class OrTerminationStrategyTest {
	
	@Mock
	TerminationStrategy<State> strategy1;

	@Mock
	TerminationStrategy<State> strategy2;

	@Mock
	TerminationStrategy<State> strategy3;

	@Mock
	State state;

	@Test
	public void stopWithTrue() {
		Mockito.when(strategy1.stop(Mockito.eq(state))).thenReturn(false);
		Mockito.when(strategy2.stop(Mockito.eq(state))).thenReturn(true);
		Assert.assertTrue(new OrTerminationStrategy<State>(Arrays.asList(strategy1, strategy2, strategy3)).stop(state));
		Mockito.verify(strategy3, Mockito.never()).stop(state);
		Mockito.verify(strategy2, Mockito.times(1)).stop(state);
		Mockito.verify(strategy1, Mockito.times(1)).stop(state);
	}

	@Test
	public void stopWithFalse() {
		Mockito.when(strategy1.stop(Mockito.eq(state))).thenReturn(false);
		Mockito.when(strategy2.stop(Mockito.eq(state))).thenReturn(false);
		Mockito.when(strategy3.stop(Mockito.eq(state))).thenReturn(false);
		Assert.assertFalse(new OrTerminationStrategy<State>(Arrays.asList(strategy1, strategy2, strategy3)).stop(state));
		Mockito.verify(strategy3, Mockito.times(1)).stop(state);
		Mockito.verify(strategy2, Mockito.times(1)).stop(state);
		Mockito.verify(strategy1, Mockito.times(1)).stop(state);
	}

}
