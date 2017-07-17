package kang.interview.programming.binarytree;

/**
 * Elements of Programming P158 10.4
 * 
 * @author Yan Kang
 *
 */
public class LowestCommonAncestor_BinaryTreeWithParent {

	public static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
		Tree<Integer> parent; 
	}

	public Tree<Integer> lcs(Tree<Integer> node1, Tree<Integer> node2) {

		int depth1 = getDepth(node1);
		int depth2 = getDepth(node2);

		int diff = Math.abs(depth2 - depth1);
		if (depth1 > depth2) {
			while (diff-- > 0) {
				node1 = node1.parent;
			}

		} else if (depth1 < depth2) {
			while (diff-- > 0) {
				node2 = node2.parent;
			}
		}

		while (node1 != null) {
			if (node1.value.equals(node2.value)) {
				return node1;
			}
			node1 = node1.parent;
			node2 = node2.parent;
		}

		return null;

	}

	private int getDepth(Tree<Integer> node1) {
		int depth = 0;
		while (node1 != null) {
			depth++;
			node1 = node1.parent;
		}
		return depth;
	}
}
