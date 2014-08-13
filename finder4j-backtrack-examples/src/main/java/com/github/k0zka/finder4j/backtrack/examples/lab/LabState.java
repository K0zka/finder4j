package com.github.k0zka.finder4j.backtrack.examples.lab;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.github.k0zka.finder4j.backtrack.State;

@SuppressWarnings("serial")
public class LabState implements State {

	private final LabObject[][] lab;
	private final List<Position> route;

	LabState(final LabObject[][] lab, final List<Position> route) {
		this.lab = lab;
		this.route = route;
	}

	/**
	 * Create random labirinth.
	 * 
	 * @param x
	 * @param y
	 */
	public LabState(int x, int y) {
		final Random random = new Random();
		route = Collections.emptyList();
		lab = new LabObject[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				lab[i][j] = LabObject.Floor;
			}
		}
		for (int i = 1; i < x; i += 2) {
			for (int j = 0; j < y; j++) {
				int rand = random.nextInt(100);
				if (rand < 10) {
					lab[i][j] = LabObject.Floor;
				} else if (rand < 12) {
					lab[i][j] = LabObject.Monster;
				} else if (rand < 13) {
					lab[i][j] = LabObject.Dragon;
				} else if (rand < 14) {
					lab[i][j] = LabObject.Dragon;
				} else {
					lab[i][j] = LabObject.Wall;
				}
			}
		}
		lab[0][random.nextInt(lab[0].length - 1)] = LabObject.Exit;

	}

	public boolean isComplete() {
		final Position position = route.get(route.size() - 1);
		return LabObject.Exit.equals(lab[position.getX()][position.getY()]);
	}

	public String toString() {
		final StringBuilder builder = new StringBuilder(lab.length
				* (lab[0].length + 2));
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[i].length; j++) {
				if(route.contains(new Position(i, j))) {
					builder.append('.');
				} else {
					switch (lab[i][j]) {
					case Wall:
						builder.append("+");
						break;
					case Floor:
						builder.append(' ');
						break;
					case Dragon:
						builder.append('%');
						break;
					case Monster:
						builder.append(',');
						break;
					case Exit:
						builder.append('#');
						break;
					}
				}
			}
			builder.append('\n');
		}
		return builder.toString();
	}

	LabObject[][] getLab() {
		return lab;
	}

	List<Position> getRoute() {
		return route;
	}

}
