package kang.interview.programming.zhe;

import java.util.Random;

/**
 * LeetCode 398. Random Pick Index:
 * https://leetcode.com/problems/random-pick-index/description/
 * 
 * Given an array of integers with possible duplicates, randomly output the
 * index of a given target number. You can assume that the given target number
 * must exist in the array.
 * 
 * Note: The array size can be very large. Solution that uses too much extra
 * space will not pass the judge.
 * 
 * Example:
 * 
 * int[] nums = new int[] {1,2,3,3,3}; 
 * Solution solution = new Solution(nums);
 * 
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should
 * have equal probability of returning. solution.pick(3);
 * 
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 * 
 * 
 * @author Yan Kang
 *
 */
public class RandomPickIndex_H {
	private int[] nums;
	private Random rand = new Random();

	public RandomPickIndex_H(int[] nums) {
		this.nums = nums;
	}

	public int pick(int target) {

		int ret = -1;
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				continue;

			// IMPORTANT: randomly select an integer r from 0 to the nums of
			// target.
			// If r equals 0, set the res as the current index. The probability
			// is always 1/total for the latest appeared number. For example, 1
			// for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each
			// of the first 2 nums).
			int r = rand.nextInt(++total); 
			ret = r == 0 ? i : ret;
		}
		return ret;
	}
}
