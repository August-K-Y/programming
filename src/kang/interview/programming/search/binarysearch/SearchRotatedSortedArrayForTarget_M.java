package kang.interview.programming.search.binarysearch;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 33. Search in Rotated Sorted Array:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/#/description
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * 
 * @author Yan Kang
 *
 */
public class SearchRotatedSortedArrayForTarget_M {
	
	/**
	 * TODO: change this to based on right side
	 * @param A
	 * @param target
	 * @return
	 */
	public int search_(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return A[lo] == target ? lo : -1;
	}
	
	/**
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		return search(nums, target, 0, nums.length - 1);
	}

	private int search(int[] nums, int target, int left, int right) {
		
		if(left > right)
			return -1;

		int mid = left + (right - left) / 2;
		
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < nums[right]) {
			if (target > nums[mid]) {
				int result = search(nums, target, mid + 1, right);
				if (result != -1)
					return result;
				return search(nums, target, left, mid - 1);
			} else {
				return search(nums, target, left, mid - 1);
			}
		} else {
			// nums[mid] >= nums[right]
			if(target > nums[mid]) {
				return search(nums, target, mid + 1, right);
			} else {
				int result = search(nums, target, left, mid - 1);
				if (result != -1)
					return result;
				return search(nums, target, mid + 1, right);
			}
		}
	}
	
	public static void main(String[] args) {
		SearchRotatedSortedArrayForTarget_M alg = new SearchRotatedSortedArrayForTarget_M();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		DataPrinter.println(alg.search(nums, 4));
		DataPrinter.println(alg.search(nums, 5));
		DataPrinter.println(alg.search(nums, 6));
		DataPrinter.println(alg.search(nums, 7));
		DataPrinter.println(alg.search(nums, 0));
		DataPrinter.println(alg.search(nums, 1));
		DataPrinter.println(alg.search(nums, 2));
	}
}
