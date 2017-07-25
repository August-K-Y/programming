package kang.interview.programming.binarytree.binarysearchtree;

import java.util.Stack;

import kang.interview.programming.util.DataPrinter;
import kang.interview.programming.binarytree.BinaryTreeKthNode_M;

/**
 * LeetCode 230. Kth Smallest Element in a BST:
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/description
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ? k ? BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * @see {@link BinaryTreeKthNode_M}
 * @see https://leetcode.com/problems/kth-smallest-element-in-a-bst/#/discuss
 * @author yankang
 *
 */
public class FindKthSmallestElementOfBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k - 1 - count); // 1 is counted as
															// current node
		}
		return root.val;
	}

	public int countNodes(TreeNode n) {
		if (n == null)
			return 0;
		return 1 + countNodes(n.left) + countNodes(n.right);
	}
	
	/**
	 * 
	 */

	private int remain;
	private int val;

	public int kthSmallest_(TreeNode root, int k) {
		remain = k;
		search(root);
		return val;
	}

	private void search(TreeNode root) {
		if (root == null)
			return;
		search(root.left);
		
		if (remain-- == 1) {
			val = root.val;
			return;
		}
		search(root.right);
			
	}

	public int kthSmallest__(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();

		while (root != null) {
			st.push(root);
			root = root.left;
		}

		while (k != 0) {
			TreeNode n = st.pop();
			k--;
			if (k == 0)
				return n.val;
			TreeNode right = n.right;
			while (right != null) {
				st.push(right);
				right = right.left;
			}
		}

		return -1; // never hit if k is valid
	}

	public static void main(String[] args) {
		FindKthSmallestElementOfBST alg = new FindKthSmallestElementOfBST();

		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(1);
		node1.left = node2;
		DataPrinter.println(alg.kthSmallest_(node1, 1));
	}

}
