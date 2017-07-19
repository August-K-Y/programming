package kang.interview.programming.binarytree.binarysearchtree;

import java.util.Stack;

/**
 * 
 * 
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 * 
 * 
 * @author Yan Kang
 *
 */
public class BinearySearchTreeIterator_M {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class BSTIterator {

	    private Stack<TreeNode> stack = new Stack<TreeNode>();
	    
	    public BSTIterator(TreeNode root) {
	        pushAll(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        TreeNode tmpNode = stack.pop();
	        pushAll(tmpNode.right);
	        return tmpNode.val;
	    }

		private void pushAll(TreeNode node) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
	    
	    /*
	     * 
	     * 
	     * 
	     * 
	     * 
	     */
	    
	    
//		private int k;
//		private TreeNode cursor;
//		private Queue<TreeNode> q = new LinkedList<>();
//		public BSTIterator(TreeNode root) {
//			cursor = root;
//			k = getHeight(root);
//			inorderTraverse(root, k);
//		}
//
//		private int getHeight(TreeNode root) {
//			if (root == null)
//				return 0;
//
//			return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
//		}
//
//		/** @return whether we have a next smallest number */
//		public boolean hasNext() {
//			if(q.isEmpty()) {
//				inorderTraverse(cursor.right, k);
//			}
//			
//			return q.peek() != null;
//		}
//
//		/** @return the next smallest number */
//		public int next() {
//			TreeNode top = q.remove();
//			return top.val;
//		}
//		
//		private void inorderTraverse(TreeNode node, int k){
//			if (node == null)
//				return;
//			inorderTraverse(node.left, k);
//			q.add(node);
//			cursor = node;
//			if (q.size() == k) {
//				return;
//			}
//			inorderTraverse(node.right, k);
//		}
	}


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
