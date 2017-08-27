package kang.interview.programming.binarytree.subtree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 508. Most Frequent Subtree Sum:
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 * 
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

	Examples 1
	Input:
	
	  5
	 /  \
	2   -3
	return [2, -3, 4], since all the values happen only once, return all of them in any order.
	Examples 2
	Input:
	
	  5
	 /  \
	2   -5
	return [2], since 2 happens twice, however -5 only occur once.
	Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

 * @author Yan Kang
 *
 */
public class MostFrequentSubtreeSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private int max;

	public int[] findFrequentTreeSum(TreeNode root) {
		if (root == null)
			return new int[0];

		Map<Integer, Integer> map = new HashMap<>();
		max = 0;
		findSum(root, map);

		List<Integer> temp = new LinkedList<>();
		for (int k : map.keySet()) {
			if (map.get(k) == max)
				temp.add(k);
		}
		return temp.stream().mapToInt(i -> i).toArray();
	}

	private int findSum(TreeNode root, Map<Integer, Integer> map) {
		if (root == null)
			return 0;

		int sum = findSum(root.left, map) + findSum(root.right, map) + root.val;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		max = Math.max(max, map.get(sum));
		return sum;
	}
}
