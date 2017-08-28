package kang.interview.programming.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
	private Map<Integer, Integer> locs;
	private ArrayList<Integer> nums;
	private Random rand;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom() {
		locs = new HashMap<>();
		nums = new ArrayList<>();
		rand = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (!locs.containsKey(val)) {
			locs.put(val, nums.size());
			nums.add(val);
			return true;
		}
		return false;

	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		Integer loc = locs.get(val);
		if (loc != null) {
			Integer last = nums.get(nums.size() - 1);
			nums.set(loc, last);
			locs.put(last, loc);

			locs.remove(val);
			nums.remove(nums.size() - 1);

			return true;
		}

		return false;

	}

	/** Get a random element from the set. */
	public int getRandom() {
		// Returns a pseudorandom, uniformly distributed int value between 0
		// (inclusive) and the specified value (exclusive), drawn from this
		// random number generator's sequence.
		return nums.get(rand.nextInt(nums.size()));
	}
}
