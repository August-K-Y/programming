package kang.interview.programming.array.deleteduplicates;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 26. Remove Duplicates from Sorted Array:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/#/description
 * 
 * How to remove duplicates from array in place?
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gYA83DDi
 * 
 * @author Yan Kang
 *
 */
public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] array) {

		if (array == null || array.length == 1)
			return 1;

		// pointer point to the position to be filled
		int pos = 0; 
		for (int i = 1; i < array.length; i++) {

			// if current element is equal to previous element, skip current
			// element and not write it back to the array. Otherwise, put this
			// element to the position specified by
			// pos pointer.
			if (i == 0 || array[i] != array[i - 1]) {
				array[pos++] = array[i];
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray s = new RemoveDuplicatesFromSortedArray();
		int[] array = { 1, 1, 2, 2, 2, 2, 3, 4, 5, 5 };
		int[] array2 = { 1, 1, 2 };
		int newLength = s.removeDuplicates(array);
		System.out.println(newLength); // 5
		
		DataPrinter.println(s.removeDuplicates(array2)); // 2

		for (int i = 0; i < newLength; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
