package kang.interview.programming.invariant;

import java.util.Collections;
import java.util.PriorityQueue;

import kang.interview.programming.util.DataPrinter;

/**
 * 239. Sliding Window Maximum
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
 * 1 [3 -1 -3] 5 3 6 7      3 
 * 1 3 [-1 -3 5] 3 6 7      5 
 * 1 3 -1 [-3 5 3] 6 7      5 
 * 1 3 -1 -3 [5 3 6] 7      6 
 * 1 3 -1 -3 5 [3 6 7]      7 
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
 * @see https://leetcode.com/problems/sliding-window-maximum/#/description
 * 
 * @see kang.interview.programming.array.ContainsNearbyDuplicate
 * @author yankang
 *
 */
public class SlidingWindowMaximum_M {
	
	/**
	 * Using priority queue to track the max value in the range of window. This
	 * algorithm takes: N*O(logk)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k <= 0)
			return new int[0];

		// 
		int size = nums.length - k +1;
		int[] res = new int[size];
		
		// Maximum priority queue
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		//
		int r = 0;
		int l = 0;
		for (; l < k; l++) {
			q.add(nums[l]);
		}
		int c = 0;
		res[c++] = q.peek();
	
		while(l < nums.length) {
			q.remove(nums[r++]);
			q.add(nums[l++]);
			res[c++] = q.peek();
		}
		return res;
	}

	/**
	 * From LeetCode: O(n) solution with two simple pass in the array.</br>
	 * 
	 * For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4
	 * 
	 * partition the array in blocks of size w=4. The last block may have less
	 * then w. 2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|
	 * 
	 * Traverse the list from start to end and calculate max_so_far. Reset max
	 * after each block boundary (of w elements). 
	 * left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56
	 * 
	 * Similarly calculate max in future by traversing from end to start.
	 * right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56
	 * 
	 * now, sliding max at each position i in current window, sliding-max(i) =
	 * max{right_max(i), left_max(i+w-1)} 
	 * sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
	 * 
	 * @param in
	 * @param w
	 * @return
	 * @see https://discuss.leetcode.com/topic/26480/o-n-solution-in-java-with-
	 *      two-simple-pass-in-the-array
	 */
	public static int[] maxSlidingWindow_(int[] in, int w) {
		final int[] max_left = new int[in.length];
		final int[] max_right = new int[in.length];

		max_left[0] = in[0];
		max_right[in.length - 1] = in[in.length - 1];

		for (int i = 1; i < in.length; i++) {
			max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

			final int j = in.length - i - 1;
			max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
		}

		final int[] sliding_max = new int[in.length - w + 1];
		for (int i = 0, j = 0; i + w <= in.length; i++) {
			sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
		}

		return sliding_max;
	}
	
	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		
		SlidingWindowMaximum_M s = new SlidingWindowMaximum_M();
		int[] res = s.maxSlidingWindow(nums, k);
		DataPrinter.printArray(res);
	}
}
