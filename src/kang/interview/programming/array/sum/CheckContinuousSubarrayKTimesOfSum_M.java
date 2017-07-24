package kang.interview.programming.array.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * Given a list of non-negative numbers and a target integer k, write a function
 * to check if the array has a continuous subarray of size at least 2 that sums
 * up to the multiple of k, that is, sums up to n*k where n is also an integer.
 * 
 * Example 1: Input: [23, 2, 4, 6, 7], k=6 Output: True Explanation: Because [2,
 * 4] is a continuous subarray of size 2 and sums up to 6.
 * 
 * Example 2: Input: 23, 2, 6, 4, 7], k=6 Output: True Explanation: Because [23,
 * 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * 
 * Note: The length of the array won't exceed 10,000. You may assume the sum of
 * all the numbers is in the range of a signed 32-bit integer.
 * 
 * @see {@link ComputeOccurrencesOfContinuouSubarrayBySum_withNegativeValue_M}
 * @see {@link CheckContinuousSubarrayBySum}
 * @see {@link MaximumLengthContinuousSubarrayBySum_M}
 * @author Yan Kang
 *
 */
public class CheckContinuousSubarrayKTimesOfSum_M {

	// Pitfalls: lots of corner cases to be considered, e.g., when k == 0

	/**
	 * brute force: time complexity O(N^2)
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return false;

		for (int i = 0; i < nums.length - 1; i++) {
			int j = i + 1;
			int sum = nums[j--];
			for (; j >= 0; j--) {
				sum += nums[j];
				if (k == 0 && sum == k || k != 0 && sum % k == 0)
					return true;

			}
		}
		return false;
	}
	
	/**
	 * We iterate through the input array exactly once, keeping track of the
	 * running sum mod k of the elements in the process. If we find that a
	 * running sum value at index i has been previously seen before in some
	 * earlier index prev in the array, then we know that the sub-array (prev,i]
	 * contains a desired sum:
	 * 
	 * sum of elements in range of [prev + 1, i] is n*k, because given A stored
	 * in the map:
	 * (A + B) % k = A with (A < k) ==> B % k = 0 ==> B = n * k
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean checkSubarraySum_(int[] nums, int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);

		int runningSum = 0;
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			if (k != 0)
				runningSum %= k;
			Integer prev = map.get(runningSum);
			if (prev != null) {
				if (i - prev > 1)
					return true;
			} else
				map.put(runningSum, i);
		}
		return false;
	}
	
	public static void main(String[] args) {
		CheckContinuousSubarrayKTimesOfSum_M s = new CheckContinuousSubarrayKTimesOfSum_M();
		int[] input1 = { 23, 2, 4, 6, 7 }; 
		int k1 = 6, k2 = -6, k3 = 0;
		
		int[] input2 = { 0, 0 };
		int k4 = 0;
		System.out.println(s.checkSubarraySum(input1, k1) + " = true");
		System.out.println(s.checkSubarraySum(input1, k2) + " = true");
		System.out.println(s.checkSubarraySum(input1, k3) + " = false");
		System.out.println(s.checkSubarraySum(input2, k4) + " = true");
	}
}
