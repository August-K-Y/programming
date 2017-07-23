package kang.interview.programming.array.deleteduplicates;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 80. Remove Duplicates from Sorted Array II:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/#/description
 * 
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 * 
 * @author yankang
 *
 */
public class RemoveDuplicatesFromSortedArrayII_M {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int pos = 1;

		// the appear variable tracks how many times the previous number of
		// currently visiting number has already appeared.
		// If nums[i] == nums[i - 1] and appear == 1, we write num[i] to the array and increase appear to 2.
		// If nums[i] == nums[i - 1] and appear == 2, it means the current number has already appeared twice 
		// and we will skip writing current number to the array.
		int appear = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[pos++] = nums[i];
				appear = 1;
			} else if (appear < 2) {
				nums[pos++] = nums[i];
				appear++;
			}
		}
		return pos;
	}
	
	public static void main(String[] arg) {
		int[] array = { 2, 3, 5, 5, 5, 7, 11, 11, 11,11, 13};
		RemoveDuplicatesFromSortedArrayII_M ora = new RemoveDuplicatesFromSortedArrayII_M();
		int end = ora.removeDuplicates(array);
		DataPrinter.printArray(array, end - 1);
	}
}
