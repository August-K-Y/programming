package kang.interview.programming.binarytree;

public class BinaryTreeSuccessorAndPredecessor {
	
	public TreeNode findSuccessor(TreeNode node) {

		if (node.right != null) {
			return leftMost(node.right);
		} else {

			TreeNode parent = node.parent;
			while(parent != null && parent.left != node) {
				parent = parent.parent; 
				node = node.parent;
			}
			return parent;
		}
	}

	private TreeNode leftMost(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

}
