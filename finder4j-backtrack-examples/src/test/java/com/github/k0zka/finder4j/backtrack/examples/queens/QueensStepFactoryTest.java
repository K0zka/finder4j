package com.github.k0zka.finder4j.backtrack.examples.queens;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.k0zka.finder4j.backtrack.examples.queens.QueensState;
import com.github.k0zka.finder4j.backtrack.examples.queens.QueensStep;
import com.github.k0zka.finder4j.backtrack.examples.queens.QueensStepFactory;

public class QueensStepFactoryTest {
	@Test
	public void produce() {
		List<QueensStep> steps = new QueensStepFactory().produce(new QueensState((short)1, (short)1, null, null));
		Assert.assertFalse(steps.isEmpty());
	}
}
