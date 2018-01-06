package com.github.k0zka.finder4j.backtrack

import org.slf4j.LoggerFactory
import java.util.Collections
import java.util.LinkedList
import java.util.concurrent.ExecutionException
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.Future

class LocalParallelTrack<X : State, S : Step<X>>(private val executor: ForkJoinPool) : ParallelTrack<X, S> {
	private val jobs = Collections
			.synchronizedList(LinkedList<Future<*>>())

	override fun available(): Boolean {
		return executor.runningThreadCount < executor.parallelism
	}

	override fun start(state: X,
					   stepFactory: StepFactory<S, X>,
					   terminationStrategy: TerminationStrategy<X>,
					   listener: SolutionListener<X>) {
		val parallelTrack = this
		jobs.add(executor.submit {
			Backtrack.backtrack(state, stepFactory, terminationStrategy,
								listener, parallelTrack)
		})
	}

	override fun join() {
		while (!jobs.isEmpty()) {
			val future = jobs.removeAt(0)
			try {
				future.get()
			} catch (e: InterruptedException) {
				logger.warn("Future did not work, something may be wrong {}",
							future, e)
			} catch (e: ExecutionException) {
				logger.warn("Future did not work, something may be wrong {}", future, e)
			}

		}
	}

	companion object {
		private val logger = LoggerFactory
				.getLogger(LocalParallelTrack::class.java)
	}
}
