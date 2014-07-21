package com.github.K0zka.finder4j.backtrack.examples.sudoku;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.K0zka.finder4j.backtrack.examples.sudoku.SudokuState;
import com.github.K0zka.finder4j.backtrack.examples.sudoku.SudokuStep;
import com.github.K0zka.finder4j.backtrack.examples.sudoku.SudokuStepFactory;

public class SudokuStepFactoryTest {
	@Test
	public void produce() {
		Short[][] board = new Short[][] {
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null }
				};
		List<SudokuStep> steps = new SudokuStepFactory().produce(new SudokuState(board));
		Assert.assertFalse(steps.isEmpty());
	}

	@Test
	public void produceColumn() {
		Short[][] board = new Short[][] {
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ null, 9, 8, 7, 5, 6, 4, 3, 2 },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null }
				};
		List<SudokuStep> steps = new SudokuStepFactory().produce(new SudokuState(board));
		Assert.assertTrue(steps.isEmpty());
	}

	@Test
	public void produceColumn2() {
		Short[][] board = new Short[][] {
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 6, 9, 8, 7, 1, 3, 4, 5, 2 },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null }
				};
		List<SudokuStep> steps = new SudokuStepFactory().produce(new SudokuState(board));
		Assert.assertFalse(steps.isEmpty());
	}

}
