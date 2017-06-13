package kang.interview.programming.binarytree;

public class CheckHeightBalancedTree {
	
	public boolean isHeightBalancedTree(TreeNode root) {
		int height = height(root);
		return height == -1 ? false : true;
	}

	public int height(TreeNode node) {

		if (node == null)
			return 0;
		
		int leftHeight = height(node.left); 
		int rightHeight = height(node.right);
		
		if(leftHeight == -1 || rightHeight == -1) 
		{
			return -1;
		}
		else {
			int diff = Math.abs(leftHeight - rightHeight);
			if(diff > 1)
				return -1;
			return Math.max(leftHeight, rightHeight) + 1;
		}
		
	}


}
