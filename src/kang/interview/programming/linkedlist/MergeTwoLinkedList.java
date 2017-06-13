package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class MergeTwoLinkedList {

	public ListNode mergeTwoSortedSinglyLinkedList(ListNode head1, ListNode head2) {

		// to preserve the original two lists, create two new list nodes
		// pointing to the heads of two lists respectively
		ListNode l1 = head1;
		ListNode l2 = head2;

		ListNode dummyNode = new ListNode(0);

		ListNode current = dummyNode;
		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		current.next = l1 == null ? l2 : l1;
		return dummyNode.next;
	}

}
