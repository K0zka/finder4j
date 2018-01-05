package com.github.k0zka.finder4j.backtrack.examples.queens

import com.github.k0zka.finder4j.backtrack.Backtrack
import com.github.k0zka.finder4j.backtrack.SolutionListener
import com.github.k0zka.finder4j.backtrack.TerminationStrategy
import com.github.k0zka.finder4j.backtrack.listener.LoggerSolutionListener
import com.github.k0zka.finder4j.backtrack.termination.AllSolutionsTerminationStrategy

object Main {
	@JvmStatic
	fun main(args: Array<String>) {
		val terminationStrategy = AllSolutionsTerminationStrategy<QueensState>()
		val listener = LoggerSolutionListener<QueensState, QueensStep>()
		Backtrack
				.backtrack(
						QueensState(),
						QueensStepFactory(),
						terminationStrategy,
						listener)
	}
}
