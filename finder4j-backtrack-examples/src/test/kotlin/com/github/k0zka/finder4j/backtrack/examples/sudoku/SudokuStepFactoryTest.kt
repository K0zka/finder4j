package com.github.k0zka.finder4j.backtrack.examples.sudoku

import com.github.k0zka.finder4j.backtrack.examples.sudoku.SudokuState.Companion.notSet
import org.junit.Assert
import org.junit.Test

class SudokuStepFactoryTest {
	
	val n = notSet
	
	@Test
	fun produce() {
		val board = arrayOf(arrayOf(1.toShort(), 2.toShort(), 3.toShort(), 4.toShort(), 5.toShort(), 6.toShort(), 7.toShort(), 8.toShort(), 9.toShort()).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray())
		val steps = SudokuStepFactory().produce(SudokuState(board))
		Assert.assertFalse(steps.isEmpty())
	}

	@Test
	fun produceColumn() {
		val board = arrayOf(arrayOf(1.toShort(), 2.toShort(), 3.toShort(), 4.toShort(), 5.toShort(), 6.toShort(), 7.toShort(), 8.toShort(), 9.toShort()).toShortArray(),
							arrayOf(n, 9.toShort(), 8.toShort(), 7.toShort(), 5.toShort(), 6.toShort(), 4.toShort(), 3.toShort(), 2.toShort()).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray())
		val steps = SudokuStepFactory().produce(SudokuState(board))
		Assert.assertTrue(steps.isEmpty())
	}

	@Test
	fun produceColumn2() {
		val board = arrayOf(arrayOf(1.toShort(), 2.toShort(), 3.toShort(), 4.toShort(), 5.toShort(), 6.toShort(), 7.toShort(), 8.toShort(), 9.toShort()).toShortArray(),
							arrayOf(6.toShort(), 9.toShort(), 8.toShort(), 7.toShort(), 1.toShort(), 3.toShort(), 4.toShort(), 5.toShort(), 2.toShort()).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray(),
							arrayOf(n, n, n, n, n, n, n, n, n).toShortArray())
		val steps = SudokuStepFactory().produce(SudokuState(board))
		Assert.assertFalse(steps.isEmpty())
	}

}
