package com.github.k0zka.finder4j.backtrack.termination;

import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.Step;
import com.github.k0zka.finder4j.backtrack.TerminationStrategy;

public class TimeoutTerminationStrategy<X extends State, S extends Step<X>>
		implements TerminationStrategy<X> {

	public TimeoutTerminationStrategy(final long timeout) {
		super();
		this.timeout = timeout;
	}

	private final long timeout;

	public boolean stop(final X state) {
		return System.currentTimeMillis() >= timeout;
	}

}
