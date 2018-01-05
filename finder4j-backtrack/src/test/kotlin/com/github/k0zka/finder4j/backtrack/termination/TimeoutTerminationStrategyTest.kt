package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.Step
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TimeoutTerminationStrategyTest {

	private val state: State = mock()

	@Test
	fun stop() {
		assertTrue(TimeoutTerminationStrategy<State, Step<State>>(
				System.currentTimeMillis() - 1000).stop(state))
		assertFalse(TimeoutTerminationStrategy<State, Step<State>>(
				System.currentTimeMillis() + 1000).stop(state))
	}
}
