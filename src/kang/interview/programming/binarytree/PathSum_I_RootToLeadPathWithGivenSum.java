package kang.interview.programming.binarytree;

/**
 * 
 * LeetCode 112. Path Sum
 * https://leetcode.com/problems/path-sum/#/description
 * 
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
 * @see RootToLeafPathsFormedDecimalNumbersSum_M
 * @see 
 * @author Yan kang
 *
 */
public class PathSum_I_RootToLeadPathWithGivenSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/**
	 * Given a binary tree t and an integer s, determine whether there is a root
	 * to leaf path in t such that the sum of vertex values equals s.
	 * 
	 * @param root
	 *            the tree
	 * @param sum
	 *            the number
	 * @return true if the root to leaf path exists; false, otherwise
	 */
	public boolean hasPathSum(TreeNode root, int sum) {

		// This algorithm treat an null tree has value of zero
		if (root == null && sum == 0)
			return true;

		if (root == null && sum != 0) {
			return false;
		}

		if (root.val == sum && isLeaf(root)) {
			return true;
		}

		return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);

	}

	private boolean isLeaf(TreeNode n) {
		return n.left == null && n.right == null;
	}

}
