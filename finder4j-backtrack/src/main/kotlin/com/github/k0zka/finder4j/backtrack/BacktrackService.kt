package com.github.k0zka.finder4j.backtrack

interface BacktrackService {

	fun stop()

	fun <X : State, S : Step<X>> backtrack(state: X,
										   factory: StepFactory<S, X>,
										   terminationStrategy: TerminationStrategy<X>,
										   listener: SolutionListener<X>)

	fun <X : Any, S : Step<X>> backtrack(state: X,
										 factory: StepFactory<S, X>,
										 terminationStrategy: TerminationStrategy<X>,
										 listener: SolutionListener<X>,
										 check : (X) -> Boolean)

}