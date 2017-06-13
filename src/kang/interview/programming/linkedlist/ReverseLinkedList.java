package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class ReverseLinkedList {

	
	/**
	 * Reverse 
	 * @param head
	 * @return
	 */
	public ListNode reverseLinkedList(ListNode head)
	{
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode current = dummy.next;

		ListNode temp = null;
		while (current.next != null) {
			
			// make temp pointing to the next node of current
			temp = current.next;
			// remove temp node
			current.next = temp.next;
			// insert temp node after the prev node
			temp.next = prev.next;
			prev.next = temp;
		}
		return dummy.next;
	}

	/**
	 * 
	 * @param head
	 * @param start
	 * @param end
	 * @return
	 */
	public ListNode reverseSubLinkedList(ListNode head, int start, int end) {
		if (start == end)
			return head;

		int i = 1;
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode current = dummy.next;
		while (i < start) {
			prev = current;
			current = current.next;
			i++;
		}

		ListNode temp = null;

		while (i < end && current.next != null) {
			temp = current.next;
			current.next = temp.next;
			// insert temp node after the prev node
			temp.next = prev.next;
			prev.next = temp;
			i++;
		}
		return dummy.next;
	}
	
	/**
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKNodes(ListNode head, int k)
	{
		int length = computeLength(head);
		int iteration = length / k;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode prev = dummy;
		ListNode current = dummy.next;
		for (int i = 0; i < iteration; i++) {
			int j = 1;
			ListNode temp = null;
			while (j < k && current.next != null) {
				temp = current.next;
				current.next = temp.next;
				temp.next = prev.next;
				prev.next = temp;
				j++;
			}
			prev = current;
			current = current.next;
		}
		return dummy.next;
	}

	private int computeLength(ListNode head) {
		int length = 0;
		ListNode iter = head;
		while (iter != null) {
			length++;
			iter = iter.next;
		}
		return length;
	}

	public static void main(String[] arg) {
		System.out.println("result:");
		ListNode head = createLinkedList();
		ReverseLinkedList ora = new ReverseLinkedList();
		ListNode newHead = ora.reverseLinkedList(head);
		newHead = iterateLinkedList(newHead);

		System.out.println();
		head = createLinkedList();
		newHead = ora.reverseSubLinkedList(head, 2, 4);
		newHead = iterateLinkedList(newHead);
		
		System.out.println();
		head = createLongLinkedList();
		newHead = ora.reverseKNodes(head, 3);
		newHead = iterateLinkedList(newHead);
	}

	private static ListNode createLinkedList() {
		ListNode head = new ListNode(11);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(5);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(2);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
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
