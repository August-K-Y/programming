package kang.interview.programming.linkedlist;

/**
 * LeetCode 138. Copy List with Random Pointer:
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author Yan Kang
 *
 */
public class CopyListWithRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public class Solution {
		
		/**
		 * Two runs: <br/>
		 * In the first run, only iteratively copy the each node and its next
		 * node <br/>
		 * In the second run, only copy the random node of each node
		 * 
		 * @param head
		 * @return
		 */
		public RandomListNode copyRandomList(RandomListNode head) {
			if (head == null)
				return null;
			RandomListNode dummy = new RandomListNode(0);

			RandomListNode p = head;
			RandomListNode prev = dummy;
			while (p != null) {
				RandomListNode curr = new RandomListNode(p.label);
				prev.next = curr;
				prev = curr;
				p = p.next;
			}

			p = head;
			RandomListNode curr = dummy.next;
			while (p != null) {
				curr.random = p.random == null ? null : new RandomListNode(p.random.label);
				curr = curr.next;
				p = p.next;
			}
			return dummy.next;
		}
	}
}
