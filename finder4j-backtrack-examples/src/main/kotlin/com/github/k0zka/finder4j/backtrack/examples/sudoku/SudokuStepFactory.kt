package com.github.k0zka.finder4j.backtrack.examples.sudoku

import com.github.k0zka.finder4j.backtrack.StepFactory
import java.util.ArrayList
import java.util.HashSet

class SudokuStepFactory : StepFactory<SudokuStep, SudokuState> {

	private class Pair(internal val x: Short, internal val y: Short)

	override fun produce(state: SudokuState): List<SudokuStep> {
		val targetSlot = getLastEmptySlot(state) ?: return emptyList<SudokuStep>()
		val ret = ArrayList<SudokuStep>()

		val numbersThatCantBe = HashSet<Short>()
		// add all numbers from the column, the row, and the cell
		for (x in 0 until SudokuState.sudokuRowSize) {
			addIfNotNull(numbersThatCantBe,
						 state.sudoku[x][targetSlot.y.toInt()])
		}
		for (y in 0 until SudokuState.sudokuRowSize) {
			addIfNotNull(numbersThatCantBe,
						 state.sudoku[targetSlot.x.toInt()][y])
		}
		val gridX = targetSlot.x - targetSlot.x % SudokuState.sudokuGridSize
		for (x in gridX until gridX + SudokuState.sudokuGridSize) {
			val gridY = targetSlot.y - targetSlot.y % SudokuState.sudokuGridSize
			for (y in gridY until gridY + SudokuState.sudokuGridSize) {
				val value = state.sudoku[x][y]
				addIfNotNull(numbersThatCantBe, value)
			}
		}

		for (i in 1..SudokuState.sudokuRowSize) {
			if (!numbersThatCantBe.contains(i.toShort())) {
				ret.add(SudokuStep(targetSlot.x, targetSlot.y, i.toShort()))
			}
		}

		return ret
	}

	private fun addIfNotNull(numbersThatCantBe: MutableSet<Short>,
							 value: Short?) {
		if (value != null) {
			numbersThatCantBe.add(value)
		}
	}

	private fun getLastEmptySlot(state: SudokuState): Pair? {
		// find first empty spot
		for (x in 0 until SudokuState.sudokuRowSize) {
			for (y in 0 until SudokuState.sudokuRowSize) {
				if (state.sudoku[x][y] == SudokuState.notSet) {
					return Pair(x.toShort(), y.toShort())
				}
			}
		}
		return null
	}

}
