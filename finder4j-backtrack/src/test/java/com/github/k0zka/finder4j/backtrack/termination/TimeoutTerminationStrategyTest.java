package com.github.k0zka.finder4j.backtrack.termination;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.Step;

@RunWith(MockitoJUnitRunner.class)
public class TimeoutTerminationStrategyTest {

	@Mock
	State state;

	@Test
	public void stop() {
		Assert.assertTrue(new TimeoutTerminationStrategy<State, Step<State>>(
				System.currentTimeMillis() - 1000).stop(state));
		Assert.assertFalse(new TimeoutTerminationStrategy<State, Step<State>>(
				System.currentTimeMillis() + 1000).stop(state));
	}
}
