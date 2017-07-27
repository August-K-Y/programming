package kang.interview.programming.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 199. Binary Tree Right Side View: 
 * https://leetcode.com/problems/binary-tree-right-side-view/#/description
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.

		For example:
		Given the following binary tree,
		   1            <---
		 /   \
		2     3         <---
		 \     \
		  5     4       <---
		You should return [1, 3, 4].

 * @author Yan Kang
 *
 */
public class BinaryTreeRightSideView_M {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null)
            return list;
        
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int cn = 1;
		int nn = 0;
		while (!queue.isEmpty()) {
			TreeNode top = queue.remove();
			cn--;
			if (top.left != null) {
				queue.add(top.left);
				nn++;
			}

			if (top.right != null) {
				queue.add(top.right);
				nn++;
			}

			// the end of each level, add the last node of each level to the
			// result list
			if (cn == 0) {
				list.add(top.val);
				cn = nn;
				nn = 0;
			}
		}
		return list;
    }

	public static void main(String[] args) {
		BinaryTreeRightSideView_M alg = new BinaryTreeRightSideView_M();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		
		node1.left = node2;
		node2.right = node5;
		node1.right = node3;
		node3.left = node4;
		node5.left = node6;
		node2.left = node7;
		node7.left = node8;
		node8.left = node9;
		
		DataPrinter.println(alg.rightSideView(node1));
		
	}
}
