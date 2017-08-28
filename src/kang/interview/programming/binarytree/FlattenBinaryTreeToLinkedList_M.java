package kang.interview.programming.binarytree;

/**
 * 
 * LeetCode 114. Flatten Binary Tree to Linked List: 
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/tabs/description/
 * 
	Given a binary tree, flatten it to a linked list in-place.
	
	For example,
	Given
	
	         1
	        / \
	       2   5
	      / \   \
	     3   4   6
	The flattened tree should look like:
	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6
	             
	             
 * @author yankang
 *
 */
public class FlattenBinaryTreeToLinkedList_M {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		doFlatten(root);
	}

	private TreeNode doFlatten(TreeNode root) {
		if (root == null)
			return null;

		TreeNode temp = root.right;
		
		root.right = doFlatten(root.left);
		root.left = null;
		
		TreeNode cur = root;
		while (cur.right != null) cur = cur.right;
		cur.right = doFlatten(temp);
		
		return root;
	}
	
	/**
	 * TODO: understand this
	 * @param root
	 */
	public void flatten_(TreeNode root) {
	    if (root == null)
	        return;
	    flatten(root.right);
	    flatten(root.left);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}
	private TreeNode prev = null;
	
	
	// TODO: do it iteratively
}
