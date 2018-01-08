package com.github.k0zka.finder4j.backtrack

import org.slf4j.LoggerFactory
import java.util.concurrent.ExecutionException
import java.util.concurrent.ForkJoinPool

/**
 *
 */
class BacktrackServiceImpl constructor(
		private val executorService: ForkJoinPool = ForkJoinPool(Runtime.getRuntime().availableProcessors())
) : BacktrackService {

	private inner class Worker<X : State, S : Step<X>> constructor(private val state: X,
																   private val terminationStrategy: TerminationStrategy<X>,
																   private val listener: SolutionListener<X>,
																   private val factory: StepFactory<S, X>) :
			Runnable {

		override fun run() {
			logger.debug("starting backtrack from state {}", state)
			val tracker = LocalParallelTrack<X, S>(executorService, factory, terminationStrategy, listener)
			Backtrack.backtrack(state, factory, terminationStrategy, listener,
								tracker)
			tracker.join()
		}
	}

	private inner class AnyWorker<X : Any, S : Step<X>> constructor(private val state: X,
																	private val terminationStrategy: TerminationStrategy<X>,
																	private val listener: SolutionListener<X>,
																	private val factory: StepFactory<S, X>,
																	private val check: (X) -> Boolean) :
			Runnable {

		override fun run() {
			logger.debug("starting backtrack from state {}", state)
			val tracker = LocalAnyParallelTrack<X, S>(executorService, factory, terminationStrategy, listener, check)
			Backtrack.backtrack(state, factory, terminationStrategy, listener,
								tracker, check)
			tracker.join()
		}
	}


	override fun <X : State, S : Step<X>> backtrack(state: X,
													factory: StepFactory<S, X>,
													terminationStrategy: TerminationStrategy<X>,
													listener: SolutionListener<X>) {
		doInThreadPool(Worker(
				state, terminationStrategy, listener, factory))
	}

	private fun doInThreadPool(
			worker: Runnable) {
		try {
			executorService.submit(worker).get()
		} catch (e: InterruptedException) {
			throw IllegalStateException(e)
		} catch (e: ExecutionException) {
			throw IllegalStateException(e)
		}
	}

	override fun <X : Any, S : Step<X>> backtrack(state: X,
												  factory: StepFactory<S, X>,
												  terminationStrategy: TerminationStrategy<X>,
												  listener: SolutionListener<X>,
												  check: (X) -> Boolean) {
		doInThreadPool(AnyWorker(state, terminationStrategy, listener, factory, check))
	}

	override fun stop() {
		executorService.shutdown()
	}

	companion object {
		private val logger = LoggerFactory
				.getLogger(BacktrackServiceImpl::class.java)
	}
}
