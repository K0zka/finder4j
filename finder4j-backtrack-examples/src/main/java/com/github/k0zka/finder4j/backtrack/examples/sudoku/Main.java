package com.github.k0zka.finder4j.backtrack.examples.sudoku;

import com.github.k0zka.finder4j.backtrack.Backtrack;
import com.github.k0zka.finder4j.backtrack.termination.FirstSolutionTerminationStrategy;

public class Main {
	private final static Short n = null;

	public static void main(String[] args) {
		Short[][] board = new Short[][] {
				{ n, n, 9, 3, n, n, n, n, n },
				{ n, 3, n, 6, n, 2, n, 4, n },
				{ 6, n, 8, n, n, 9, n, n, n },
				{ 3, 7, n, n, n, n, 5, 8, n },
				{ n, n, n, n, 5, n, n, n, n },
				{ n, 5, 2, n, n, n, n, 6, 7 },
				{ n, n, n, 5, n, n, 2, n, 1 },
				{ n, 1, n, 7, n, 4, n, 3, n },
				{ n, n, n, n, n, 6, 9, n, n }};
		final SudokuState state = new SudokuState(board);
		final FirstSolutionTerminationStrategy<SudokuState, SudokuStep> terminationStrategy = new FirstSolutionTerminationStrategy<SudokuState, SudokuStep>();
		Backtrack.backtrack(state, new SudokuStepFactory(),
				terminationStrategy, terminationStrategy);
		System.out.println(terminationStrategy.getSolution());
	}
}
