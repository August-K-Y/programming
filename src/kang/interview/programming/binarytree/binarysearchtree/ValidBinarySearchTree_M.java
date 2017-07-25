package kang.interview.programming.binarytree.binarysearchtree;

import java.util.LinkedList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 98. Validate Binary Search Tree:
 * https://leetcode.com/problems/validate-binary-search-tree/#/description
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	Example 1:
	    2
	   / \
	  1   3
	Binary tree [2,1,3], return true.
	Example 2:
	    1
	   / \
	  2   3
	Binary tree [1,2,3], return false.


 * @author Yan Kang
 *
 */
public class ValidBinarySearchTree_M {
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
	 * @param root
	 * @return
	 */
	public boolean isValidBST_WRONG(TreeNode root) {
		if(root == null)
			return true;
		
		if(root.left != null && root.left.val >= root.val)
			return false;
		
		if(root.right != null && root.right.val <= root.val)
			return false;
		
		return isValidBST_WRONG(root.left) && isValidBST_WRONG(root.right) ;
	}
	
	/**
	 * Failed on corner cases: when max value of the BST is Integer.MAX_VALUE or
	 * min value of the BST is Integer.MIN_VALUE.
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		
		return checkValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ;
	}
	
	private boolean checkValid(TreeNode root, int min, int max) {
		if(root == null)
			return true;
		
		if(root.val >= min || root.val <= max)
			return false;
		
		return checkValid(root.left, min, root.val) && checkValid(root.right, root.val, max);
	}
	
	/**
	 * Bob Dondero's elegant solution (Algorithm 4 version)
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBST(TreeNode root) {
		// if min or max is null, treat as empty constraint
		return isBST(root, null, null);
	}

	private boolean isBST(TreeNode x, Integer min, Integer max) {
		if (x == null)
			return true;
		if (min != null && x.val <= min)
			return false;
		if (max != null && x.val >= max)
			return false;
		return isBST(x.left, min, x.val) && isBST(x.right, x.val, max);
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST_(TreeNode root) {
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;

		List<Integer> list = new LinkedList<>();
		traverse(root, list);

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) <= list.get(i - 1))
				return false;
		}
		return true;
	}

	private void traverse(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		traverse(root.left, list);
		list.add(root.val);
		traverse(root.right, list);
	}
	
	
	public static void main(String[] args) {
		
		ValidBinarySearchTree_M alg = new ValidBinarySearchTree_M();
		
//		[10,5,15,null,null,6,20]
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(20);
		
		node1.right = node3;
		node1.left = node2;
		node3.right = node5;
		node3.left = node4;
		
		DataPrinter.println(alg.isValidBST_WRONG(node1));
		DataPrinter.println(alg.isValidBST_(node1));
		
	}
	
}
