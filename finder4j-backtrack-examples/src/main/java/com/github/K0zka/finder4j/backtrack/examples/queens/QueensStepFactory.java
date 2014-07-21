package com.github.K0zka.finder4j.backtrack.examples.queens;

import java.util.ArrayList;
import java.util.List;

import com.github.K0zka.finder4j.backtrack.StepFactory;

public class QueensStepFactory implements StepFactory<QueensStep, QueensState> {

	public List<QueensStep> produce(QueensState state) {
		List<QueensStep> ret = new ArrayList<QueensStep>();
		Short[] queensShorts = state.getQueens();
		Short lastQueen = state.getLastQueen();
		// a structure to keep where the new queen can be placed
		boolean[] possiblePlaces = calculatePossiblePlaces(queensShorts,
				lastQueen);

		for (short i = 0; i < possiblePlaces.length; i++) {
			if (possiblePlaces[i]) {
				ret.add(new QueensStep(lastQueen, i));
			}
		}

		return ret;
	}

	static boolean[] calculatePossiblePlaces(Short[] queensShorts,
			Short lastQueen) {
		boolean[] possiblePlaces = new boolean[8];
		for (int i = 0; i < possiblePlaces.length; i++) {
			possiblePlaces[i] = true;
		}
		// take each queens previously placed
		for (int i = 0; i < lastQueen; i++) {
			Short loc = queensShorts[i];
			int distance = lastQueen - i;
			possiblePlaces[loc] = false;
			if (loc - distance > 0) {
				possiblePlaces[loc - distance] = false;
			}
			if (loc + distance < 8) {
				possiblePlaces[loc + distance] = false;
			}
		}
		return possiblePlaces;
	}

}
