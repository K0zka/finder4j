package com.github.k0zka.finder4j.backtrack.examples.queens

import org.junit.Assert
import org.junit.Test

import com.github.k0zka.finder4j.backtrack.examples.queens.QueensState
import com.github.k0zka.finder4j.backtrack.examples.queens.QueensState.Companion.notSet
import com.github.k0zka.finder4j.backtrack.examples.queens.QueensStep
import com.github.k0zka.finder4j.backtrack.examples.queens.QueensStepFactory

class QueensStepFactoryTest {
	@Test
	fun produce() {
		val steps = QueensStepFactory().produce(QueensState(arrayOf(1.toShort(), 1.toShort(), notSet, notSet).toShortArray()))
		Assert.assertFalse(steps.isEmpty())
	}
}
