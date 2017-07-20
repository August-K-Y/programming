package kang.interview.programming.zhe;

import java.util.Arrays;

public class FindFirstMissingPositiveNumber {

	/**
	 * O(nlogn)
	 * 
	 * @param array
	 * @return the minimal missing positive number
	 */
	public int find_withSort(int[] array) {
		Arrays.sort(array);

		int expect = 1;
		for (int entry : array) {
			if (entry == expect) {
				expect++;
			} else if (entry > expect) {
				return expect;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		FindFirstMissingPositiveNumber f = new FindFirstMissingPositiveNumber();
		int[] array = { 3, 5, 4, -1, 5, 1, -1 };
		System.out.println(f.find_withSort(array));
	}
}
