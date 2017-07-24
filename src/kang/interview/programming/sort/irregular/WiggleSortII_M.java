package kang.interview.programming.sort.irregular;

import java.util.Arrays;

import kang.interview.programming.util.DataPrinter;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 * 
 * Example: 
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note: You may assume all input has valid answer.
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * @author yankang
 *
 */
public class WiggleSortII_M {
	/**
	 * 
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {
	}

	
	public static void main(String[] args) {
		int[] nums = {1, 5, 1, 1, 6, 4};
		int[] nums2 = {1, 3, 2, 2, 3, 1};
		
		WiggleSortII_M alg = new WiggleSortII_M();
		alg.wiggleSort(nums);
		DataPrinter.printArray(nums);
		System.out.println();
		alg.wiggleSort(nums2);
		DataPrinter.printArray(nums2);
		
	}
}
