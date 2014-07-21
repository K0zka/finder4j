package com.github.K0zka.finder4j.backtrack.examples.lab;

import java.util.ArrayList;
import java.util.List;

import com.github.K0zka.finder4j.backtrack.StepFactory;

public class LabStepFactory implements StepFactory<LabStep, LabState> {

	public List<LabStep> produce(LabState state) {
		final List<LabStep> steps = new ArrayList<LabStep>();
		// produce up, down, left and right steps in case that position is not
		final List<Position> route = state.getRoute();
		final Position position = route.get(route.size() - 1);
		if (position.getX() > 0) {
			addIfNotpresent(route, steps, new Position(position.getX() - 1,
					position.getY()), state);
		}
		if (position.getX() < state.getLab().length - 1) {
			addIfNotpresent(route, steps, new Position(position.getX() + 1,
					position.getY()), state);
		}
		if (position.getY() > 0) {
			addIfNotpresent(route, steps, new Position(position.getX(),
					position.getY() - 1), state);
		}
		if (position.getY() < state.getLab()[0].length - 1) {
			addIfNotpresent(route, steps, new Position(position.getX(),
					position.getY() + 1), state);
		}
		return steps;
	}

	public void addIfNotpresent(List<Position> route, List<LabStep> steps,
			Position position, LabState state) {
		LabObject targetObj = state.getLab()[position.getX()][position.getY()];
		if (!route.contains(position) && !LabObject.Wall.equals(targetObj)) {
			steps.add(new LabStep(position));
		}
	}

}
