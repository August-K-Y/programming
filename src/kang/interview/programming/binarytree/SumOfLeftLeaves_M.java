package kang.interview.programming.binarytree;

import java.util.Stack;

/**
 * LeetCode 404. Sum of Left Leaves:
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 * 
 * Find the sum of all left leaves in a given binary tree.

	Example:
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	
	There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

 * @author Yan Kang
 *
 */
public class SumOfLeftLeaves_M {
	
	/**
	 * In order traversal
	 * 
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;

		Stack<TreeNode> s = new Stack<>();
		int sum = 0;
		TreeNode cur = root;
		while (!s.isEmpty() || cur != null) {
			if (cur != null) {
				s.push(cur);

				cur = cur.left;

				// IMPORTANT check if the left node is a left leave, if yes, add
				// the value to the sum.
				if (cur != null && cur.left == null && cur.right == null)
					sum += cur.val;

			} else {
				TreeNode top = s.pop();
				cur = top.right;
			}
		}
		return sum;

	}
	
	// TODO: Using level by level search
}
