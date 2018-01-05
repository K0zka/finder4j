package com.github.k0zka.finder4j.backtrack

import com.nhaarman.mockito_kotlin.atLeast
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.After
import org.junit.Before
import org.junit.Test

class BacktrackServiceTest {

	private var state: State = mock()

	private var finalState: State = mock()

	private var step1: Step<State> = mock()

	var step2: Step<State> = mock()

	var factory: StepFactory<Step<State>, State> = mock()

	var listener: SolutionListener<State, Step<State>> = mock()

	var terminationStrategy: TerminationStrategy<State> = mock()

	var service: BacktrackService? = null

	@Before
	fun startup() {
		// for testing, enforce having 4 workers even if the number of actual
		// CPUs is less
		service = BacktrackService(4)
	}

	@After
	fun cleanup() {
		service?.stop()
	}

	@Test
	fun backtrackParallel() {
		whenever(factory.produce(eq(state))).thenReturn(
				listOf(step1, step2))
		whenever(factory.produce(eq(finalState))).thenReturn(
				listOf())
		whenever(step1.take(eq(state))).thenReturn(finalState)
		whenever(step2.take(eq(state))).thenReturn(finalState)
		whenever(finalState.complete).thenReturn(true)

		service!!.backtrack(state, factory, terminationStrategy, listener)

		verify(listener, atLeast(1)).onSolution(
				eq(finalState))
	}

}
