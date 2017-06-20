package kang.interview.programming.array.multidimentional;

import kang.interview.programming.util.AlgorithmTestUtil;

public class Rotate2DArray {
	
	public void rotate(int[][] array) {
		rotate(array, 0);
	}

	private void rotate(int[][] array, int indent) {

		int length = array.length - 2 * indent;
		if(length <= 0)
			return;
					
		int lastRows = array.length - indent - 1; // last row index
		int lastCols = array[0].length - indent - 1; // last col index
		
		int[] backup = new int[length];
		for (int i = 0; i < length; i++) {
			backup[i] = array[indent][i + indent];
		}
		
		for (int i = lastCols, j = indent; i >= indent && j <= lastRows; i--, j++) {
			array[indent][i] = array[j][indent];
		}
		
		for (int i = indent, j = indent; i <= lastRows && j <= lastCols; i++, j++) {
			array[i][indent] = array[lastRows][j];
		}
		
		for (int i = indent, j = lastRows; i <= lastCols && j >= indent; i++, j--) {
			array[lastRows][i] = array[j][lastCols];
		}
		
		for (int i = indent, j = 0; i <= lastRows && j < length; i++, j++) {
			array[i][lastCols] = backup[j];
		}
		rotate(array, indent+1);
	}
	
	public static void main(String[] args) {
		Rotate2DArray a = new Rotate2DArray();
		int[][] array1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		a.rotate(array1);
		AlgorithmTestUtil.print2DArray(array1);

		System.out.println();
		int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	    a.rotate(array2);
		AlgorithmTestUtil.print2DArray(array2);
	}
}
