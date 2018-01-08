package com.github.k0zka.finder4j.backtrack.examples.sudoku

import com.github.k0zka.finder4j.backtrack.Backtrack
import com.github.k0zka.finder4j.backtrack.termination.FirstSolutionTerminationStrategy

object Main {
	private val n: Short = SudokuState.notSet

	@JvmStatic
	fun main(args: Array<String>) {
		val board = arrayOf(arrayOf(n, n, 9, 3, n, n, n, n, n).toShortArray(),
							arrayOf(n, 3, n, 6, n, 2, n, 4, n).toShortArray(),
							arrayOf(6, n, 8, n, n, 9, n, n, n).toShortArray(),
							arrayOf(3, 7, n, n, n, n, 5, 8, n).toShortArray(),
							arrayOf(n, n, n, n, 5, n, n, n, n).toShortArray(),
							arrayOf(n, 5, 2, n, n, n, n, 6, 7).toShortArray(),
							arrayOf(n, n, n, 5, n, n, 2, n, 1).toShortArray(),
							arrayOf(n, 1, n, 7, n, 4, n, 3, n).toShortArray(),
							arrayOf(n, n, n, n, n, 6, 9, n, n).toShortArray())
		val state = SudokuState(board)
		val terminationStrategy = FirstSolutionTerminationStrategy<SudokuState>()
		Backtrack.backtrack(state, SudokuStepFactory(),
							terminationStrategy, terminationStrategy)
		println(terminationStrategy.solution)
	}
}
