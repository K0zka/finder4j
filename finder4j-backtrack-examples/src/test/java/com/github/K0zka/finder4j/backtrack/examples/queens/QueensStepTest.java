package com.github.K0zka.finder4j.backtrack.examples.queens;


import org.junit.Assert;
import org.junit.Test;

import com.github.K0zka.finder4j.backtrack.examples.queens.QueensState;
import com.github.K0zka.finder4j.backtrack.examples.queens.QueensStep;

public class QueensStepTest {
	@Test
	public void take() {
		QueensState state = new QueensState(new Short[]{1});
		QueensStep step = new QueensStep((short)0, (short)2);
		QueensState newState = step.take(state);
		Assert.assertEquals(2, newState.getQueens()[0].shortValue());
	}
}
