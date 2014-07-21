package com.github.K0zka.finder4j.backtrack.examples.classroom;

import java.io.Serializable;

public class ScheduleItem implements Serializable {
	private static final long serialVersionUID = -4227785011781140759L;
	public ScheduleItem(Lesson lesson, Teacher teacher, Group group, Room room) {
		super();
		this.lesson = lesson;
		this.teacher = teacher;
		this.group = group;
		this.room = room;
	}
	public Lesson getLesson() {
		return lesson;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public Group getGroup() {
		return group;
	}
	public Room getRoom() {
		return room;
	}
	private final Lesson lesson;
	private final Teacher teacher;
	private final Group group;
	private final Room room;
}
