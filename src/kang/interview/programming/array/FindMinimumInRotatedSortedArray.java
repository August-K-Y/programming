package kang.interview.programming.array;

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
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gkDwvwXs
 */
public class FindMinimumInRotatedSortedArray {
	
	// binary search
	/**
	 * Finds minimum in a rotated sorted array.
	 * 
	 * @param array
	 *            the rotated sorted array.
	 * @return the index of the minimum value
	 */
	public int findMinimum(int[] array) {
		
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] < right) {
				right = mid;
			} else if (array[mid] > right) {
				left = mid + 1;
			}
		}
		return left;
	}

}
