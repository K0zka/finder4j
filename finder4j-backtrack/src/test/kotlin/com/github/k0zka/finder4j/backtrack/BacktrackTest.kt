package com.github.k0zka.finder4j.backtrack

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import java.util.Arrays

class BacktrackTest {

	private var state: State = mock()

	private var endState: State = mock()

	private var completeState: State = mock()

	private var stepFactory: StepFactory<Step<State>, State> = mock()

	private var terminationStrategy: TerminationStrategy<State> = mock()

	private var listener: SolutionListener<State, Step<State>> = mock()

	private var step: Step<State> = mock()

	@Test
	fun backtrackNosolutionShort() {
		whenever(terminationStrategy.stop(any()))
				.thenReturn(false)
		whenever(stepFactory.produce(any()))
				.thenReturn(listOf())
		Backtrack.backtrack(state, stepFactory, terminationStrategy, listener)
		verify(listener, never()).onSolution(
				any())
	}

	@Test
	fun backtrackSingleStepToComplete() {
		whenever(terminationStrategy.stop(eq(state))).thenReturn(false)
		whenever(terminationStrategy.stop(eq(completeState))).thenReturn(true)
		whenever(completeState.isComplete).thenReturn(true)
		whenever(stepFactory.produce(eq(state))).thenReturn(listOf(step))
		whenever(step.take(eq(state))).thenReturn(completeState)
		Backtrack.backtrack(state, stepFactory, terminationStrategy, listener)
		verify(listener, never()).onSolution(state)
		verify(listener).onSolution(completeState)
	}

	@Test
	fun backtrackSingleStepDeadEnd() {
		whenever(terminationStrategy.stop(any())).thenReturn(false)
		whenever(stepFactory.produce(eq(state))).thenReturn(listOf(step))
		whenever(step.take(eq(state))).thenReturn(endState)
		Backtrack.backtrack(state, stepFactory, terminationStrategy, listener)
		verify(step).take(state)
		verify(listener, never()).onSolution(
				any())
	}

}
