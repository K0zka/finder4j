package com.github.k0zka.finder4j.backtrack

import java.io.Serializable

interface State : Cloneable, Serializable {
	/**
	 * Check if the state is legal and complete.
	 *
	 * @return
	 */
	val isComplete: Boolean
}
