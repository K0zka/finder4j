package com.github.K0zka.finder4j.backtrack.examples.lab;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.github.K0zka.finder4j.backtrack.examples.lab.LabObject;
import com.github.K0zka.finder4j.backtrack.examples.lab.LabState;
import com.github.K0zka.finder4j.backtrack.examples.lab.Position;

public class LabStateTest {
	@Test
	public void isComplete() {
		LabState state = new LabState(new LabObject[][] { { LabObject.Exit } },
				Arrays.asList(new Position(0, 0)));
		Assert.assertTrue(state.isComplete());
	}

	@Test
	public void isCompleteNotComplete() {
		LabState state = new LabState(new LabObject[][] {
				{ LabObject.Floor, LabObject.Exit },
				{ LabObject.Floor, LabObject.Floor } },
				Arrays.asList(new Position(0, 0)));
		Assert.assertFalse(state.isComplete());
	}

	@Test
	public void testToString() {
		System.out.println(new LabState(25, 25));
	}

}
