package com.github.k0zka.finder4j.backtrack;

public interface SearchState {
	/**
	 * Get the time when the search started
	 * 
	 * @return
	 */
	public long getSearchStartTimestamp();

	/**
	 * Get the number of solutions found during the search so far;
	 * 
	 * @return
	 */
	public int getSolutionsFound();
}
