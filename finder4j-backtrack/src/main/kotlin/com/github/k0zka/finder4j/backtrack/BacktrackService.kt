package com.github.k0zka.finder4j.backtrack

import org.slf4j.LoggerFactory
import java.util.concurrent.ExecutionException
import java.util.concurrent.ForkJoinPool

/**
 *
 */
class BacktrackService @JvmOverloads constructor(nrOfCpus: Int = Runtime.getRuntime().availableProcessors()) {

	private val executorService: ForkJoinPool

	private inner class Worker<X : State, S : Step<X>> constructor(private val state: X,
																		   private val terminationStrategy: TerminationStrategy<X>,
																		   private val listener: SolutionListener<X, S>,
																		   private val factory: StepFactory<S, X>) :
			Runnable {

		override fun run() {
			logger.debug("starting backtrack from state {}", state)
			val tracker = LocalParallelTrack<X, S>(executorService)
			Backtrack.backtrack(state, factory, terminationStrategy, listener,
								tracker)
			tracker.join()
		}
	}

	init {
		this.executorService = ForkJoinPool(nrOfCpus)
	}

	fun <X : State, S : Step<X>> backtrack(state: X,
										   factory: StepFactory<S, X>,
										   terminationStrategy: TerminationStrategy<X>,
										   listener: SolutionListener<X, S>) {
		try {
			val future = executorService.submit(Worker(
					state, terminationStrategy, listener, factory))
			future.get()

		} catch (e: InterruptedException) {
			throw IllegalStateException(e)
		} catch (e: ExecutionException) {
			throw IllegalStateException(e)
		}

	}

	fun stop() {
		executorService.shutdown()
	}

	companion object {
		private val logger = LoggerFactory
				.getLogger(BacktrackService::class.java)
	}
}
