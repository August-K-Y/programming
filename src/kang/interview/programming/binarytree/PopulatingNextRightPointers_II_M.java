package kang.interview.programming.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import kang.interview.programming.binarytree.PopulatingNextRightPointers_I.TreeLinkNode;
import kang.interview.programming.util.DataPrinter;

/**
 *  LeetCode 117. Populating Next Right Pointers in Each Node II:
 *  https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/tabs/description
 *  

 * Follow up for problem "Populating Next Right Pointers in Each Node".

	What if the given tree could be any binary tree? Would your previous solution still work?
	
	Note:
	
	You may only use constant extra space.
	For example,
	Given the following binary tree,
	         1
	       /  \
	      2    3
	     / \    \
	    4   5    7
	After calling your function, the tree should look like:
	
	         1 -> NULL
	       /  \
	      2 -> 3 -> NULL
	     / \    \
	    4-> 5 -> 7 -> NULL
    
    
   @see https://discuss.leetcode.com/topic/8447/simple-solution-using-constant-space
   @see https://discuss.leetcode.com/topic/28580/java-solution-with-constant-space/2
 * @author Yan Kang
 *
 */
public class PopulatingNextRightPointers_II_M {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	/**
	 * Level-order traversal.
	 * 
	 * @param root
	 */
    public void connect(TreeLinkNode root) {
		if (root == null)
			return;

		Queue<TreeLinkNode> q = new LinkedList<>();
		q.add(root);
		int currCount = 1;
		int nextCount = 0;
		while (!q.isEmpty()) {

			TreeLinkNode top = q.poll();
			currCount--;
			if (top.left != null) {
				q.add(top.left);
				nextCount++;
			}

			if (top.right != null) {
				q.add(top.right);
				nextCount++;
			}

			if (currCount == 0) {
				currCount = nextCount;
				nextCount = 0;
				setNextPointers(q, currCount);
			}
		}
	}

	private void setNextPointers(Queue<TreeLinkNode> q, int count) {
		int i = 0;
		Iterator<TreeLinkNode> iter = q.iterator();
		TreeLinkNode prev = null;
		while (i < count && iter.hasNext()) {
			if (i++ == 0)
				prev = iter.next();
			else {
				prev.next = iter.next();
				prev = prev.next;
			}
		}
	}
	
	/**
	 * Code from LeetCode: 
	 */
	
	public void connect_(TreeLinkNode root) {

		while (root != null) {
			TreeLinkNode tempChild = new TreeLinkNode(0);
			TreeLinkNode currentChild = tempChild;
			while (root != null) {
				if (root.left != null) {
					currentChild.next = root.left;
					currentChild = currentChild.next;
				}
				if (root.right != null) {
					currentChild.next = root.right;
					currentChild = currentChild.next;
				}
				root = root.next;
			}
			root = tempChild.next;
		}
	}
	
	
	public void connect__(TreeLinkNode root) {
		TreeLinkNode dummyHead = new TreeLinkNode(0);
		TreeLinkNode pre = dummyHead;
		while (root != null) {
			if (root.left != null) {
				pre.next = root.left;
				pre = pre.next;
			}
			if (root.right != null) {
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if (root == null) {
				pre = dummyHead;
				root = dummyHead.next;
				dummyHead.next = null;
			}
		}
	}
	
	
	public static void main(String[] args) {
		TreeLinkNode node1 = new TreeLinkNode(0);
		TreeLinkNode node2 = new TreeLinkNode(1);
		TreeLinkNode node3 = new TreeLinkNode(2);
		TreeLinkNode node4 = new TreeLinkNode(3);
		TreeLinkNode node5 = new TreeLinkNode(4);
		node1.left = node2;
		node2.left = node4;
		node1.right = node3;
		node3.right = node5;
		
		PopulatingNextRightPointers_II_M alg = new PopulatingNextRightPointers_II_M();
		alg.connect(node1);
		
		DataPrinter.println(node2.next.val); // 2
		DataPrinter.println(node4.next.val); // 4
		DataPrinter.println(node5.next); // null
	}
}
