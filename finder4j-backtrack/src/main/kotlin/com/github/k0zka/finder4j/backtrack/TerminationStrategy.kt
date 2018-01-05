package com.github.k0zka.finder4j.backtrack

interface TerminationStrategy<X : State> {
	fun stop(state: X): Boolean
}
