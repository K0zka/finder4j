package com.github.k0zka.finder4j.backtrack.examples.queens

import com.github.k0zka.finder4j.backtrack.examples.queens.QueensState.Companion.notSet
import org.junit.Assert
import org.junit.Test

class QueensStateTest {
	@Test
	fun isLegal() {
		val state = QueensState(arrayOf(1, notSet).toShortArray())
		Assert.assertTrue(state.isLegal)
	}

	@Test
	fun isLegalNegative() {
		var state = QueensState(arrayOf(1.toShort(), 1.toShort()).toShortArray())
		Assert.assertFalse(state.isLegal)

		state = QueensState(arrayOf(1.toShort(), 2.toShort()).toShortArray())
		Assert.assertFalse(state.isLegal)

		state = QueensState(arrayOf(1.toShort(), 3.toShort(), 1.toShort()).toShortArray())
		Assert.assertFalse(state.isLegal)

		state = QueensState(arrayOf(1.toShort(), 5.toShort(), 3.toShort()).toShortArray())
		Assert.assertFalse(state.isLegal)

	}

	@Test
	fun testToString() {
		println(QueensState(arrayOf(1.toShort(), 5.toShort(), 7.toShort(), 2.toShort()).toShortArray()))
		println(QueensState(
				arrayOf(1.toShort(), 5.toShort(), 7.toShort(), notSet, 1.toShort(), 5.toShort(), 7.toShort(),
						notSet).toShortArray()))
	}

}
