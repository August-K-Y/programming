package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class RemoveKthFromLastNode {
	
	/**
	 * numbering from 1
	 * @param head
	 * @return
	 */
	public ListNode removeKthLastNode_bf(ListNode head, int k) 
	{
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
		prev.next = current.next;
		current.next = null;
		return dummy.next;
	}

	private int computeLength(ListNode head) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ListNode removeKthLastNode(ListNode head, int k) {
		ListNode faster = head;
		
		// forwards the faster pointer k-1 steps
		while (k > 1) {
			faster = faster.next;
			k--;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode current = head;
		
		// 
		while (faster != null && faster.next != null) {
			faster = faster.next;
			current = current.next;
			prev = prev.next;
		}

		prev.next = current.next;
		current.next = null;
		return dummy.next;
	}


}
