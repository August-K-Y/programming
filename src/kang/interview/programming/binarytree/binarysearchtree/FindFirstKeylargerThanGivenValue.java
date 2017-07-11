package kang.interview.programming.binarytree.binarysearchtree;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;

public class FindFirstKeylargerThanGivenValue {
	
	public TreeNode find(TreeNode node, int value) {
		
		TreeNode min = null;
		while(node != null) 
		{
			if(value == node.val) {
				node = leftMost(node.right);
				if(node == null)
					return min;
			} else if (value > node.val){
				node = node.right;
			} else {
				// value < node.val case

				// Note: this node is a candidate for the next value in the tree
				// of the given value. But, we keeps searching
				min = node;
				node = node.left;
			}
		}

		return min;
		
	}

	private TreeNode leftMost(TreeNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public static void main(String[] arg) 
	{
		FindFirstKeylargerThanGivenValue c = new FindFirstKeylargerThanGivenValue();
		System.out.println(c.find(ZTestDataCreator.createBinarySearchTree(), 14).val);
	}

}
