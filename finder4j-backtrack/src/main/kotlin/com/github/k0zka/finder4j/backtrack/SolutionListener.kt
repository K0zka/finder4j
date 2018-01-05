package com.github.k0zka.finder4j.backtrack

/**
 * Collect solutions while running.
 */
interface SolutionListener<X : State, S : Step<X>> {
	fun onSolution(state: X)
}
