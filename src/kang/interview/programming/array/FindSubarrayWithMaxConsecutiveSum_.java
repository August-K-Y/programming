package kang.interview.programming.array;

/**
 * 
 * Given an array of integers, find the maximum possible sum you can get from
 * one of its contiguous subarrays. The subarray from which this sum comes must
 * contain at least 1 element.
 * 
 * Example
 * 
 * For inputArray = [-2, 2, 5, -11, 6], the output should be
 * arrayMaxConsecutiveSum2(inputArray) = 7.
 * 
 * The contiguous subarray that gives the maximum possible sum is [2, 5], with a
 * sum of 7.
 * 
 * @author Yan Kang
 * @see FindSubarrayWithMaxConsecutiveSum
 *
 */
public class FindSubarrayWithMaxConsecutiveSum_ {

	int arrayMaxConsecutiveSum2(int[] inputArray) {
		int max = inputArray[0];
		int tempSum = inputArray[0];
		for (int i = 1; i < inputArray.length; i++) {
			tempSum = Math.max(tempSum + inputArray[i], inputArray[i]);
			max = Math.max(tempSum, max);
		}
		return max;
	}

}
