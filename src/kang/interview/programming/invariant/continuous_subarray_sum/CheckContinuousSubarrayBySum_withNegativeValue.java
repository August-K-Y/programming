package kang.interview.programming.invariant.continuous_subarray_sum;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

public class CheckContinuousSubarrayBySum_withNegativeValue {
	public boolean canFind(int[] nums, int k) {
		
		if(nums == null || nums.length == 0) {
			return false;
		}

		Set<Integer> map = new HashSet<>();

		map.add(0);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.contains(sum - k)) {
				return true;
			}
			map.add(sum);
		}
		return false;

	}

	public static void main(String[] args) {
		CheckContinuousSubarrayBySum_withNegativeValue alg = new CheckContinuousSubarrayBySum_withNegativeValue();

		int[] nums = { 1, 1, 1 };
		int k = 2;

		int[] nums2 = { 1, -1, 5, -2, 3 };
		int k2 = 3;

		int[] nums3 = { -2, -1, 2, 1 };
		int k3 = 1;

		int[] nums4 = { 1, 3, 5, 23, 2 };
		int k4 = 8;

		int[] nums5 = { 1, 3, 5, 23, 2 };
		int k5 = 7;
		
		DataPrinter.println(alg.canFind(nums, k)); // true
		DataPrinter.println(alg.canFind(nums2, k2)); // true
		DataPrinter.println(alg.canFind(nums3, k3)); // true
		DataPrinter.println(alg.canFind(nums4, k4)); // true
		DataPrinter.println(alg.canFind(nums5, k5)); // false
	}
}
