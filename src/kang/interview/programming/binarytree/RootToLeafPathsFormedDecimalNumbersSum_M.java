package kang.interview.programming.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * We're going to store numbers in a tree. Each node in this tree will store a single digit (from 0 to 9), 
 * and each path from root to leaf encodes a non-negative integer.

	Given a binary tree t, find the sum of all the numbers encoded in it.
	
	Example
	
	For
	t = {
	    "value": 1,
	    "left": {
	        "value": 0,
	        "left": {
	            "value": 3,
	            "left": null,
	            "right": null
	        },
	        "right": {
	            "value": 1,
	            "left": null,
	            "right": null
	        }
	    },
	    "right": {
	        "value": 4,
	        "left": null,
	        "right": null
	    }
	}
	the output should be
	digitTreeSum(t) = 218.
	There are 3 numbers encoded in this tree:
	
	Path 1->0->3 encodes 103
	Path 1->0->1 encodes 101
	Path 1->4 encodes 14
	and their sum is 103 + 101 + 14 = 218.
	t = {
	    "value": 0,
	    "left": {
	        "value": 9,
	        "left": null,
	        "right": null
	    },
	    "right": {
	        "value": 9,
	        "left": {
	            "value": 1,
	            "left": null,
	            "right": null
	        },
	        "right": {
	            "value": 3,
	            "left": null,
	            "right": null
	        }
	    }
	}
	the output should be
	digitTreeSum(t) = 193.
	Because 09 + 091 + 093 = 193
 * 
 * @see {@link RootToLeafPathsFormedBinaryNumberSum}
 * @see {@link BinaryTreeIterativeTraversal_M}
 * @see {@link PathSum_I_RootToLeadPathWithGivenSum}
 * @see http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 * @author Yan Kang
 *
 */
public class RootToLeafPathsFormedDecimalNumbersSum_M {
	public static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	/**
	 * Recursive version of the digit tree sum algorithm. This is simple, just
	 * do the normal recursive pre-order binary tree traversal and pass the
	 * cumulative sum down the tree. When reach the leaf, recording the sum of a
	 * path in the result list serving like a bus accumulate the sums.
	 * 
	 * @param t
	 * @return
	 */
	long digitTreeSum(Tree<Integer> t) {
		if (t == null) return 0;
		
		List<Long> result = new LinkedList<>();
		computeSum(t, 0, result);
		
		// this is the stream way of create the sum of a list
		return result.stream().mapToLong(i -> i).sum();
	}

	private void computeSum(Tree<Integer> t, long sum, List<Long> result) {
		if (t == null) return;
		sum = sum * 10 + t.value;
		if (t.left == null && t.right == null) {
			result.add(sum);
		}
		computeSum(t.left, sum, result);
		computeSum(t.right, sum, result);
	}
	
	/**
	 * 
	 * The same as the first algorithm that using recursive method to traverse
	 * the tree and pass down the cumulative sum.
	 * 
	 * The difference is that this method does not use a bus-like result list to
	 * accumulate the sums of paths. Instead, it passes up the calculated sum
	 * for each path and adds them together along the way up.
	 * 
	 * @param t
	 * @return
	 */
	long digitTreeSum_(Tree<Integer> t) {
		if (t == null) return 0;
		return computeSum_(t, 0);
	}

	private long computeSum_(Tree<Integer> t, long sum) {
		if (t == null) return 0;
		sum = sum * 10 + t.value;
		if (t.left == null && t.right == null) {
			return sum;
		}
		return computeSum_(t.left, sum) + computeSum_(t.right, sum);
	}
	
	/**
	 * Iterative algorithm.
	 * 
	 * Recursive algorithm has a built-in stack mechanism that the called
	 * function stores variables passed down from calling function (typically
	 * the same one as current function) and variables created locally into a
	 * stack (i.e., current states). Then, when the called function finishes its
	 * task, the calling function and all its variables from the stack are
	 * restored (previous states).
	 * 
	 * If using iterative algorithm to achieve the same effect, we have to mimic
	 * the stack mechanism (e.g. using Java Stack class) or use some other ways
	 * to store current states (e.g., passed-down and local variables) and
	 * restore previous state.
	 * 
	 * @param t
	 * @return
	 */
	long digitTreeSum__(Tree<Integer> t) {
		if (t == null)
			return 0;

		Stack<TreeHolder> stack = new Stack<>();
		TreeHolder d = new TreeHolder(t, t.value);
		List<Long> result = new LinkedList<>();
		while (d != null || !stack.isEmpty()) {
			if (d != null) {
				stack.add(d);
				d = d.left();
			} else {
				TreeHolder node = stack.pop();
				if (node.left() == null && node.right() == null) {
					result.add(node.num);
				} else {
					d = node.right();
				}
			}
		}
		return result.stream().mapToLong(i -> i).sum();
	}
	
	class TreeHolder{
		Tree<Integer> tree;
		long num;
		public TreeHolder(Tree<Integer> tree, long num) {
			this.tree = tree;
			this.num = num;
		}
		
		public TreeHolder left() {
			return tree.left == null ? null : new TreeHolder(tree.left, (num * 10 + tree.left.value));
		}
		
		public TreeHolder right() {
			return tree.right == null ? null : new TreeHolder(tree.right, (num * 10 + tree.right.value));
		}
	}
	
	public static void main(String[] args) {
		RootToLeafPathsFormedDecimalNumbersSum_M d = new RootToLeafPathsFormedDecimalNumbersSum_M();
		Tree<Integer> tree1 = new Tree<>(1);
		Tree<Integer> tree2 = new Tree<>(0);
		Tree<Integer> tree3 = new Tree<>(4);
		Tree<Integer> tree4 = new Tree<>(3);
		Tree<Integer> tree5 = new Tree<>(1);
		
		tree1.left = tree2;
		tree1.right = tree3;
		
		tree2.left = tree4;
		tree2.right = tree5;
		
		
		System.out.println(d.digitTreeSum_(tree1));
	}
}
