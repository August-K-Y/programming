package kang.interview.programming.binarytree;

public class BinaryTreeKthNode {

	/**
	 * 
	 * @param node
	 * @param k
	 * @return
	 */
	public TreeNode findKthNodeRecursively(TreeNode node, int k) {
		if (node == null)
			return null;

		int leftSize = node.left == null ? 0 : node.left.size;
		if (k == leftSize + 1) {
			return node;
		} else if (k > leftSize + 1) {
			return findKthNodeRecursively(node.right, k - leftSize - 1);
		} else {
			return findKthNodeRecursively(node.left, k);
		}
	}

	public TreeNode findKthNodeIteratively(TreeNode node, int k) {
		if (node == null)
			return null;

		TreeNode curr = node;
		while (curr != null) {
			int leftSize = curr.left == null ? 0 : curr.left.size;
			if (k == leftSize + 1) {
				return curr;
			} else if (k > leftSize + 1) {
				curr = curr.right;
				k -= (leftSize + 1);
			} else {
				curr = curr.left;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		TreeNode root = ZTestDataCreator.createBinaryTree();

		BinaryTreeKthNode r = new BinaryTreeKthNode();

		TreeNode node = r.findKthNodeRecursively(root, 6);
		System.out.println(node.Id);
		node = r.findKthNodeRecursively(root, 12);
		System.out.println(node.Id);
		
		node = r.findKthNodeIteratively(root, 6);
		System.out.println(node.Id);
		
		node = r.findKthNodeIteratively(root, 12);
		System.out.println(node.Id);
	}

}
