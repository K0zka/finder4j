package com.github.k0zka.finder4j.backtrack;

public interface TerminationStrategy<X extends State> {
	boolean stop(X state);
}
