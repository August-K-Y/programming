package kang.interview.programming.optimization;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumRectangleUnderSkyline {

	/**
	 * O(n^2)
	 * 
	 * @param array
	 * @return
	 */
	public int compute(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			int j = i;
			int minHeight = array[i];
			while (j >= 0) {
				int length = i - j + 1;
				minHeight = Math.min(minHeight, array[j]);
				max = Math.max(max, minHeight * length);
				j--;
			}
		}
		return max;
	}
	
	// TODO: finish this algorithm
	public int compute_faster(int[] array) {
		int max = 0;
		Deque<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {
			int height = array[i];
			while(!queue.isEmpty()) {
				if(array[queue.peekFirst()] >= height){
					queue.removeFirst();
				} else {
					break;
				}
			}
			
			int j = i;
			while (!queue.isEmpty()) {
				int pos = queue.peekFirst();
				int length = i - pos + 1;
				max = Math.max(max,  array[j] * length);
				j--;
			}
			queue.addFirst(i);
		}
		return max;
		
	}

	public static void main(String[] arg) {
		int[] array = { 1, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3 };
		MaximumRectangleUnderSkyline m = new MaximumRectangleUnderSkyline();
		System.out.println("result: " + m.compute(array));
	}

}
