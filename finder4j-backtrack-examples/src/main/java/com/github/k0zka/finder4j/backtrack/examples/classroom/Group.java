package com.github.k0zka.finder4j.backtrack.examples.classroom;

import java.util.Set;

public class Group {
	public Group(String name, Set<Lesson> lessons, int size) {
		super();
		this.name = name;
		this.lessons = lessons;
		this.size = size;
	}
	private final String name;
	private final Set<Lesson> lessons;
	private final int size;
	public String getName() {
		return name;
	}
	public Set<Lesson> getLessons() {
		return lessons;
	}
	public int getSize() {
		return size;
	}
	
}
