package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class LinkedListBasedIntegerAddition {

	public ListNode add(ListNode list1, ListNode list2) {

		int carry = 0;
		ListNode dummy = new ListNode(0);
		ListNode iter = dummy;
		while (list1 != null || list2 != null) {

			int sum = carry;

			if (list1 != null)
				sum += list1.data;

			if (list2 != null)
				sum += list2.data;

			int reside = sum % 10;
			carry = sum / 10;

			iter.next = new ListNode(reside);
			iter = iter.next;
			list1 = list1 == null ? null : list1.next;
			list2 = list2 == null ? null : list2.next;
		}

		// IMPORTANT: there might have carry need to be added to the list
		if (carry > 0) {
			iter.next = new ListNode(carry);
		}
		return dummy.next;

	}

	public static void main(String[] arg) {
		System.out.println("result:");
		ListNode list1 = createLinkedList1();
		ListNode list2 = createLinkedList2();
		LinkedListBasedIntegerAddition ora = new LinkedListBasedIntegerAddition();
		ListNode newHead = ora.add(list1, list2);
		newHead = iterateLinkedList(newHead);
	}

	private static ListNode createLinkedList1() {
		ListNode head = new ListNode(3);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(4);
		head.next = node2;
		node2.next = node3;
		return head;
	}

	private static ListNode createLinkedList2() {
		ListNode head = new ListNode(7);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(9);
		head.next = node2;
		node2.next = node3;
		return head;
	}

	private static ListNode iterateLinkedList(ListNode newHead) {
		while (newHead != null) {
			System.out.print(newHead.data + ", ");
			newHead = newHead.next;
		}
		return newHead;
	}

}
