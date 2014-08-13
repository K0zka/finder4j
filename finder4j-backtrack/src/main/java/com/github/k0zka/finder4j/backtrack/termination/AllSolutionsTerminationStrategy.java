package com.github.k0zka.finder4j.backtrack.termination;

import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.TerminationStrategy;

/**
 * Requires all solutions to be discovered by fully completing the backtrack.
 * 
 * @param <X>
 *            state type
 */
public class AllSolutionsTerminationStrategy<X extends State> implements
		TerminationStrategy<X> {

	public boolean stop(final X state) {
		return false;
	}

}
