package com.github.k0zka.finder4j.backtrack.examples.queens;

import com.github.k0zka.finder4j.backtrack.Step;

public class QueensStep implements Step<QueensState> {

	private static final long serialVersionUID = -555046442160555351L;

	public QueensStep(short queenNr, short pos) {
		super();
		this.queenNr = queenNr;
		this.pos = pos;
	}

	private final short queenNr;
	private final short pos;

	public QueensState take(QueensState state) {
		final Short[] queens = state.getQueens();
		queens[queenNr] = pos;
		return new QueensState(queens);
	}

	@Override
	public String toString() {
		return "{" + queenNr + "->" + pos + "}";
	}

	@Override
	public int hashCode() {
		return queenNr + pos;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof QueensStep && ((QueensStep)obj).queenNr == queenNr && ((QueensStep)obj).pos == pos;
	}

}
