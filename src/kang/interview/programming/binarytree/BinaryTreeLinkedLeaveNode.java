package kang.interview.programming.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLinkedLeaveNode {

	public List<String> getLinkedLeaves(TreeNode node) {
		List<String> list = new LinkedList<String>();
		populateList(list, node);
		return list;
	}

	private void populateList(List<String> list, TreeNode node) {
		if (node == null)
			return;

		if (isLeafNode(node)) {
			list.add(node.Id);
		} else {
			populateList(list, node.left);
			populateList(list, node.right);
		}
	}

	private boolean isLeafNode(TreeNode node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = ZTestDataCreator.createBinaryTree();
		BinaryTreeLinkedLeaveNode r = new BinaryTreeLinkedLeaveNode();
		List<String> result = r.getLinkedLeaves(root);
		result.stream().forEach(n -> System.out.print(n + " "));
	}

}
