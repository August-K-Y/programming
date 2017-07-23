package kang.interview.programming.invariant.continuous_subarray_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 325. Maximum Size Subarray Sum Equals k:
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/#/description
 * 
 * Given an array nums and a target value k, find the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Note: The sum of the entire nums array is guaranteed to fit within the 32-bit
 * signed integer range.
 * 
 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3, return 4. (because the
 * subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 * Example 2: Given nums = [-2, -1, 2, 1], k = 1, return 2. (because the
 * subarray [-1, 2] sums to 1 and is the longest)
 * 
 * Follow Up: Can you do it in O(n) time?
 * 
 * @see {@link CheckContinuousSubarrayBySum}
 * @see {@link ComputeOccurrencesOfContinuouSubarrayBySum_withNegativeValue_M}
 * @see {@link CheckContinuousSubarrayKTimesOfSum_M}
 * @author yankang
 *
 */
public class ComputeMaxLengthOfContinuouSubarrayBySum_withNegativeValue_M {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int max = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}

//			Integer val = map.get(sum);
//			if (val == null) {
//				map.put(sum, i);
//			}
			
			map.putIfAbsent(sum, i);
		}
		return max;
	}
}
