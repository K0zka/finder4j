package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.TerminationStrategy

open class AndTerminationStrategy<X : Any>(private val strategies: List<TerminationStrategy<X>>) : TerminationStrategy<X> {

	override fun stop(state: X): Boolean {
		for (strategy in strategies) {
			if (!strategy.stop(state)) {
				return false
			}
		}
		return true
	}

}
