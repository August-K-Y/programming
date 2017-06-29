package kang.interview.programming.binarytree;

/**
 * 
 * @see kang.interview.programming.binarytree.CheckSymmetricTree
 * @author Yan Kang
 *
 */
public class _CheckSymmetriTree {
	class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	boolean isTreeSymmetric(Tree<Integer> t) {
		return t == null || isSymmetric(t.right, t.left);
	}

	private boolean isSymmetric(Tree<Integer> right, Tree<Integer> left) {
		if (right == null && left == null) {
			return true;
		} else if (right != null && left != null) {
			return right.value.equals(left.value) && isSymmetric(right.right, left.left)
					&& isSymmetric(right.left, left.right);
		}
		return false;
	}
}
