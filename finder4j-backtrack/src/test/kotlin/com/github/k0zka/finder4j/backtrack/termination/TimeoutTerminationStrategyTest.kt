package com.github.k0zka.finder4j.backtrack.termination

import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TimeoutTerminationStrategyTest {

	private val state: Any = mock()

	@Test
	fun stop() {
		assertTrue(TimeoutTerminationStrategy<Any>(
				System.currentTimeMillis() - 1000).stop(state))
		assertFalse(TimeoutTerminationStrategy<Any>(
				System.currentTimeMillis() + 1000).stop(state))
	}
}
