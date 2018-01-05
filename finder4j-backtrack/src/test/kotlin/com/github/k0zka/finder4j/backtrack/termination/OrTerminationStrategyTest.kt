package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.TerminationStrategy
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Assert.assertFalse
import org.junit.Test

class OrTerminationStrategyTest {

	private val strategy1: TerminationStrategy<State> = mock()

	private val strategy2: TerminationStrategy<State> = mock()

	private val strategy3: TerminationStrategy<State> = mock()

	private val state: State = mock()

	@Test
	fun stopWithTrue() {
		whenever(strategy1.stop(eq(state))).thenReturn(false)
		whenever(strategy2.stop(eq(state))).thenReturn(true)
		Assert.assertTrue(
				OrTerminationStrategy(listOf(strategy1, strategy2, strategy3)).stop(
						state))
		verify(strategy3, never()).stop(state)
		verify(strategy2, times(1)).stop(state)
		verify(strategy1, times(1)).stop(state)
	}

	@Test
	fun stopWithFalse() {
		whenever(strategy1.stop(eq(state))).thenReturn(false)
		whenever(strategy2.stop(eq(state))).thenReturn(false)
		whenever(strategy3.stop(eq(state))).thenReturn(false)
		assertFalse(
				OrTerminationStrategy(listOf(strategy1, strategy2, strategy3)).stop(
						state))
		verify(strategy3, times(1)).stop(state)
		verify(strategy2, times(1)).stop(state)
		verify(strategy1, times(1)).stop(state)
	}

}
