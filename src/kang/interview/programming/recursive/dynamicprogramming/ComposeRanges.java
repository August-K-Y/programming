package kang.interview.programming.recursive.dynamicprogramming;

import java.util.LinkedList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * Given a sorted integer array that does not contain any duplicates, return a
 * summary of the number ranges it contains.
 * 
 * What if the sorted array contains duplicates?
 * 
 * Can do this using Dynamic Programming?
 * 
 * Example
 * 
 * For nums = [-1, 0, 1, 2, 6, 7, 9], the output should be composeRanges(nums) =
 * ["-1->2", "6->7", "9"].
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] array.integer nums
 * 
 * A sorted array of unique integers.
 * 
 * Guaranteed constraints: 
 * 		0 <= nums.length <= 15, 
 * 		-(231 - 1) <= nums[i] <= 231 - 1.
 * 
 * [output] array.string
 * 
 * @author Yan Kang
 *
 */
public class ComposeRanges {
	
	
	String[] composeRanges(int[] nums) {
		if (nums == null || nums.length == 0)
			return new String[0];

		List<String> list = new LinkedList<>();

		StringBuilder sb = new StringBuilder();
		sb.append(nums[0]);

		// count tracks the number of consecutive increasing numbers. In other
		// words, the amount of numbers in a range
		int count = 1;
		int i = 1;
		for (; i < nums.length; i++) {
			if (nums[i] - nums[i - 1] == 1) {
				count++;
			} else {
				if (count != 1) {
					sb.append("->" + nums[i - 1]);
				}
				list.add(sb.toString());
				sb.setLength(0);
				sb.append(nums[i]);
				count = 1;
			}
		}
		
		//
		if (count != 1) {
			sb.append("->" + nums[i - 1]);
		}
		list.add(sb.toString());
		
		return list.toArray(new String[0]);
	}
	
	public static void main(String[] args) {
		int[] nums1 =  {-1, 0, 1, 2, 6, 7, 9};
		int[] nums2 =  {0, 1, 2, 4, 5, 7};
		int[] nums3 =  {-1};
		int[] nums4 =  {1, 3};
		int[] nums5 =  {0, 1};
		int[] nums6 =  {-1, 0, 1, 2, 6, 7, 8};
		
		ComposeRanges alg = new ComposeRanges();
		String[] result1 = alg.composeRanges(nums1);
		DataPrinter.printArray(result1);
		result1 = alg.composeRanges(nums2);
		DataPrinter.printArray(result1);
		result1 = alg.composeRanges(nums3);
		DataPrinter.printArray(result1);
		result1 = alg.composeRanges(nums4);
		DataPrinter.printArray(result1);
		result1 = alg.composeRanges(nums5);
		DataPrinter.printArray(result1);
		result1 = alg.composeRanges(nums6);
		DataPrinter.printArray(result1);
	}

}
