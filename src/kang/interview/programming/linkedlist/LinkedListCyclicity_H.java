package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class LinkedListCyclicity_H {

	/**
	 * Checks if a linked list contains cycle.
	 * 
	 * @param head
	 *            the head of the specified linked list
	 * @return true if the linked list contains cycle
	 */
	public boolean checkLinkedListCyclicity(ListNode head) {

		if (head == null)
			return false;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	/**
	 * Finds the start node of the cycle in a linked list if cycle exists.
	 * 
	 * @param head
	 *            the head of the linked list
	 * @return the start node of the cycle; null, if no cycle exists
	 */
	public ListNode fineStartOfCycle(ListNode head) {

		if (head == null)
			return null;

		ListNode slow = head;
		ListNode fast = head.next;

		// checks if cycle exists. if exists, slow and fast should meet at
		// certain node
		boolean hasCycle = false;
		while (fast != null && fast.next != null) {
			if (fast == slow) {
				hasCycle = true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		// calculates the length of the cycle
		int length = 0;
		if (hasCycle) {
			do {
				fast = fast.next;
				length++;
			} while (fast != slow);
		} else {
			return null;
		}

		// resets slow and fast to the head and advances the fast pointer the
		// length amount of steps ahead
		slow = head;
		fast = head;
		while (length > 0) {
			fast = fast.next;
			length--;
		}

		// when the slow and fast pointer meet, the node at where they are
		// meeting is the start node of the cycle
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}
}
