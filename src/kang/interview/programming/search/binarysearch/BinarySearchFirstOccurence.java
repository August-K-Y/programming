package kang.interview.programming.search.binarysearch;

public class BinarySearchFirstOccurence {

	public int search(int[] array, int value) {
		if (array.length == 0)
			return -1;

		int left = 0;
		int right = array.length - 1;
		int result = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (value > array[mid]) {
				left = mid + 1;
			} else if (value < array[mid]) {
				right = mid - 1;
			} else {
				// Continue searching the first occurrence of k on the left of
				// current occurrence. If current occurrence is the first, this
				// value will return at last
				right = mid - 1;
				result = array[mid];
			}
		}
		return result;
	}
}
