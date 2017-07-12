package kang.interview.programming.search.binarysearch;

/**
 * 
 * 
 * Looking for array[mid] == mid
 * 
 * For example:
 *  0  1  2  3  4  5  6
 * -8 -7  2  3  8  7  9
 * 
 * no duplicates,
 * 
 * 
 * @author Yan Kang
 *
 */
public class SearchSortedArrayForEntryEqualsIndex {
	
	/**
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
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
