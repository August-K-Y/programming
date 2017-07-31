package kang.interview.programming.array.sum;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 209. Minimum Size Subarray Sum:
 * https://leetcode.com/problems/minimum-size-subarray-sum/#/description
 * 
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum ≥ s. If there isn't
 * one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 * 
 * @author Yan Kang
 *
 */
public class MinimumLengthContinuousSubarrayBiggerSum_M {
	
	public int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;

		int l = 0, r = 0, sum = 0;
		int minL = nums.length + 1;

		while (r < nums.length) {
			sum += nums[r++];

			while (sum >= s) {
				// keep updating the minimum length while keep removing left
				// most element of the window from the sum until sum < s
				minL = Math.min(minL, r - l);
				sum -= nums[l++];
			}
		}
		
		// 
		return minL == (nums.length + 1) ? 0 : minL;
	}
	
	
	public static void main(String[] args) {
		MinimumLengthContinuousSubarrayBiggerSum_M alg = new MinimumLengthContinuousSubarrayBiggerSum_M();

		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int k = 7;

		int[] nums2 = { 1, 1 };
		int k2 = 3;

		int[] nums3 = { 1, 1, 1, 1 };
		int k3 = 4;

		DataPrinter.println(alg.minSubArrayLen(k, nums)); // expect 2
		DataPrinter.println(alg.minSubArrayLen(k2, nums2)); // expect 0
		DataPrinter.println(alg.minSubArrayLen(k3, nums3)); // expect 4
	}
}
