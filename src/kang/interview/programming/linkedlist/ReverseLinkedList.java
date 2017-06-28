package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;
import kang.interview.programming.util.DataPrinter;

public class ReverseLinkedList {

	/**
	 * Reverses a linked list.
	 * 
	 * @param head
	 *            the head of the linked list
	 * @return the head of the reversed linked list
	 */
	public ListNode reverseLinkedList(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode helper = dummy;
		ListNode pivot = dummy.next;

		/*
		 * Reverse each node, say N, involves two steps: (1) remove node N from
		 * the list and (2) insert node N to the front of the list.
		 * 
		 * Makes temp node pointing to node N is to help remove node N from the
		 * list and then insert it to the front
		 * 
		 * When pivot.next == null, it means that all nodes on the right of the
		 * pivot have been reversed to the left of the pivot
		 */
		ListNode temp = null;
		while (pivot.next != null) {

			// Makes temp pointing to the next node of pivot, that is the node
			// to be reversed, and remove temp node from the list
			temp = pivot.next;
			pivot.next = temp.next;

			// Inserts temp node after the helper node such that it becomes the
			// front node
			temp.next = helper.next;
			helper.next = temp;
		}
		return dummy.next;
	}

	/**
	 * Reverses sub linked list begin from the specified start index to the
	 * specified end index.
	 * 
	 * @param head
	 *            the head of the linked list
	 * @param start
	 *            the start index of the sub linked list, numbering from zero
	 * @param end
	 *            the end index of the sub linked list, numbering from zero
	 * @return the head of the reversed linked list
	 */
	public ListNode reverseSubLinkedList(ListNode head, int start, int end) {
		if (start == end)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode helper = dummy;
		ListNode pivot = dummy.next;

		// Move pivot pointer to the start position
		int i = 0;
		while (i < start) {
			helper = pivot;
			pivot = pivot.next;
			i++;
		}

		// Next, we will do exactly the same task as we discussed in the
		// reverseLinkedList method, except that we may end the loop when the
		// reversing is done before reach the end of the list
		ListNode temp = null;
		while (i < end && pivot.next != null) {

			// remove temp node from the list
			temp = pivot.next;
			pivot.next = temp.next;

			// insert temp node after the prev node
			temp.next = helper.next;
			helper.next = temp;

			i++;
		}
		return dummy.next;
	}

	public static void main(String[] arg) {
		System.out.println("result:");
		ListNode head = LinkedListUtil.createLinkedList();
		ReverseLinkedList ora = new ReverseLinkedList();
		ListNode newHead = ora.reverseLinkedList(head);
		newHead = DataPrinter.printLinkedList(newHead);

		System.out.println();
		head = LinkedListUtil.createLinkedList();
		newHead = ora.reverseSubLinkedList(head, 2, 4);
		newHead = DataPrinter.printLinkedList(newHead);
	}
}
