package kang.interview.programming.array.sum;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * 
 * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 Note: You may
 * assume that the array does not change. There are many calls to sumRange
 * function.
 * 
 * @author yankang
 *
 */
public class NumArray {
	
	private int[] sumArray;
	public NumArray(int[] nums) {
		sumArray = new int[nums.length + 1];
		int sum = 0;
		sumArray[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sumArray[i + 1] = sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumArray[j + 1] - sumArray[i];
	}
	
	
}
