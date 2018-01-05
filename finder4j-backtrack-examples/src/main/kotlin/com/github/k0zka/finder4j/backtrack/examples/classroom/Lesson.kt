package com.github.k0zka.finder4j.backtrack.examples.classroom

import java.io.Serializable

class Lesson(val subject: String, val requiredFeatures: Set<String>, val weeklyCount: Int) : Serializable {
	companion object {
		private const val serialVersionUID = 689245100093598561L
	}
}
