package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class OverlappingLinkedList {

	public ListNode isOverlapping(ListNode head1, ListNode head2) {
		int length1 = computeLength(head1);
		int length2 = computeLength(head2);
		if (length1 == 0 || length2 == 0)
			return null;

		if (length1 > length2) {
			int diff = length1 - length2;
			while (diff > 0) {
				head1 = head1.next;
				diff--;
			}

		} else {
			int diff = length2 - length1;
			while (diff > 0) {
				head2 = head2.next;
				diff--;
			}
		}

		while (head1 != null && head2 != null) {
			if (head1 == head2)
				return head1;
			head1 = head1.next;
			head2 = head2.next;
		}

		return null;
	}

	private int computeLength(ListNode head1) {
		// TODO Auto-generated method stub
		return 0;
	}

}
