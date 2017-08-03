package kang.interview.programming.design;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 146. LRU Cache:
 * https://leetcode.com/problems/lru-cache/description/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It
 * should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1. 
 * 
 * put(key, value) - Set or insert the
 * value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new
 * item.
 * 
 * Follow up: Could you do both operations in O(1) time complexity?
 * 
 * @author yankang
 *
 */
public class LRUCache_HH {

	public static class DLinkedList {
		DLinkedList prev;
		DLinkedList next;
		int val;
		int key;

		public DLinkedList(int key, int value) {
			this.key = key;
			this.val = value;
		}
	}

	private Map<Integer, DLinkedList> cache;
	public DLinkedList dummyH;
	private DLinkedList dummyT;
	private int count;
	private int capacity;

	public LRUCache_HH(int capacity) {

		this.capacity = capacity;
		count = 0;
		dummyH = new DLinkedList(0, 0);
		dummyT = new DLinkedList(0, 0);
		dummyH.next = dummyT;
		dummyT.prev = dummyH;

		cache = new HashMap<>();
	}

	public int get(int key) {
		DLinkedList node = cache.get(key);
		if (node == null)
			return -1;

		moveToHead(node);
		return node.val;
	}

	public void put(int key, int value) {

		DLinkedList node = cache.get(key);
		if (node == null) {

			if (count == capacity) {
				cache.remove(dummyT.prev.key);
				remove(dummyT.prev);
			} else {
				count++;
			}

			node = new DLinkedList(key, value);
			cache.put(key, node);
			add(node);

		} else {
			node.val = value;
			moveToHead(node);
		}
	}

	private void moveToHead(DLinkedList node) {
		remove(node);
		add(node);
	}

	private void add(DLinkedList node) {

		node.next = dummyH.next;
		node.prev = dummyH;

		dummyH.next.prev = node;

		dummyH.next = node;
	}

	private void remove(DLinkedList node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;

		node.prev = null;
		node.next = null;
	}

	public static void main(String[] args) {

		// ["LRUCache","put","put","get","put","get","put","get","get","get"]
		// [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]

		LRUCache_HH obj = new LRUCache_HH(2);
		obj.put(2, 1);
		obj.put(1, 1);
		obj.put(2, 3);
		obj.put(4, 1);
		print(obj.dummyH);
		int param_1 = obj.get(1);
		System.out.println(param_1);
		param_1 = obj.get(2);
		System.out.println(param_1);
	}

	private static void print(DLinkedList head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
