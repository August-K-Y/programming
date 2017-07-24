package kang.interview.programming.sort.irregular;

import java.util.Arrays;

import kang.interview.programming.util.DataPrinter;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
 * nums[1] >= nums[2] <= nums[3]....
 * 
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6,
 * 2, 5, 3, 4].
 * 
 * Solution:
 * @see https://leetcode.com/problems/wiggle-sort/#/solution
 * 
 * @author Yan Kang
 *
 */
public class WiggleSort_M {
	
	/**
	 * 
	 * @param nums
	 */
	public void wiggleSort(int[] nums) {
		if(nums == null || nums.length == 0)
			return;
		
		Arrays.sort(nums);
		int m = nums.length / 2;
		int j = 1;
		for (int i = 1; i <= m; i++) {
			rotate(nums, j, nums.length - 1);
			j += 2;
		}
	}

	private void rotate(int[] nums, int start, int end) {
		int last = nums[end];
		for (int i = end - 1; i >= start; i--) {
			nums[i + 1] = nums[i];
		}
		nums[start] = last;
	}

	/**
	 * 
	 * @param nums
	 */
	public void wiggleSort_(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length - 1; i += 2) {
			swap(nums, i, i + 1);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
	/**
	 * 
	 * Intuitively, we should be able to reorder it in one-pass. As we iterate
	 * through the array, we compare the current element to its next element and
	 * if the order is incorrect, we swap them.
	 * 
	 */
	
	public void wiggleSort_1(int[] nums) {
	    boolean less = true;
	    for (int i = 0; i < nums.length - 1; i++) {
	        if (less) {
	            if (nums[i] > nums[i + 1]) {
	                swap(nums, i, i + 1);
	            }
	        } else {
	            if (nums[i] < nums[i + 1]) {
	                swap(nums, i, i + 1);
	            }
	        }
	        less = !less;
	    }
	}
	
	public void wiggleSort_2(int[] nums) {
	    for (int i = 0; i < nums.length - 1; i++) {
	        if (((i % 2 == 0) && nums[i] > nums[i + 1])
	                || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
	            swap(nums, i, i + 1);
	        }
	    }
	}
	
	
	public void wiggleSort_3(int[] nums) {
	    for (int i = 0; i < nums.length - 1; i++) {
	        if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
	            swap(nums, i, i + 1);
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 5, 2, 1, 6, 4, 7, 7};
		
		WiggleSort_M alg = new WiggleSort_M();
		alg.wiggleSort(nums);
		DataPrinter.printArray(nums);
		
	}
}
