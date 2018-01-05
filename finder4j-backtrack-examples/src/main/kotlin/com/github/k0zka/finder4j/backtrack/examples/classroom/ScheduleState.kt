package com.github.k0zka.finder4j.backtrack.examples.classroom

import com.github.k0zka.finder4j.backtrack.State

class ScheduleState(private val items: Collection<ScheduleItem>,
					private val rooms: Collection<Room>, private val groups: Collection<Group>) : State {

	override//TODO
			//check that the group does have all lessons scheduled
	val isComplete: Boolean
		get() {
			for (group in groups) {
				for (lesson in group.lessons) {
					isLessonScheduled()
				}
			}
			return false
		}

	private fun isLessonScheduled() {
		for (schedule in items) {

		}
	}

	companion object {

		private val serialVersionUID = 8098443098192205511L
	}
}
