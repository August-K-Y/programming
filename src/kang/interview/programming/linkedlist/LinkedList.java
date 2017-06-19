package kang.interview.programming.linkedlist;

public class LinkedList {

	public static class ListNode {
		public ListNode jump;
		public ListNode next;
		public int data;

		public ListNode(int i) {
			data = i;
		}
	}

	private ListNode head;

	/**
	 * Searches the linked list and returns the node having value equals to the
	 * specified value.
	 * 
	 * @param value
	 *            the value to be searched
	 * @return the node having the specified value
	 */
	public ListNode search(int value) {
		ListNode t = head;
		while (t != null) {
			if (t.data == value)
				return t;
			t = t.next;
		}

		return null;
	}

	/**
	 * 
	 * @param value
	 */
	public void insertBefore(int value) {
		ListNode node = new ListNode(value);

		// Should deal with the scenario that the head is null
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public void delete(int value) {

		// Should deal with the scenario that the head is null
		if (head == null)
			return;

		// Should deal with the scenario that the head is the node to be deleted
		if (head.data == value) {
			head = head.next;
		}

		// To delete a node, we must know the node before the node to be deleted
		ListNode prev = head;
		ListNode t = head.next;
		while (t != null) {
			if (t.data == value) {
				prev.next = t.next;
				break;
			}
			t = t.next;
		}
	}
}
