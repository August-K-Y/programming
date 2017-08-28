package kang.interview.programming.array.sum;

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
 * @see {@link OccurrencesOfContinuouSubarrayBySum_withNegativeValue_M}
 * @see {@link CheckContinuousSubarrayKTimesOfSum_HH}
 * @author yankang
 *
 */
public class MaxLengthOfContinuouSubarrayBySum_withNegativeValue_H {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		
		// base case
		map.put(0, -1);
		int sum = 0, max = 0;

		/*
		 * Given an array nums, one fast way to find the sum of a sub-array from
		 * index j to i is sums[i] - sums[j-1], where sums[i] represents the sum
		 * of elements from nums[0] to nums[i].
		 * 
		 * Put it other way, if there exists two elements: sums[x] and sums[y-1],
		 * x > y-1, such that sums[x] - sums[y-1] == k, it means the sum of
		 * sub-array from y to x is equal to k.
		 * 
		 * Generally, to find the maximum length of sub-array whose element sum
		 * is k, we can search all pairs of elements in the array sums for pairs
		 * that have difference of k.
		 * 
		 * Following is one implementation.
		 * 
		 */
		for (int i = 0; i < nums.length; i++) {
			// no need to compute the sum using a separate loop
			sum += nums[i];
			if (map.containsKey(sum - k)) {
				max = Math.max(max, i - map.get(sum - k));
			}

			/*
			 * If there are duplicates in the array sums (multiple sub-arrays
			 * that have element sum equals to k), we record the earliest one in
			 * the map since we want to find sums[x] - sums[y-1] == k and x - (y
			 * - 1) is the largest.
			 */
			map.putIfAbsent(sum, i);
		}
		return max;
	}
}
