package com.github.k0zka.finder4j.backtrack

/**
 * Interface to help the backtrack algorithm run several threads in parallel.
 *
 * @param <X>
 * state type
 * @param <S>
 * step type
</S></X> */
interface ParallelTrack<X : State, S : Step<X>> {
	/**
	 * Should return true if there is any free computation resource available.
	 *
	 * @return
	 */
	fun available(): Boolean

	/**
	 * Run the search starting from a state.
	 *
	 * @param state
	 * starting state of the search thread
	 * @param stepFactory
	 * steps factory
	 * @param terminationStrategy
	 * termination strategy
	 * @param listener
	 * solution listener
	 */
	fun start(state: X, stepFactory: StepFactory<S, X>,
			  terminationStrategy: TerminationStrategy<X>,
			  listener: SolutionListener<X, S>)

	/**
	 * Join all the started processes.
	 */
	fun join()

}
