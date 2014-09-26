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
public class AndTerminationStrategyTest {
	@Mock
	TerminationStrategy<State> strategy1;

	@Mock
	TerminationStrategy<State> strategy2;

	@Mock
	TerminationStrategy<State> strategy3;

	@Mock
	State state;

	@Test
	public void stopTrue() {
		Mockito.when(strategy1.stop(Mockito.eq(state))).thenReturn(true);
		Mockito.when(strategy2.stop(Mockito.eq(state))).thenReturn(true);
		Mockito.when(strategy3.stop(Mockito.eq(state))).thenReturn(true);
		Assert.assertTrue(new AndTerminationStrategy<>(Arrays.asList(strategy1,
				strategy2, strategy3)).stop(state));
		Mockito.verify(strategy3, Mockito.times(1)).stop(state);
		Mockito.verify(strategy2, Mockito.times(1)).stop(state);
		Mockito.verify(strategy1, Mockito.times(1)).stop(state);
	}

	@Test
	public void stopFalse() {
		Mockito.when(strategy1.stop(Mockito.eq(state))).thenReturn(true);
		Mockito.when(strategy2.stop(Mockito.eq(state))).thenReturn(false);
		Mockito.when(strategy3.stop(Mockito.eq(state))).thenReturn(true);
		Assert.assertFalse(new AndTerminationStrategy<>(Arrays.asList(
				strategy1, strategy2, strategy3)).stop(state));
		Mockito.verify(strategy3, Mockito.never()).stop(state);
		Mockito.verify(strategy2, Mockito.times(1)).stop(state);
		Mockito.verify(strategy1, Mockito.times(1)).stop(state);

	}
}
