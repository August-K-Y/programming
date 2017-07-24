package kang.interview.programming.sort.irregular;

/**
 * LeetCode 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/#/description
 * 
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * click to show follow up.
 * 
 * Follow up: A rather straight forward solution is a two-pass algorithm using
 * counting sort. First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @author Yan Kang
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int n0 = 0, n2 = nums.length - 1;
		for (int i = 0; i <= n2; i++) {
			if (nums[i] == 0) {
				swap(nums, i, n0++);
			} else if (nums[i] == 2) {
				swap(nums, i--, n2--);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {2};
		SortColors alg = new SortColors();
		alg.sortColors(nums);;
	}
}
