package kang.interview.programming.binarytree;

/**
 * Given a binary tree t and an integer s, determine whether there is a root to leaf path 
 * in t such that the sum of vertex values equals s.

	Example
	
	For
	
	t = {
	    "value": 4,
	    "left": {
	        "value": 1,
	        "left": {
	            "value": -2,
	            "left": null,
	            "right": {
	                "value": 3,
	                "left": null,
	                "right": null
	            }
	        },
	        "right": null
	    },
	    "right": {
	        "value": 3,
	        "left": {
	            "value": 1,
	            "left": null,
	            "right": null
	        },
	        "right": {
	            "value": 2,
	            "left": {
	                "value": -2,
	                "left": null,
	                "right": null
	            },
	            "right": {
	                "value": -3,
	                "left": null,
	                "right": null
	            }
	        }
	    }
	}
	and
	s = 7,
	the output should be hasPathWithGivenSum(t, s) = true.
	
	This is what this tree looks like:
	
	      4
	     / \
	    1   3
	   /   / \
	  -2  1   2
	    \    / \
	     3  -2 -3
	Path 4 -> 3 -> 2 -> -2 gives us 7, the required sum.
	
	For
	
	t = {
	    "value": 4,
	    "left": {
	        "value": 1,
	        "left": {
	            "value": -2,
	            "left": null,
	            "right": {
	                "value": 3,
	                "left": null,
	                "right": null
	            }
	        },
	        "right": null
	    },
	    "right": {
	        "value": 3,
	        "left": {
	            "value": 1,
	            "left": null,
	            "right": null
	        },
	        "right": {
	            "value": 2,
	            "left": {
	                "value": -4,
	                "left": null,
	                "right": null
	            },
	            "right": {
	                "value": -3,
	                "left": null,
	                "right": null
	            }
	        }
	    }
	}
	and
	s = 7,
	the output should be hasPathWithGivenSum(t, s) = false.
	
	This is what this tree looks like:
	
	      4
	     / \
	    1   3
	   /   / \
	  -2  1   2
	    \    / \
	     3  -4 -3
	There is no path from root to leaf with the given sum 7.

 * @see RootToLeafPathNumber
 * @see RootToLeafPathsFormedNumbersSum_M
 * @see 
 * @author Yan kang
 *
 */
public class RootToLeadPathWithGivenSum {
	class Tree<T> {
		Tree(T x) {
			value = x;
		}

		T value;
		Tree<T> left;
		Tree<T> right;
	}

	/**
	 * Given a binary tree t and an integer s, determine whether there is a root
	 * to leaf path in t such that the sum of vertex values equals s.
	 * 
	 * @param t
	 *            the tree
	 * @param s
	 *            the number
	 * @return true if the root to leaf path exists; false, otherwise
	 */
	public boolean hasPathWithGivenSum(Tree<Integer> t, int s) {

		// This algorithm treat an null tree has value of zero
		if (t == null && s == 0)
			return true;

		if (t == null && s != 0) {
			return false;
		}

		if (t.value == s && isLeaf(t)) {
			return true;
		}

		return hasPathWithGivenSum(t.right, s - t.value) || hasPathWithGivenSum(t.left, s - t.value);

	}

	private boolean isLeaf(Tree<Integer> n) {
		return n.left == null && n.right == null;
	}

}
