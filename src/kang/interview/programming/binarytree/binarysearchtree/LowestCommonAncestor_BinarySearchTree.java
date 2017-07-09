package kang.interview.programming.binarytree.binarysearchtree;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;

/**
 * LeetCode: 235. Lowest Common Ancestor of a Binary Search Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 *      _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 * 
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another
 * example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of
 * itself according to the LCA definition.
 * 
 * 
 * @author Yan Kang
 *@see kang.interview.programming.binarytree.LowestCommonAncestor_BinaryTree
 *@see https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/#/description
 */
public class LowestCommonAncestor_BinarySearchTree {
//	public static class TreeNode {
//		int val;
//		TreeNode left;
//		TreeNode right;
//
//		TreeNode(int x) {
//			val = x;
//		}
//	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode node = root;
		while (node != null) {
			if (node.val < p.val && node.val < q.val) {
				node = node.right;
			} else if (node.val > p.val && node.val > q.val) {
				node = node.left;
			} else {
				return node;
			}
		}
		return null;
	}

	public static void main(String[] arg) {
		LowestCommonAncestor_BinarySearchTree c = new LowestCommonAncestor_BinarySearchTree();
//		System.out.println(
//				c.lowestCommonAncestor(ZTestDataCreator.createBinarySearchTree(), ZTestDataCreator.L, ZTestDataCreator.N).val);
		
		TreeNode node1 = new TreeNode("A", 2);
		TreeNode node2 = new TreeNode("B", 3);
		node1.right = node2;
		TreeNode result = c.lowestCommonAncestor(node1, node2, node1);
		System.out.println(result.val);
	}
}
