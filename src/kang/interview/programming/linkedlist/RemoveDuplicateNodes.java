package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

/**
 * 
 * @author Yan Kang
 *
 */
public class RemoveDuplicateNodes {

	public ListNode wrong_impl_removeDuplicates(ListNode head) {
		ListNode current = head;

		while (current != null && current.next != null) {
			if (current.data == current.next.data) {
				current.next = current.next.next;
			}
			current = current.next;
		}

		return head;
	}
	
	public ListNode removeDuplicates(ListNode head) 
	{
		ListNode iter = head;
		while(iter != null) 
		{
			ListNode current = iter.next;
			while(current!=null && current.data == iter.data) 
			{
				current = current.next;
			}
			// Deleted all duplicates after iter cursor
			iter.next = current;
			// move the cursor forward
			iter = current;
		}
		return head;
	}
	
	public ListNode removeDuplicatesAboveThreshold(ListNode head, int m)
	{
		ListNode iter = head;
		while(iter!=null) 
		{
			ListNode current = iter.next;
			int count = 1;
			while (current != null && current.data == iter.data) {
				count++;
				current = current.next;
			}
			if (count > m) {
				iter.next = current;
			}
			iter = current;
		}
		return head;
	}

	public static void main(String[] arg) {
		System.out.println("result:");
		ListNode head = createLinkedList();
		RemoveDuplicateNodes ora = new RemoveDuplicateNodes();
		ListNode newHead = ora.wrong_impl_removeDuplicates(head);
		newHead = iterateLinkedList(newHead);
		
		System.out.println("");
		head = createLinkedList();
		newHead = ora.removeDuplicates(head);
		newHead = iterateLinkedList(newHead);
		
		System.out.println("");
		head = createLinkedList();
		newHead = ora.removeDuplicatesAboveThreshold(head, 1);
		newHead = iterateLinkedList(newHead);
		
		System.out.println("");
		head = createLinkedList();
		newHead = ora.removeDuplicatesAboveThreshold(head, 2);
		newHead = iterateLinkedList(newHead);
		
		System.out.println("");
		head = createLinkedList();
		newHead = ora.removeDuplicatesAboveThreshold(head, 3);
		newHead = iterateLinkedList(newHead);
		
	}

	private static ListNode createLinkedList() {
		ListNode head = new ListNode(11);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(7);
		ListNode node5 = new ListNode(2);
		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(2);
		
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
