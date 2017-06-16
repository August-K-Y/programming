package kang.interview.programming.invariant;

public class LongestSubarrayWithEqualElements {

	/**
	 * 
	 * @param array
	 * @return
	 */
	public int findLongestSubarrayWithEqualElements(int array[]) {

		int longestSoFar = 0;
		int current = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] == array[i]) {
				current++;
			} else {
				longestSoFar = Math.max(current, longestSoFar);
				current = 1;
			}
		}
		return longestSoFar;
	}

	public static void main(String[] arg) {
		System.out.println("run");
		int[] array = { 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 5 };

		LongestSubarrayWithEqualElements ora = new LongestSubarrayWithEqualElements();
		int profit = ora.findLongestSubarrayWithEqualElements(array);
		System.out.println(profit);
	}
}
