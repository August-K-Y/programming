package kang.interview.programming.binarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Note: Try to solve this task without using recursion, since this is what you'll be asked to do during an interview.

	Given a binary tree of integers t, return its node values in the following format:
	
	- The first element should be the value of the tree root;
	- The next elements should be the values of the nodes at height 1 (i.e. the root children), ordered from the leftmost 
	  to the rightmost one;
	- The elements after that should be the values of the nodes at height 2 (i.e. the children of the nodes at height 1) 
	  ordered in the same way;
	- Etc.
	
	Example
	
	For
	
	t = {
	    "value": 1,
	    "left": {
	        "value": 2,
	        "left": null,
	        "right": {
	            "value": 3,
	            "left": null,
	            "right": null
	        }
	    },
	    "right": {
	        "value": 4,
	        "left": {
	            "value": 5,
	            "left": null,
	            "right": null
	        },
	        "right": null
	    }
	}
	the output should be
	traverseTree(t) = [1, 2, 4, 3, 5].
	
	This t looks like this:
	
	     1
	   /   \
	  2     4
	   \   /
	    3 5
 * 
 * @author yankang
 *
 */
public class TraverseTreeLevelByLevel {
	
	static class Tree<T> {
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
	 * @return
	 */
	int[] traverseTree(Tree<Integer> t) {
		if (t == null)
			return new int[0];

		Queue<Tree<Integer>> q1 = new LinkedList<>();
		List<Integer> rec = new LinkedList<>();
		q1.add(t);
		while (!q1.isEmpty()) {
			Tree<Integer> n = q1.remove();
			rec.add(n.value);
			if (n.left != null) {
				q1.add(n.left);
			}
			if (n.right != null) {
				q1.add(n.right);
			}
		}
		return rec.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * 
	 * @param t
	 * @return
	 */
	List<List<Integer>> traverseTree_LevelByLevel(Tree<Integer> t) {
		
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (t == null)
			return result;
		
		Queue<Tree<Integer>> q1 = new LinkedList<>();
		List<Integer> rec = new LinkedList<>();
		q1.add(t);
		int currNum = 1;
		int nextNum = 0;
		while (!q1.isEmpty()) {
			Tree<Integer> n = q1.remove();
			rec.add(n.value);
			currNum--;

			if (n.left != null) {
				q1.add(n.left);
				nextNum++;
			}

			if (n.right != null) {
				q1.add(n.right);
				nextNum++;
			}

			if (currNum == 0) {
				currNum = nextNum;
				nextNum = 0;
				result.add(rec);
				rec = new LinkedList<>();
			}

		}
		return result;
	}

	public static void main(String[] args) {
		Tree<Integer> tree1 = new Tree<>(1);
		Tree<Integer> tree2 = new Tree<>(2);
		Tree<Integer> tree3 = new Tree<>(3);
		Tree<Integer> tree4 = new Tree<>(4);
		Tree<Integer> tree5 = new Tree<>(5);
		Tree<Integer> tree6 = new Tree<>(6);
		
		tree1.left= tree2;
		tree1.right = tree3;
		tree2.left = tree4;
		tree2.right = tree5;
		tree3.left = tree6;
		
		TraverseTreeLevelByLevel t = new TraverseTreeLevelByLevel();
		List<List<Integer>> result = t.traverseTree_LevelByLevel(tree1);

		for (List<Integer> level : result) {
			for (int v : level) {
				System.out.print(v + " ");
			}
			System.out.println();
		}
	}

}
