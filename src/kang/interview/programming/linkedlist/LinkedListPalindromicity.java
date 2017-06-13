package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class LinkedListPalindromicity {

	// brute-force: using an array to store all the data in the linked list and
	// to check if the array is palindormic.

	/**
	 * 
	 * @param head
	 * @return
	 */
	public boolean isLinkedListPalindromic(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondHalf = null;
		if (fast != null) {
			secondHalf = reverse(slow.next);
		} else {
			secondHalf = reverse(slow);
		}

		ListNode firstHalf = head;
		while (secondHalf != null) {

			if (secondHalf.data != firstHalf.data)
				return false;
			secondHalf = secondHalf.next;
			firstHalf = firstHalf.next;
		}
		return true;

	}

	private ListNode reverse(ListNode head) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = head;
		ListNode temp = null;
		while (current.next != null) {
			
			temp = current.next;
			current.next = temp.next;

			temp.next = dummy.next;
			dummy.next = temp;
		}

		return dummy.next;
	}

	public static void main(String[] arg) {
		LinkedListPalindromicity ora = new LinkedListPalindromicity();
		System.out.println("result:");
		ListNode head = createLinkedList();
		boolean newHead = ora.isLinkedListPalindromic(head);
		System.out.println(newHead);
		head = createLinkedList2();
		newHead = ora.isLinkedListPalindromic(head);
		System.out.println(newHead);
		head = createLinkedList3();
		newHead = ora.isLinkedListPalindromic(head);
		System.out.println(newHead);
		head = createLongLinkedList();
		newHead = ora.isLinkedListPalindromic(head);
		System.out.println(newHead);
	}

	private static ListNode createLinkedList() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		return head;
	}
	
	private static ListNode createLinkedList2() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(1);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		return head;
	}
	
	private static ListNode createLinkedList3() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(7);
		ListNode node6 = new ListNode(1);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		return head;
	}
	
	private static ListNode createLongLinkedList() {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		ListNode node11 = new ListNode(11);
		ListNode node12 = new ListNode(12);
		ListNode node13 = new ListNode(13);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = node13;
		return head;
	}

	private static ListNode iterateLinkedList(ListNode newHead) {
		while (newHead != null) 
		{
			System.out.print(newHead.data + ", ");
			newHead = newHead.next;
		}
		return newHead;
	}

}
