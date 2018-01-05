package com.github.k0zka.finder4j.backtrack.examples.sudoku

import java.util.Arrays

import com.github.k0zka.finder4j.backtrack.Step

class SudokuStep(private val x: Short, private val y: Short, private val num: Short) : Step<SudokuState> {

	override fun take(state: SudokuState): SudokuState {
		val copy = Array<ShortArray>(state.sudoku.size,
										  {i -> Arrays.copyOf(state.sudoku[i], state.sudoku.size)}
		)
		for (i in 0 until state.sudoku.size) {
			copy[i] = state.sudoku[i].copyOf()
		}
		copy[x.toInt()][y.toInt()] = num
		return SudokuState(copy)
	}

	override fun toString(): String {
		return "{ [$x,$y] <-$num }"
	}
}
