package com.github.k0zka.finder4j.backtrack.examples.classroom;

import java.io.Serializable;
import java.util.Set;

public class Teacher implements Serializable {
	private static final long serialVersionUID = -2230068009733512785L;
	public Teacher(String name, Set<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
	}
	private final String name;
	private final Set<String> subjects;
	public String getName() {
		return name;
	}
	public Set<String> getSubjects() {
		return subjects;
	}
}
