package kang.interview.programming.linkedlist;

/**
 * LeetCode 23. Merge k Sorted Lists:
 * https://leetcode.com/problems/merge-k-sorted-lists/#/description
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * 
 * @author Yan Kang
 *
 */
public class MergeKSortedLists_M {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * Q(logK * (M+N))
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		return merge(lists, 0, lists.length - 1);
	}

	private ListNode merge(ListNode[] lists, int left, int right) {
		if (left == right) {
			return lists[left];
		}

		int mid = left + (right - left) / 2;

		ListNode list1 = merge(lists, left, mid);
		ListNode list2 = merge(lists, mid + 1, right);

		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				cur.next = list2;
				list2 = list2.next;
			} else {
				cur.next = list1;
				list1 = list1.next;
			}
			cur = cur.next;
		}
		cur.next = list1 == null ? list2 : list1;
		return dummy.next;
	}
	
	public static void main(String[] args){
		MergeKSortedLists_M alg = new MergeKSortedLists_M();
		ListNode[] lists = {null};
		System.out.println(alg.mergeKLists(lists));
	}
}
