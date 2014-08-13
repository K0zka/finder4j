package com.github.k0zka.finder4j.backtrack.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.k0zka.finder4j.backtrack.SolutionListener;
import com.github.k0zka.finder4j.backtrack.State;
import com.github.k0zka.finder4j.backtrack.Step;

public class LoggerSolutionListener<X extends State, S extends Step<X>> implements SolutionListener<X, S>{

	private  static final Logger logger = LoggerFactory.getLogger(LoggerSolutionListener.class);
	
	private int cntr = 0;
	
	public void onSolution(final X state) {
		logger.info("Solution {} : {}", cntr ++, state);
	}

}