package kang.interview.programming.binarytree;

import java.util.LinkedList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 113. Path Sum II:
 * https://leetcode.com/problems/path-sum-ii/#/description
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

	For example:
	Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]


 * @author Yan Kang
 *
 */
public class PathSum_II_RootToLeafPathsOfGivenSum {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		LinkedList<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		LinkedList<Integer> bus = new LinkedList<>();
		findPaths(root, sum, bus, result);
		return result;
	}

	private void findPaths(TreeNode node, int sum, LinkedList<Integer> bus, LinkedList<List<Integer>> result) {
		if (node == null)
			return;

		bus.add(node.val);
		if (node.left == null && node.right == null && sum - node.val == 0) {
			result.add(new LinkedList<>(bus));
		}

		findPaths(node.left, sum - node.val, bus, result);
		findPaths(node.right, sum - node.val, bus, result);
		bus.removeLast();

	}
	
	public static void main(String[] args) {
		PathSum_II_RootToLeafPathsOfGivenSum alg = new PathSum_II_RootToLeafPathsOfGivenSum();
		
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(11);
		TreeNode node5 = new TreeNode(13);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(2);
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node7;
		node4.right = node8;
		node3.left = node5;
		node3.right = node6;
		node6.left = node9;
		node6.right = node10;

		List<List<Integer>> result = alg.pathSum(node1, 22);
		DataPrinter.print2DList(result); // [5,4,11,2], [5,8,4,5]
		
	}
}
