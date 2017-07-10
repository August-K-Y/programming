package kang.interview.programming.zhe;

import java.util.HashMap;
import java.util.Map;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

/**
 *
 * Question 25.10 at Page 457
 * 
 * @see kang.interview.programming.graph.CloneGraph
 * @see kang.interview.programming.stack.SearchPostingList
 * @author Yan Kang
 *
 */
public class ClonePostingsList {
	
	/**
	 * Recursively traverse the Postings List and clone the nodes along the way.
	 * This approach is similar to the way of cloning a graph.
	 * 
	 * @param head
	 *            the head of the linked list
	 * @return
	 */
	public ListNode clone_bf(ListNode head) {
		Map<Integer, ListNode> track = new HashMap<Integer, ListNode>();
		ListNode copiedHead = shallowClone(head);
		track.put(copiedHead.data, copiedHead);
		traverse(copiedHead, head, track);
		return copiedHead;
	}

	private void traverse(ListNode copiedNode, ListNode node, Map<Integer, ListNode> track) {
		if (node == null)
			return;

		// Since the next node and jump node are treated different, we clone
		// them differently. This is different than clone a graph, in which
		// case, all children of graph node are treated the same.
		ListNode next = node.next;
		if (next != null) {
			if (track.containsKey(next.data)) {
				copiedNode.next = track.get(next.data);
			} else {
				ListNode copiedNext = shallowClone(next);
				track.put(next.data, copiedNext);
				copiedNode.next = copiedNext;
				traverse(copiedNext, next, track);
			}
		}
		ListNode jump = node.jump;
		if (jump != null) {
			if (track.containsKey(jump.data)) {
				copiedNode.jump = track.get(jump.data);
			} else {
				ListNode copiedJump = shallowClone(jump);
				track.put(jump.data, copiedJump);
				copiedNode.jump = copiedJump;
				traverse(copiedJump, jump, track);
			}
		}

	}

	private ListNode shallowClone(ListNode node) {
		return new ListNode(node.data);
	}
	
	/**
	 * Clone the Postings List by iterating the Postings List twice.
	 * 
	 * @param head
	 *            the head of the linked list
	 * @return
	 */
	public ListNode clone_iterate(ListNode head) {

		Map<Integer, ListNode> track = new HashMap<Integer, ListNode>();

		// (1) Iterate the original linked list to just clone the node along
		// with its next node if exists.
		// IMPORTANT: After the first iteration, all the jump nodes must be
		// cloned and recored in the track Map.
		ListNode iter = head;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		while (iter != null) {
			ListNode copiedHead = shallowClone(iter);
			prev.next = copiedHead;
			track.put(copiedHead.data, copiedHead);
			prev = copiedHead;
			iter = iter.next;
		}

		// (2) The second iteration just set the jump node of each
		// cloned node.
		iter = head;
		while (iter != null) {
			ListNode copiedNode = track.get(iter.data);
			if (iter.jump != null) {
				copiedNode.jump = track.get(iter.jump.data);
			}
			iter = iter.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		node1.jump = node3;
		node2.jump = node4;
		print(node1, "start");
		ClonePostingsList l = new ClonePostingsList();
		ListNode copied = l.clone_iterate(node1);
		
		System.out.println();
		print(copied, "start");
		
	}

	private static void print(ListNode node, String label) {
		if (node != null) {
			System.out.println(label + ": " + node.data);
			print(node.next, node.data + ".next");
			print(node.jump, node.data + ".jump");
		}

	}

}
