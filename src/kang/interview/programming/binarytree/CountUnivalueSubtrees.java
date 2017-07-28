package kang.interview.programming.binarytree;

import kang.interview.programming.binarytree.PopulatingNextRightPointers_I.TreeLinkNode;
import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 250. Count Univalue Subtrees:
 * https://leetcode.com/problems/count-univalue-subtrees/tabs/description
 * 
 * Given a binary tree, count the number of uni-value subtrees.

	A Uni-value subtree means all nodes of the subtree have the same value.
	
	For example:
	Given binary tree,
	              5
	             / \
	            1   5
	           / \   \
	          5   5   5
	return 4.


 * @author yankang
 *
 */
public class CountUnivalueSubtrees {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private int count;
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;
		count = 0;
		check(root, 0);
		return count;
	}
	private boolean check(TreeNode node, int parentValue) {
		if (node == null)
			return true;
		boolean left = check(node.left, node.val);
		boolean right = check(node.right, node.val);
		if (left && right) {
			count++;
			if (parentValue == node.val)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		
		CountUnivalueSubtrees alg = new CountUnivalueSubtrees();
		DataPrinter.println(alg.countUnivalSubtrees(node1));
	}
}
