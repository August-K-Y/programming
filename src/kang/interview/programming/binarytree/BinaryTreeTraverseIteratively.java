package kang.interview.programming.binarytree;

import java.util.Stack;

public class BinaryTreeTraverseIteratively {

	public void inorderTraverse(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> tracing = new Stack<TreeNode>();
		TreeNode curr = root;
		while (!tracing.isEmpty() || curr != null) {
			if (curr != null) {
				tracing.push(curr);
				curr = curr.left;
			} else {
				TreeNode top = tracing.pop();
				visit(top);
				curr = top.right;
			}
		}
	}

	public void preorderTraverse(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> tracing = new Stack<TreeNode>();
		TreeNode curr = root;
		while (!tracing.isEmpty() || curr != null) {
			if (curr != null) {
				visit(curr);
				tracing.push(curr);
				curr = curr.left;
			} else {
				TreeNode top = tracing.pop();
				curr = top.right;
			}
		}
	}

	public void postorderTraverse(TreeNode root) {
	}

	private void visit(TreeNode top) {
		System.out.print(top.val + " ");
	}

	public static void main(String[] args) {
		TreeNode root = ZTestDataCreator.createBinaryTree();

		BinaryTreeTraverseIteratively r = new BinaryTreeTraverseIteratively();

		r.inorderTraverse(root);
		System.out.println();
		r.preorderTraverse(root);
		System.out.println();
	}
}
