package kang.interview.programming.binarytree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.binarytree.TreeNode;

public class FindKLargestElementsOfBST_M {

	public List<TreeNode> find(TreeNode node, int k) {

		List<TreeNode> result = new ArrayList<>(k);

		TreeNode largestNode = findLargest(node);
		result.add(largestNode);
		TreeNode temp = largestNode;
		while (k > 0) {
			if (temp == null)
				return result;

			temp = findPrevious(temp);
			result.add(temp);
			k--;
		}

		return result;

	}

	private TreeNode findPrevious(TreeNode node) {
		if (node.left == null) {
			// TODO
			return null;
		} else {
			return findLargest(node.left);
		}
	}

	private TreeNode findLargest(TreeNode node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
}
