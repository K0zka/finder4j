package com.github.k0zka.finder4j.backtrack;

import java.util.Arrays;
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
	State completeState;

	@Mock
	StepFactory<Step<State>, State> stepFactory;

	@Mock
	TerminationStrategy<State> terminationStrategy;

	@Mock
	SolutionListener<State, Step<State>> listener;

	@Mock
	Step<State> step;
	
	@Test
	public void backtrackNosolutionShort() {
		Mockito.when(terminationStrategy.stop(Matchers.any(State.class)))
				.thenReturn(false);
		Mockito.when(stepFactory.produce(Matchers.any(State.class)))
				.thenReturn(Collections.<Step<State>> emptyList());
		Backtrack.backtrack(state, stepFactory, terminationStrategy, listener);
		Mockito.verify(listener, Mockito.never()).onSolution(Mockito.any(State.class));;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void backtrackSingleStepToComplete() {
		Mockito.when(terminationStrategy.stop(Mockito.eq(state))).thenReturn(false);
		Mockito.when(terminationStrategy.stop(Mockito.eq(completeState))).thenReturn(true);
		Mockito.when(completeState.isComplete()).thenReturn(true);
		Mockito.when(stepFactory.produce(Mockito.eq(state))).thenReturn(Arrays.asList(step));
		Mockito.when(step.take(Mockito.eq(state))).thenReturn(completeState);
		Backtrack.backtrack(state, stepFactory, terminationStrategy, listener);
		Mockito.verify(listener, Mockito.never()).onSolution(state);
		Mockito.verify(listener).onSolution(completeState);
	}
}
