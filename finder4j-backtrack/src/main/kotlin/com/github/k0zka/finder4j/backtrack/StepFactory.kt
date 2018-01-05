package com.github.k0zka.finder4j.backtrack

interface StepFactory<S : Step<X>, X : State> {
	fun produce(state: X): List<S>
}
