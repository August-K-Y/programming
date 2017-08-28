package kang.interview.programming.array.sum.ksum;

import java.util.Arrays;

/**
 * LeetCode 16. 3Sum Closest:
 * https://leetcode.com/problems/3sum-closest/description/
 * 
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Yan Kang
 *
 */
public class ThreeSumClosest {
	
	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int start = i + 1;
			int end = nums.length - 1;

			while (start < end) {
				int val = nums[start] + nums[end] + nums[i];
				if (val == target) {
					return val;
				} else {
					if (diff > Math.abs(val - target)) {
						diff = Math.abs(val - target);
						sum = val;
					}

					if (val > target) {
						end--;
					} else {
						start++;
					}

				}
			}
		}
		return sum;
	}
}
