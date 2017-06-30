package kang.interview.programming.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given two binary trees t1 and t2, determine whether the second one is a subtree of the first one. A subtree for vertex v in binary tree t is a tree consisting of v and all its descendants in t. Your task is to check whether there is a vertex v in tree t1 such that a subtree for vertex v in t1 equals t2.

	Example
	
	For
	
	t1 = {
	    "value": 5,
	    "left": {
	        "value": 10,
	        "left": {
	            "value": 4,
	            "left": {
	                "value": 1,
	                "left": null,
	                "right": null
	            },
	            "right": {
	                "value": 2,
	                "left": null,
	                "right": null
	            }
	        },
	        "right": {
	            "value": 6,
	            "left": null,
	            "right": {
	                "value": -1,
	                "left": null,
	                "right": null
	            }
	        }
	    },
	    "right": {
	        "value": 7,
	        "left": null,
	        "right": null
	    }
	}
	and
	
	t2 = {
	    "value": 10,
	    "left": {
	        "value": 4,
	        "left": {
	            "value": 1,
	            "left": null,
	            "right": null
	        },
	        "right": {
	            "value": 2,
	            "left": null,
	            "right": null
	        }
	    },
	    "right": {
	        "value": 6,
	        "left": null,
	        "right": {
	            "value": -1,
	            "left": null,
	            "right": null
	        }
	    }
	}
	the output should be isSubtree(t1, t2) = true.
	
	This is what these trees look like:
	
	      t1:             t2:
	       5              10
	      / \            /  \
	    10   7          4    6
	   /  \            / \    \
	  4    6          1   2   -1
	 / \    \
	1   2   -1
	As you can see, t2 is a subtree of t1 (the vertex in t1 with value 10).
	
	For
	
	t1 = {
	    "value": 5,
	    "left": {
	        "value": 10,
	        "left": {
	            "value": 4,
	            "left": {
	                "value": 1,
	                "left": null,
	                "right": null
	            },
	            "right": {
	                "value": 2,
	                "left": null,
	                "right": null
	            }
	        },
	        "right": {
	            "value": 6,
	            "left": {
	                "value": -1,
	                "left": null,
	                "right": null
	            },
	            "right": null
	        }
	    },
	    "right": {
	        "value": 7,
	        "left": null,
	        "right": null
	    }
	}
	and
	
	t2 = {
	    "value": 10,
	    "left": {
	        "value": 4,
	        "left": {
	            "value": 1,
	            "left": null,
	            "right": null
	        },
	        "right": {
	            "value": 2,
	            "left": null,
	            "right": null
	        }
	    },
	    "right": {
	        "value": 6,
	        "left": null,
	        "right": {
	            "value": -1,
	            "left": null,
	            "right": null
	        }
	    }
	}
	the output should be isSubtree(t1, t2) = false.
	
	This is what these trees look like:
	
	        t1:            t2:
	         5             10
	       /   \          /  \
	     10     7        4    6
	   /    \           / \    \
	  4     6          1   2   -1
	 / \   / 
	1   2 -1
	As you can see, there is no vertex v such that the subtree of t1 for vertex v equals t2.
	
	For
	
	t1 = {
	    "value": 1,
	    "left": {
	        "value": 2,
	        "left": null,
	        "right": null
	    },
	    "right": {
	        "value": 2,
	        "left": null,
	        "right": null
	    }
	}
	and
	
	t2 = {
	    "value": 2,
	    "left": {
	        "value": 1,
	        "left": null,
	        "right": null
	    },
	    "right": null
	}
	the output should be isSubtree(t1, t2) = false.
 * 
 * @see BinaryTreeKthNode
 * @author Yan Kang
 *
 */
public class BinaryTreeKthNodeWithoutRecordingSize {
	class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}
	
	/*
	 * 
	 */
	List<Integer> x;

	int kthLargestInBST_withAdditionalSpace(Tree<Integer> t, int k) {
		x = new ArrayList<Integer>();
		order(t);
		return x.get(k - 1);
	}

	private void order(Tree<Integer> rootNode) {
		if (rootNode == null)
			return;
		order(rootNode.left);
		x.add(rootNode.value);
		order(rootNode.right);
	}

	/*
	 * Variation of the traditional way of finding the kth node in a BST each
	 * node that each node represents a subtree and records the number of nodes in
	 * this subtree.
	 */

	class Result {
		boolean found; // default false
		int number; // default 0
	}

	int kthLargestInBST(Tree<Integer> t, int k) {

		Result result = findKthNode(t, k);
		return result.number;
	}

	private Result findKthNode(Tree<Integer> t, int k) {

		if (t == null) {
			return new Result();
		}

		Result result = findKthNode(t.left, k);
		if (result.found) {
			return result;
		} else {
			if (k == result.number + 1) {
				result.found = true;
				result.number = t.value;
				return result;
			} else {
				// k > result.number + 1
				Result rightResult = findKthNode(t.right, k - result.number - 1);
				if (!rightResult.found) {
					rightResult.number = result.number + rightResult.number + 1;
				}
				return rightResult;
			}
		}
	}
	
	/*
	 * This is a clever way of doing this task. Using k keeps tracking the
	 * number of nodes visited while in-order traversing the tree. When the
	 * value of k reached zero, we found the kth largest node in the BST
	 */

	int k, r;

	int kthLargestInBST_(Tree<Integer> t, int k) {
	    this.k = k;
	    f(t);
	    return r;
	}

	void f(Tree<Integer> t) {
	    if (t.left != null) f(t.left);
	    --k;
	    if (k == 0) r = t.value;
	    if (t.right != null) f(t.right);
	}
}
