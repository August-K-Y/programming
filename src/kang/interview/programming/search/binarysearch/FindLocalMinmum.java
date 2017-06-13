package kang.interview.programming.search.binarysearch;

public class FindLocalMinmum {

	/**
	 * brute-force: iterate the array and find the value that is less than or
	 * equal to its neighbors. The time complexity is O(n).
	 * 
	 * @param array
	 * @return
	 */
	public int findLocalMinmum(int[] array) {
		// 
		return -1;
	}
	
	/**
	 * // http://www.geeksforgeeks.org/find-local-minima-array/
	 * // http://stackoverflow.com/questions/12238241/find-local-minima-in-an-array
	 * @param array
	 * @return
	 */
	public int findLocalMinum_BinarySearch(int[] array) 
	{
		int left = 0;
		int right = array.length - 1;
		while(left <= right) 
		{
			int mid = left + (right - left) / 2;

			// check if the local minimum is at the boundary
			if ((mid == 0 && array[mid] <= array[mid + 1]) 
					|| (mid == array.length - 1 && array[mid] <= array[mid - 1])) {
				return mid;
			}
			
			// check if the local minimum between the boundary
			if (mid > 0 && mid < array.length - 1 
					&& array[mid] <= array[mid - 1] && array[mid] <= array[mid + 1]) {
				return mid;
			}
			
			// narrow down the boundary toward the local minimum
			if (mid > 0 && array[mid] > array[mid - 1]) {
				right = mid - 1;
			} else if (mid < array.length - 1 && array[mid] > array[mid + 1]) {
				left = mid + 1;
			}
		}
		return -1;
	}

}
