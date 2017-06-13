package kang.interview.programming.array;

/**
 * How to find if there is a sub array with sum equal to zero?
 * 
 * There is whole set of array related questions which are based upon sub-array
 * or only selective elements of array e.g. from some range, this is one of such
 * problem. Here you are given an array of positive and negative numbers, find
 * if there is a sub-array with 0 sum.
 * 
 * Examples:
 * 
 * Input: {4, 2, -3, 1, 6} Output: true There is a sub-array with zero sum from
 * index 1 to 3.
 * 
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gYAeRvLe
 */
public class SubarraySumToZero {

	/**
	 * Q(n^2)
	 * TODO: better solutions???
	 * @param array
	 * @return
	 */
	public boolean isSumToZero(int[] array) {

		for (int i = 0; i < array.length; i++) {

			int sum = array[i];
			for (int j = i - 1; j >= 0; j--) {
				sum += array[j];
				if (sum == 0) {
					print(array, j, i);
					return true;
				}
			}
		}
		return false;
	}

	private void print(int[] array, int j, int i) {
		for (; j <= i; j++) {
			System.out.print(array[j] + " ");
		}

	}
	
	public static void main(String[] args) 
	{
		SubarraySumToZero s = new SubarraySumToZero();
		int[] array = {4, 2, -3, 1, 6};
		System.out.println(s.isSumToZero(array));
	} 

}
