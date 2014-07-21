package com.github.K0zka.finder4j.backtrack.examples.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.K0zka.finder4j.backtrack.examples.lab.LabObject;
import com.github.K0zka.finder4j.backtrack.examples.lab.LabState;
import com.github.K0zka.finder4j.backtrack.examples.lab.LabStep;
import com.github.K0zka.finder4j.backtrack.examples.lab.LabStepFactory;
import com.github.K0zka.finder4j.backtrack.examples.lab.Position;

public class LabStepFactoryTest {
	@Test
	public void produce() {
		LabObject[][] map = new LabObject[][] {
				{ LabObject.Floor, LabObject.Exit },
				{ LabObject.Floor, LabObject.Floor } };
		List<LabStep> steps = new LabStepFactory().produce(new LabState(map, Arrays
				.asList(new Position(1, 1))));
		Assert.assertFalse(steps.isEmpty());
	}
	@Test
	public void produceWithWalls() {
		LabObject[][] map = new LabObject[][] {
				{ LabObject.Floor, LabObject.Wall, LabObject.Floor},
				{ LabObject.Floor, LabObject.Floor, LabObject.Floor },
				{ LabObject.Wall, LabObject.Exit, LabObject.Floor } };
		List<LabStep> steps = new LabStepFactory().produce(new LabState(map, Arrays
				.asList(new Position(0, 0))));
		Assert.assertEquals(1, steps.size());
		Assert.assertEquals(new Position(1, 0), steps.get(0).getStepTo());
	}

}
