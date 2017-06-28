package kang.interview.programming.honors;

import kang.interview.programming.linkedlist.LinkedList.ListNode;
import kang.interview.programming.linkedlist.LinkedListUtil;
import kang.interview.programming.util.DataPrinter;

/**
 * 
 * Question 25.9 at Page 456
 * @author Yan Kang
 *
 */
public class LinkedListZipping {

	public ListNode compute(ListNode head) {

		/*
		 * (1) Find the start node of the second half of the list
		 */
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode second = slow.next;
		slow.next = null;
		ListNode first = head;

		/*
		 * (2) Reverse the second half of the list and prepare for interleaving
		 * merge
		 */
		second = reverse(second);

		/*
		 * (3) Interleave the first and second halves of the list
		 */
		ListNode temp = null;
		while (second != null) {
			temp = second.next;

			second.next = first.next;
			first.next = second;

			first = second.next;
			second = temp;

		}
		return head;
	}

	private ListNode reverse(ListNode head) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = dummy.next;
		ListNode temp = null;
		while (curr.next != null) {

			temp = curr.next;
			curr.next = temp.next;

			temp.next = prev.next;
			prev.next = temp;
		}
		return dummy.next;
	}

	public static void main(String[] arg) {
		LinkedListZipping ora = new LinkedListZipping();

		System.out.println("result:");
		ListNode head = LinkedListUtil.createLongLinkedList();
		ListNode newHead = ora.compute(head);
		newHead = DataPrinter.printLinkedList(newHead);
	}

}
