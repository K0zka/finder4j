package com.github.k0zka.finder4j.backtrack;

import java.io.Serializable;

public interface Step<X extends State> extends Cloneable, Serializable {
	X take(X state);
}
