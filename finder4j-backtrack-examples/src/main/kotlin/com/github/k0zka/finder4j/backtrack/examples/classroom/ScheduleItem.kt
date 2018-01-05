package com.github.k0zka.finder4j.backtrack.examples.classroom

import java.io.Serializable

class ScheduleItem(val lesson: Lesson, val teacher: Teacher, val group: Group, val room: Room) : Serializable {
	companion object {
		private const val serialVersionUID = -4227785011781140759L
	}
}
