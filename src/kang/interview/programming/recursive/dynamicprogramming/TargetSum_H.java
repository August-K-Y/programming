package kang.interview.programming.recursive.dynamicprogramming;

/**
 * LeetCode 494. Target Sum:
 * https://leetcode.com/problems/target-sum/#/description
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 
 * 
 * Explanation:
 * 
 * -1+1+1+1+1 = 3 
 * +1-1+1+1+1 = 3 
 * +1+1-1+1+1 = 3 
 * +1+1+1-1+1 = 3 
 * +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3. Note:
 * The length of the given array is positive and will not exceed 20. The sum of
 * elements in the given array will not exceed 1000. Your output answer is
 * guaranteed to be fitted in a 32-bit integer.
 * 
 * Solution: https://leetcode.com/problems/target-sum/#/solution
 * 
 * @author Yan Kang
 *
 */
public class TargetSum_H {

	/**
	 * Time complexity : O(2^n). Size of recursion tree will be 2^n. n refers to
	 * the size of nums array.
	 * 
	 * Space complexity : O(n). The depth of the recursion tree can go up to n.
	 * 
	 * @param nums
	 * @param S
	 * @return
	 */
	public int findTargetSumWays(int[] nums, int S) {
		return find(nums, 0, S);
	}

	private int find(int[] nums, int index, int sum) {

		if (index == nums.length) {
			if (sum == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		return find(nums, index + 1, sum + nums[index]) + find(nums, index + 1, sum - nums[index]);
	}
	
	public int findTargetSumWays_(int[] nums, int S) {
		
		int[][] dp = new int[nums.length][2001];
		
		
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < 2001; i++) {
				dp[i][j + 1000] = dp[i - 1][j + 1000 + nums[i]] + dp[i - 1][j + 1000 - nums[i]];
			}
		}
		return dp[nums.length][S];
	}
}
