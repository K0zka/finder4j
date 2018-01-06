package com.github.k0zka.finder4j.backtrack

/**
 * Collect solutions while running.
 */
interface SolutionListener<in X : Any> {
	fun onSolution(state: X)
}
