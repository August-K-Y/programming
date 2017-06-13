package kang.interview.programming.stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

public class SearchPostingList {

	private Set<ListNode> tracking;
	private Deque<ListNode> stack;

	public SearchPostingList() {
		tracking = new HashSet<>();
		stack = new LinkedList<>();
	}

	public void traverse(ListNode node, int order) {
		if (node == null || node.data != -1)
			return;

		int newOrder = order + 1;
		node.data = order + 1;
		traverse(node.jump, newOrder);
		traverse(node.jump, newOrder);
	}

	public void iterateTraverse(ListNode node) {

		int order = 0;
		ListNode current = node;
		stack.push(current);
		while (!stack.isEmpty()) {

			ListNode top = stack.pop();
			if (top != null && top.data == -1) {
				top.data = order + 1;
				stack.push(current.next);
				stack.push(current.jump);
			}
		}

	}

	private void print(ListNode node) {
		System.out.println(node.data);
	}

	private boolean explored(ListNode jump) {
		return jump == null || tracking.contains(jump);
	}

}
