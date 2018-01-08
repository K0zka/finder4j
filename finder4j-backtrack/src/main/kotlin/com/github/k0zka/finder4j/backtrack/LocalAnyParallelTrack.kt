package com.github.k0zka.finder4j.backtrack

import java.util.concurrent.ForkJoinPool

class LocalAnyParallelTrack<X : Any, S : Step<X>>(
		executor: ForkJoinPool,
		private val stepFactory: StepFactory<S, X>,
		private val terminationStrategy: TerminationStrategy<X>,
		private val listener: SolutionListener<X>,
		private val check: (X) -> Boolean
) : AbstractParallelTrack<X, S>(executor) {
	override fun start(state: X) {
		submit {
			Backtrack.backtrack(state, stepFactory, terminationStrategy,
								listener, this, check)
		}
	}
}