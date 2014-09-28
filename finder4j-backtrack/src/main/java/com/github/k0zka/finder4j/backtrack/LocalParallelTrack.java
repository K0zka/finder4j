package com.github.k0zka.finder4j.backtrack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalParallelTrack<X extends State, S extends Step<X>> implements
		ParallelTrack<X, S> {

	public LocalParallelTrack(final ForkJoinPool executor) {
		super();
		this.executor = executor;
	}

	private static final Logger logger = LoggerFactory
			.getLogger(LocalParallelTrack.class);

	private final ForkJoinPool executor;
	private final List<Future<?>> jobs = Collections
			.<Future<?>> synchronizedList(new LinkedList<Future<?>>());

	public boolean available() {
		return executor.getRunningThreadCount() < executor.getParallelism();
	}

	public void start(final X state, final StepFactory<S, X> factory,
			final TerminationStrategy<X> terminationStrategy,
			final SolutionListener<X, S> listener) {
		final ParallelTrack<X, S> parallelTrack = this;
		jobs.add(executor.submit(new Runnable() {

			public void run() {
				Backtrack.backtrack(state, factory, terminationStrategy,
						listener, parallelTrack);
			}
		}));
	}

	@Override
	public void join() {
		for (final Future<?> future : jobs) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				logger.warn("Future did not work, something may be wrong {}",
						future, e);
			}
		}
	}
}
