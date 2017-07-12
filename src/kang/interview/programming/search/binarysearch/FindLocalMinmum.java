package kang.interview.programming.search.binarysearch;

/**
 * 
 * 
 * Find a local minima in an array Given an array arr[0 .. n-1] of distinct
 * integers, the task is to find a local minima in it. We say that an element
 * arr[x] is a local minimum if it is less than or equal to both its neighbors.
 * 
 * - For corner elements, we need to consider only one neighbor for comparison.
 * - There can be more than one local minima in an array, we need to find any one
 * of them. Examples:
 * 
 * Input: arr[] = {9, 6, 3, 14, 5, 7, 4}; Output: Index of local minima is 2 The
 * output prints index of 3 because it is smaller than both of its neighbors.
 * Note that indexes of elements 5 and 4 are also valid outputs.
 * 
 * Input: arr[] = {23, 8, 15, 2, 3}; Output: Index of local minima is 1
 * 
 * Input: arr[] = {1, 2, 3}; Output: Index of local minima is 0
 * 
 * Input: arr[] = {3, 2, 1}; Output: Index of local minima is 2 
 * 
 * A simple solution is to do a linear scan of array and as soon as we find a
 * local minima, we return it. The worst case time complexity of this method
 * would be O(n).
 * 
 * An efficient solution is based on Binary Search. We compare middle element
 * with its neighbors. If middle element is not greater than any of its
 * neighbors, then we return it. If the middle element is greater than its left
 * neighbor, then there is always a local minima in left half (Why? take few
 * examples). If the middle element is greater than its right neighbor, then
 * there is always a local minima in right half (due to same reason as left
 * half).
 * 
 * 
 * @see http://www.geeksforgeeks.org/find-local-minima-array/
 * @author Yan Kang
 *
 */
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
	 * // http://www.geeksforgeeks.org/find-local-minima-array/ //
	 * http://stackoverflow.com/questions/12238241/find-local-minima-in-an-array
	 * 
	 * @param array
	 * @return
	 */
	public int findLocalMinum_BinarySearch(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// check if the local minimum is at the boundary
			if ((mid == 0 && array[mid] <= array[mid + 1])
					|| (mid == array.length - 1 && array[mid] <= array[mid - 1])) {
				return mid;
			}

			// check if the local minimum between the boundary
			if (mid > 0 && mid < array.length - 1 && array[mid] <= array[mid - 1] && array[mid] <= array[mid + 1]) {
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
	
	public static void main(String[] args) {
		FindLocalMinmum f = new FindLocalMinmum();
		int arr[] = { 4, 3, 1, 14, 16, 40 };
		System.out.println("Index of a local minima is " + f.findLocalMinum_BinarySearch(arr));

    }

}
