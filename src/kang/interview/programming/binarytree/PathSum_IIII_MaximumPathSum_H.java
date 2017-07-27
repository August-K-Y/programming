package kang.interview.programming.binarytree;

/**
 * LeetCode 124. Binary Tree Maximum Path Sum:
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/#/description
 * 
 * Given a binary tree, find the maximum path sum.
	
	For this problem, a path is defined as any sequence of nodes from some starting 
	node to any node in the tree along the parent-child connections. The path must 
	contain at least one node and does not need to go through the root.
	
	For example:
	Given the below binary tree,
	
	       1
	      / \
	     2   3
	Return 6.
 * 
 * @author Yan Kang
 *
 */
public class PathSum_IIII_MaximumPathSum_H {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * 
	 * 
	 */
	private int globalMax;;
	public int maxPathSum(TreeNode root) {
		if (root == null) return 0;
		globalMax = Integer.MIN_VALUE;
		find(root);
		return globalMax;
	}
	  
	public int find(TreeNode root) {
		if (root == null) return 0;
		int left = find(root.left);
		int right = find(root.right);
		int localMax = Math.max(root.val + left, root.val);
		localMax = Math.max(localMax + right, localMax);
		globalMax = Math.max(globalMax, localMax);
		return Math.max(Math.max(left, right) + root.val, root.val);
	}
	
	
	/**
	 * 
	 * 
	 */
	int maxValue;
	public int maxPathSum_(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		maxPathDown(root);
		return maxValue;
	}

	private int maxPathDown(TreeNode node) {
		if (node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left));
		int right = Math.max(0, maxPathDown(node.right));
		maxValue = Math.max(maxValue, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
}
