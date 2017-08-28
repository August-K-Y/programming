package kang.interview.programming.recursive.backtracking.permutation;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 46. Permutations:
 * https://leetcode.com/problems/permutations/description/
 * 
 * Given a collection of distinct numbers, return all possible permutations.

	For example,
	
	[1,2,3] have the following permutations:
	
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]

 * @author Yan Kang
 *
 */
public class Permutations_wDistinctNumbers {
	public List<List<Integer>> permute(int[] nums) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		if (nums == null || nums.length == 0)
			return result;

		// to compute permutations of an array with distinct number, each number
		// should be put in one and only one position of the array. We can use
		// an array or map to track the usage of each number to prevent it being
		// used more than once.
		boolean[] used = new boolean[nums.length];
		find(nums, 0, used, new LinkedList<Integer>(), result);
		return result;
	}

	private void find(int[] nums, int index, boolean used[], LinkedList<Integer> path,
			LinkedList<List<Integer>> result) {
		if (index == nums.length)
			result.add(new LinkedList<Integer>(path));

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			path.add(nums[i]);
			used[i] = true;
			find(nums, index + 1, used, path, result);
			used[i] = false;
			path.removeLast();
		}
	}
}
