package kang.interview.programming.array.multidimentional;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.util.AlgorithmTestUtil;

public class SpiralOrderingOf2DArray {
	
	public List<Integer> compute(int[][] array) {
		List<Integer> result = new ArrayList<>();
		compute(array, result, 0);
		return result;
	}

	private void compute(int[][] array, List<Integer> result, int indent) {

		int rows = array.length;
		int cols = array[0].length;
		
		if (result.size() >= rows * cols) {
			return;
		}
		
		for (int i = 0 + indent; i <= cols - indent - 1; i++) {
			result.add(array[indent][i]);
		}
		
		for (int i = 1 + indent; i <= rows - indent - 1; i++) {
			result.add(array[i][cols - indent - 1]);
		}
		
		for (int i = cols - indent - 2; i >= indent; i--) {
			result.add(array[rows - indent - 1][i]);
		}
		
		for (int i = rows - indent - 2; i >= indent + 1; i--) {
			result.add(array[i][indent]);
		}

		compute(array, result, indent + 1);
	}

	public static void main(String[] args) {
		SpiralOrderingOf2DArray a = new SpiralOrderingOf2DArray();
		int[][] array1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		List<Integer> result1 = a.compute(array1);
		AlgorithmTestUtil.printList(result1);

		System.out.println();
		int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> result2 = a.compute(array2);
		AlgorithmTestUtil.printList(result2);

	}

}
