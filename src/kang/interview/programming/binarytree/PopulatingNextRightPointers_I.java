package kang.interview.programming.binarytree;

import kang.interview.programming.util.DataPrinter;

public class PopulatingNextRightPointers_I {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if(root == null)
			return;
		doConnect(root);
	}

	private void doConnect(TreeLinkNode node) {
		if(node.left == null)
			return;

		node.left.next = node.right;
		node.right.next = node.next == null ? null : node.next.left;

		doConnect(node.left);
		doConnect(node.right);
	}

	// TODO Do iterative approach in Java
	
//	void connect(TreeLinkNode *root) {
//	    if (root == NULL) return;
//	    TreeLinkNode *pre = root;
//	    TreeLinkNode *cur = NULL;
//	    while(pre->left) {
//	        cur = pre;
//	        while(cur) {
//	            cur->left->next = cur->right;
//	            if(cur->next) cur->right->next = cur->next->left;
//	            cur = cur->next;
//	        }
//	        pre = pre->left;
//	    }
//	}
	
	public static void main(String[] args) {
		TreeLinkNode node1 = new TreeLinkNode(0);
		TreeLinkNode node2 = new TreeLinkNode(1);
		TreeLinkNode node3 = new TreeLinkNode(2);
		node1.left = node2;
		node1.right = node3;
		
		PopulatingNextRightPointers_I alg = new PopulatingNextRightPointers_I();
		alg.connect(node1);
		
		DataPrinter.println(node2.next.val); // 2
		DataPrinter.println(node3.next); // null
	}
}
