package kang.interview.programming.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * @see kang.interview.programming.invariant.SlidingWindowMaximum_M
 * @author Yan Kang
 *
 */
public class ContainsNearbyDuplicate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0)
			return false;

		if (k + 1 > nums.length)
			k = nums.length - 1;
		
		Set<Integer> set = new HashSet<>();
		int l = 0;
		int r = 0;
		for (; r < k + 1; r++) {
			if (!set.add(nums[r])) {
				return true;
			}
		}
	
		while(r < nums.length) {
			set.remove(nums[l++]);
			if(!set.add(nums[r++]))
				return true;
		}
		return false;
	}
}
