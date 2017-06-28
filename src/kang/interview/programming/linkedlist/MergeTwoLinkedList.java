package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

/**
 * Note: Your solution should have O(l1.length + l2.length) time complexity,
 * since this is what you will be asked to accomplish in an interview.
 * 
 * Given two singly linked lists sorted in non-decreasing order, your task is to
 * merge them. In other words, return a singly linked list, also sorted in
 * non-decreasing order, that contains the elements from both original lists.
 * 
 * Example
 * 
 * For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be
 * mergeTwoLinkedLists(l1, l2) = [1, 2, 3, 4, 5, 6]; 
 * For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be 
 * mergeTwoLinkedLists(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
 * 
 * @author Yan Kang
 *
 */
public class MergeTwoLinkedList {

	public static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}
	
	public ListNode<Integer> mergeTwoSortedSinglyLinkedList(ListNode<Integer> l1, ListNode<Integer> l2) {

		ListNode<Integer> dummyNode = new ListNode<>(0);

		ListNode<Integer> cursor = dummyNode;
		while (l1 != null && l2 != null) {
			if (l1.value <= l2.value) {
				cursor.next = l1;
				l1 = l1.next;
			} else {
				cursor.next = l2;
				l2 = l2.next;
			}
			cursor = cursor.next;
		}
		
		//
		cursor.next = l1 == null ? l2 : l1;
		return dummyNode.next;
	}
	
	public static void main(String[] arg) {
		MergeTwoLinkedList ora = new MergeTwoLinkedList();
		System.out.println("result:");
		ListNode<Integer> a = createLinkedList1();
		ListNode<Integer> b = createLinkedList2();
		ListNode<Integer> newHead = ora.mergeTwoSortedSinglyLinkedList(a, b);
		
		printLinkedList(newHead);
	}
	
	public static void printLinkedList(ListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	private static ListNode<Integer> createLinkedList1() {
		ListNode<Integer> head = new ListNode<>(1);
		ListNode<Integer> node2 = new ListNode<>(1);
		ListNode<Integer> node3 = new ListNode<>(2);
		ListNode<Integer> node4 = new ListNode<>(4);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		return head;
	}

	private static ListNode<Integer> createLinkedList2() {
		ListNode<Integer> head = new ListNode<>(0);
		ListNode<Integer> node2 = new ListNode<>(3);
		ListNode<Integer> node3 = new ListNode<>(5);
//		ListNode<Integer> node4 = new ListNode<>(2);
//		ListNode<Integer> node5 = new ListNode<>(3);
//		ListNode<Integer> node6 = new ListNode<>(4);
//		ListNode<Integer> node7 = new ListNode<>(5);
		
		head.next = node2;
		node2.next = node3;
//		node3.next = node4;
//		node4.next = node5;
//		node5.next = node6;
//		node6.next = node7;
		return head;
	}

}
