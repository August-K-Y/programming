package kang.interview.programming.array.sum.ksum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 15. 3Sum: https://leetcode.com/problems/3sum/#/description
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Yan Kang
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if(nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);

		/**
		 * Duplicate triplets may happen when there are duplicate numbers in the
		 * array.
		 * 
		 */
		for (int i = 0; i < nums.length; i++) {
			
			
			if (i > 0 && nums[i] == nums[i-1])
				continue;
			
			int sum = -nums[i];
			int start = i + 1;
			int end = nums.length - 1;
			int prev = 0;
			boolean found = false;
			while (start < end) {
				if (nums[start] + nums[end] == sum) {
					
					
					if (found && nums[start] == prev) {
						start++;
						end--;
						continue;
					}
					found = true;
					prev = nums[start];
					
					
					result.add(Arrays.asList(nums[i], nums[start], nums[end]));
					start++;
					end--;
				} else if (nums[start] + nums[end] < sum) {
					start++;
				} else {
					end--;
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> threeSum_(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < num.length - 2; i++) {
			if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
				int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
				while (lo < hi) {
					if (num[lo] + num[hi] == sum) {
						res.add(Arrays.asList(num[i], num[lo], num[hi]));
						while (lo < hi && num[lo] == num[lo + 1])
							lo++;
						while (lo < hi && num[hi] == num[hi - 1])
							hi--;
						lo++;
						hi--;
					} else if (num[lo] + num[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ThreeSum alg = new ThreeSum();
		
		int[] nums = {-1, 0, 1, 2, -1, -4};
		DataPrinter.print2DList(alg.threeSum(nums));
		System.out.println();
		int[] nums2 = { -2, 0, 0, 2, 2 };
		DataPrinter.print2DList(alg.threeSum(nums2));

	}
}
