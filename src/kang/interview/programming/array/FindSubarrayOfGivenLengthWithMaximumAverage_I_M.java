package kang.interview.programming.array;

import kang.interview.programming.util.DataPrinter;
import kang.interview.programming.invariant.*;

/**
 * 
 * LeetCode: 643. Maximum Average Subarray I:
 * https://leetcode.com/problems/maximum-average-subarray-i/#/description
 * 
 * Given an array consisting of n integers, find the contiguous subarray of
 * given length k that has the maximum average value. And you need to output the
 * maximum average value.
 * 
 * Example 1: Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 Explanation: Maximum
 * average is (12-5-6+50)/4 = 51/4 = 12.75 Note: 1 <= k <= n <= 30,000. Elements
 * of the given array will be in the range [-10,000, 10,000].
 * 
 * @see {@link ContainsDuplicate}
 * @see {@link ContainsNearbyDuplicate}
 * @see {@link ContainsNearbyAlmostDuplicate_H}
 * @see {@link SlidingWindowMaximum_M}
 * @author Yan Kang
 *
 */
public class FindSubarrayOfGivenLengthWithMaximumAverage_I_M {

	/**
	 * 
	 */
	
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;
        
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        
        return max / 1.0 / k;
    }

	public static void main(String[] args) {
		FindSubarrayOfGivenLengthWithMaximumAverage_I_M alg = new FindSubarrayOfGivenLengthWithMaximumAverage_I_M();
		// int[] nums = new int[] { 1, 12, -5, -6, 50, 3 };
		// DataPrinter.println(alg.findMaxAverage(nums, 4));
		//
		// int[] nums2 = new int[] { 1, 12, -5, -6, 50, 14, 3 };
		// DataPrinter.println(alg.findMaxAverage(nums2, 4));

		int[] nums3 = new int[] { 0, 4, 0, 3, 2 };
		DataPrinter.println(alg.findMaxAverage(nums3, 1));
	}
}
