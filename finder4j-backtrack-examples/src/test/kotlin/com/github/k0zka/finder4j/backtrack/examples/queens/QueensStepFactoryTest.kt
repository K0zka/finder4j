package com.github.k0zka.finder4j.backtrack.examples.queens

import com.github.k0zka.finder4j.backtrack.examples.queens.QueensState.Companion.notSet
import org.junit.Assert
import org.junit.Test

class QueensStepFactoryTest {
	@Test
	fun produce() {
		val steps = QueensStepFactory().produce(
				QueensState(arrayOf(1.toShort(), 1.toShort(), notSet, notSet).toShortArray()))
		Assert.assertFalse(steps.isEmpty())
	}
}
