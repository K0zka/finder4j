package com.github.k0zka.finder4j.backtrack.examples.classroom

import java.io.Serializable

class Teacher(val name: String, val subjects: Set<String>) : Serializable {
	companion object {
		private const val serialVersionUID = -2230068009733512785L
	}
}
