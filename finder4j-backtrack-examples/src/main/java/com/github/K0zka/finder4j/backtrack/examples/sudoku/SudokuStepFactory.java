package com.github.K0zka.finder4j.backtrack.examples.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.K0zka.finder4j.backtrack.StepFactory;

public class SudokuStepFactory implements StepFactory<SudokuStep, SudokuState> {

	private final static class Pair {
		public Pair(short x, short y) {
			super();
			this.x = x;
			this.y = y;
		}

		final short x;
		final short y;

		short getX() {
			return x;
		}

		short getY() {
			return y;
		}
	}

	public List<SudokuStep> produce(SudokuState state) {
		final Pair targetSlot = getLastEmptySlot(state);
		if(targetSlot == null) {
			return Collections.emptyList();
		}
		final ArrayList<SudokuStep> ret = new ArrayList<SudokuStep>();

		final Set<Short> numbersThatCantBe = new HashSet<Short>();
		// add all numbers from the column, the row, and the cell
		for (short x = 0; x < SudokuState.sudokuRowSize; x++) {
			addIfNotNull(numbersThatCantBe,
					state.getSudoku()[x][targetSlot.getY()]);
		}
		for (short y = 0; y < SudokuState.sudokuRowSize; y++) {
			addIfNotNull(numbersThatCantBe,
					state.getSudoku()[targetSlot.getX()][y]);
		}
		final int gridX = targetSlot.getX() - (targetSlot.getX() % SudokuState.sudokuGridSize);
		for (int x = gridX; x < gridX + SudokuState.sudokuGridSize; x++) {
			final int gridY = targetSlot.getY() - (targetSlot.getY() % SudokuState.sudokuGridSize);
			for (int y = gridY; y < gridY + SudokuState.sudokuGridSize; y++) {
				final Short value = state.getSudoku()[x][y];
				addIfNotNull(numbersThatCantBe, value);
			}
		}

		for (short i = 1; i <= SudokuState.sudokuRowSize; i++) {
			if (!numbersThatCantBe.contains(i)) {
				ret.add(new SudokuStep(targetSlot.getX(), targetSlot.getY(), i));
			}
		}

		return ret;
	}

	private void addIfNotNull(final Set<Short> numbersThatCantBe,
			final Short value) {
		if (value != null) {
			numbersThatCantBe.add(value);
		}
	}

	private Pair getLastEmptySlot(SudokuState state) {
		// find first empty spot
		for (short x = 0; x < SudokuState.sudokuRowSize; x++) {
			for (short y = 0; y < SudokuState.sudokuRowSize; y++) {
				if (state.getSudoku()[x][y] == null) {
					return new Pair(x, y);
				}
			}
		}
		return null;
	}

}
