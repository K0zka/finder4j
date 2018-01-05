package com.github.k0zka.finder4j.backtrack.examples.lab

import java.util.ArrayList

import com.github.k0zka.finder4j.backtrack.StepFactory

class LabStepFactory : StepFactory<LabStep, LabState> {

	override fun produce(state: LabState): List<LabStep> {
		val steps = ArrayList<LabStep>()
		// produce up, down, left and right steps in case that position is not
		val route = state.route
		val position = route[route.size - 1]
		if (position.x > 0) {
			addIfNotpresent(route, steps, Position(position.x - 1,
												   position.y), state)
		}
		if (position.x < state.lab.size - 1) {
			addIfNotpresent(route, steps, Position(position.x + 1,
												   position.y), state)
		}
		if (position.y > 0) {
			addIfNotpresent(route, steps, Position(position.x,
												   position.y - 1), state)
		}
		if (position.y < state.lab[0].size - 1) {
			addIfNotpresent(route, steps, Position(position.x,
												   position.y + 1), state)
		}
		return steps
	}

	fun addIfNotpresent(route: List<Position>, steps: MutableList<LabStep>,
						position: Position, state: LabState) {
		val targetObj = state.lab[position.x][position.y]
		if (!route.contains(position) && LabObject.Wall != targetObj) {
			steps.add(LabStep(position))
		}
	}

}
