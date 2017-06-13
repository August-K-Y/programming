package kang.interview.programming.array;

/**
 * How to find sub array with maximum sum in an array of positive and negative
 * number?
 * 
 * Another array coding question based upon sub-array. Here you have to find the
 * contiguous sub-array within an array (containing at least one number) which
 * has the largest sum.
 * 
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray
 * [4,-1,2,1] has the largest sum = 6.
 * 
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gYECYYCJ
 *
 */
public class FindSubarrayWithMaximumSum {
	
	public int maxSumSubarray(int[] array) {

		int sum = array[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < array.length; i++) {
			sum = Math.max(sum + array[i], array[i]);
			max = Math.max(max, sum);
		}
		return max;
	}
	
	public int maxSumSubarray2(int[] array) {

		int sum = array[0];
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = array.length;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > sum + array[i]) {
				start = i;
				sum = array[i];
			} else {
				sum = sum + array[i];
			}

			if (sum > max) {
				max = sum;
				end = i;
			}
		}

		for (int i = start; i <= end; i++)
			System.out.print(array[i] + " ");
		
		return max;
	}

	public static void main(String[] args) {
		FindSubarrayWithMaximumSum s = new FindSubarrayWithMaximumSum();
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int max = s.maxSumSubarray2(array);
		System.out.println(max);
	}
}
