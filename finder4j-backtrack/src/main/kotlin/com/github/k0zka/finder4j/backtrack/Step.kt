package com.github.k0zka.finder4j.backtrack

import java.io.Serializable

interface Step<X : State> : Cloneable, Serializable {
	fun take(state: X): X
}
