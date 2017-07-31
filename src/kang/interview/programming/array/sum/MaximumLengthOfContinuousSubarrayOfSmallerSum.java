package kang.interview.programming.array.sum;

import kang.interview.programming.util.DataPrinter;

public class MaximumLengthOfContinuousSubarrayOfSmallerSum {

	public int maxSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int l = 0;
		int r = 0;
		int maxL = 0;

		int sum = 0;
		while (r < nums.length) {
			sum += nums[r++];

			while (sum > s) {
				sum -= nums[l++];
			}

			maxL = Math.max(maxL, r - l);
		}

		return maxL;

	}
	
	
	public static void main(String[] args) {
		MaximumLengthOfContinuousSubarrayOfSmallerSum alg = new MaximumLengthOfContinuousSubarrayOfSmallerSum();

		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int k = 7;

//		int[] nums2 = { 1, 1 };
//		int k2 = 3;
//
//		int[] nums3 = { 1, 1, 1, 1 };
//		int k3 = 4;

		DataPrinter.println(alg.maxSubArrayLen(k, nums)); // expect 2
//		DataPrinter.println(alg.maxSubArrayLen(k2, nums2)); // expect 0
//		DataPrinter.println(alg.maxSubArrayLen(k3, nums3)); // expect 4
	}

}
