package kang.interview.programming.linkedlist;

/**
 * LeetCode 24. Swap Nodes in Pairs:
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * 
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 * 
 * @see {@link ReverseKNodeInGroup}
 * @author Yan Kang
 *
 */
public class SwapNodesInPairs {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode pivot = head;

		ListNode temp = null;
		while (pivot != null) {
			int j = 1;
			
			// NOTE: we add pivot.next != null into the while condition since
			// when the length of the linked list is an odd number, we will end
			// up with just one node at last, in which case the pivot.next is
			// null and we will just leave the last node as it is.
			while (j < 2 && pivot.next != null) {
				temp = pivot.next;
				pivot.next = temp.next;

				temp.next = prev.next;
				prev.next = temp;
				j++;
			}
			prev = pivot;
			pivot = pivot.next;
		}
		return dummy.next;
	}
}
