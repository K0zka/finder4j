package com.github.K0zka.finder4j.backtrack;

import java.util.Iterator;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Backtrack {

	private static final Logger logger = LoggerFactory
			.getLogger(Backtrack.class);

	final static class BackTrackState<X extends State, S extends Step<X>> {
		public BackTrackState(final X state, final Iterator<S> steps) {
			super();
			this.state = state;
			this.steps = steps;
		}

		private final X state;
		private final Iterator<S> steps;

		public X getState() {
			return state;
		}

		public Iterator<S> getSteps() {
			return steps;
		}
	}

	/**
	 * Run a backtracking algorithm on a problem
	 * 
	 * @param state
	 * @param factory
	 * @param terminationStrategy
	 * @param listener
	 * @param step
	 */
	public static <X extends State, S extends Step<X>> void backtrack(
			final X state, final StepFactory<S, X> factory,
			final TerminationStrategy<X> terminationStrategy,
			final SolutionListener<X, S> listener) {

		logger.debug("Starting backtrack");

		final LinkedList<BackTrackState<X, S>> stack = new LinkedList<BackTrackState<X, S>>();
		X head = state;
		// initial state
		BackTrackState<X, S> btState = new BackTrackState<X, S>(state, factory
				.produce(state).iterator());

		while (!terminationStrategy.stop(btState.getState())) {
			if (!btState.getSteps().hasNext()) {
				// no steps available, try to step back
				if (stack.isEmpty()) {
					// if stepping back is not possible, there is no solution
					logger.debug("no (more) solution possible, exiting");
					return;
				} else {
					// step back
					btState = stack.pop();
					head = btState.getState();
					logger.debug("Steping back to {}", head);
				}
			} else {
				// take next step
				final Step<X> step = btState.getSteps().next();
				logger.debug("Taking step {}", step);
				// save the state for possible return
				stack.push(btState);
				// create new state
				head = step.take(head);
				// move to new state
				btState = new BackTrackState<X, S>(head, factory.produce(head)
						.iterator());
				logger.debug("Step ahead to {}");

				// check if new state is complete, notify if so
				if (head.isComplete()) {
					listener.onSolution(head);
				}
			}
		}
		logger.debug("termination strategy decided to stop, exiting backtrack");
	}
}
