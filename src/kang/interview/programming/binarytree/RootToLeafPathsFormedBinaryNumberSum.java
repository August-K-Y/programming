package kang.interview.programming.binarytree;

/**
 * 
 * Elements of Programming P159 10.5
 * @see {@link RootToLeafPathsFormedDecimalNumbersSum_M}
 * @author Yan Kang
 *
 */
public class RootToLeafPathsFormedBinaryNumberSum {
	public static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}
	
	public int compute(Tree<Integer> node) {
		return compute(node, 0);
	}

	private int compute(Tree<Integer> t, int sum) {
		if (t == null) return 0;
		sum = sum * 2 + t.value;
		if (t.left == null && t.right == null) {
			return sum;
		}
		return compute(t.left, sum) + compute(t.right, sum);
	}

}
