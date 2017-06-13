package kang.interview.programming.binarytree;

public class CheckSymmetricTree {

	public boolean isSymmetricBinaryTree(TreeNode root) {
		return root == null || isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {

		if (left == null && right == null) {
			return true;
		} else if (left != null && right != null) {

			return left.data == right.data && isSymmetric(left.left, right.right)
					&& isSymmetric(left.right, right.left);

		} else {
			return false;
		}

	}
}
