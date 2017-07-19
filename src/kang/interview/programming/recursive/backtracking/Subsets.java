package kang.interview.programming.recursive.backtracking;

import java.util.LinkedList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 78. Subsets: https://leetcode.com/problems/subsets/#/description
 * 
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example, If nums = [1,2,3], a solution is:
 * 
 * [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 * 
 * @author Yan Kang
 *
 */
public class Subsets {
	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		LinkedList<Integer> sb = new LinkedList<>();
		compute(0, nums, sb, lists);
		return lists;
	}

	private void compute(int index, int[] nums, LinkedList<Integer> sb, List<List<Integer>> lists) {
		if (nums.length >= sb.size()) {
			lists.add(new LinkedList<Integer>(sb));
		} else {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			sb.add(nums[i]);
			compute(i + 1, nums, sb, lists);
			sb.removeLast();
		}
	}
	
	public static void main(String[] args){
		Subsets alg = new Subsets();
		int[] nums = {1,2,3};
		
		DataPrinter.print2DList(alg.subsets(nums));
	}
}
