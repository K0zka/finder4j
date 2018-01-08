package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.Step
import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert
import org.junit.Test

class FirstSolutionTerminationStrategyTest {

	internal var state: State = mock()

	@Test
	fun onSolution() {
		val strategy = FirstSolutionTerminationStrategy<State>()
		Assert.assertNull(strategy.solution)
		Assert.assertFalse(strategy.stop(state))
		strategy.onSolution(state)
		Assert.assertEquals(state, strategy.solution)
		Assert.assertTrue(strategy.stop(state))
	}
}
