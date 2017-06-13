package kang.interview.programming.search.generalsearch;

import java.util.Random;

public class QuickSearch {
	private Random rm = new Random();
	
	public int search(int[] array, int k) {
		return findKthLargest(array, 0, array.length - 1, k);
	}
	
	private int findKthLargest(int[] array, int left, int right, int k) {
		int pivotIndex = partition(array, left, right);
		int rank = pivotIndex + 1;
		if (rank == k) {
			return array[pivotIndex];
		} else if (rank > k) {
			return findKthLargest(array, left, pivotIndex - 1, k);
		} else {
			return findKthLargest(array, pivotIndex + 1, right, k);
		}
	}

	private int partition(int[] array, int left, int right) {
		
		int pivot = array[rm.nextInt(right - left + 1) + left];

		while(left < right) {
			while(left < right && array[left] > pivot) left ++;
			while(left < right && array[right] < pivot) right --;
			swap(array, left, right);
		}
		return left;
	}

	private void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void main(String[] args) {
		QuickSearch s = new QuickSearch();
		int[] board = { 3, 2, 1, 5, 4 };
		System.out.println(s.search(board, 1));
		System.out.println(s.search(board, 3));
		System.out.println(s.search(board, 5));
	}
}
