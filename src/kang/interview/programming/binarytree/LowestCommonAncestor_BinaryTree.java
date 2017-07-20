package kang.interview.programming.binarytree;

/**
 * LeetCode 236. Lowest Common Ancestor of a Binary Tree Given a binary tree,
 * find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).
 * 
 *      _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 * 
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another
 * example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of
 * itself according to the LCA definition.
 * 
 * @see kang.interview.programming.binarytree.binarysearchtree.
 *      LowestCommonAncestor_BinarySearchTree
 * @see https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/
 *      description
 * @see Cracking the codeing interview (first edition) P230
 * @author Yan Kang
 */
public class LowestCommonAncestor_BinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Assuming that node1 and node2 are nodes of tree rooted at root time
	 * complexity O(n^2)
	 * 
	 * @param root
	 *            the root of a tree or subtree
	 * @param p
	 *            node one
	 * @param q
	 *            node two
	 * @return the lowest common ancestor of node one and node two
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;

		boolean onLeft1 = contains(root.left, p);
		boolean onLeft2 = contains(root.left, q);

		// If p and q are on different sides
		if (onLeft1 != onLeft2)
			return root;

		// If p and q are on the same side. Traverse this side.
		TreeNode childSide = onLeft1 ? root.left : root.right;
		return lowestCommonAncestor(childSide, p, q);
	}

	private boolean contains(TreeNode root, TreeNode node) {
		if (root == null)
			return false;
		if (root.val == node.val)
			return true;
		return contains(root.left, node) || contains(root.right, node);
	}
	
	/**
	 * Does not work for only one tree node exists as a child of root??? Verify this
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor_(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.val == p.val || root.val == q.val)
			return root;
		TreeNode left = lowestCommonAncestor_(root.left, p, q);
		TreeNode right = lowestCommonAncestor_(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
	
	public static void main(String[] arg) {

		TreeNode node1 = new TreeNode(37);
		TreeNode node2 = new TreeNode(-34);
		TreeNode node3 = new TreeNode(-48);
		TreeNode node4 = new TreeNode(-50);
		TreeNode node5 = new TreeNode(-100);
		TreeNode node6 = new TreeNode(48);
		TreeNode node7 = new TreeNode(-71);
		TreeNode node8 = new TreeNode(-22);
		
		TreeNode node9 = new TreeNode(200);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.right = node4;
		
		node3.left = node5;
		node3.right = node6;
		
		node6.left = node7;
		node6.right = node8;
		
		LowestCommonAncestor_BinaryTree lca = new LowestCommonAncestor_BinaryTree();
		TreeNode result = lca.lowestCommonAncestor(node1, node5, node9);
		System.out.println("result: " + result.val);
		
		TreeNode result2 = lca.lowestCommonAncestor_(node1, node5, node9);
		System.out.println("result: " + result2.val);
	}

}
