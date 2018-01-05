package com.github.k0zka.finder4j.backtrack.examples.classroom

import com.github.k0zka.finder4j.backtrack.Step

class ScheduleStep(internal val item: ScheduleItem) : Step<ScheduleState> {

	override fun take(state: ScheduleState): ScheduleState {
		TODO()
	}

	companion object {

		private val serialVersionUID = -1306607512165979047L
	}

}
