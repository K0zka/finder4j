package com.github.K0zka.finder4j.backtrack.examples.queens;

import org.junit.Assert;
import org.junit.Test;

import com.github.K0zka.finder4j.backtrack.examples.queens.QueensState;

public class QueensStateTest {
	@Test
	public void isLegal() {
		QueensState state = new QueensState(new Short[] { 1, null });
		Assert.assertTrue(state.isLegal());
	}

	@Test
	public void isLegalNegative() {
		QueensState state = new QueensState(new Short[] { 1, 1 });
		Assert.assertFalse(state.isLegal());

		state = new QueensState(new Short[] { 1, 2 });
		Assert.assertFalse(state.isLegal());

		state = new QueensState(new Short[] { 1, 3, 1 });
		Assert.assertFalse(state.isLegal());

		state = new QueensState(new Short[] { 1, 5, 3 });
		Assert.assertFalse(state.isLegal());

	}

	@Test
	public void testToString() {
		System.out.println(new QueensState(new Short[] { 1, 5, 7, 2 }));
		System.out.println(new QueensState(new Short[] { 1, 5, 7, null, 1, 5, 7, null }));
	}

}
