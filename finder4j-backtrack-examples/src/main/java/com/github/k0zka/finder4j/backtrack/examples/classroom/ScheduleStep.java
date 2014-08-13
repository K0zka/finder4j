package com.github.k0zka.finder4j.backtrack.examples.classroom;

import com.github.k0zka.finder4j.backtrack.Step;

public class ScheduleStep implements Step<ScheduleState> {

	private static final long serialVersionUID = -1306607512165979047L;

	public ScheduleStep(ScheduleItem item) {
		super();
		this.item = item;
	}

	final ScheduleItem item;

	public ScheduleState take(ScheduleState state) {
		// TODO Auto-generated method stub
		return null;
	}

}
