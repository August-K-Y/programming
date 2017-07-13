package kang.interview.programming.recursive.dynamicprogramming;

/**
 * 
 * 
 * 
 * {@link http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/}
 * 
 * @author yankang
 *
 */
public class LongestIncreasingSubsequence {
	
	/**
	 * The brute force recursion version of the algorithm. It's time complexity
	 * is O(N!)
	 * 
	 * @param array
	 * @return
	 */
	public int LIS_bf(int[] array) {
		max = 0;
		LIS_bf(array, array[0], 1, 1);
		return max;
	}
	
	private int max;
	
	public void LIS_bf(int[] array, int pre, int index, int sum) {

		if (index == array.length) {
			max = Math.max(max, sum);
		}

		for (int i = index; i < array.length; i++) {

			if (array[i] > pre) {
				LIS_bf(array, array[i], i + 1, sum + 1);
			}
		}
	}
	
	
	
	/**
	 * Bottom-up Dynamic Programming:
	 * 
	 * Let arr[0..n-1] be the input array and L(i) be the length of the LIS
	 * ending at index i such that arr[i] is the last element of the LIS. </br>
	 * <p>
	 * Then, L(i) can be recursively written as: </br>
	 * <ul>
	 * <li>L(i) = 1 + max( L(j) ) where 0 <= j < i and arr[j] < arr[i]
	 * <ul>
	 * </br>
	 * <li>literately, this means looking through all elements that are before
	 * element i and with values smaller than that of element i for the one with
	 * maximum< LIS value</li>
	 * </ul>
	 * </li>
	 * <li>or L(i) = 1, if no such j exists.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param array
	 * @return
	 */
	public int LIS_bottomup(int[] array) {
		
		int n = array.length;
		int L[] = new int[n]; 

		for (int i = 0; i < n; i++)
			L[i] = 1;

		/*
		 * This is a very useful routine that:
		 * 
		 * For each element i in an array, looking through all elements before
		 * element i for certain value, or calculate certain (accumulative)
		 * value and store them in a data structure.
		 */
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] > array[j] && L[j] + 1 > L[i]) {
					L[i] = L[j] + 1;
				}
			}
		}

		int max = 0;
		for (int e : L) {
			max = Math.max(max, e);
		}
		return max;
	}

	public static void main(String args[]) {
		LongestIncreasingSubsequence alg = new LongestIncreasingSubsequence();
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 65, 67 };
		System.out.println("Length of lis is " + alg.LIS_bf(arr));
		System.out.println("Length of lis is " + alg.LIS_bottomup(arr));
	}

}
