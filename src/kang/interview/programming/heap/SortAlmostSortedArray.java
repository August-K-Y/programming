package kang.interview.programming.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortAlmostSortedArray {

	public List<Integer> sortAlmostSortedArray(List<Integer> sequence, int k) {

		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < sequence.size(); i++) {
			queue.add(sequence.get(i));
			if (i >= k) {
				result.add(queue.poll());
			} 
		}
		
		while (!queue.isEmpty()) {
			result.add(queue.poll());
		}
		return result;
	}
	public static void main(String[] args) {

		SortAlmostSortedArray r = new SortAlmostSortedArray();

		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(-1);
		list.add(2);
		list.add(6);
		list.add(4);
		list.add(5);
		list.add(8);
		
		List<Integer> result = r.sortAlmostSortedArray(list, 2);
		result.stream().forEach(a -> System.out.println(a + " "));
		
	}
}
