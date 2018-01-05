package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.Step
import com.github.k0zka.finder4j.backtrack.TerminationStrategy

class TimeoutTerminationStrategy<X : State, S : Step<X>>(private val timeout: Long) : TerminationStrategy<X> {

	override fun stop(state: X): Boolean {
		return System.currentTimeMillis() >= timeout
	}

}
