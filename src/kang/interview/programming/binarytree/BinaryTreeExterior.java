package kang.interview.programming.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeExterior {

	public List<String> extractExterior(TreeNode node) {
		List<String> list = new LinkedList<>();
		list.add(node.Id);
		poplateLeftMargin(list, node.left);
		poplateLeaves(list, node);
		poplateRightMargin(list.size(), list, node.right);
		return list;
	}

	private void poplateRightMargin(int startIndex, List<String> list, TreeNode node) {
		if (node == null)
			return;
		if (node.left != null || node.right != null)
			list.add(startIndex, node.Id);
		poplateRightMargin(startIndex, list, node.right);
	}

	private void poplateLeaves(List<String> list, TreeNode node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null)
			list.add(node.Id);
		poplateLeaves(list, node.left);
		poplateLeaves(list, node.right);
	}

	private void poplateLeftMargin(List<String> list, TreeNode node) {
		if (node == null)
			return;
		if (node.left != null || node.right != null)
			list.add(node.Id);
		poplateLeftMargin(list, node.left);
	}

	public static void main(String[] args) {
		TreeNode root = ZTestDataCreator.createBinaryTree();
		BinaryTreeExterior r = new BinaryTreeExterior();
		List<String> result = r.extractExterior(root);
		result.stream().forEach(n -> System.out.print(n + " "));
	}
}
