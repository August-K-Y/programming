package kang.interview.programming.array;

/**
 * LeetCode 283. Move Zeroes:
 * https://leetcode.com/problems/move-zeroes/description/
 * 
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums
 * should be [1, 3, 12, 0, 0].
 * 
 * Note: You must do this in-place without making a copy of the array. Minimize
 * the total number of operations.
 * 
 * @author Yan Kang
 *
 */
public class MoveZeros {

	/**
	 * The innovation part of this algorithm is that: since we know that the
	 * only number we want move to the back is zero, we can move number that is
	 * not zero to front in order and fill the rest of the array with zero (in
	 * this way, no swap, replace or search operations is necessary).
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int insert = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[insert++] = nums[i];
			}
		}

		while (insert < nums.length) {
			nums[insert++] = 0;
		}
	}
}
