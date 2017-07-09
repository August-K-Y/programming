package kang.interview.programming.binarytree;


public class BinaryTreeSuccessorAndPredecessor {
	
	/**
	 * 	      30             
		     / \           
		    1   31        
		     \           
		     (10)      
		        \
		    	 15
		         / \
		       12   18  
	 *
	 * the successor of 10 is 12
	 * 
	 * 
	 * 	      30             
		     / \           
		    1   31        
		     \           
		     (10)      
		        \
		    	 15
	 * 
	 * the successor of 10 is 15
	 * 
	 * 
	 * 	      30             
		     / \           
		    1   31        
		     \           
		     (10)   
	
	 * the successor of 10 is 30   
	 */
	
	/**
	 * 
	 * <ol>
	 * <li>first, look for left most child node of the right child of current
	 * node
	 * <ol>
	 * <li>If the right child has no left child, this right child is the
	 * successor</li>
	 * <li>Otherwise, the left most child of this right child is the successor
	 * </li>
	 * </ol>
	 * </li>
	 * <li>If current node has no right child, then:
	 * <ol>
	 * search up from current node for the first reached ancestor whose left
	 * subtree (i.e., child) contains current node.
	 * </ol>
	 * </li>
	 * </ol>
	 * 
	 * @param node
	 * @return
	 */
	public TreeNode findSuccessor(TreeNode node) {
		
		if (node.right != null) {
			return leftMost(node.right);
		} else {
			TreeNode parent = node.parent;
			while(parent != null && parent.left != node) {
				parent = parent.parent; 
				node = node.parent;
			}
			return parent;
		}
	}

	private TreeNode leftMost(TreeNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	/**
	 * The algorithm for finding the predecessor of the specified node follows
	 * similar logic of finding successor.</br>
	 * 
	 * <ol>
	 * <li>first, look for right most child node of the left child of current
	 * node
	 * <ol>
	 * <li>If the left child has no right child, this left child is the
	 * predecessor</li>
	 * <li>Otherwise, the right most child of this left child is the predecessor
	 * </li>
	 * </ol>
	 * </li>
	 * <li>If current node has no left child, then:
	 * <ol>
	 * search up from current node for the first reached ancestor whose right
	 * subtree (i.e., child) contains current node.
	 * </ol>
	 * </li>
	 * </ol>
	 * 
	 * @param node
	 * @return
	 */
	public TreeNode findPredecessor(TreeNode node) {
		
		if (node.left != null) {
			return rightMost(node.left);
		} else {
			TreeNode parent = node.parent;
			while(parent != null && parent.right != node) {
				node = node.parent;
				parent = node.parent; 
			}
			return parent;
		}
	} 

	private TreeNode rightMost(TreeNode node) {
		if (node.right != null) {
			node = node.right;
		}
		return node;
	}

}
