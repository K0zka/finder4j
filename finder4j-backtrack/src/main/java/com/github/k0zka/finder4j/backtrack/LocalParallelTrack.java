package com.github.k0zka.finder4j.backtrack;

import java.util.concurrent.ForkJoinPool;

public class LocalParallelTrack<X extends State, S extends Step<X>> implements
		ParallelTrack<X, S> {

	public LocalParallelTrack(final ForkJoinPool executor) {
		super();
		this.executor = executor;
	}

	private final ForkJoinPool executor;

	public boolean available() {
		return executor.getRunningThreadCount() < executor.getParallelism();
	}

	public void start(final X state, final StepFactory<S, X> factory,
			final TerminationStrategy<X> terminationStrategy,
			final SolutionListener<X, S> listener) {
		final ParallelTrack<X, S> parallelTrack = this;
		executor.submit(new Runnable() {

			public void run() {
				Backtrack.backtrack(state, factory, terminationStrategy,
						listener, parallelTrack);
			}
		});
	}

}
