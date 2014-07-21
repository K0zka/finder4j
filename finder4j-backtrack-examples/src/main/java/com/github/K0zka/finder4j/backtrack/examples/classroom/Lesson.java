package com.github.K0zka.finder4j.backtrack.examples.classroom;

import java.io.Serializable;
import java.util.Set;

public class Lesson implements Serializable {
	private static final long serialVersionUID = 689245100093598561L;
	public Lesson(String subject, Set<String> requiredFeatures, int weeklyCount) {
		super();
		this.subject = subject;
		this.requiredFeatures = requiredFeatures;
		this.weeklyCount = weeklyCount;
	}
	private final String subject;
	private final Set<String> requiredFeatures;
	private final int weeklyCount;
	public String getSubject() {
		return subject;
	}
	public Set<String> getRequiredFeatures() {
		return requiredFeatures;
	}
	public int getWeeklyCount() {
		return weeklyCount;
	}
}
