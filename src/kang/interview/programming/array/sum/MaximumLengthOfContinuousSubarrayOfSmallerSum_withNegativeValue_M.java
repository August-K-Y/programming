package kang.interview.programming.array.sum;

import kang.interview.programming.util.DataPrinter;

public class MaximumLengthOfContinuousSubarrayOfSmallerSum_withNegativeValue_M {
	
	public int maxSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		
		int[] sums = new int[nums.length + 1];
		sums[0] = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sums[i + 1] = sum;
		}
		
		
		int l = 0;
		int r = 1;
		int maxL = 0;

		int temp = 0;
		while (r < sums.length) {
			temp = sums[r++];
			while (temp - sums[l] > s){
				l++;
			}

			maxL = Math.max(maxL, r - l - 1);
		}

		return maxL;
		
		
	}
	
	public static void main(String[] args) {
		MaximumLengthOfContinuousSubarrayOfSmallerSum_withNegativeValue_M alg = new MaximumLengthOfContinuousSubarrayOfSmallerSum_withNegativeValue_M();

		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int k = 7;

		int[] nums2 = { 431, -15, 639, 342, -14, 565, -924, 635, 167, -70 };
		int k2 = 184;

		DataPrinter.println(alg.maxSubArrayLen(k, nums)); // expect 3
		DataPrinter.println(alg.maxSubArrayLen(k2, nums2)); // expect 4
	}
}
