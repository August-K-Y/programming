package kang.interview.programming.recursive.backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 47. Permutations II:
 * https://leetcode.com/problems/permutations-ii/description/
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

	For example,
	[1,1,2] have the following unique permutations:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]

 * @author Yan Kang
 *
 */
public class Permutations_wDuplicateNumbers {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if (nums == null || nums.length == 0)
			return result;

		// This version of algorithm basically is the same as the one of
		// computing permutations with distinct members. But it has one
		// additional constraints that there are duplicates in the array.
		
		// With duplicates, it is possible that we will get duplicate
		// permutations in the result. To deal with this, we first sort the
		// array to put the duplicates next to each other. Then for each
		// position in the array, while we are iterating unused numbers for this
		// position, we must check if the duplicate of current visiting number
		// has already been put into this position before. If yes, we will skip
		// this number.
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		find(nums, used, new LinkedList<Integer>(), result);
		return result;
	}

	private void find(int[] nums, boolean[] used, LinkedList<Integer> list, List<List<Integer>> result) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
		}

		for (int i = 0; i < nums.length; i++) {
			// For each position in the array, while we are iterating
			// unused numbers for this position, we must check if the duplicate
			// of current visiting number has already been put into this
			// position before. If yes, we will skip this number.
			if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
				continue;
			used[i] = true;
			list.add(nums[i]);
			find(nums, used, list, result);
			used[i] = false;
			list.removeLast();
		}
	}
}
