package kang.interview.programming.optimization;

import java.util.Collections;
import java.util.PriorityQueue;

import kang.interview.programming.array.*;
import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 239. Sliding Window Maximum
 * 
 * Given an array nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers
 * in the window. Each time the sliding window moves right by one position.
 * 
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 * 
 * Window position         Max 
 * ---------------        ----- 
 * [1 3 -1] -3 5 3 6 7      3 
 * 1 [3 -1 -3] 5 3 6 7 		3 
 * 1 3 [-1 -3 5] 3 6 7 		5 
 * 1 3 -1 [-3 5 3] 6 7 		5 
 * 1 3 -1 -3 [5 3 6] 7 		6 
 * 1 3 -1 -3  5 [3 6 7] 	7
 * 
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Note:
 * 
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for
 * non-empty array.
 * 
 * Follow up: Could you solve it in linear time?
 * 
 * @see {@link ContainsDuplicate}
 * @see {@link ContainsNearbyDuplicate}
 * @see {@link ContainsNearbyAlmostDuplicate_H}
 * @see https://leetcode.com/problems/sliding-window-maximum/#/description
 * @author yankang
 *
 */
public class SlidingWindowMaximum_M {
	
	/**
	 * This is typical sliding window problem:
	 * 
	 * Given a window of certain size and slide the window from typically left
	 * to right, to check if elements (e.g., number) in each sliding window
	 * satisfies certain character or perform some work based elements in the
	 * window.
	 */
	
	/**
	 * Using priority queue to track the max value in the range of window. This
	 * algorithm takes: N*O(logk)
	 * 
	 * @param nums
	 * @param w the weight of the sliding window
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int w) {
		if (w <= 0)
			return new int[0];

		// compute the number of sliding windows and create an array to hold max
		// values for these windows
		int size = nums.length - w + 1;
		int[] max = new int[size];

		// Maximum priority queue to track the largest element in each window
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		// This is the initialization of the window. After the initialization, l
		// variable points to the left boundary of the window while r variable
		// point to the one position after the right boundary of the window
		// (Note, this is a convenient design when the window reaches the end of
		// the array, the sliding will terminate automatically, no additional
		// work is needed to check the array boundary).
		int l = 0;
		int r = 0;
		for (; r < w; r++) {
			// do some work on the elements while initializing the window
			q.add(nums[r]);
		}
		int c = 0;
		max[c++] = q.peek();
	
		while (r < nums.length) {
			// remove the first element in old new window from the priority
			// queue and add new element from the new window to the priority
			// queue. 
			
			// Since l points to the left boundary of the old window,
			// q.remove(nums[l++]) first remove this element from the priority
			// queue and move the left boundary one step to the right.

			// Since r points to one position after the right boundary of the
			// old window (in other words, r points to the first element of the
			// forthcoming new window), q.add(nums[r++]) first add the new
			// element to the priority queue and move one step of r further. 
			q.remove(nums[l++]);
			q.add(nums[r++]);
			max[c++] = q.peek();
		}
		return max;
	}

	/**
	 * From LeetCode: O(n) solution with two simple pass in the array.</br>
	 * 
	 * For Example: A = [2,7,3,4,6,3,8,9,10,12,56], w=4
	 * 
	 * partition the array in blocks of size w=4. The last block may have less
	 * then w. 2, 7, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|
	 * 
	 * Traverse the list from start to end and calculate max_so_far. Reset max
	 * after each block boundary (of w elements). 
	 * left_max[] = 2, 7, 7, 7 | 6, 6, 8, 9 | 10, 12, 56
	 * 
	 * Similarly calculate max in future by traversing from end to start.
	 * right_max[] = 7, 7, 4, 4 | 9, 9, 9, 9 | 56, 56, 56
	 * 
	 * now, sliding max at each position i in current window, sliding-max(i) =
	 * max{right_max(i), left_max(i+w-1)} 
	 * sliding_max = 7, 7, 6, 8, 9, 10, 12, 56
	 * 
	 * Rational behind this logic:
	 * 
	 * 
	 * 
	 * @param num
	 * @param w the weight of the sliding window
	 * @return
	 * @see https://discuss.leetcode.com/topic/26480/o-n-solution-in-java-with-
	 *      two-simple-pass-in-the-array
	 */
	public int[] maxSlidingWindow_(int[] num, int w) {
		final int[] max_left = new int[num.length];
		final int[] max_right = new int[num.length];

		max_left[0] = num[0];
		max_right[num.length - 1] = num[num.length - 1];

		for (int i = 1; i < num.length; i++) {
			max_left[i] = (i % w == 0) ? num[i] : Math.max(max_left[i - 1], num[i]);

			final int j = num.length - i - 1;
			max_right[j] = ((j + 1) % w == 0) ? num[j] : Math.max(max_right[j + 1], num[j]);
		}
		
		final int[] sliding_max = new int[num.length - w + 1];
		for (int i = 0, j = 0; i + w <= num.length; i++) {
			sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
		}

		return sliding_max;
	}
	
	public static void main(String[] args) {
		
		int[] nums = { 2, 7, 3, 4, 6, 3, 8, 9, 10, 12, 56 };
		// int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 4;
		
		SlidingWindowMaximum_M s = new SlidingWindowMaximum_M();
		int[] res = s.maxSlidingWindow_(nums, k);
		
		DataPrinter.printArray(res);
	}
}
