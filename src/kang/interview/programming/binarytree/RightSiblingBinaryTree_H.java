package kang.interview.programming.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RightSiblingBinaryTree_H {
	
	/**
	 * 
	 * @param node
	 */
	public void createRightSibling0(TreeNode node){
		
	}
	
	/**
	 * 
	 * @param node
	 */
	public void createRightSibling1(TreeNode node) {

		if (node.left == null)
			return;

		node.left.rightSibling = node.right;
		node.right.rightSibling = node.rightSibling.left;

		createRightSibling1(node.left);
		createRightSibling1(node.right);
	}

	/**
	 * 
	 * @param root
	 */
	public void createRightSibling2(TreeNode root) {
		
		TreeNode rightChild = root.right;
		root.right = null;
		createRightSibling2(root, rightChild);
	}
	public void createRightSibling2(TreeNode node, TreeNode rightChild) {

		if (node.left == null)
			return;

		TreeNode leftChildRight = node.left.right;
		node.left.right = rightChild;

		TreeNode rightChildRight = rightChild.right;
		rightChild.right = node.right.left;

		createRightSibling2(node.left, leftChildRight);
		createRightSibling2(rightChild, rightChildRight);

	}
	
	/**
	 * 
	 * @param node
	 */
	public void createRightSibling3(TreeNode node) {
		if (node == null)
			return;

		Queue<TreeNode> tracking = new LinkedList<>();
		int nextLevel = 0;
		int currLevel = 1;
		tracking.add(node);
		while (!tracking.isEmpty()) {
			TreeNode top = tracking.remove();
			currLevel--;
			if (top.left != null) {
				nextLevel++;
				tracking.add(top.left);
			}
			if (top.right != null) {
				nextLevel++;
				tracking.add(top.right);
			}

			if (currLevel == 0) {
				currLevel = nextLevel;
				nextLevel = 0;
				setRightSibling(tracking);
			}
		}
	}

	private void setRightSibling(Queue<TreeNode> tracking) {
		TreeNode prev = null;
		Iterator<TreeNode> iterator = tracking.iterator();
		while (iterator.hasNext()) {
			TreeNode curr = iterator.next();
			if (prev != null) {
				prev.rightSibling = curr;
			}
			prev = curr;
		}
	}

}
