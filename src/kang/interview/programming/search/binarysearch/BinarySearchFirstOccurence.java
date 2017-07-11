package kang.interview.programming.search.binarysearch;

/**
 * Binary search a sorted array with duplicates and return the first occurrence
 * of the given value is it has duplicate in the array
 * 
 * @author Yan Kang
 *
 */
public class BinarySearchFirstOccurence {

	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public int search(int[] array, int value) {
		if (array.length == 0)
			return -1;

		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			// the resulting mid must >= left and < right
			int mid = left + (right - left) / 2;
			if (value > array[mid]) {
				left = mid + 1;
			} else if (value < array[mid]) {
				right = mid - 1;
			} else {
				// value == array[mid] case

				// Keeps searching the first occurrence of given value
				// inclusively (do not rule out current valid answer) on the
				// left of current occurrence.
				right = mid;
			}
		}
		return array[left] == value ? left : -1;
	}
	
	/**
	 * 
	 * @param array
	 * @param value
	 * @return
	 */
	public int search_(int[] array, int value) {
		if (array.length == 0)
			return -1;
		
		int result = -1;
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			// the resulting mid must >= left and < right
			int mid = left + (right - left) / 2;
			if (value > array[mid]) {
				left = mid + 1;
			} else if (value < array[mid]) {
				right = mid - 1;
			} else {
				// value == array[mid] case

				// Record the valid answer (may or may not be the final answer)
				// and keeps searching the first occurrence of given value
				// exclusively on the left of current occurrence.
				result = mid;
				right = mid - 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] input = new int[] { 1, 3, 4, 5, 5, 5, 8, 12, 15 };

		BinarySearchFirstOccurence alg = new BinarySearchFirstOccurence();
		int result = alg.search(input, 5);
		System.out.println("result: " + result);
		
		int result2 = alg.search_(input, 5);
		System.out.println("result2: " + result2);
	}
}
