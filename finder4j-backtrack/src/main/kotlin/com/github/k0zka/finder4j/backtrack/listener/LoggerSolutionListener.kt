package com.github.k0zka.finder4j.backtrack.listener

import com.github.k0zka.finder4j.backtrack.SolutionListener
import com.github.k0zka.finder4j.backtrack.State
import com.github.k0zka.finder4j.backtrack.Step
import org.slf4j.LoggerFactory

class LoggerSolutionListener<in X : State> : SolutionListener<X> {

	private var cntr = 0

	override fun onSolution(state: X) {
		logger.info("Solution {} : {}", cntr++, state)
	}

	companion object {
		private val logger = LoggerFactory
				.getLogger(LoggerSolutionListener::class.java)
	}

}
