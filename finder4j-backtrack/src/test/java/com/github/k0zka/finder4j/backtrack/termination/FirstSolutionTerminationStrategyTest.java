package com.github.k0zka.finder4j.backtrack.termination;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.Step;

@RunWith(MockitoJUnitRunner.class)
public class FirstSolutionTerminationStrategyTest {

	@Mock
	State state;

	@Test
	public void onSolution() {
		FirstSolutionTerminationStrategy<State, Step<State>> strategy = new FirstSolutionTerminationStrategy<State, Step<State>>();
		Assert.assertNull(strategy.getSolution());
		Assert.assertFalse(strategy.stop(state));
		strategy.onSolution(state);
		Assert.assertEquals(state, strategy.getSolution());
		Assert.assertTrue(strategy.stop(state));
	}
}
