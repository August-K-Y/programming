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
		if (nums == null || nums.length == 0)
			return;

		int ri = 0;
		int wi = 0;
		int bi = nums.length - 1;

		// NOTE: i <= bi since elements after bi should all be blue color
		for (int i = 0; i <= bi; i++) {
			if (nums[i] == 0) {
				swap(nums, ri++, i);
			} else if (nums[i] == 2) {
				swap(nums, bi--, i);
				// After swapping blue color with color at i, we need to examine
				// color at i since it might be either red or white.
				i--;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void sortColors_CountingSort(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int[] b = new int[3];
		for (int n : nums) {
			b[n]++;
		}

		int z = 0;
		for (int i = 0; i < b.length; i++) {
			int count = b[i];
			for (int j = 0; j < count; j++) {
				nums[z++] = i;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {2};
		SortColors alg = new SortColors();
		alg.sortColors(nums);;
	}
}
