package com.github.k0zka.finder4j.backtrack.examples.queens


import org.junit.Assert
import org.junit.Test

import com.github.k0zka.finder4j.backtrack.examples.queens.QueensState
import com.github.k0zka.finder4j.backtrack.examples.queens.QueensStep

class QueensStepTest {
	@Test
	fun take() {
		val state = QueensState(arrayOf(1.toShort()).toShortArray())
		val step = QueensStep(0.toShort(), 2.toShort())
		val newState = step.take(state)
		Assert.assertEquals(2, newState.queens[0].toShort().toLong())
	}
}
