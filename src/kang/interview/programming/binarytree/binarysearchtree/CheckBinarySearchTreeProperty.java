package kang.interview.programming.binarytree.binarysearchtree;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;

public class CheckBinarySearchTreeProperty {
	
	public boolean checkBSTProperty(TreeNode node) {
		if(node == null)
			return true;
		
		if (node.left != null && node.data < node.left.data)
			return false;

		if (node.right != null && node.data > node.right.data)
			return false;

		return checkBSTProperty(node.left) && checkBSTProperty(node.right);
	}
	
	public static void main(String[] arg) 
	{
		CheckBinarySearchTreeProperty c = new CheckBinarySearchTreeProperty();
		System.out.println(c.checkBSTProperty(ZTestDataCreator.createBinaryTree()));
		System.out.println(c.checkBSTProperty(ZTestDataCreator.createBinarySearchTree()));
	}

}
