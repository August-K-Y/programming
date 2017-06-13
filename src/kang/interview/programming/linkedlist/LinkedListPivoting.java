package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class LinkedListPivoting {

	public ListNode pivoting(ListNode head, int k) {

		ListNode smallerDummyHead = new ListNode(0);
		ListNode equalDummyHead = new ListNode(0);
		ListNode biggerDummyHead = new ListNode(0);
		ListNode smaller = smallerDummyHead;
		ListNode equal = equalDummyHead;
		ListNode bigger = biggerDummyHead;

		ListNode current = head;
		while (current != null) {
			if (current.data == k) {
				equal.next = current;
				equal = current;
			} else if (current.data > k) {
				bigger.next = current;
				bigger = current;
			} else {
				smaller.next = current;
				smaller = current;
			}
			current = current.next;
		}
		
		smaller.next = equalDummyHead.next;
		equal.next = biggerDummyHead.next;
		bigger.next = null;
		return  smallerDummyHead.next;

	}
	
	public static void main(String[] arg) {
		System.out.println("result:");
		ListNode head = createLinkedList();
		LinkedListPivoting ora = new LinkedListPivoting();
		ListNode newHead = ora.pivoting(head, 4);
		newHead = iterateLinkedList(newHead);
	}

	private static ListNode createLinkedList() {
		ListNode head = new ListNode(0);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(1);
		ListNode node8 = new ListNode(5);
		
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
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
