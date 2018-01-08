package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.TerminationStrategy
import java.util.ArrayList

class OrTerminationStrategy<X : Any>(strategies: List<TerminationStrategy<X>>) : TerminationStrategy<X> {

	private val strategies: List<TerminationStrategy<X>>

	init {
		this.strategies = ArrayList(strategies)
	}

	override fun stop(state: X): Boolean {
		for (strategy in strategies) {
			if (strategy.stop(state)) {
				return true
			}
		}
		return false
	}

}
