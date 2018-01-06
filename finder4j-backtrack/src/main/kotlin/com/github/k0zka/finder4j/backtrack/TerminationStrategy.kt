package com.github.k0zka.finder4j.backtrack

interface TerminationStrategy<in X : Any> {
	fun stop(state: X): Boolean
}
