package kang.interview.programming.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class KLargestElementsInMaxHeap_M {

	private class HeapEntry {
		int value;
		int index;

		public HeapEntry(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	/**
	 * This algorithm is WRONG
	 * @param heap
	 * @param k
	 * @return
	 */
	public int[] getKLargestElementsInMaxHeap_WRONG(int[] heap, int k) {
		int[] result = new int[k];

		// tracking how many elements have already been added to the result
		// array
		int tracking = 0;
		List<Integer> currLevel = new ArrayList<>();
		Queue<HeapEntry> q = new LinkedList<>();
		q.add(new HeapEntry(heap[0], 0));
		int currCount = 1;
		int nextCount = 0;
		while (!q.isEmpty()) {

			HeapEntry he = q.poll();
			currLevel.add(he.value);
			currCount--;

			int index = he.index;
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			if (left < heap.length) {
				q.add(new HeapEntry(heap[left], left));
				nextCount++;
			}
			if (right < heap.length) {
				q.add(new HeapEntry(heap[right], right));
				nextCount++;
			}
			if (currCount == 0) {
				currCount = nextCount;
				nextCount = 0;
				
				Collections.sort(currLevel);
				for (int i = tracking, j = 0; i < k && j < currLevel.size(); i++, j++) {
					result[i] = currLevel.get(j);
					tracking++;
				}
				currLevel.clear();
			}
			if (tracking == k)
				break;
		}
		return result;
	}
	
	public int[] getKLargestElementsInMaxHeap(int[] heap, int k) {
		
		int[] result = new int[k];
		PriorityQueue<HeapEntry> q = new PriorityQueue<>();
		q.add(new HeapEntry(heap[0], 0));
		for (int i = 0; i < k; i++) {

			HeapEntry he = q.poll();
			result[i] = he.value;

			int index = he.index;
			int left = 2 * index + 1;
			int right = 2 * index + 2;
			if (left < heap.length) {
				q.add(new HeapEntry(heap[left], left));
			}
			if (right < heap.length) {
				q.add(new HeapEntry(heap[right], right));
			}
		}

		return result;
	}

}
