package kang.interview.programming.array.ksum;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1. Two Sum: https://leetcode.com/problems/two-sum/#/description
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author Yan Kang
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return new int[0];

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i])) {
				int[] r = new int[2];
				r[0] = map.get(nums[i]);
				r[1] = i;
				return r;
			} else {
				map.put(target - nums[i], i);
			}
		}
		return new int[0];
	}
}
