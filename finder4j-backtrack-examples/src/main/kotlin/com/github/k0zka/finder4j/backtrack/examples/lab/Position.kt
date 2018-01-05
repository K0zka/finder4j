package com.github.k0zka.finder4j.backtrack.examples.lab

import java.io.Serializable

class Position(val x: Int, val y: Int) : Serializable {

	override fun hashCode(): Int {
		val prime = 31
		var result = 1
		result = prime * result + x
		result = prime * result + y
		return result
	}

	override fun equals(obj: Any?): Boolean {
		if (this === obj)
			return true
		if (obj == null)
			return false
		if (javaClass != obj.javaClass)
			return false
		val other = obj as Position?
		if (x != other!!.x)
			return false
		return if (y != other.y) false else true
	}

	override fun toString(): String {
		return "[$x, $y]"
	}
}