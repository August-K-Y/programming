package kang.interview.programming.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, write a function that determines whether the
 * array contains any duplicates. Your function should return true if any
 * element appears at least twice in the array, and it should return false if
 * every element is distinct.
 * 
 * Example
 * 
 * For a = [1, 2, 3, 1], the output should be containsDuplicates(a) = true.
 * 
 * There are two 1s in the given array.
 * 
 * For a = [3, 1], the output should be containsDuplicates(a) = false.
 * 
 * The given array contains no duplicates.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] array.integer a
 * 
 * Guaranteed constraints: 0 <= a.length <= 10^5, -2 � 10^9 <= a[i] <= 2 � 10^9.
 * 
 * [output] boolean
 * 
 * @see ContainsNearbyDuplicate
 * @see ContainsNearbyAlmostDuplicate_H
 * @author Yan Kang
 *
 */
public class ContainsDuplicate {

	/**
	 * 
	 * @param nums
	 * @return
	 */
	boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		Set<Integer> s = new HashSet<Integer>();
		for (int n : nums) {
			if (s.contains(n)) {
				return true;
			} else {
				s.add(n);
			}
		}
		return false;
	}

	/**
	 * From CodeFight: This is an interesting variation of first one.
	 * 
	 * @param nums
	 * @return
	 */
	boolean containsDuplicate_(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		Set<Integer> s = new HashSet<>();
		for (int b : nums)
			s.add(b);
		return s.size() != nums.length;
	}

	/**
	 * 
	 * @param nums
	 * @return
	 */
	boolean containsDuplicate__(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			// if there is same
			if (!set.add(i))
				return true;
		}
		return false;
	}
	// TODO: which one is better???
}
