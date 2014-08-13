package com.github.k0zka.finder4j.backtrack;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BacktrackTest {
	@Mock
	State state;

	@Mock
	StepFactory<Step<State>, State> stepFactory;

	@Mock
	TerminationStrategy<State> terminationStrategy;

	@Mock
	SolutionListener<State, Step<State>> listener;

	@Test
	public void backtrackNosolutionShort() {
		Mockito.when(terminationStrategy.stop(Matchers.any(State.class)))
				.thenReturn(false);
		Mockito.when(stepFactory.produce(Matchers.any(State.class)))
				.thenReturn(Collections.<Step<State>> emptyList());
		Backtrack.backtrack(state, stepFactory, terminationStrategy, listener);
	}
}
