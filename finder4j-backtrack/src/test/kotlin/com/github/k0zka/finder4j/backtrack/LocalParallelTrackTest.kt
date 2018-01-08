package com.github.k0zka.finder4j.backtrack

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.ForkJoinPool

class LocalParallelTrackTest {

	private var pool: ForkJoinPool = mock()

	private var state: State = mock()

	private var stepFactory: StepFactory<Step<State>, State> = mock()

	private var terminationStrategy: TerminationStrategy<State> = mock()

	private var listener: SolutionListener<State> = mock()

	private var localParallelTrack: LocalParallelTrack<State, Step<State>>? = null

	@Before
	fun setup() {
		localParallelTrack = LocalParallelTrack(pool, stepFactory, terminationStrategy, listener)
	}

	@Test
	fun available() {
		whenever(pool.activeThreadCount).thenReturn(10)
		whenever(pool.parallelism).thenReturn(16)
		Assert.assertTrue(localParallelTrack!!.available())
	}

	@Test
	fun notAvailable() {
		whenever(pool.activeThreadCount).thenReturn(16)
		whenever(pool.parallelism).thenReturn(16)
		Assert.assertTrue(localParallelTrack!!.available())
	}

	@Test
	fun start() {
		whenever(
				pool.submit(any())).thenAnswer { null }
		localParallelTrack!!.start(state)

	}

}
