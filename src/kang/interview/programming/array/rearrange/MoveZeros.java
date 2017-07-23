package kang.interview.programming.array.rearrange;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 283. Move Zeroes:
 * https://leetcode.com/problems/move-zeroes/#/description
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example,
 * 
 * given nums = [0, 1, 0, 3, 12], after calling your function, nums should be
 * [1, 3, 12, 0, 0].
 * 
 * Note: 
 * You must do this in-place without making a copy of the array. 
 * Minimize the total number of operations.
 * 
 * @author Yan Kang
 *
 */
public class MoveZeros {

	/**
	 * When do certain manipulation on an array while maintaining the order of
	 * the part that is not affected by this manipulation, rotate is a solution.
	 */

	/**
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length == 0)
			return;

		for(int i = 0; i< nums.length;i++) {
			if(nums[i] == 0) {
				int index = find(nums, i + 1);
				if(index != -1) {
					rotate(nums, i, index);
				}
			}
		}
	}

	private int find(int[] nums, int start) {
		for (int i = start; i < nums.length; i++) {
			if (nums[i] != 0) return i;
		}
		return -1;
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
	 * Shift non-zero values as far forward as possible Fill remaining space
	 * with zeros
	 * 
	 * @param nums
	 */
	public void moveZeroes_(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	
	public static void main(String[] args){
		MoveZeros alg = new MoveZeros();
		
		int[] nums = {0, 1, 0, 3, 12};
		alg.moveZeroes(nums);
		DataPrinter.printArray(nums);
	}

}
