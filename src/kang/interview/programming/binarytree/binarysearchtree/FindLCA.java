package kang.interview.programming.binarytree.binarysearchtree;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;

public class FindLCA {

	public TreeNode findLCA(TreeNode node, TreeNode leftNode, TreeNode rightNode) {
		while (node != null) {
			if (node.data < leftNode.data) {
				node = node.right;
			} else if (node.data > rightNode.data) {
				node = node.left;
			} else {
				return node;
			}
		}
		return null;
	}

	public static void main(String[] arg) {
		FindLCA c = new FindLCA();
		System.out.println(
				c.findLCA(ZTestDataCreator.createBinarySearchTree(), ZTestDataCreator.L, ZTestDataCreator.N).data);
	}
}
