package kang.interview.programming.binarytree.leveltraversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 637. Average of Levels in Binary Tree:
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 * 
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

	Example 1:
	Input:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Output: [3, 14.5, 11]
	
	Explanation:
	
	The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
	Note:
	The range of node's value is in the range of 32-bit signed integer.

 * @author YK044346
 *
 */
public class AverageOfLevelsInBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new LinkedList<>();
		if (root == null)
			return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		result.add((double) root.val);
		int curr = 1;
		int next = 0;

		double sum = 0;
		while (!q.isEmpty()) {
			TreeNode top = q.remove();
			curr--;
			if (top.left != null) {
				next++;
				sum += top.left.val;
				q.add(top.left);
			}

			if (top.right != null) {
				next++;
				sum += top.right.val;
				q.add(top.right);
			}

			if (curr == 0) {
				// 
				if (next != 0) {
					result.add(sum / next);
				}
				curr = next;
				next = 0;
				sum = 0;
			}
		}
		return result;

	}
}
