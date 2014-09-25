package com.github.k0zka.finder4j.backtrack;

/**
 * Interface to help the backtrack algorithm run several threads in parallel.
 * 
 * @param <X>
 *            state type
 * @param <S>
 *            step type
 */
public interface ParallelTrack<X extends State, S extends Step<X>> {
	/**
	 * Should return true if there is any free computation resource available.
	 * 
	 * @return
	 */
	boolean available();

	/**
	 * Run the search starting from a state.
	 * 
	 * @param state
	 *            starting state of the search thread
	 * @param stepFactory
	 *            steps factory
	 * @param terminationStrategy
	 *            termination strategy
	 * @param listener
	 *            solution listener
	 */
	void start(final X state, final StepFactory<S, X> stepFactory,
			final TerminationStrategy<X> terminationStrategy,
			final SolutionListener<X, S> listener);

}
