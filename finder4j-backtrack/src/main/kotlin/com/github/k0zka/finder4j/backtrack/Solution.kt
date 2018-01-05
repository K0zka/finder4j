package com.github.k0zka.finder4j.backtrack

/**
 * This might not be needed at all.
 *
 * @param <S>
 * step type
</S> */
interface Solution<S : Step<*>> {
	val steps: List<S>
}
