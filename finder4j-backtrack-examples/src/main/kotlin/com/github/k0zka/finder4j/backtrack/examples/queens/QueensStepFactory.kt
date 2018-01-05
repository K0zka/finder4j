package com.github.k0zka.finder4j.backtrack.examples.queens

import java.util.ArrayList

import com.github.k0zka.finder4j.backtrack.StepFactory

class QueensStepFactory : StepFactory<QueensStep, QueensState> {

	override fun produce(state: QueensState): List<QueensStep> {
		val ret = ArrayList<QueensStep>()
		val queensShorts = state.queens
		val lastQueen = state.lastQueen
		// a structure to keep where the new queen can be placed
		val possiblePlaces = calculatePossiblePlaces(queensShorts.toTypedArray(),
													 lastQueen)

		for (i in possiblePlaces.indices) {
			if (possiblePlaces[i]) {
				ret.add(QueensStep(lastQueen, i.toShort()))
			}
		}

		return ret
	}

	companion object {

		internal fun calculatePossiblePlaces(queensShorts: Array<Short>,
											 lastQueen: Short?): BooleanArray {
			val possiblePlaces = BooleanArray(8)
			for (i in possiblePlaces.indices) {
				possiblePlaces[i] = true
			}
			// take each queens previously placed
			for (i in 0 until (lastQueen ?: 0)) {
				val loc = queensShorts[i]
				val distance = lastQueen!! - i
				possiblePlaces[loc.toInt()] = false
				if (loc - distance > 0) {
					possiblePlaces[loc - distance] = false
				}
				if (loc + distance < 8) {
					possiblePlaces[loc + distance] = false
				}
			}
			return possiblePlaces
		}
	}

}
