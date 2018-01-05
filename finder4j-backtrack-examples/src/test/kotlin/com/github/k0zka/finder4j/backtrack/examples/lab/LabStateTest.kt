package com.github.k0zka.finder4j.backtrack.examples.lab

import org.junit.Assert
import org.junit.Test

class LabStateTest {
	@Test
	fun isComplete() {
		val state = LabState(arrayOf(arrayOf(LabObject.Exit)),
							 listOf(Position(0, 0)))
		Assert.assertTrue(state.complete)
	}

	@Test
	fun isCompleteNotComplete() {
		val state = LabState(
				arrayOf(arrayOf(LabObject.Floor, LabObject.Exit), arrayOf(LabObject.Floor, LabObject.Floor)),
				listOf(Position(0, 0)))
		Assert.assertFalse(state.complete)
	}

	@Test
	fun testToString() {
		println(LabState(25, 25))
	}

}
