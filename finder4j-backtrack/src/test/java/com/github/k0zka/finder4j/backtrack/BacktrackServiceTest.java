package com.github.k0zka.finder4j.backtrack;

import java.util.Arrays;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BacktrackServiceTest {

	@Mock
	State state;

	@Mock
	State finalState;

	@Mock
	Step<State> step1;

	@Mock
	Step<State> step2;

	@Mock
	StepFactory<Step<State>, State> factory;

	@Mock
	SolutionListener<State, Step<State>> listener;

	@Mock
	TerminationStrategy<State> terminationStrategy;

	BacktrackService service;

	@Before
	public void startup() {
		// for testing, enforce having 4 workers even if the number of actual
		// CPUs is less
		service = new BacktrackService(4);
	}

	@After
	public void cleanup() {
		service.stop();
	}

	@Test
	public void backtrackParallel() {
		Mockito.when(factory.produce(Mockito.eq(state))).thenReturn(
				Arrays.asList(step1, step2));
		Mockito.when(factory.produce(Mockito.eq(finalState))).thenReturn(
				Collections.<Step<State>> emptyList());
		Mockito.when(step1.take(Mockito.eq(state))).thenReturn(finalState);
		Mockito.when(step2.take(Mockito.eq(state))).thenReturn(finalState);
		Mockito.when(finalState.isComplete()).thenReturn(true);

		service.backtrack(state, factory, terminationStrategy, listener);

		Mockito.verify(listener, Mockito.atLeast(1)).onSolution(
				Mockito.eq(finalState));
	}

}
