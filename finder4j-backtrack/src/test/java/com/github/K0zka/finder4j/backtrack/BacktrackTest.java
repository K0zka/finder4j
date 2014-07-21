package com.github.K0zka.finder4j.backtrack;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.K0zka.finder4j.backtrack.Backtrack;
import com.github.K0zka.finder4j.backtrack.SolutionListener;
import com.github.K0zka.finder4j.backtrack.State;
import com.github.K0zka.finder4j.backtrack.Step;
import com.github.K0zka.finder4j.backtrack.StepFactory;
import com.github.K0zka.finder4j.backtrack.TerminationStrategy;

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
		Mockito.when(terminationStrategy.stop(Mockito.any(State.class)))
				.thenReturn(false);
		Mockito.when(stepFactory.produce(Mockito.any(State.class))).thenReturn(
				Collections.<Step<State>> emptyList());
		Backtrack.backtrack(state, stepFactory, terminationStrategy, listener);
	}
}
