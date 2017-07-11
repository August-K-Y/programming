package kang.interview.programming.search.binarysearch;

/**
 * Binary search a sorted array for a given value
 * 
 * @author Yan Kang
 *
 */
public class BinarySearch {

	/**
	 * Search the position of the specified value in an array.
	 * 
	 * @param array
	 *            the array to be searched
	 * @param value
	 *            the value
	 * @return the index of the value in the array
	 */
	public int search(int[] array, int value) {
		if(array.length == 0)
			return -1;
		
		int left = 0;
		int right = array.length - 1;
		
		// Note: here is left <= right
		while (left <= right) {
			// Note: the resulting mid must >= left and < right
			int mid = left + (right - left) / 2;
			if (value > array[mid])
				left = mid + 1;
			else if (value < array[mid])
				right = mid - 1;
			else
				return mid;
		}
		return -1;
	}
}
