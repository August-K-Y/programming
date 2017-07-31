package kang.interview.programming.array.sum;

import java.util.HashMap;

/**
 * LeetCode 560. Subarray Sum Equals K:
 * https://leetcode.com/problems/subarray-sum-equals-k/#/description
 * 
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * Example 1: Input:nums = [1,1,1], k = 2 Output: 2
 * 
 * Note: 
 * The length of the array is in range [1, 20,000]. 
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is
 * [-1e7, 1e7].
 * 
 * @see {@link CheckContinuousSubarrayBySum}
 * @see {@link MaxLengthOfContinuouSubarrayBySum_withNegativeValue_M}
 * @see {@link CheckContinuousSubarrayKTimesOfSum_M}
 * @see https://leetcode.com/problems/subarray-sum-equals-k/#/solution
 * @author Yan Kang
 */
public class OccurrencesOfContinuouSubarrayBySum_withNegativeValue_M {
	
	/**
	 * Using hashmap
	 * 
	 * The idea behind this approach is as follows:
	 * 
	 * <blockquote>If the cumulative sum (represented by sum[i] for sum upto ith
	 * ​​index) upto two indices is the same, the sum of the elements lying in
	 * between those indices is zero.</blockquote>
	 * 
	 * Extending the same thought further:
	 * 
	 * <blockquote>if the cumulative sum upto two indices, say i and j is at a
	 * difference of k, i.e. if sum[i] - sum[j] = k, the sum of elements lying
	 * between indices i and j is k.</blockquote>
	 * 
	 * Based on these thoughts, we make use of a hashmap which is used to
	 * store the cumulative sum upto all the indices possible along with the
	 * number of times the same sum occurs. We store the data in the form:
	 * (sum_i, no. of occurrences of sum_i). We traverse over the array nums and
	 * keep on finding the cumulative sum. Every time we encounter a new sum, we
	 * make a new entry in the hashmap corresponding to that sum. If the same
	 * sum occurs again, we increment the count corresponding to that sum in the
	 * hashmap. Further, for every sum encountered, we also determine the number
	 * of times the sum sum-k has occurred already, since it will determine the
	 * number of times a subarray with sum k has occurred upto the current
	 * index. We increment the count by the same amount.
	 * 
	 * After the complete array has been traversed, the count gives the required
	 * result.
	 * 
	 * Time complexity : O(n). The entire nums array is traversed only once.
	 * 
	 * Space complexity : O(n). Hashmap can contain upto n distinct entries in
	 * the worst case.
	 * 
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;

		// map cumulative sum to occurrences this cumulative sum appears across
		// the array.
		// IMPORTANT: multiple cumulative sum of the same value only happens in
		// array containing zero and/or negative value
		HashMap<Integer, Integer> map = new HashMap<>();

		// IMPORTANT: This is base value. You can think of it as sum of empty
		// array (i.e., when the array has no element) happens once at the very
		// beginning
		map.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);

			//
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	/**
	 * Using cumulative sum
	 * 
	 * Instead of determining the sum of elements every time for every new
	 * subarray considered, we can make use of a cumulative sum array , sum.
	 * Then, in order to calculate the sum of elements lying between two
	 * indices, we can subtract the cumulative sum corresponding to the two
	 * indices to obtain the sum directly, instead of iterating over the
	 * subarray to obtain the sum.
	 * 
	 * In this implementation, we make use of a cumulative sum array, sum, such
	 * that sum[i] is used to store the cumulative sum of nums array upto the
	 * element corresponding to the (i−1) ​th ​​ index. Thus, to determine the
	 * sum of elements for the subarray nums[i:j], we can directly use sum[j+1]
	 * - sum[i].
	 * 
	 * Time complexity : O(n^2). Considering every possible subarray takes
	 * O(n^2) time. Finding out the sum of any subarray takes O(1) time after
	 * the initial processing of O(n) for creating the cumulative sum array.
	 * 
	 * Space complexity : O(n). Cumulative sum array sum of size n+1 is used.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum_(int[] nums, int k) {
		int count = 0;
		int[] sum = new int[nums.length + 1];
		sum[0] = 0;
		for (int i = 1; i <= nums.length; i++)
			sum[i] = sum[i - 1] + nums[i - 1];
		
		for (int start = 0; start < nums.length; start++) {
			for (int end = start + 1; end <= nums.length; end++) {
				if (sum[end] - sum[start] == k)
					count++;
			}
		}
		return count;
	}
	
	/**
	 * 
	 * 
	 * Instead of considering all the start and end points and then finding the
	 * sum for each subarray corresponding to those points, we can directly find
	 * the sum on the go while considering different end points. i.e. We can
	 * choose a particular start point and while iterating over the end points,
	 * we can add the element corresponding to the endepoint to the sum formed
	 * till now. Whenver the sum equals the required k value, we can update the
	 * count value. We do so while iterating over all the end indices possible
	 * for every start index. Whenver, we update the start index, we need to
	 * reset the sumvalue to 0.
	 * 
	 * Time complexity : O(n^2). We need to consider every subarray possible.
	 * 
	 * Space complexity : O(1). Constant space is used.
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum__(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int sum = 0;
			for (int end = start; end < nums.length; end++) {
				sum += nums[end];
				if (sum == k)
					count++;
			}
		}
		return count;
    }
}
