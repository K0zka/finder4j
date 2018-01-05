package com.github.k0zka.finder4j.backtrack.examples.lab

import java.util.ArrayList

import com.github.k0zka.finder4j.backtrack.Step

class LabStep(internal val stepTo: Position) : Step<LabState> {

	override fun take(state: LabState): LabState {
		val newRoute = ArrayList(
				state.route)
		newRoute.add(stepTo)
		return LabState(state.lab, newRoute)
	}

	override fun toString(): String {
		return "{ -> $stepTo}"
	}

}
