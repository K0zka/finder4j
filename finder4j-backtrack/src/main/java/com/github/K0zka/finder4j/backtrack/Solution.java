package com.github.K0zka.finder4j.backtrack;

import java.util.List;

/**
 * This might not be needed at all.
 * @param <S> step type
 */
public interface Solution<S extends Step<?>> {
	List<S> getSteps();
}
