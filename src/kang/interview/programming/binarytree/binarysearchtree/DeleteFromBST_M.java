package kang.interview.programming.binarytree.binarysearchtree;

/**
 * 
 * 
 * 
 * A tree is considered a binary search tree (BST) if for each of its nodes the following is true:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and the right subtrees must also be binary search trees.
	Removing a value x from a BST t is done in the following way:
	
	If there is no x in t, nothing happens;
	Otherwise, let t' be a subtree of t such that t'.value = x.
	If t' has a left subtree, remove the rightmost node from it and put it at the root of t';
	Otherwise, remove the root of t' and its right subtree becomes the new t's root.
	For example, removing 4 from the following tree has no effect because there is no such value in the tree:
	
	    5
	   / \
	  2   6
	 / \   \
	1   3   8
	       /
	      7
	Removing 5 causes 3 (the rightmost node in left subtree) to move to the root:
	
	    3
	   / \
	  2   6
	 /     \
	1       8
	       /
	      7
	And removing 6 after that creates the following tree:
	
	    3
	   / \
	  2   8
	 /   /
	1   7
	You're given a binary search tree t and an array of numbers queries. Your task is to remove queries[0], queries[1], etc., from t, step by step, following the algorithm above. Return the resulting BST.
	
	Example
	
	For
	
	t = {
	    "value": 5,
	    "left": {
	        "value": 2,
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
	    },
	    "right": {
	        "value": 6,
	        "left": null,
	        "right": {
	            "value": 8,
	            "left": {
	                "value": 7,
	                "left": null,
	                "right": null
	            },
	            "right": null
	        }
	    }
	}
	and queries = [4, 5, 6], the output should be
	
	deleteFromBST(t, queries) = {
	    "value": 3,
	    "left": {
	        "value": 2,
	        "left": {
	            "value": 1,
	            "left": null,
	            "right": null
	        },
	        "right": null
	    },
	    "right": {
	        "value": 8,
	        "left": {
	            "value": 7,
	            "left": null,
	            "right": null
	        },
	        "right": null
	    }
	}
	Input/Output
	
	[time limit] 3000ms (java)
	[input] tree.integer t
	
	A tree of integers.
	
	Guaranteed constraints:
	0 <= t size <= 1000,
	-109 <= node value <= 109.
	
	[input] array.integer queries
	
	An array that contains the numbers to be deleted from t.
	
	Guaranteed constraints:
	1 <= queries.length <= 1000,
	-109 <= queries[i] <= 109.
	
	[output] tree.integer
	
	The tree after removing all the numbers in queries, following the algorithm above.


 * @author Yan Kang
 *
 */
public class DeleteFromBST_M {
	public static class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	Tree<Integer> deleteFromBST(Tree<Integer> t, int[] queries) {
	    
	    Tree<Integer> head = t;
	    for(int num : queries) {
	       head = deleteFromBST(head, num);
	    }
	    return head;
	}

	public Tree<Integer> deleteFromBST(Tree<Integer> t, int num) {
	    
	    if(t == null)
	        return null;
	    
	    t.left = deleteFromBST(t.left, num);
	    if(t.value == num) {
	        if(t.left != null) {
	            Tree<Integer> n = findRightMost(t);
	            n.right = t.right;
	            n.left = t.left;
	            return n;
	        } else {
	            return t.right;
	        }
	    }
	    t.right = deleteFromBST(t.right, num);
	    
	    return t;
	}

	private Tree<Integer> findRightMost(Tree<Integer> t) {
	    Tree<Integer> prev = t;
	    t = t.left;
	    
	    if(t.right == null) {
	    	prev.left = t.left;
	    	return t;
	    } 
	    
		if (t.right != null) {
			prev = t;
			t = t.right;
		}
	    
	    if(t.left != null) {
	        prev.right = t.left;
	    } else {
	        prev.right = null;
	    }
	    
	    return t;
	}
	
	public static void main(String[] args) {
		
		DeleteFromBST_M alg = new DeleteFromBST_M();
		
		Tree<Integer> node1 = new Tree<Integer>(3);
		Tree<Integer> node2 = new Tree<Integer>(2);
		Tree<Integer> node3 = new Tree<Integer>(1);
		Tree<Integer> node4 = new Tree<Integer>(5);
		
		node1.left = node2;
		node1.right = node4;
		node2.left = node3;

		Tree<Integer> head = alg.deleteFromBST(node1, 3);
		System.out.println(head.value);
		System.out.println(head.left != null ? head.left.value : "");
		System.out.println(head.right != null ? head.right.value : "");
	}
}
