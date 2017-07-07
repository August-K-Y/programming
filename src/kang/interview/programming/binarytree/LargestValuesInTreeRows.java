package kang.interview.programming.binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import kang.interview.programming.binarytree.TraverseTreeLevelByLevel.Tree;

/**
 * 
 * 
 * 
 *  You have a binary tree t. Your task is to find the largest value in each row of this tree. 
 *  In a tree, a row is a set of nodes that have equal depth. For example, a row with depth 0 is a tree root, 
 *  a row with depth 1 is composed of the root's children, etc.

	Return an array in which the first element is the largest value in the row with depth 0, the second element 
	is the largest value in the row with depth 1, the third element is the largest element in the row with depth 2, 
	etc.
	
	Example
	
	For
	
	t = {
	    "value": -1,
	    "left": {
	        "value": 5,
	        "left": null,
	        "right": null
	    },
	    "right": {
	        "value": 7,
	        "left": null,
	        "right": {
	            "value": 1,
	            "left": null,
	            "right": null
	        }
	    }
	}
	the output should be largestValuesInTreeRows(t) = [-1, 7, 1].
	
	The tree in the example looks like this:
	
	    -1
	   / \
	  5   7
	       \
	        1
	In the row with depth 0, there is only one vertex - the root with value -1;
	In the row with depth 1, there are two vertices with values 5 and 7, so the largest value here is 7;
	In the row with depth 2, there is only one vertex with value 1.
	
 * @author yankang
 *
 */
public class LargestValuesInTreeRows {
	class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	int[] largestValuesInTreeRows(Tree<Integer> t) {
		if (t == null)
			return new int[0];
		
		List<Integer> result = new LinkedList<Integer>();
		
		Queue<Tree<Integer>> q1 = new LinkedList<>();
		
		// This tree set keep elements sorted in reverse natural order
		// What if do not use tree set???
		Set<Integer> rec = new TreeSet<>(Collections.reverseOrder());
		q1.add(t);
		int currNum = 1;
		int nextNum = 0;
		while (!q1.isEmpty()) {
			Tree<Integer> n = q1.remove();
			rec.add(n.value);
			currNum--;

			if (n.left != null) {
				q1.offer(n.left);
				nextNum++;
			}

			if (n.right != null) {
				q1.offer(n.right);
				nextNum++;
			}

			if (currNum == 0) {
				currNum = nextNum;
				nextNum = 0;
				result.add(rec.iterator().next());
				rec.clear();
			}
		}
		return result.stream().mapToInt(i -> i).toArray();
	}
}
