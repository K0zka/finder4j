package com.github.k0zka.finder4j.backtrack.listener

import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.Step
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test

class LoggerSolutionListenerTest {
	private val state: State = mock()

	@Test
	fun onSolution() {
		LoggerSolutionListener<State, Step<State>>().onSolution(state)
		// verify that no error thrown: done
	}
}
