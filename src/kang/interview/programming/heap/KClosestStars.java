package kang.interview.programming.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestStars {

	public class Star implements Comparable<Star> {
		int distanceToEarth = 0;

		@Override
		public int compareTo(Star arg) {
			return Integer.compare(this.distanceToEarth, arg.distanceToEarth);
		}
	}

	public List<Star> getKClosestStars(List<Star> stars, int k) {

		PriorityQueue<Star> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		stars.stream().forEach(a -> {
			maxHeap.add(a);
			if (maxHeap.size() == k + 1) {
				maxHeap.poll();
			}
		});
		
//		for (Star s : stars) {
//			maxHeap.add(s);
//			if (maxHeap.size() == k + 1) {
//				maxHeap.poll();
//			}
//		}
		
		List<Star> result = new ArrayList<>(maxHeap);
		Collections.sort(result); 
		return result;
	}
}
