package kang.interview.programming.linkedlist;

/**
 * 
 * Note: Try to solve this task in O(list size) time using O(1) additional
 * space, since this is what you'll be asked during an interview.
 * 
 * Given a singly linked list of integers l and a non-negative integer n, move
 * the last n list nodes to the beginning of the linked list.
 * 
 * Example
 * 
 * For l = [1, 2, 3, 4, 5] and n = 3, the output should be 
 * rearrangeLastN(l, n) = [3, 4, 5, 1, 2]; 
 * For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be 
 * rearrangeLastN(l, n) = [7, 1, 2, 3, 4, 5, 6].
 * 
 * [input] integer n
 * 
 * A non-negative integer.
 * 
 * Guaranteed constraints: 0 <= n <= list size.
 * 
 * @author Yan Kang
 *
 */
public class RearrangeLastN {
	class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	/**
	 * 
	 * @param l
	 * @param n
	 * @return
	 * 
	 */
	// constraints: 0 <= n <= list size
	ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
		
		/*
		 * Careful of the corner cases:
		 * (1) the linked list is empty
		 * (2) the input n is 0
		 * (3) the input n is equal to the length of the linked list
		 */
		
		// Deal with the case when the linked list is empty or the n is 0
		if (l == null || n == 0)
			return l;

		// NOTE we step forward n steps rather than n - 1 steps
		ListNode<Integer> temp = l;
		for (int i = 0; i < n; i++) {
			temp = temp.next;
		}

		// Deal with the case when n equals the length of the linked list
		if (temp == null)
			return l;

		// 
		ListNode<Integer> cursor = l;
		while (temp.next != null) {
			cursor = cursor.next;
			temp = temp.next;
		}

		// 
		ListNode<Integer> newHead = cursor.next;
		cursor.next = null;

		//
		temp.next = l;
		return newHead;
	}

}
