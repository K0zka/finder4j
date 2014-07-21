package com.github.K0zka.finder4j.backtrack.examples.sudoku;

import java.util.Arrays;

import com.github.K0zka.finder4j.backtrack.Step;

@SuppressWarnings("serial")
public class SudokuStep implements Step<SudokuState> {

	public SudokuStep(short x, short y, short num) {
		super();
		this.x = x;
		this.y = y;
		this.num = num;
	}

	private final short num;
	private final short x;
	private final short y;

	public SudokuState take(SudokuState state) {
		final Short[][] copy = new Short[state.getSudoku().length][];
		for(int i = 0; i < state.getSudoku().length; i++) {
			copy[i] = Arrays.copyOf(state.getSudoku()[i], state.getSudoku().length);
		}
		copy[x][y] = num;
		return new SudokuState(copy);
	}

	public String toString() {
		return "{ [" + x + "," + y + "] <-" + num + " }";
	}
}
