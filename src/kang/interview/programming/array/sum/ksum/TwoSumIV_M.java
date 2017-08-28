package kang.interview.programming.array.sum.ksum;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 653. Two Sum IV - Input is a BST:
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 * 
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

	Example 1:
	Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
	
	Target = 9
	
	Output: True
	Example 2:
	Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
	
	Target = 28
	
	Output: False

 * Solution;
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/
 * 
 * @author Yan Kang
 *
 */
public class TwoSumIV_M {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * In-order traverse the tree to get the sorted tree nodes and then using
	 * normal way to solve the two sum problem
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget(TreeNode root, int k) {
		if (root == null)
			return false;

		List<Integer> list = new ArrayList<>();
		fill(root, list);

		int start = 0;
		int end = list.size() - 1;

		while (start < end) {
			int val = list.get(start) + list.get(end);
			if (val == k) {
				return true;
			} else if (val < k) {
				start++;
			} else {
				end--;
			}
		}
		return false;
	}

	private void fill(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		fill(node.left, list);
		list.add(node.val);
		fill(node.right, list);
	}

	
	
	
	
	/**
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public boolean findTarget_(TreeNode root, int k) {
		if (root == null)
			return false;
		return dfs(root, root, k);
	}

	private boolean dfs(TreeNode root, TreeNode curr, int target) {
		if (curr == null)
			return false;
		return search(root, curr, target - curr.val) || dfs(root, curr.left, target) || dfs(root, curr.right, target);
	}

	/**
	 * Search the (sub-)tree starting from <code>root</code> for node that has
	 * value of <code>target</code> and is not the same node as
	 * <code>curr</code>
	 * 
	 * @param root
	 * @param curr
	 * @param target
	 * @return
	 */
	private boolean search(TreeNode root, TreeNode curr, int target) {
		if (root == null)
			return false;
		if (root.val == target && root != curr) {
			return true;
		} else if (root.val > target) {
			return search(root.left, curr, target);
		} else {
			return search(root.right, curr, target);
		}
	}
}
