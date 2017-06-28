package kang.interview.programming.linkedlist;

/**
 * You're given 2 huge integers represented by linked lists. Each linked list
 * element is a number from 0 to 9999 that represents a number with exactly 4
 * digits. The represented number might have leading zeros. Your task is to add
 * up these huge integers and return the result in the same format.
 * 
 * Example
 * 
 * For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
 * addTwoHugeNumbers(a, b) = [9876, 5434, 0].
 * 
 * Explanation: 987654321999 + 18001 = 987654340000.
 * 
 * For a = [123, 4, 5] and b = [100, 100, 100], the output should be
 * addTwoHugeNumbers(a, b) = [223, 104, 105].
 * 
 * Explanation: 12300040005 + 10001000100 = 22301040105.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] linkedlist.integer a
 * 
 * @see AddTwoNumberRepresentedByLinkedList
 * @author Yan Kang
 *
 */
public class AddTwoHugeNumber {
	public static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	public ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

		ListNode<Integer> f = reverse(a);
		ListNode<Integer> s = reverse(b);

		ListNode<Integer> dummy = new ListNode<>(0);
		ListNode<Integer> cursor = dummy;

		int carry = 0;
		while (f != null || s != null) {
			int sum = carry;

			// Add the value of the list node that exists
			if (f != null && s != null) {
				sum += f.value + s.value;
			} else if (f != null) {
				sum += f.value;
			} else {
				sum += s.value;
			}

			// Compute the carry and residue
			carry = sum / 10000;
			int residue = sum % 10000;

			ListNode<Integer> node = new ListNode<>(residue);
			cursor.next = node;
			cursor = node;

			// Forward to the next list node if it exists. This is easy to
			// forget
			f = f == null ? null : f.next;
			s = s == null ? null : s.next;
		}

		// Create a node for the final carry if it is not zero
		if (carry != 0) {
			cursor.next = new ListNode<>(carry);
		}

		return reverse(dummy.next);
	}

	private ListNode<Integer> reverse(ListNode<Integer> a) {
		ListNode<Integer> dummy = new ListNode<>(0);
		dummy.next = a;

		ListNode<Integer> pivot = a;
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
		AddTwoHugeNumber ora = new AddTwoHugeNumber();
		System.out.println("result:");
		ListNode<Integer> a = createLinkedList1();
		ListNode<Integer> b = createLinkedList2();
		ListNode<Integer> newHead = ora.addTwoHugeNumbers(a, b);
		
		printLinkedList(newHead);
	}
	
	public static void printLinkedList(ListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	private static ListNode<Integer> createLinkedList1() {
		ListNode<Integer> head = new ListNode<>(9876);
		ListNode<Integer> node2 = new ListNode<>(5432);
		ListNode<Integer> node3 = new ListNode<>(1999);
		head.next = node2;
		node2.next = node3;
		return head;
	}

	private static ListNode<Integer> createLinkedList2() {
		ListNode<Integer> head = new ListNode<>(1);
		ListNode<Integer> node2 = new ListNode<>(8001);
		head.next = node2;
		return head;
	}
}
