package com.github.k0zka.finder4j.backtrack.examples.lab

import org.junit.Assert
import org.junit.Test
import java.util.Arrays
import java.util.Arrays.asList

class LabStateTest {
	@Test
	fun isComplete() {
		val state = LabState(arrayOf(arrayOf(LabObject.Exit)),
							 asList(Position(0, 0)))
		Assert.assertTrue(state.isComplete)
	}

	@Test
	fun isCompleteNotComplete() {
		val state = LabState(
				arrayOf(arrayOf(LabObject.Floor, LabObject.Exit), arrayOf(LabObject.Floor, LabObject.Floor)),
				Arrays.asList(Position(0, 0)))
		Assert.assertFalse(state.isComplete)
	}

	@Test
	fun testToString() {
		println(LabState(25, 25))
	}

}
