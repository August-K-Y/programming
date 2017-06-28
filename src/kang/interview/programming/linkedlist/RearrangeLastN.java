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

	ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {

		return null;
	}

}
