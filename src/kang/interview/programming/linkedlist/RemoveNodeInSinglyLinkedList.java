package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class RemoveNodeInSinglyLinkedList {

	/**
	 * Remove the input node from a singly linked list.
	 * 
	 * @param node
	 *            the node to be removed
	 */
	public void remove(ListNode node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

}
