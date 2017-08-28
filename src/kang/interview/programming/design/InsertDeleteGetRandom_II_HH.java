package kang.interview.programming.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

public class InsertDeleteGetRandom_II_HH {
	
	//
	private Map<Integer, List<Integer>> locs;
	private ArrayList<Integer> nums;
	private Random rand;

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom_II_HH() {
		locs = new HashMap<>();
		nums = new ArrayList<>();
		rand = new Random();

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		boolean exist = locs.containsKey(val) && locs.get(val).size() > 0;
		List<Integer> ls = locs.get(val);
		if (ls == null) {
			ls = new LinkedList<>();
			locs.put(val, ls);
		}
		ls.add(nums.size());
		nums.add(val);

		return !exist;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		List<Integer> ls = locs.get(val);
		if (ls != null && ls.size() > 0) {
			Integer loc = ls.iterator().next();
			Integer last = nums.get(nums.size() - 1);
			nums.set(loc, last);

			// 
			locs.get(last).remove(Integer.valueOf(nums.size() - 1));
			locs.get(last).add(loc);

			ls.remove(loc);
			nums.remove(nums.size() - 1);
			return true;
		}
		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}

	public static void main(String[] args) {
		InsertDeleteGetRandom_II_HH alg = new InsertDeleteGetRandom_II_HH();
		DataPrinter.println(alg.insert(4));
		DataPrinter.println(alg.insert(3));
		DataPrinter.println(alg.insert(4));
		DataPrinter.println(alg.insert(2));
		DataPrinter.println(alg.insert(4));
		DataPrinter.println(alg.remove(4));
//		DataPrinter.println(alg.remove(3));
//		DataPrinter.println(alg.remove(4));
//		DataPrinter.println(alg.remove(4));
//		DataPrinter.println(alg.getRandom());
	}
}
