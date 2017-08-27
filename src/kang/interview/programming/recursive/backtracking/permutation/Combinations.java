package kang.interview.programming.recursive.backtracking.permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 77. Combinations:
 * https://leetcode.com/problems/combinations/description/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]

 * @author Yan Kang
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new LinkedList<>();
		if (n == 0)
			return result;

		find(n, k, 1, new LinkedList<Integer>(), result);
		return result;
	}

	private void find(int n, int k, int index, LinkedList<Integer> list, List<List<Integer>> result) {
		if (list.size() == k) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = index; i <= n; i++) {
			list.add(i);
			find(n, k, i + 1, list, result);
			list.removeLast();
		}
	}
}
