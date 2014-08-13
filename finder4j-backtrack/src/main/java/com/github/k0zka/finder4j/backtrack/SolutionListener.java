package com.github.k0zka.finder4j.backtrack;


/**
 * Collect solutions while running.
 */
public interface SolutionListener<X extends State, S extends Step<X>> {
	void onSolution(X state);
}
