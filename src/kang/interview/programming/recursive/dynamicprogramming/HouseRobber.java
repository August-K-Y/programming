package kang.interview.programming.recursive.dynamicprogramming;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * 
 * You are planning to rob houses on a specific street, and you know that every
 * house on the street has a certain amount of money hidden. The only thing
 * stopping you from robbing all of them in one night is that adjacent houses on
 * the street have a connected security system. The system will automatically
 * trigger an alarm if two adjacent houses are broken into on the same night.
 * 
 * Given a list of non-negative integers nums representing the amount of money
 * hidden in each house, determine the maximum amount of money you can rob in
 * one night without triggering an alarm.
 * 
 * Example
 * 
 * For nums = [1, 1, 1], the output should be houseRobber(nums) = 2.
 * 
 * The optimal way to get the most money in one night is to rob the first and
 * the third houses for a total of 2.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] array.integer nums
 * 
 * An array representing the amount of money that each house on the street has.
 * 
 * Guaranteed constraints: 
 * 		0 <= nums.length <= 100, 
 * 		0 <= nums[i] <= 500.
 * 
 * @author Yan Kang
 *
 */
public class HouseRobber {
	
	
	/**
	 * d[i] = max(nums[index] + d[i - 2], d[i - 1]) where index = i - 1
	 * 
	 * @param nums
	 * @return
	 */
	int houseRobber(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0; 
		
		if (nums.length == 0)
			return nums[0];
		
		int[] d = new int[nums.length + 1];
		d[0] = 0;
		d[1] = nums[0];
		
		for (int i = 2; i < nums.length + 1; i++) {
			d[i] = Math.max(nums[i - 1] + d[i - 2], d[i - 1]);
		}
		return d[nums.length];
	}
	
	public static void main(String[] args) {
		HouseRobber alg = new HouseRobber();

		int[] nums = { 1, 1, 1 };
		DataPrinter.println(alg.houseRobber(nums));
	}
}
