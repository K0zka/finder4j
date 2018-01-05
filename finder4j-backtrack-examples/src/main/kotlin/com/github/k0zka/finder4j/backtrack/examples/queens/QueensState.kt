package com.github.k0zka.finder4j.backtrack.examples.queens

import com.github.k0zka.finder4j.backtrack.State

class QueensState @JvmOverloads constructor(
		val queens: ShortArray = ShortArray(8,  {_ -> notSet })
) : State {

	val lastQueen: Short
		get() {
			for (i in queens.indices) {
				if (queens[i] == notSet) {
					return i.toShort()
				}
			}
			return queens.size.toShort()
		}

	val isLegal: Boolean
		get() = isLegal(queens)

	override val isComplete: Boolean
		get() =
			queens.any { it == notSet }

	override fun toString(): String {
		val builder = StringBuilder(81)
		builder.append("+----------------+\n")
		for (queen in queens) {
			builder.append('|')
			if (queen != notSet) {
				appendNSpaces(builder, queen * 2)
				builder.append("X ")
				appendNSpaces(builder, (8 - queen.toInt() - 1) * 2)
			} else {
				appendNSpaces(builder, 8 * 2)
			}
			builder.append("|\n")
		}
		builder.append("+----------------+\n")
		return builder.toString()
	}

	private fun appendNSpaces(builder: StringBuilder, nr: Int) {
		for (i in 0 until nr) {
			builder.append(' ')
		}
	}

	companion object {
		private val serialVersionUID = -3147893306213484516L

		val notSet = (-1).toShort()

		fun isLegal(queens: ShortArray): Boolean {
			// take each queen
			for (i in 0 until queens.size - 1) {
				val checkQueen = queens[i]
// check that it does not hit any other queens
				for (j in i + 1 until queens.size) {
					val otherQueen = queens[j]
					if (isHit(i, checkQueen, j, otherQueen)) {
						return false
					}
				}
			}
			return true
		}

		fun isHit(checkQueenPosition: Int, checkQueen: Short?,
				  otherQueenPosition: Int, otherQueen: Short?): Boolean {
			val distance = otherQueenPosition - checkQueenPosition
			return (checkQueen == otherQueen
					|| checkQueen == (otherQueen!! + distance).toShort()
					|| checkQueen == (otherQueen - distance).toShort())
		}
	}
}
