package com.github.k0zka.finder4j.backtrack.examples.classroom;

import java.util.Set;

public class Room {
	public Room(int capacity, String name, Set<String> features) {
		super();
		this.capacity = capacity;
		this.name = name;
		this.features = features;
	}
	private final int capacity;
	private final String name;
	private final Set<String> features;
	public int getCapacity() {
		return capacity;
	}
	public String getName() {
		return name;
	}
	public Set<String> getFeatures() {
		return features;
	}
}
