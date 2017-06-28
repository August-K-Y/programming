package kang.interview.programming.linkedlist;

import kang.interview.programming.linkedlist.LinkedList.ListNode;

/**
 * 
 * Practice for CodeFight
 * 
 * @author Yan Kang
 * @see LinkedListPalindromicity
 *
 */
public class _isListPalindrome {
	public static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	public boolean isListPalindrome(ListNode<Integer> l) {
		
		ListNode<Integer> fast = l;
		ListNode<Integer> slow = l;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode<Integer> secondHalf = null;
		if (fast != null) {
			secondHalf = reverse(slow.next);
		} else {
			secondHalf = reverse(slow);
		}

		ListNode<Integer> firstHalf = l;
		while (secondHalf != null) {
			
			// Since the value is type of Integer, we should be using
			// Object.equals(Object) rather than ==
			if (!firstHalf.value.equals(secondHalf.value)) {
				return false;
			}
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}
		return true;
	}

	private ListNode<Integer> reverse(ListNode<Integer> head) {
		if (head == null)
			return null;
		
		ListNode<Integer> dummy = new ListNode<>(0);
		dummy.next = head;
		
		ListNode<Integer> pivot = dummy.next;
		ListNode<Integer> temp = null;
		while (pivot.next != null) {

			temp = pivot.next;
			pivot.next = temp.next;

			temp.next = dummy.next;
			dummy.next = temp;
		}
		return dummy.next;
	}
	
	public static void main(String[] arg) {
		_isListPalindrome ora = new _isListPalindrome();
		System.out.println("result:");
		ListNode<Integer> head = createLinkedList();
		boolean newHead = ora.isListPalindrome(head);
		System.out.println(newHead);
	}

	private static ListNode<Integer> createLinkedList() {
		ListNode<Integer> head = new ListNode<>(1);
		ListNode<Integer> node2 = new ListNode<>(1000000000);
		ListNode<Integer> node3 = new ListNode<>(-1000000000);
		ListNode<Integer> node4 = new ListNode<>(-1000000000);
		ListNode<Integer> node5 = new ListNode<>(1000000000);
		ListNode<Integer> node6 = new ListNode<>(1);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		return head;
	}
}
