package kang.interview.programming.search.binarysearch;

/**
 * How to find minimum value in a rotated sorted array?
 * 
 * This is another advanced level array coding question and you should only
 * attempt this one, once you have solved the easier ones. Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array. One follow-up question of
 * this question is What if duplicates are allowed? Would this affect the
 * run-time complexity? How and why?
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gYM1Uxnt
 *
 */
public class SearchRotatedSortedArrayForMinimum {

	/**
	 * brute-force: O(n)
	 * 
	 * @param array
	 * @return
	 */
	public int search_bf(int[] array) {
		// Basic idea: find the minimum by iterating the array
		return -1;
	}

	/**
	 * binary search: compare with left boundary (not 100% sure if this is
	 * right)
	 * 
	 * @param array
	 * @return
	 */
	public int search_bs(int[] array) {

		int left = 0;
		int right = array.length - 1;

		if (array[0] < array[array.length - 1])
			return array[0];

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (array[mid] > array[left]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return left;
	}

	/**
	 * binary search: compare with right boundary
	 * 
	 * @param array
	 * @return
	 */
	public int search_minmum_bs2(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;

			if (array[mid] > array[right]) {
				// this is abnormal case where the rotate point happens. The
				// minimum value must be on the right side of mid excluding
				// array[mid].
				left = mid + 1;
			} else {
				// array[mid] <= array[right] case. 

				// This is the normal case of a sorted array, the minimum value
				// must be on the left size of the mid including array[mid].

				// This why we set right = mid rather then set right = mid + 1
				right = mid;
			}
		}
		return left;
	}

}
