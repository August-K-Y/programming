package kang.interview.programming.array.sum.ksum;

import java.util.Arrays;

/**
 * LeetCode 259. 3Sum Smaller:
 * https://leetcode.com/problems/3sum-smaller/discuss/
 * 
 * Given an array of n integers nums and a target, find the number of index
 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
 * nums[j] + nums[k] < target.
 * 
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 * Return 2. Because there are two triplets which sums are less than 2:
 * 
 * [-2, 0, 1] 
 * [-2, 0, 3] 
 * 
 * Follow up: Could you solve it in O(n2) runtime?
 * 
 * Solution:
 * https://discuss.leetcode.com/topic/26642/accepted-and-simple-java-o-n-2-solution-with-detailed-explanation
 * 
 * @author Yan Kang
 *
 */
public class ThreeSumSmaller_H {
	public int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {

			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {

				if (nums[i] + nums[start] + nums[end] < target) {
					// Example [-2, 0, 1, 3]
					// IMPORTANT: If we know that nums[i] + nums[start] +
					// nums[end] < target, then we know that since the array is
					// sorted, we can replace end with any element from lo+1 to
					// end-1, and the requirements will still be met.
					// Just like in the example above, we know that since -2 + 0
					// + 3 < 2, we can replace end (i.e., 3) with 1, and it
					// would still work. Therefore, we can just add end - start
					// to the triplet count.
					count += end - start;
					start++;
				} else {
					end--;
				}

			}
		}

		return count;

	}
}
