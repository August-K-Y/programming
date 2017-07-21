package kang.interview.programming.invariant;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 128. Longest Consecutive Sequence:
 * https://leetcode.com/problems/longest-consecutive-sequence/#/description
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * 
 * @author Yan Kang
 *
 */
public class LongestConsecutiveSequence_LeetCode_M {
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
		LongestConsecutiveSequence_LeetCode_M alg = new LongestConsecutiveSequence_LeetCode_M();

		DataPrinter.println(alg.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
	}
}
