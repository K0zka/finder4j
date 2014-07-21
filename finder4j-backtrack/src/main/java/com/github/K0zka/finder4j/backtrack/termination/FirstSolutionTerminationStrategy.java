package com.github.K0zka.finder4j.backtrack.termination;

import com.github.K0zka.finder4j.backtrack.SolutionListener;
import com.github.K0zka.finder4j.backtrack.State;
import com.github.K0zka.finder4j.backtrack.Step;
import com.github.K0zka.finder4j.backtrack.TerminationStrategy;

/**
 * Terminate the search after the first solution is received.
 * @param <X>
 * @param <S>
 */
public class FirstSolutionTerminationStrategy<X extends State, S extends Step<X>>
		implements TerminationStrategy<X>, SolutionListener<X, S> {

	private X state = null;

	public boolean stop(X state) {
		return this.state != null;
	}

	public void onSolution(final X state) {
		this.state = state;
	}

	public X getSolution() {
		return state;
	}
}
