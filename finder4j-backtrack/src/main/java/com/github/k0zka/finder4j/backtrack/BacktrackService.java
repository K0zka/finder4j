package com.github.k0zka.finder4j.backtrack;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */
public class BacktrackService {
	private static final Logger logger = LoggerFactory
			.getLogger(BacktrackService.class);

	private final class Worker<X extends State, S extends Step<X>> implements
			Runnable {
		private final X state;
		private final TerminationStrategy<X> terminationStrategy;
		private final SolutionListener<X, S> listener;
		private final StepFactory<S, X> factory;

		private Worker(X state, TerminationStrategy<X> terminationStrategy,
				SolutionListener<X, S> listener, StepFactory<S, X> factory) {
			this.state = state;
			this.terminationStrategy = terminationStrategy;
			this.listener = listener;
			this.factory = factory;
		}

		public void run() {
			logger.debug("starting backtrack from state {}", state);
			Backtrack.backtrack(state, factory, terminationStrategy, listener,
					new LocalParallelTrack<X, S>(executorService));
		}
	}

	private final ForkJoinPool executorService;

	public BacktrackService() {
		this(Runtime.getRuntime().availableProcessors());
	}

	public BacktrackService(final int nrOfCpus) {
		this.executorService = new ForkJoinPool(nrOfCpus);
	}

	public <X extends State, S extends Step<X>> void backtrack(final X state,
			final StepFactory<S, X> factory,
			final TerminationStrategy<X> terminationStrategy,
			final SolutionListener<X, S> listener) {
		try {
			final Future<?> future = executorService.submit(new Worker<X, S>(
					state, terminationStrategy, listener, factory));
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			throw new IllegalStateException(e);
		}
	}

	public void stop() {
		executorService.shutdown();
	}
}
