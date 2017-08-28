package kang.interview.programming.recursive.backtracking.permutation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 90. Subsets II:
 * https://leetcode.com/problems/subsets-ii/description/
 * 
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,2], a solution is:
 * 
 * [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author Yan Kang
 *
 */
public class Subset_II {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if (nums == null || nums.length == 0)
			return result;

		Arrays.sort(nums);
		
		LinkedList<Integer> list = new LinkedList<>();
		find(nums, 0, list, result);
		return result;
	}

	private void find(int[] nums, int index, LinkedList<Integer> list, List<List<Integer>> result) {
		result.add(new LinkedList<>(list));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1])
				continue;
			list.add(nums[i]);
			find(nums, i + 1, list, result);
			list.removeLast();

		}
	}
}
