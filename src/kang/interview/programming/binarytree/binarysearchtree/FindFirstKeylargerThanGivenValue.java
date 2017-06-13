package kang.interview.programming.binarytree.binarysearchtree;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;

public class FindFirstKeylargerThanGivenValue {
	
	public TreeNode find(TreeNode node, int value) {
		
		TreeNode min = null;
		while(node != null) 
		{
			if(value == node.data) {
				node = leftMost(node.right);
				if(node == null)
					return min;
			} else if (value > node.data){
				node = node.right;
			} else {
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
		System.out.println(c.find(ZTestDataCreator.createBinarySearchTree(), 14).data);
	}

}
