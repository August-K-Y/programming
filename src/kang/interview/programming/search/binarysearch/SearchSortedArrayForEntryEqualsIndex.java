package kang.interview.programming.search.binarysearch;

public class SearchSortedArrayForEntryEqualsIndex {
	
	/**
	 * no duplicates
	 * @param array
	 * @return
	 */
	public int search(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == mid) {
				return mid;
			} else if (array[mid] > mid) {
				right = mid + 1;
			} else {
				left = mid - 1;
			}
		}
		return -1;
	}

}
