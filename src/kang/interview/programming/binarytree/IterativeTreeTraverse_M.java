package kang.interview.programming.binarytree;

import java.util.Stack;

/**
 * 
 * @see http://www.programcreek.com/2012/12/leetcode-solution-for-binary-tree-preorder-traversal-in-java/
 * @see http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
 * @see http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
 * @see http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
 * @see http://www.geeksforgeeks.org/iterative-postorder-traversal/
 * 
 * @author Yan Kang
 *
 */
public class IterativeTreeTraverse_M {
	public static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}
	
	public void preorderIterativeTraverse(Tree<Integer> t) {

		Stack<Tree<Integer>> stack = new Stack<>();
		while (t != null || !stack.isEmpty()) {
			if (t != null) {
				System.out.print(t.value);
				stack.add(t);
				t = t.left;
			} else {
				Tree<Integer> node = stack.pop();
				t = node.right;
			}
		}
	}
	
	public void preorderIterativeTraverse_(Tree<Integer> t) {
		Stack<Tree<Integer>> stack = new Stack<>();
		stack.push(t);
		while (!stack.isEmpty()) {
			Tree<Integer> current = stack.pop();
			System.out.print(current.value);
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}

	public void inorderIterativeTraverse(Tree<Integer> t) {

		Stack<Tree<Integer>> stack = new Stack<>();
		while (t != null || !stack.isEmpty()) {
			if (t != null) {
				stack.add(t);
				t = t.left;
			} else {
				Tree<Integer> node = stack.pop();
				// do some work on this node
				System.out.print(node.value);
				t = node.right;
			}
		}
	}
	
	public static void main(String[] args) {
		IterativeTreeTraverse_M d = new IterativeTreeTraverse_M();
		Tree<Integer> tree1 = new Tree<>(1);
		Tree<Integer> tree2 = new Tree<>(0);
		Tree<Integer> tree3 = new Tree<>(4);
		Tree<Integer> tree4 = new Tree<>(3);
		Tree<Integer> tree5 = new Tree<>(1);
		
		tree1.left = tree2;
		tree1.right = tree3;
		
		tree2.left = tree4;
		tree2.right = tree5;
		d.preorderIterativeTraverse_(tree1);
		System.out.println();
		d.preorderIterativeTraverse(tree1);
		System.out.println();
		d.inorderIterativeTraverse(tree1);
	}
}
