package kang.interview.programming.binarytree;

public class LowestCommonAncestor {

	/**
	 * Assuming that node1 and node2 are nodes of tree rooted at root time
	 * complexity O(n^2)
	 * 
	 * @param root the root of a tree or subtree
	 * @param node1 node one
	 * @param node2 node two
	 * @return the lowest common ancestor of node one and node two
	 */
	public TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {

		if (root == node1 || root == node2)
			return root;

		boolean onLeft1 = contains(root.left, node1);
		boolean onLeft2 = contains(root.left, node2);

		if (onLeft1 && onLeft2) {
			return findLCA(root.left, node1, node2);
		} else if (!onLeft1 && !onLeft2) {
			return findLCA(root.right, node1, node2);
		}
		return root;
	}

	private boolean contains(TreeNode root, TreeNode node) {
		if (root == null)
			return false;
		if (root.data == node.data)
			return true;
		return contains(root.left, node) || contains(root.right, node);
	}

	public TreeNode findLCA2(TreeNode root, TreeNode node1, TreeNode node2) {
		return null;
	}
}
