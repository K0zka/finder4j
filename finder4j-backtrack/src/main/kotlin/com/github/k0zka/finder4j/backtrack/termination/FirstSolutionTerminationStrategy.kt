package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.SolutionListener
import com.github.k0zka.finder4j.backtrack.TerminationStrategy

/**
 * Terminate the search after the first solution is received.
 *
 * @param <X>
 */
open class FirstSolutionTerminationStrategy<X : Any> : TerminationStrategy<X>, SolutionListener<X> {

	var solution: X? = null

	override fun onSolution(state: X) {
		this.solution = state
	}

	override fun stop(state: X): Boolean {
		return this.solution != null
	}
}
