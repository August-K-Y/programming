package kang.interview.programming.search.generalsearch;

import java.util.Random;

import kang.interview.programming.util.DataPrinter;

public class QuickSearch_M {
	
	private Random rm = new Random();
	
	public int search(int[] array, int k) {
		return findKthLargest(array, 0, array.length - 1, k);
	}
	
	private int findKthLargest(int[] array, int left, int right, int k) {
		int pivotIndex = partition_(array, left, right);
		int rank = pivotIndex + 1;
		if (rank == k) {
			return array[pivotIndex];
		} else if (rank > k) {
			return findKthLargest(array, left, pivotIndex - 1, k);
		} else {
			return findKthLargest(array, pivotIndex + 1, right, k);
		}
	}

	/**
	 * This is the core function of the quick search algorithm. It partitions
	 * the sub-array of the specified array into two parts.  from index of left to index of right
	 * has problem deals with array has duplicates
	 * 
	 * @param array
	 *            the array of which a sub-array is to be partitioned upon
	 * @param left
	 *            the left boundary index of the sub-array to be partitioned
	 *            upon
	 * @param right
	 *            the right boundary index of the sub-array to be partitioned
	 *            upon
	 * @return the index of pivot in the array
	 */
	private int partition(int[] array, int left, int right) {
		
		int pivot = array[rm.nextInt(right - left + 1) + left];

		while(left < right) {
			while(left < right && array[left] > pivot) left ++;
			while(left < right && array[right] < pivot) right --;
			swap(array, left, right);
		}
		return left;
	}
	
	/**
	 * Still has problem deals with array has duplicates
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private int partition_(int[] array, int left, int right) {
		
		int pivotIndex = rm.nextInt(right - left + 1) + left;
		int pivot = array[pivotIndex];
		while(left < right) {
			while(array[left] < pivot) left++;
			while(array[right] > pivot) { right--;}
			if (left < right) {
				swap(array, left, right);
				right--;
				left++;
			}
		}
		
		return left;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void main(String[] args) {
		QuickSearch_M s = new QuickSearch_M();
		int[] board = { 3, 2, 7, 6, 4 };
//		int[] board = { 3, 2, 1, 2, 2, 2, 5, 4 };
		System.out.println(s.search(board, 1));
		System.out.println(s.search(board, 3));
		System.out.println(s.search(board, 5));
//		s.partition_(board, 0, board.length - 1);
	}
}
