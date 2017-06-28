package kang.interview.programming.array.multidimentional;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

public class SpiralOrderingOf2DArray {
	
	/**
	 * 
	 * @param the input 2D array
	 * @return
	 */
	public List<Integer> compute_bf(int[][] array) {
		List<Integer> result = new ArrayList<>();
		compute_bf(array, result, 0);
		return result;
	}

	private void compute_bf(int[][] array, List<Integer> result, int offset) {

		int rows = array.length;
		int cols = array[0].length;

		if (result.size() >= rows * cols) {
			return;
		}

		int lastRowIndex = rows - offset - 1;
		int lastColIndex = cols - offset - 1;
		int firstRowIndex = offset;
		int firstColIndex = offset;
		for (int i = firstColIndex; i <= lastColIndex; i++) {
			result.add(array[firstRowIndex][i]);
		}

		for (int i = 1 + firstRowIndex; i <= lastRowIndex; i++) {
			result.add(array[i][lastColIndex]);
		}

		for (int i = lastColIndex - 1; i >= offset; i--) {
			result.add(array[lastRowIndex][i]);
		}

		for (int i = lastRowIndex - 1; i >= offset + 1; i--) {
			result.add(array[i][firstColIndex]);
		}

		compute_bf(array, result, offset + 1);
	}
	
	
	/**
	 * 
	 * @param the input 2D array
	 * @return
	 */
	public List<Integer> compute(int[][] array) {
		List<Integer> result = new ArrayList<>();
		compute(array, result, 0);
		return result;
	}

	private void compute(int[][] array, List<Integer> result, int offset) {

		int rows = array.length;
		int cols = array[0].length;
		
		if (result.size() >= rows * cols) {
			return;
		}
		
		int lastRowIndex = rows - offset - 1;
		int lastColIndex = cols - offset - 1;
		int firstRowIndex = offset;
		int firstColIndex = offset;
		for (int i = firstColIndex; i <= lastColIndex - 1; i++) {
			result.add(array[firstRowIndex][i]);
		}

		for (int i = firstRowIndex; i <= lastRowIndex - 1; i++) {
			result.add(array[i][lastColIndex]);
		}

		for (int i = lastColIndex; i >= offset + 1; i--) {
			result.add(array[lastRowIndex][i]);
		}

		for (int i = lastRowIndex; i >= offset + 1; i--) {
			result.add(array[i][firstColIndex]);
		}

		compute(array, result, offset + 1);
	}
	
	public static void main(String[] args) {
		SpiralOrderingOf2DArray a = new SpiralOrderingOf2DArray();
		int[][] array1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> result1 = a.compute_bf(array1);
		DataPrinter.printList(result1);

		System.out.println();
		int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> result2 = a.compute_bf(array2);
		DataPrinter.printList(result2);
	}
}
