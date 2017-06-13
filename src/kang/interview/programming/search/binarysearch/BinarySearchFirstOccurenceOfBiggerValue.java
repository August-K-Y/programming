package kang.interview.programming.search.binarysearch;

public class BinarySearchFirstOccurenceOfBiggerValue {
	public int search(int[] array, int value) {
		if (array.length == 0)
			return -1;

		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (value >= array[mid]) {
				/*
				 * This index, and everything below it, must not be the first
				 * element greater than what we're looking for because this
				 * element is no 
				 */
				left = mid + 1;
			} else {
				// (value < array[mid])
				/*
				 * This element is possible the first element and anything after
				 * it can't be the first element that's at least as large.
				 */
				// Note it is mid, not mid - 1. This is because array[mid] is
				// still the first element possibly. We do not exclude this
				// possibility.
				right = mid;
			}
		}

		if (value < array[left])
			return left;
		else
			return -1;
	}
}
