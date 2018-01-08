package com.github.k0zka.finder4j.backtrack

import org.slf4j.LoggerFactory
import java.util.LinkedList

object Backtrack {

	private val logger = LoggerFactory
			.getLogger(Backtrack::class.java)

	internal class BackTrackState<X : Any, S : Step<X>>(val state: X, val steps: Iterator<S>)

	/**
	 * Run a backtracking algorithm on a problem
	 *
	 * @param state
	 * @param factory
	 * @param terminationStrategy
	 * @param listener
	 */
	fun <X : State, S : Step<X>> backtrack(
			state: X,
			factory: StepFactory<S, X>,
			terminationStrategy: TerminationStrategy<X>,
			listener: SolutionListener<X>) {
		backtrack(state, factory, terminationStrategy, listener, null)
	}

	fun <X : State, S : Step<X>> backtrack(
			state: X,
			factory: StepFactory<S, X>,
			terminationStrategy: TerminationStrategy<X>,
			listener: SolutionListener<X>,
			parallelTrack: ParallelTrack<X, S>?) {
		backtrack(state, factory, terminationStrategy, listener, parallelTrack, { it.complete })
	}

	/**
	 * Run a backtracking algorithm on a problem
	 *
	 * @param state        the start state for the search
	 * @param factory    produces new steps from a state
	 * @param terminationStrategy    decides when to terminate the search
	 * @param listener        the listener receives the results
	 * @param parallelTrack    (optional) service to run search tasks in parallel
	 * @param check        check if a state is complete
	 */
	fun <X : Any, S : Step<X>> backtrack(
			state: X,
			factory: StepFactory<S, X>,
			terminationStrategy: TerminationStrategy<X>,
			listener: SolutionListener<X>,
			parallelTrack: ParallelTrack<X, S>? = null,
			check: (X) -> Boolean) {

		logger.debug("Starting backtrack")

		val stack = LinkedList<BackTrackState<X, S>>()
		var head = state
		// initial state
		var btState = BackTrackState(state, factory
				.produce(state).iterator())

		while (!terminationStrategy.stop(btState.state)) {
			if (btState.steps.hasNext()) {
				// take next step
				val step = btState.steps.next()
				// just a short check if the other's have enough to do.
				// if taking multiple steps is enabled
				if (parallelTrack != null) {
					val steps = btState.steps
					fork(parallelTrack,
						 head, steps)
				}

				logger.debug("Taking step {}", step)
				// save the state for possible return
				stack.push(btState)
				// create new state
				head = step.take(head)
				// move to new state
				btState = BackTrackState(head, factory.produce(head)
						.iterator())
				logger.debug("Step ahead to {}")

				// check if new state is complete, notify if so
				if (check(head)) {
					listener.onSolution(head)
				}
			} else {
				// no steps available, try to step back
				if (stack.isEmpty()) {
					// if stepping back is not possible, there is no solution
					logger.debug("no (more) solution possible, exiting")
					return
				} else {
					// step back
					btState = stack.pop()
					head = btState.state
					logger.debug("Steping back to {}", head)
				}
			}
		}
		logger.debug("termination strategy decided to stop, exiting backtrack")
	}

	private fun <X : Any, S : Step<X>> fork(
			parallelTrack: ParallelTrack<X, S>,
			head: X,
			steps: Iterator<S>) {
		// as long as
		// there are possible next steps
		// and computing resources available
		while (steps.hasNext() && parallelTrack.available()) {
			// get the next step
			val parallelStep = steps.next()
			// take a next step
			val forkedStep = parallelStep.take(head)
			// leave the parallel process running
			parallelTrack.start(forkedStep)
		}
	}
}
