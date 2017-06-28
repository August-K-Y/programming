package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;
import kang.interview.programming.util.DataPrinter;

public class RemoveKthFromLastNode {
	
	/**
	 * First get the length of the linked list and then forward (length - k)
	 * steps from the head to reach the kth from last node, and remove this
	 * node.
	 * 
	 * @param head
	 *            the head of the linked list
	 * @param k
	 *            the kth node from the last, numbering from 1
	 * @return the head of the list after the deletion
	 */
	public ListNode removeKthLastNode_bf(ListNode head, int k) {
		int length = computeLength(head);
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev = dummy;
		ListNode current = dummy.next;
		int steps = length - k;
		while (steps > 0) {
			prev = prev.next;
			current = current.next;
			steps--;
		}
		
		// Removes current node (i.e., the kth node from last)
		prev.next = current.next;
		current.next = null;
		return dummy.next;
	}

	private int computeLength(ListNode head) {
		int length = 0;
		ListNode dummy = head;
		while (dummy != null) {
			length++;
			dummy = dummy.next;
		}
		return length;
	}
	
	/**
	 * 
	 * @param head
	 *            the head of the linked list
	 * @param k
	 *            the kth node from the last, numbering from 1
	 * @return the head of the list after the deletion
	 */
	public ListNode removeKthLastNode(ListNode head, int k) {
		ListNode faster = head;

		// forwards the faster pointer k-1 steps. the head is the kth node away
		// from the faster node.
		while (k > 1) {
			faster = faster.next;
			k--;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode current = head;

		// Forwards both faster and current pointers at the same pace. When the
		// faster pointer points to the last node, the current pointer is
		// pointing to the kth node.
		// Note: we check whether faster.next is null or not. If it is null, the
		// faster pointer is pointing to the last node.
		while (faster != null && faster.next != null) {
			faster = faster.next;
			current = current.next;
			prev = prev.next;
		}

		// Removes current node (i.e., the kth node from last)
		prev.next = current.next;
		current.next = null;
		return dummy.next;
	}
	
	public static void main(String[] arg) {
		System.out.println("result:");
		ListNode head = createLongLinkedList();
		RemoveKthFromLastNode ora = new RemoveKthFromLastNode();
		ListNode newHead = ora.removeKthLastNode_bf(head, 4);
		newHead = DataPrinter.printLinkedList(newHead);

		System.out.println();
		head = createLongLinkedList();
		newHead = ora.removeKthLastNode(head, 4);
		newHead = DataPrinter.printLinkedList(newHead);
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
}
