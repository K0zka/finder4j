package com.github.K0zka.finder4j.backtrack.examples.lab;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.K0zka.finder4j.backtrack.Backtrack;
import com.github.K0zka.finder4j.backtrack.termination.FirstSolutionTerminationStrategy;

public class Main {

	private final static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		FirstSolutionTerminationStrategy<LabState, LabStep> terminationStrategy = new FirstSolutionTerminationStrategy<LabState, LabStep>();
		Backtrack.backtrack(
				new LabState(new LabObject[][] {
						{ LabObject.Floor, LabObject.Floor, LabObject.Floor,
								LabObject.Wall },
						{ LabObject.Wall, LabObject.Floor, LabObject.Floor,
								LabObject.Wall },
						{ LabObject.Wall, LabObject.Floor, LabObject.Wall,
								LabObject.Wall },
						{ LabObject.Floor, LabObject.Monster, LabObject.Floor,
								LabObject.Exit }, }, Arrays
						.asList(new Position(0, 0))), new LabStepFactory(),
				terminationStrategy, terminationStrategy);
		logger.info("Solution: ", terminationStrategy.getSolution());
	}

}
