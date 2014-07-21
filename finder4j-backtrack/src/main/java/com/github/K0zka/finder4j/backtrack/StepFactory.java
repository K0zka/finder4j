package com.github.K0zka.finder4j.backtrack;

import java.util.List;

public interface StepFactory<S extends Step<X>, X extends State> {
	List<S> produce(X state);
}
