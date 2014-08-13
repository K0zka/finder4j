package com.github.k0zka.finder4j.backtrack.examples.classroom;

import java.util.Collection;

import com.github.k0zka.finder4j.backtrack.State;

public class ScheduleState implements State {

	public ScheduleState(Collection<ScheduleItem> items,
			Collection<Room> rooms, Collection<Group> groups) {
		super();
		this.items = items;
		this.rooms = rooms;
		this.groups = groups;
	}

	private static final long serialVersionUID = 8098443098192205511L;

	private final Collection<ScheduleItem> items;
	private final Collection<Room> rooms;
	private final Collection<Group> groups;

	public boolean isComplete() {
		//TODO
		for(Group group : groups) {
			//check that the group does have all lessons scheduled
			for(Lesson lesson : group.getLessons()) {
				isLessonScheduled();
			}
		}
		return false;
	}

	private void isLessonScheduled() {
		for(ScheduleItem schedule : items) {
			
		}
	}
}
