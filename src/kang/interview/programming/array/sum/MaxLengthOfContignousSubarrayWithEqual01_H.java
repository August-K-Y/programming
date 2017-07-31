package kang.interview.programming.array.sum;

import java.util.HashMap;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * 525. Contiguous Array
 * 
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * Example 1:
 * 
 * Input: [0,1] 
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0
 * and 1.
 * 
 * Example 2:
 * 
 * Input: [0,1,0] 
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1. Note: The length of the given binary array will not exceed
 * 50,000.
 * 
 * @author Yan Kang
 *
 */
public class MaxLengthOfContignousSubarrayWithEqual01_H {

	/**
	 * O(n^2) not efficient
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaxLength_(int[] nums) {

		if (nums == null || nums.length == 0)
			return 0;

		int maxL = 0;
		for (int i = 1; i < nums.length; i++) {
			int[] rec = new int[2];
			for (int j = i; j >= 0; j--) {
				rec[nums[j]]++;
				if (rec[0] == rec[1]) {
					maxL = Math.max(maxL, i - j + 1);
				}
			}
		}
		return maxL;
	}
	
	/**
	 * O(n) time and O(n) space
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaxLength(int[] nums) {
		
		if (nums == null || nums.length == 0)
			return 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		int[] rec = new int[2];
		
		map.put(0, -1);
		int diff = 0, max = 0;
		for (int i = 0; i < nums.length; i++) {
			rec[nums[i]]++;

			// Pitfall: do not use Math.abs since there there is a difference,
			// which number (1 or 0) has more amount matters
			diff = rec[0] - rec[1];
			if (map.containsKey(diff)) {
				max = Math.max(max, i - map.get(diff));
			}
			map.putIfAbsent(diff, i);
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaxLengthOfContignousSubarrayWithEqual01_H alg = new MaxLengthOfContignousSubarrayWithEqual01_H();
		int[] nums = { 0, 1 }; // 2
		int[] nums2 = { 0, 1, 0 }; // 2
		int[] nums3 = { 0 }; // 0
		int[] nums4 = { 1, 1, 0, 1, 0 }; // 4
		int[] nums5 = { 0, 1, 0, 0, 0, 1, 1, 1 }; // 8
		DataPrinter.println(alg.findMaxLength(nums));
		DataPrinter.println(alg.findMaxLength(nums2));
		DataPrinter.println(alg.findMaxLength(nums3));
		DataPrinter.println(alg.findMaxLength(nums4));
		DataPrinter.println(alg.findMaxLength(nums5));
	}
}
