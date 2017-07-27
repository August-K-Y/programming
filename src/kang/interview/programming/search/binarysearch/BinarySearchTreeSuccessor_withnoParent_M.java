package kang.interview.programming.search.binarysearch;

/**
 * LeetCode 285. Inorder Successor in BST
 * https://leetcode.com/problems/inorder-successor-in-bst/#/description
 * 
 * Given a binary search tree and a node in it, find the in-order successor of
 * that node in the BST.
 * 
 * Note: If the given node has no in-order successor in the tree, return null.
 * 
 * 
 * @see {@link BinarySearchFirstOccurenceOfBiggerValue_M}
 * @author Yan Kang
 *
 */
public class BinarySearchTreeSuccessor_withnoParent_M {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * The idea is to compare root's value with p's value if root is not null,
	 * and consider the following two cases:
	 * <ol>
	 * <li>root.val > p.val. In this case, root can be a possible answer, so we
	 * store the root node first and call it res. However, we don't know if
	 * there is anymore node on root's left that is larger than p.val. So we
	 * move root to its left and check again.</li>
	 * <li>root.val <= p.val. In this case, root cannot be p's inorder
	 * successor, neither can root's left child. So we only need to consider
	 * root's right child, thus we move root to its right and check again.</li>
	 * </ol>
	 * We continuously move root until exhausted. To this point, we only need to
	 * return the res in case 1.
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while (root != null) {
			if (root.val > p.val) {
				res = root;
				root = root.left;
			} else
				root = root.right;
		}
		return res;
	}
	
	
	/**
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public TreeNode inorderSuccessor_(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		} else {
			TreeNode left = inorderSuccessor(root.left, p);
			return (left != null) ? left : root;
		}
	}

	public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;

		if (root.val >= p.val) {
			return inorderPredecessor(root.left, p);
		} else {
			TreeNode right = inorderPredecessor(root.right, p);
			return (right != null) ? right : root;
		}
	}

}
