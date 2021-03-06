package com.github.k0zka.finder4j.backtrack.examples.lab

import org.junit.Assert
import org.junit.Test
import java.util.Arrays

class LabStepFactoryTest {
	@Test
	fun produce() {
		val map = arrayOf(arrayOf(LabObject.Floor, LabObject.Exit), arrayOf(LabObject.Floor, LabObject.Floor))
		val steps = LabStepFactory().produce(LabState(map, Arrays
				.asList(Position(1, 1))))
		Assert.assertFalse(steps.isEmpty())
	}

	@Test
	fun produceWithWalls() {
		val map = arrayOf(arrayOf(LabObject.Floor, LabObject.Wall, LabObject.Floor),
						  arrayOf(LabObject.Floor, LabObject.Floor, LabObject.Floor),
						  arrayOf(LabObject.Wall, LabObject.Exit, LabObject.Floor))
		val steps = LabStepFactory().produce(LabState(map, Arrays
				.asList(Position(0, 0))))
		Assert.assertEquals(1, steps.size.toLong())
		Assert.assertEquals(Position(1, 0), steps[0].stepTo)
	}

}
