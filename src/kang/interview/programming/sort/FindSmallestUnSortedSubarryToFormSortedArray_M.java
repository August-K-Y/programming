package kang.interview.programming.sort;

import kang.interview.programming.util.DataPrinter;

public class FindSmallestUnSortedSubarryToFormSortedArray_M {

	/**
	 * brute-force method: worst time complexity O(N^3);
	 * 
	 * @param array
	 * @return
	 */
	public int compute(int[] array) {

		int minL = array.length;
		int l = -1;
		int r = -1;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (isSorted(array, 0, i - 1) && !isSorted(array, i, j) && isSorted(array, j + 1, array.length - 1)) {
					int min = min(array, i, j);
					int max = max(array, i, j);
					if (i - 1 >= 0 && min >= array[i - 1] && j + 1 < array.length && max <= array[j + 1]) {
						if (minL > j - i + 1) {
							minL = j - i + 1;
							l = i;
							r = j;
						}
					}
				}
			}
		}

		DataPrinter.println(array, l, r);
		return minL == array.length ? -1 : minL;
	}

	private int max(int[] array, int l, int r) {
		int max = Integer.MIN_VALUE;
		for (int i = l; i <= r; i++) {
			max = Math.max(max, array[i]);
		}
		return max;
	}

	private int min(int[] array, int l, int r) {
		int min = Integer.MAX_VALUE;
		for (int i = l; i <= r; i++) {
			min = Math.min(min, array[i]);
		}
		return min;
	}

	private boolean isSorted(int[] array, int l, int r) {
		if (l >= r)
			return true;

		for (int i = l; i < r; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		FindSmallestUnSortedSubarryToFormSortedArray_M alg = new FindSmallestUnSortedSubarryToFormSortedArray_M();
		int[] array = new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		System.out.println(alg.compute(array));
	}

}
