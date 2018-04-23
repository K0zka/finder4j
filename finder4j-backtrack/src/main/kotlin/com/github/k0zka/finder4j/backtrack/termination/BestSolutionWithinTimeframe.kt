package com.github.k0zka.finder4j.backtrack.termination

import com.github.k0zka.finder4j.backtrack.SolutionListener
import com.github.k0zka.finder4j.backtrack.TerminationStrategy

/**
 *
 */
open class BestSolutionWithinTimeframe<X : Any>(
		/**
		 * Even if there are no solutions found at all, terminate after a maximum amount of time spent in search.
		 */
		val maxTime: Long,
		/**
		 * Even if there is already a solution, do not terminate and wait for new solutions
		 */
		val idealTime: Long,
		/**
		 * Compare the results
		 */
		val comparator: Comparator<X>,
		private val start: Long = System.currentTimeMillis(),
		private val clock: () -> Long = { System.currentTimeMillis() }) :
		TerminationStrategy<X>, SolutionListener<X> {

	init {
		check(idealTime < maxTime) { "ideal time ($idealTime) must be less than max time ($maxTime)" }
	}

	@Volatile
	private var best: X? = null

	fun getBestResult() = synchronized(this) { best }

	override fun stop(state: X): Boolean =
			(clock() - start).let { elapsed ->
				val hasResult = lazy {
					synchronized(this) {
						best != null
					}
				}

				elapsed > maxTime || (elapsed > idealTime && hasResult.value)
			}

	override fun onSolution(state: X) {
		synchronized(this) {
			if (best == null || comparator.compare(best, state) > 0) {
				best = state
			}
		}
	}
}