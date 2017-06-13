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

	public ListNode search(int value) {

		ListNode t = head;
		for (; t != null; t = t.next) {
			if (t.data == value)
				return t;
		}

		// if value not exist in the list, t will become null
		return t;
	}

	public void insert(int value) {
		ListNode node = new ListNode(value);

		if (head == null) {
			head.next = node;
		} else {
			node.next = head.next;
			head.next = node;
		}
	}

	public void delete(int value) {

		if (head == null)
			return;

		if (head.next == null && head.data == value) {
			head = null;
		}

		ListNode prev = head;
		ListNode t = head.next;
		for (; t != null; t = t.next) {
			if (t.data == value) {
				prev.next = t.next;
			}
		}
	}

}
