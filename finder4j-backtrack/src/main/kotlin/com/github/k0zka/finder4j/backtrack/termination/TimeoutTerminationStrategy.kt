package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.TerminationStrategy

class TimeoutTerminationStrategy<X : Any>(private val timeout: Long) : TerminationStrategy<X> {

	override fun stop(state: X): Boolean {
		return System.currentTimeMillis() >= timeout
	}

}
