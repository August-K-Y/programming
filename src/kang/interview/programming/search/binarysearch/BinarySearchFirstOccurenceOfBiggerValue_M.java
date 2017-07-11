package kang.interview.programming.search.binarysearch;

public class BinarySearchFirstOccurenceOfBiggerValue_M {
	public int search(int[] array, int value) {
		if (array.length == 0)
			return -1;

		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] <= value) {
				/*
				 * This index, and everything below it, must not be the first
				 * element greater than what we're looking for because this
				 * element is no bigger than the given value
				 */
				left = mid + 1;
			} else {
				// array[mid] > value case

				/*
				 * This element is possible the first element. Anything after it
				 * can't be the first element that's at least as large. In other
				 * words, the first occurrence of bigger value must on the left
				 * of mid including array[mid].
				 */
				
				// Note it is mid, not mid - 1. This is because array[mid] is
				// still the first element possibly. We do not exclude this
				// possibility.
				right = mid;
			}
		}
		return value < array[left] ? left : -1;
	}
	

	public static void main(String[] args) {
		int[] input = new int[] { 1, 3, 4, 5, 5, 5, 5, 8, 8, 8, 12, 15 };

		BinarySearchFirstOccurenceOfBiggerValue_M alg = new BinarySearchFirstOccurenceOfBiggerValue_M();
		int result = alg.search(input, 5);
		System.out.println("result: " + result);
	}
}
