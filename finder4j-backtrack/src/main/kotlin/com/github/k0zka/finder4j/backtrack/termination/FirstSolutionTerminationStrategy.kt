package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.SolutionListener
import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.Step
import com.github.k0zka.finder4j.backtrack.TerminationStrategy

/**
 * Terminate the search after the first solution is received.
 *
 * @param <X>
 * @param <S>
</S></X> */
class FirstSolutionTerminationStrategy<X : State, S : Step<X>> : TerminationStrategy<X>, SolutionListener<X> {

	var solution: X? = null

	override fun onSolution(state: X) {
		this.solution = state
	}

	override fun stop(state: X): Boolean {
		return this.solution != null
	}
}
