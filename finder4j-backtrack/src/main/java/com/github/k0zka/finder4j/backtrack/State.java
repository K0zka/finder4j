package com.github.k0zka.finder4j.backtrack;

import java.io.Serializable;

public interface State extends Cloneable, Serializable {
	/**
	 * Check if the state is legal and complete.
	 * 
	 * @return
	 */
	boolean isComplete();
}
