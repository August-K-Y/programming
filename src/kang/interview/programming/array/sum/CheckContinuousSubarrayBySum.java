package kang.interview.programming.array.sum;

import kang.interview.programming.util.DataPrinter;

/**
 * Question: Given a sequence of positive integers A and an integer T, return
 * whether there is a continuous sequence of A that sums up to exactly T.
 * 
 * Example
 * [23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20 
 * [1, 3, 5, 23, 2], 8. Return True because 3 + 5 = 8 
 * [1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7
 * 
 * @see {@link CheckContinuousSubarrayKTimesOfSum_M}
 * @see {@link MaximumLengthContinuousSubarrayBySum_M}
 * @author Yan Kang
 *
 */
public class CheckContinuousSubarrayBySum {

	public boolean canFind(int[] array, int k) {
		if (array == null || array.length == 0)
			return false;

		int r = 0;
		int l = 0;
		int sum = 0;
		while (r < array.length) {
			sum += array[r++];
			while (sum > k) {
				sum -= array[l++];
			}
			if (sum == k) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		CheckContinuousSubarrayBySum alg = new CheckContinuousSubarrayBySum();

		int[] nums = new int[] { 23, 5, 4, 7, 2, 11 };
		int[] nums2 = new int[] { 1, 3, 5, 23, 2 };
		int[] nums3 = new int[] { 1, 3, 5, 23, 2 };
		int[] nums4 = new int[] { 1, 1, 1 };

		DataPrinter.println(alg.canFind(nums, 20));
		DataPrinter.println(alg.canFind(nums2, 8));
		DataPrinter.println(alg.canFind(nums3, 7));
		DataPrinter.println(alg.canFind(nums4, 2));
		DataPrinter.println(alg.canFind(nums4, 3));
	}

}
