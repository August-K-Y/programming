package kang.interview.programming.binarytree;

import java.util.Stack;

/**
 * 
 * @see http://www.programcreek.com/2012/12/leetcode-solution-for-binary-tree-preorder-traversal-in-java/
 * 
 * @see http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
 * 
 * @see http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
 * @see http://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
 * @see http://www.geeksforgeeks.org/iterative-postorder-traversal/
 * 
 * @author Yan Kang
 *
 */
public class BinaryTreeIterativeTraversal_M {
	public static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}
	
	/**
	 * 
	 * @param t
	 */
	public void inorderIterativeTraverse(Tree<Integer> t) {

		Stack<Tree<Integer>> stack = new Stack<>();

		// It is possible that either t variable is null or stack is empty while
		// traversing the tree.
		//
		// For example:
		//
		// When the left side of the root was traversed, the root is popped up
		// from the stack, at this time the stack is empty but the t variable is
		// not null.
		//
		// When a node's left or right child is null, the t variable is null.
		// The stack cannot be empty when node's left child is null since its
		// parent was pushed into the stack. When both node's right is null and
		// the stack is empty, the whole tree was traversed.
		while (t != null || !stack.isEmpty()) {
			if (t != null) {
				stack.add(t);
				t = t.left;
			} else {

				// Note: When code reaches this point, it means the last
				// traversed node, be it A, is null and we pop out a node from
				// the stack, be it B.
				//
				// If B is parent of A, A must be left child of B since B was
				// pushed into the stack just before the code reaching A.
				//
				// Or B must be the parent of parent of A and A is the right
				// child of its parent.
				Tree<Integer> node = stack.pop();

				// We visit node here
				visit(node);

				t = node.right;
			}
		}
	}

	/**
	 * This pre-order traversal is the same as that of in-order traversal except
	 * we visit the node at different place: it is visited before it is pushed
	 * into the stack.
	 * 
	 * @param t
	 */
	public void preorderIterativeTraverse(Tree<Integer> t) {

		Stack<Tree<Integer>> stack = new Stack<>();
		while (t != null || !stack.isEmpty()) {
			if (t != null) {

				// Note: we visit node here, which is different from in-order
				// traversal
				visit(t);
				stack.add(t);
				t = t.left;
			} else {
				Tree<Integer> node = stack.pop();
				t = node.right;
			}
		}
	}

	private void visit(Tree<Integer> t) {
		System.out.print(t.value);
	}
	
	/**
	 * 
	 * @param t
	 */
	public void preorderIterativeTraverse_(Tree<Integer> t) {
		Stack<Tree<Integer>> stack = new Stack<>();
		stack.push(t);
		while (!stack.isEmpty()) {
			Tree<Integer> current = stack.pop();
			visit(current);
			if (current.right != null) {
				stack.push(current.right);
			}
			if (current.left != null) {
				stack.push(current.left);
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeIterativeTraversal_M d = new BinaryTreeIterativeTraversal_M();
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
