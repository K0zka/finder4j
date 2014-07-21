package com.github.K0zka.finder4j.backtrack.examples.lab;

import java.util.ArrayList;

import com.github.K0zka.finder4j.backtrack.Step;

@SuppressWarnings("serial")
public class LabStep implements Step<LabState> {

	public LabStep(Position stepTo) {
		super();
		this.stepTo = stepTo;
	}

	private final Position stepTo;

	public LabState take(LabState state) {
		final ArrayList<Position> newRoute = new ArrayList<Position>(
				state.getRoute());
		newRoute.add(stepTo);
		return new LabState(state.getLab(), newRoute);
	}

	@Override
	public String toString() {
		return "{ -> " + stepTo + "}";
	}

	Position getStepTo() {
		return stepTo;
	}

}
