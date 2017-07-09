package kang.interview.programming.binarytree.binarysearchtree;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;

public class CheckBinarySearchTreeProperty {
	
	public boolean checkBSTProperty(TreeNode node) {
		if(node == null)
			return true;
		
		if (node.left != null && node.val < node.left.val)
			return false;

		if (node.right != null && node.val > node.right.val)
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
