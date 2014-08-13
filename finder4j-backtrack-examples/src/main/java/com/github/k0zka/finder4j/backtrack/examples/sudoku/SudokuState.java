package com.github.k0zka.finder4j.backtrack.examples.sudoku;

import com.github.k0zka.finder4j.backtrack.State;

@SuppressWarnings("serial")
public class SudokuState implements State {

	public SudokuState(Short[][] sudoku) {
		super();
		if (sudoku.length != sudokuRowSize && sudoku[0].length != sudokuRowSize) {
			throw new IllegalArgumentException("Requires " + sudokuRowSize
					+ " * " + sudokuRowSize + " array");
		}
		this.sudoku = sudoku;
	}

	final static short sudokuGridSize = 3;
	final static short sudokuRowSize = sudokuGridSize * sudokuGridSize;

	private final Short[][] sudoku;

	public boolean isComplete() {
		for(Short[] row : sudoku) {
			for(Short num : row) {
				if(num == null) {
					return false;
				}
			}
		}
		return true;
	}

	Short[][] getSudoku() {
		return sudoku;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(Short[] row : sudoku) {
			for(Short num : row) {
				str.append(num == null ? "?" : num);
				str.append(' ');
			}
			str.append('\n');
		}
		return str.toString();
	}

}
