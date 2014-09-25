package com.github.k0zka.finder4j.backtrack;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class LocalParallelTrackTest {
	@Mock
	ForkJoinPool pool;
	@Mock
	State state;
	@Mock
	StepFactory<Step<State>, State> stepFactory;
	@Mock
	TerminationStrategy<State> terminationStrategy;
	@Mock
	SolutionListener<State, Step<State>> listener;
	
	LocalParallelTrack<State, Step<State>> localParallelTrack;
	
	@Before
	public void setup() {
		localParallelTrack = new LocalParallelTrack<>(pool);
	}
	
	@Test
	public void available() {
		Mockito.when(pool.getActiveThreadCount()).thenReturn(10);
		Mockito.when(pool.getParallelism()).thenReturn(16);
		Assert.assertTrue(localParallelTrack.available());
	}

	@Test
	public void notAvailable() {
		Mockito.when(pool.getActiveThreadCount()).thenReturn(16);
		Mockito.when(pool.getParallelism()).thenReturn(16);
		Assert.assertTrue(localParallelTrack.available());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void start() {
		Mockito.when(pool.submit(Mockito.any(ForkJoinTask.class))).thenAnswer(new Answer<ForkJoinTask<?>>() {

			@Override
			public ForkJoinTask<?> answer(InvocationOnMock invocation)
					throws Throwable {
				return null;
			}
		});
		localParallelTrack.start(state, stepFactory, terminationStrategy, listener);
		
	}
	
}
