package kang.interview.programming.array;

/**
 * LeetCode 334. Increasing Triplet Subsequence:
 * https://leetcode.com/problems/increasing-triplet-subsequence/#/description
 * 
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 * 
 * Formally the function should: 
 * Return true if there exists i, j, k such that
 * arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false. 
 * 
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * 
 * Examples: Given [1, 2, 3, 4, 5], return true.
 * 
 * Given [5, 4, 3, 2, 1], return false.
 * 
 * 
 * @author Yan Kang
 *
 */
public class CheckIncreasingTripletSubsequence_H {

	public boolean increasingTriplet(int[] nums) {

		int small = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;

		/*
		 * If we never get the 'second' variable updated, the array is a
		 * consecutive non-increasing array. Put it another way, when the
		 * 'second' variable is updated, the first increasing subsequence of
		 * length 2 appear. Subarray before this point is consecutive
		 * non-increasing.
		 * 
		 * After this point, if we immediately get a value that is bigger than
		 * the 'second' variable, we have got increasing triplet subsequence and
		 * return true.
		 * 
		 * Otherwise, we keep encountering values that are smaller than that of
		 * the 'second' variable and updating the 'small' variable or/and
		 * 'second' variables (IMPORTANT, the 'second' variable is always
		 * updated to a smaller value, otherwise we would get the increasing
		 * triplet subsequence and return true) until either we reach the end of
		 * the array and return false, or we encounter a value that is bigger
		 * than that of the 'second' variable.
		 * 
		 * NOTE: before we encounter the value that is bigger than that of the
		 * 'second' variable, we may always update the 'smaller' variable but
		 * the 'second' variable since all the values we encountered may be
		 * smaller than the 'second' variable. This is fine, since we already
		 * know that there are values smaller than the 'second' variable.
		 */

		for (int n : nums) {
			if (n <= small) {
				small = n;
			} else if (n <= second) {
				second = n;
			} else
				return true;
		}
		return false;
	}
}
