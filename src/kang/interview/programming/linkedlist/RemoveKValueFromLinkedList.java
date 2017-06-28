package kang.interview.programming.linkedlist;

/**
 * 
 * Note: Try to solve this task in O(n) time using O(1) additional space, where
 * n is the number of elements in the list, since this is what you'll be asked
 * to do during an interview.
 * 
 * Given a singly linked list of integers l and an integer k, remove all
 * elements from list l that have a value equal to k.
 * 
 * Example
 * 
 * For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be 
 * removeKFromList(l, k) = [1, 2, 4, 5]; 
 * For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be 
 * removeKFromList(l, k) = [1, 2, 3, 4, 5, 6, 7]. Input/Output
 * 
 * [time limit] 
 * 
 * 3000ms (java) [input] linkedlist.integer l
 * 
 * A singly linked list of integers.
 * 
 * Guaranteed constraints: 0 <= list size <= 105, -1000 <= element value <= 1000.
 * 
 * [input] integer k
 * 
 * An integer.
 * 
 * Guaranteed constraints: -1000 <= k <= 1000.
 * 
 * [output] linkedlist.integer
 * 
 * Return l with all the values equal to k removed.
 */
public class RemoveKValueFromLinkedList {

	class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {

		ListNode<Integer> dummy = new ListNode<>(0);
		ListNode<Integer> prev = new ListNode<>(0);
		dummy.next = l;
		prev = dummy;

		ListNode<Integer> curr = l;
		ListNode<Integer> temp = null;
		while (curr != null) {

			if (curr.value == k) {
				temp = curr.next;
				prev.next = curr.next;
				curr.next = null;
				curr = temp;
			} else {
				prev = curr;
				curr = curr.next;
			}

		}
		return dummy.next;
	}

	public static void main(String[] arg) {

	}
}
