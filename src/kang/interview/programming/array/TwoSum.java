package kang.interview.programming.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @see {@link FindAllParisOfTwoSum}
 * @see {@link ContinuousSubarrayKTimesOfSum_M}
 * 
 * @author yankang
 *
 */
public class TwoSum {
	
	
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
