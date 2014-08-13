package com.github.k0zka.finder4j.backtrack.examples.queens;

import java.util.Arrays;

import com.github.k0zka.finder4j.backtrack.State;

public class QueensState implements State {
	private static final long serialVersionUID = -3147893306213484516L;

	public QueensState() {
		this(new Short[] { null, null, null, null, null, null, null, null });
	}

	public QueensState(Short... queens) {
		super();
		this.queens = queens;
	}

	private final Short[] queens;

	public Short[] getQueens() {
		return Arrays.copyOf(queens, queens.length);
	}

	protected Short getLastQueen() {
		for (short i = 0; i < queens.length; i++) {
			if (queens[i] == null) {
				return i;
			}
		}
		return (short) queens.length;
	}

	public boolean isLegal() {
		return isLegal(queens);
	}

	public static boolean isLegal(Short[] queens) {
		// take each queen
		for (int i = 0; i < queens.length - 1; i++) {
			final Short checkQueen = queens[i];
			if (checkQueen == null) {
				continue;
			}
			// check that it does not hit any other queens
			for (int j = i + 1; j < queens.length; j++) {
				final Short otherQueen = queens[j];
				if (otherQueen == null) {
					continue;
				}
				if (isHit(i, checkQueen, j, otherQueen)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isHit(int checkQueenPosition, Short checkQueen,
			int otherQueenPosition, Short otherQueen) {
		final int distance = otherQueenPosition - checkQueenPosition;
		if (checkQueen.equals(otherQueen)
				|| checkQueen.equals(otherQueen + distance)
				|| checkQueen.equals((short) (otherQueen - distance))) {
			return true;
		}
		return false;
	}

	public boolean isComplete() {
		for (Short pos : queens) {
			if (pos == null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(81);
		builder.append("+----------------+\n");
		for (Short queen : queens) {
			builder.append('|');
			if (queen != null) {
				appendNSpaces(builder, queen * 2);
				builder.append("X ");
				appendNSpaces(builder, (8 - queen - 1) * 2);
			} else {
				appendNSpaces(builder, 8 * 2);
			}
			builder.append("|\n");
		}
		builder.append("+----------------+\n");
		return builder.toString();
	}

	private void appendNSpaces(StringBuilder builder, int nr) {
		for (int i = 0; i < nr; i++) {
			builder.append(' ');
		}
	}
}
