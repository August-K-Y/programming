package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;
import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 2. Add Two Numbers:
 * https://leetcode.com/problems/add-two-numbers/#/description
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 * @see AddTwoHugeNumber_M
 * @author Yan Kang
 *
 */
public class AddTwoNumberRepresentedByLinkedList {
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int sum = carry;

			/*
			 * DO NOT forget move l1 and l2 to their corresponding next (which I
			 * always do) and check if they are null while moving
			 */

			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			int r = sum % 10;
			carry = sum / 10;

			ListNode node = new ListNode(r);
			cur.next = node;
			cur = cur.next;
		}

		// DO NOT forget this part
		if (carry != 0)
			cur.next = new ListNode(carry);

		return dummy.next;
	}
	
	public static void main(String[] args) {
		AddTwoNumberRepresentedByLinkedList alg = new AddTwoNumberRepresentedByLinkedList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(8);
		ListNode n3 = new ListNode(0);
		
		n1.next = n2;
		ListNode res = alg.addTwoNumbers(n1, n3);
		printLinkedList(res);
	}
	
	public static ListNode printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		return head;
	}
}
