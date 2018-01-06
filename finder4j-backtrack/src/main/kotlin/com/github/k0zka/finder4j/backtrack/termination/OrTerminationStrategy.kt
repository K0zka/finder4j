package com.github.k0zka.finder4j.backtrack.termination

import java.util.ArrayList

import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.TerminationStrategy

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
