package kang.interview.programming.optimization;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 128. Longest Consecutive Sequence:
 * https://leetcode.com/problems/longest-consecutive-sequence/#/description
 * 
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Challenging part of this question is that your algorithm should run in O(n)
 * complexity.
 * 
 * 
 * Read more: http://www.geeksforgeeks.org/longest-consecutive-subsequence/
 *
 */
public class LongestConsecutiveSquence_M {

	public int findLongestConsecutiveSquence(int[] array) {
		Set<Integer> set = new HashSet<>();
		for (int num : array) {
			set.add(num);
		}

		int max = 0;
		// check each possible sequence from the start
		// then update optimal length
		for (int i = 0; i < array.length; i++) {
			// Check whether current element is the starting element of a
			// sequence. If it is, we only need to check whether the next
			// element of current element exists in the set.

			// When the previous element of current next is not in the set, the
			// current element is the starting element of a sequence.
			if (!set.contains(array[i] - 1)) {

				int curr = array[i];
				int num = 0;
				// Then check for next elements in the
				// sequence
				while (set.contains(curr)) {
					num++;
					curr++;
				}

				// update optimal length if this length
				// is more
				max = Math.max(max, num);

			}
		}
		return max;
	}
	
	public int longestConsecutive(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	
    	Set<Integer> set = new HashSet<>();
    	for(int n : nums) {
    		set.add(n);
    	}
    	
    	int max = Integer.MIN_VALUE;
		for (int n : nums) {
			int count = 1;
			int s = n - 1;
			int b = n + 1;
			while (set.remove(s)) {
				s--;
				count++;
			}
			while (set.remove(b)) {
				b++;
				count++;
			}
			max = Math.max(max, count);
		}
		return max;
	}
    

	public static void main(String[] args) {
		LongestConsecutiveSquence_M s = new LongestConsecutiveSquence_M();
		int[] array = { 1, 9, 3, 10, 4, 20, 2 };
		System.out.println(s.findLongestConsecutiveSquence(array));
		
		LongestConsecutiveSquence_M alg = new LongestConsecutiveSquence_M();

		DataPrinter.println(alg.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}
}
