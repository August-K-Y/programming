package kang.interview.programming.array;

import java.util.PriorityQueue;

/**
 * How to find top two numbers from an integer array?
 * 
 * This is another one of the easy array questions you will find on telephonic
 * round of Interviews, but its also little bit tricky. You are asked to find
 * top two numbers not just the top or highest numbers? Can you think of how you
 * would do it without sorting? before looking at solution.
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4giWkulIj
 *
 * http://www.java67.com/2014/03/how-to-find-top-two-maximum-number-from-integer
 * -array-java.html
 */
public class FindTopTwoNumbersInArray {

	/**
	 * Using min-heap. More general approach with additional data structure.
	 * @param array
	 */
	public void findTopTwoWithHeap(int[] array) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < array.length; i++) {
			if (i < 2) {
				minHeap.add(array[i]);
			} else {
				minHeap.add(array[i]);
				minHeap.poll();
			}
		}

		while (!minHeap.isEmpty()) {
			System.out.print(minHeap.poll() + " ");
		}
	}

	/**
	 * Using two variable to track the top two numbers. More efficient but only
	 * works for tracking top two numbers.
	 * 
	 * @param array
	 */
	public void findTopTwoNumbers(int[] array) {
		int max = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				// This step is important. When certain number N is bigger than
				// current max, current max steps down to becomes the second
				// while N becomes max
				second = max;
				max = array[i];
			} else if (array[i] > second) {
				second = array[i];
			}
		}

		System.out.println(max + ", " + second);
	}

	public static void main(String[] args) {
		FindTopTwoNumbersInArray s = new FindTopTwoNumbersInArray();
		int[] array = { 10, 1, 3, 4, 3, 11, 9 };
		s.findTopTwoNumbers(array);

		s.findTopTwoWithHeap(array);
	}

}
