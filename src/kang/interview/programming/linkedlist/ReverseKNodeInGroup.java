package kang.interview.programming.linkedlist;

/**
 * Note: Your solution should have O(n) time complexity, where n is the number
 * of element in l, and O(1) additional space complexity, since this is what you
 * would be asked to accomplish in an interview.
 * 
 * Given a linked list l, reverse its nodes k at a time and return the modified
 * list. k is a positive integer that is less than or equal to the length of l.
 * If the number of nodes in the linked list is not a multiple of k, then the
 * nodes that are left out at the end should remain as-is.
 * 
 * You may not alter the values in the nodes - only the nodes themselves can be
 * changed.
 * 
 * Example
 * 
 * For l = [1, 2, 3, 4, 5] and k = 2, the output should be
 * reverseNodesInKGroups(l, k) = [2, 1, 4, 3, 5]; 
 * For l = [1, 2, 3, 4, 5] and k = 1, the output should be 
 * reverseNodesInKGroups(l, k) = [1, 2, 3, 4, 5]; 
 * For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be
 * reverseNodesInKGroups(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].
 * 
 * @author Yan Kang
 *
 */
public class ReverseKNodeInGroup {
	public static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	public ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
		
		int length = computeLength(l);
		
		// The number of reversion to be performed
		int iteration = length / k;

		ListNode<Integer> dummy = new ListNode<>(0);
		dummy.next = l;
		
		ListNode<Integer> cursor = dummy;
		ListNode<Integer> pivot = dummy.next;
		for(int i = 0; i<iteration; i++) {
			
			int j = 1;
			ListNode<Integer> temp = null;
			
			while(j < k && pivot.next!=null) {
				
				temp = pivot.next;
				pivot.next = temp.next;
				
				temp.next = cursor.next;
				cursor.next = temp;
				
				j++;
			}
			
			// Forwards the pivot to the start of the next k nodes
			cursor = pivot;
			pivot = pivot.next;
		}
		
		return dummy.next;
	}

	private int computeLength(ListNode<Integer> head) {
		int length = 0;
		ListNode<Integer> iter = head;
		while (iter != null) {
			length++;
			iter = iter.next;
		}
		return length;
	}
	
	public static void main(String[] arg) {
		System.out.println("result:");
		ReverseKNodeInGroup ora = new ReverseKNodeInGroup();
		
		ListNode<Integer> head = createLongLinkedList();
		ListNode<Integer> newHead = ora.reverseNodesInKGroups(head, 3);
		printLinkedList(newHead);
	}
	
	public static void printLinkedList(ListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	
	public static ListNode<Integer> createLongLinkedList() {
		ListNode<Integer> head = new ListNode<>(1);
		ListNode<Integer> node2 = new ListNode<>(2);
		ListNode<Integer> node3 = new ListNode<>(3);
		ListNode<Integer> node4 = new ListNode<>(4);
		ListNode<Integer> node5 = new ListNode<>(5);
		ListNode<Integer> node6 = new ListNode<>(6);
		ListNode<Integer> node7 = new ListNode<>(7);
		ListNode<Integer> node8 = new ListNode<>(8);
		ListNode<Integer> node9 = new ListNode<>(9);
		ListNode<Integer> node10 = new ListNode<>(10);
		ListNode<Integer> node11 = new ListNode<>(11);
		ListNode<Integer> node12 = new ListNode<>(12);
		ListNode<Integer> node13 = new ListNode<>(13);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = node13;
		return head;
	}
}
