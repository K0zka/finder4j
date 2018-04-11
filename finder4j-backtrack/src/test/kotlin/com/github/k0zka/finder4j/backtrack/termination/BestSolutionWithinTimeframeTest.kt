package com.github.k0zka.finder4j.backtrack.termination

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BestSolutionWithinTimeframeTest {
	@Test
	fun stop() {
		assertFalse("should not be terminating when we are within the ideal time") {
			BestSolutionWithinTimeframe<String>(maxTime = 1000, idealTime = 500, clock = { 1 }, start = 0,
												comparator = Comparator { first, second -> first.compareTo(second) }
			).stop("x")

		}
		assertFalse("should not be terminating when we are within max time and no solution yet") {
			BestSolutionWithinTimeframe<String>(maxTime = 1000, idealTime = 500, clock = { 600 }, start = 0,
												comparator = Comparator { first, second -> first.compareTo(second) }
			).stop("x")

		}

		assertTrue("should be terminating when we are within max time, but beyond ideal time and have solution yet") {
			val strategy = BestSolutionWithinTimeframe<String>(
					maxTime = 1000, idealTime = 500,
					clock = { 600 }, start = 0,
					comparator = Comparator { first, second ->
						first.compareTo(second)
					}
			)
			strategy.onSolution("c")
			strategy.stop("x")

		}

		assertTrue("should be terminating when we are beyond max time even if no solution") {
			BestSolutionWithinTimeframe<String>(maxTime = 1000, idealTime = 500, clock = { 1600 }, start = 0,
												comparator = Comparator { first, second -> first.compareTo(second) }
			).stop("x")

		}
	}

	@Test
	fun onSolution() {
		val strategy = BestSolutionWithinTimeframe<String>(maxTime = 1000, idealTime = 500,
														   clock = { 0 }, start = 0,
														   comparator = Comparator { first, second ->
															   first.compareTo(second)
														   }
		)
		strategy.onSolution("A")
		strategy.onSolution("B")
		strategy.onSolution("C")
		assertEquals("A", strategy.getBestResult())
	}
}