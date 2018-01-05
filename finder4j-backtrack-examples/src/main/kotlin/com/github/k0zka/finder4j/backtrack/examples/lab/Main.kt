package com.github.k0zka.finder4j.backtrack.examples.lab

import java.util.Arrays

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import com.github.k0zka.finder4j.backtrack.Backtrack
import com.github.k0zka.finder4j.backtrack.termination.FirstSolutionTerminationStrategy

object Main {

	private val logger = LoggerFactory.getLogger(Main::class.java!!)

	@JvmStatic
	fun main(args: Array<String>) {
		val terminationStrategy = FirstSolutionTerminationStrategy<LabState, LabStep>()
		Backtrack.backtrack(
				LabState(arrayOf(arrayOf(LabObject.Floor, LabObject.Floor, LabObject.Floor, LabObject.Wall),
								 arrayOf(LabObject.Wall, LabObject.Floor, LabObject.Floor, LabObject.Wall),
								 arrayOf(LabObject.Wall, LabObject.Floor, LabObject.Wall, LabObject.Wall),
								 arrayOf(LabObject.Floor, LabObject.Monster, LabObject.Floor, LabObject.Exit)), Arrays
								 .asList(Position(0, 0))), LabStepFactory(),
				terminationStrategy, terminationStrategy)
		logger.info("Solution: ", terminationStrategy.solution)
	}

}
