package com.github.k0zka.finder4j.backtrack.examples.queens;

import com.github.k0zka.finder4j.backtrack.Backtrack;
import com.github.k0zka.finder4j.backtrack.SolutionListener;
import com.github.k0zka.finder4j.backtrack.TerminationStrategy;
import com.github.k0zka.finder4j.backtrack.listener.LoggerSolutionListener;
import com.github.k0zka.finder4j.backtrack.termination.AllSolutionsTerminationStrategy;

public class Main {
	public static void main(String[] args) {
		TerminationStrategy<QueensState> terminationStrategy = new AllSolutionsTerminationStrategy<QueensState>();
		final SolutionListener<QueensState, QueensStep> listener = new LoggerSolutionListener<QueensState, QueensStep>();
		Backtrack
				.backtrack(
						new QueensState(),
						new QueensStepFactory(),
						terminationStrategy,
						listener);
	}
}
