package com.github.k0zka.finder4j.backtrack.examples.lab

import com.github.k0zka.finder4j.backtrack.State
import java.util.Random

class LabState : State {

	internal val lab: Array<Array<LabObject>>
	internal val route: List<Position>

	override val complete: Boolean
		get() {
			val position = route[route.size - 1]
			return LabObject.Exit == lab[position.x][position.y]
		}

	internal constructor(lab: Array<Array<LabObject>>, route: List<Position>) {
		this.lab = lab
		this.route = route
	}

	/**
	 * Create random labirinth.
	 *
	 * @param x
	 * @param y
	 */
	constructor(x: Int, y: Int) {
		val random = Random()
		route = listOf()
		lab = Array(x) { Array(y, {LabObject.Floor}) }
		var i = 1
		while (i < x) {
			for (j in 0 until y) {
				val rand = random.nextInt(100)
				if (rand < 10) {
					lab[i][j] = LabObject.Floor
				} else if (rand < 12) {
					lab[i][j] = LabObject.Monster
				} else if (rand < 13) {
					lab[i][j] = LabObject.Dragon
				} else if (rand < 14) {
					lab[i][j] = LabObject.Dragon
				} else {
					lab[i][j] = LabObject.Wall
				}
			}
			i += 2
		}
		lab[0][random.nextInt(lab[0].size - 1)] = LabObject.Exit

	}

	override fun toString(): String {
		val builder = StringBuilder(lab.size * (lab[0].size + 2))
		for (i in lab.indices) {
			for (j in 0 until lab[i].size) {
				if (route.contains(Position(i, j))) {
					builder.append('.')
				} else {
					when (lab[i][j]) {
						LabObject.Wall -> builder.append("+")
						LabObject.Floor -> builder.append(' ')
						LabObject.Dragon -> builder.append('%')
						LabObject.Monster -> builder.append(',')
						LabObject.Exit -> builder.append('#')
					}
				}
			}
			builder.append('\n')
		}
		return builder.toString()
	}

}
