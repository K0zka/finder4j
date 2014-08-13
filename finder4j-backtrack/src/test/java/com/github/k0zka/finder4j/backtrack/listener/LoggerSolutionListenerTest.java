package com.github.k0zka.finder4j.backtrack.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.Step;

@RunWith(MockitoJUnitRunner.class)
public class LoggerSolutionListenerTest {
	@Mock
	State state;

	@Test
	public void onSolution() {
		new LoggerSolutionListener<State, Step<State>>().onSolution(state);
		// verify that no error thrown: done
	}
}
