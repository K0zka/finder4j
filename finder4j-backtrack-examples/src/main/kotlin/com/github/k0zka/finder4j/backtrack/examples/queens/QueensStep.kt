package com.github.k0zka.finder4j.backtrack.examples.queens

import com.github.k0zka.finder4j.backtrack.Step

class QueensStep(private val queenNr: Short, private val pos: Short) : Step<QueensState> {

	override fun take(state: QueensState): QueensState {
		val queens = state.queens
		queens[queenNr.toInt()] = pos
		return QueensState(queens)
	}

	override fun toString(): String {
		return "{$queenNr->$pos}"
	}

	override fun hashCode(): Int {
		return queenNr + pos
	}

	override fun equals(obj: Any?): Boolean {
		return obj is QueensStep && obj.queenNr == queenNr && obj.pos == pos
	}

	companion object {

		private val serialVersionUID = -555046442160555351L
	}

}
