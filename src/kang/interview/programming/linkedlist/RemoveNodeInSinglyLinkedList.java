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

		// To remove a node from a singly linked list, we need to know the
		// previous node of the node to be removed. In this scenario, we only
		// know the node to be removed. Therefore, what we can do is copying all
		// the data of the next node to current node and removing the next node
		// from the list.
		node.data = node.next.data;
		node.next = node.next.next;
	}
}
