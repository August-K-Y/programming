package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class LinkedListEvenOddMerge {
	
	public ListNode merge(ListNode head) {

		ListNode evenDummyHead = new ListNode(0);
		ListNode evenIter = evenDummyHead;
		ListNode oddDummyHead = new ListNode(0);
		ListNode oddIter = oddDummyHead;
		ListNode iter = head;
		while (iter != null) {
           if(iter.data % 2 ==0)
           {
        	   // even number
        	   evenIter.next = iter;
        	   evenIter = evenIter.next;
           } 
           else 
           {
        	   // odd number
        	   oddIter.next = iter;
        	   oddIter = oddIter.next;
           }
           iter = iter.next;
		}
		
		evenIter.next = oddDummyHead.next;
		return evenDummyHead.next;
	}
	
	public static void main(String[] arg) {
		System.out.println("result:");
		ListNode head = createLinkedList();
		LinkedListEvenOddMerge ora = new LinkedListEvenOddMerge();
		ListNode newHead = ora.merge(head);
		newHead = iterateLinkedList(newHead);
		
		
	}

	private static ListNode createLinkedList() {
		ListNode head = new ListNode(0);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		ListNode node8 = new ListNode(7);
		
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
