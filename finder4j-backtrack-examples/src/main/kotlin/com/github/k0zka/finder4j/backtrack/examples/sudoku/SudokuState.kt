package com.github.k0zka.finder4j.backtrack.examples.sudoku

import com.github.k0zka.finder4j.backtrack.State

class SudokuState(internal val sudoku: Array<ShortArray>) : State {

	override val isComplete: Boolean
		get() {
			for (row in sudoku) {
				for (num in row) {
					if (num == notSet) {
						return false
					}
				}
			}
			return true
		}

	init {
		if (sudoku.size != sudokuRowSize.toInt() && sudoku[0].size != sudokuRowSize.toInt()) {
			throw IllegalArgumentException("Requires " + sudokuRowSize
												   + " * " + sudokuRowSize + " array")
		}
	}

	override fun toString(): String {
		val str = StringBuilder()
		for (row in sudoku) {
			for (num in row) {
				str.append(num)
				str.append(' ')
			}
			str.append('\n')
		}
		return str.toString()
	}

	companion object {
		val notSet = (-1).toShort()
		internal val sudokuGridSize: Short = 3
		internal val sudokuRowSize = (sudokuGridSize * sudokuGridSize).toShort()
	}

}
