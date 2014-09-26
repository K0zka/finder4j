package com.github.k0zka.finder4j.backtrack.termination;

import java.util.ArrayList;
import java.util.List;

import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.TerminationStrategy;

public class OrTerminationStrategy<X extends State> implements TerminationStrategy<X> {

	private final List<TerminationStrategy<X>> strategies;
	
	public OrTerminationStrategy(List<TerminationStrategy<X>> strategies) {
		super();
		this.strategies = new ArrayList<>(strategies);
	}

	@Override
	public boolean stop(X state) {
		for(TerminationStrategy<X> strategy : strategies) {
			if(strategy.stop(state)) {
				return true;
			}
		}
		return false;
	}

}
