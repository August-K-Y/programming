package kang.interview.programming.binarytree;

/**
 * 
 * Given two binary trees t1 and t2, determine whether the second one is a subtree of the first one. 
 * A subtree for vertex v in binary tree t is a tree consisting of v and all its descendants in t. 
 * Your task is to check whether there is a vertex v in tree t1 such that a subtree for vertex v in t1 equals t2.

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
 * @author Yan Kang
 *
 */
public class CheckIsSubtree {

	class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
		// One open question is that do we consider t2 is subtree of t1 if t2 is
		// null while t1 is not null? what if t1 is null?
		if (isMatch(t1, t2))
			return true;
		return t1 != null && (isSubtree(t1.left, t2) || isSubtree(t1.right, t2));
	}

	private boolean isMatch(Tree<Integer> t1, Tree<Integer> t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return t1.value.equals(t2.value) && 
				isMatch(t1.left, t2.left) && 
				isMatch(t1.right, t2.right);
	}
}
