package kang.interview.programming.recursive.backtracking.permutation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 31. Next Permutation
 * https://leetcode.com/problems/next-permutation/description/
 * 
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column. 
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3 
 * 1,1,5 -> 1,5,1
 * 
 * @see kang.interview.programming.graph.connection.SwapLexOrder_H
 * @see https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 */
public class TheNextPermutation_M {

	public void nextPermutation(int[] nums) {

		// Iterate the array backward to find the first element whose value is
		// smaller than the value of its next element, i.e., nums[i] <
		// nums[i+1];
		int a = -1;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				a = i;
				break;
			}
		}

		if (a < 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		
		// Iterate the array backward to find the first element > nums[a];
		int b = -1;
		for (int j = nums.length - 1; j > a; j--) {
			if (nums[j] > nums[a]) {
				b = j;
				break;
			}
		}

		// 
		swap(nums, a, b);
		reverse(nums, a + 1, nums.length - 1);
	}

	private void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	private void reverse(int[] nums, int start, int end) {
		if (start >= end)
			return;
		for (int i = start; i <= (start + end) / 2; i++) {
			swap(nums, i, start + end - i);
		}
	}
	    
	/**
	 * 
	 * @param perm
	 */
	public void nextPermutation(List<Integer> perm) {
		
		int index = -1;
		for (int i = perm.size() - 1; i > 0; i--) {
			if (perm.get(i) > perm.get(i - 1)) {
				index = i - 1;
				break;
			}
		}

		if (index < 0) {
			// if no index found, there is no next permutation
			for (int i = 0; i < perm.size(); i++)
				perm.set(i, -1);
		} else {
			int min = perm.get(index + 1);
			int minIndex = index + 1;
			for (int i = index + 2; i < perm.size(); i++) {
				if (perm.get(i) > perm.get(index) && perm.get(i) < min) {
					min = perm.get(i);
					minIndex = i;
				}
			}
			Collections.swap(perm, index, minIndex);
			
			Collections.reverse(perm.subList(index + 1, perm.size())); 
		}
	}

	public static void main(String[] args) {
		TheNextPermutation_M t = new TheNextPermutation_M();
		
		Integer[] array = { 1,0,3,2 };
		t.nextPermutation(Arrays.asList(array));
		if (array.length > 0) {
//			DataPrinter.printList(array);
		} else {
			System.out.println("no next");
		}

		List<Integer> perm = DataPrinter.createList(1, 0, 2, 3);
		t.nextPermutation(perm);
		DataPrinter.printList(perm);
	}

}
