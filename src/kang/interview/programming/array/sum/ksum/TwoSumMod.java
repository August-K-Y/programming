package kang.interview.programming.array.sum.ksum;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.array.FindAllParisOfTwoSum;

/**
 * 
 * @see {@link FindAllParisOfTwoSum}
 * @see {@link CheckContinuousSubarrayKTimesOfSum_HH}
 * 
 * @author Yan Kang
 *
 */
public class TwoSumMod {
	
	public boolean twoSumMod(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return false;

		k = k < 0 ? -k : k;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i] % k)) {
				return true;
			} else {
				set.add(k - nums[i] % k);
			}
		}
		return false;
	}
}
