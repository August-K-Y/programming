package kang.interview.programming.array.multidimentional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 59. Spiral Matrix II:
 * https://leetcode.com/problems/spiral-matrix-ii/#/description
 * 
 * Given an integer n, generate a square matrix filled with elements from 1 to
 * n2 in spiral order.
 * 
 * For example, Given n = 3,
 * 
 * You should return the following matrix: 
 * [ 
 * 	[ 1, 2, 3 ], 
 * 	[ 8, 9, 4 ], 
 * 	[ 7, 6, 5 ] 
 * ]
 * 
 * @author yankang
 *
 */
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

		// Continue to compute the inner layer of the 2D array
		compute_bf(array, result, offset + 1);
	}
	
	
	/**
	 * This version of algorithm is almost identical to the previous one except
	 * that this version do the task in more uniform way.
	 * 
	 * @param the
	 *            input 2D array
	 * @return
	 */
	public List<Integer> compute(int[][] array) {
		List<Integer> result = new ArrayList<>();
		compute_(array, result, 0);
		return result;
	}

	private void compute_(int[][] array, List<Integer> result, int offset) {

		int rows = array.length;
		int cols = array[0].length;
		
		if (result.size() >= rows * cols) {
			return;
		}
		
        if(offset == 2)
        	return;
        
		int lastRowIndex = rows - offset - 1;
		int lastColIndex = cols - offset - 1;
		int firstRowIndex = offset;
		int firstColIndex = offset;
		
        System.out.println("frow: " + lastRowIndex);
        System.out.println("fcol: " + lastColIndex);
        System.out.println("lrow: " + firstRowIndex);
        System.out.println("lcol: " + firstColIndex);
		
		// The only difference between this version of the previous version if
		// the logic control of the four for loops:
		//
		//  -- -- --  | 
		//   |        | 
		//   |        |
		//   | -- -- --
		//
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
		
		// Continue to compute the inner layer of the 2D array
		compute_(array, result, offset + 1);
	}
	
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new LinkedList<>();
        if(matrix == null || matrix.length == 0)
            return ret;
        compute(matrix, 0, ret);
        return ret;
        
    }
    
    private void compute(int[][] matrix, int level, List<Integer> ret) {
        if(ret.size() >= matrix.length * matrix[0].length)
            return;
        
        int frow = level;
        int fcol = level;
        int lrow = matrix.length - level - 1;
        int lcol = matrix[0].length - level - 1;
        
        
        for(int i = fcol; i <= lcol; i++) ret.add(matrix[frow][i]);
        for(int i = frow + 1; i <= lrow; i++) ret.add(matrix[i][lcol]);
        if(frow != lrow)
        	for(int i = lcol - 1; i >= fcol; i--) ret.add(matrix[lrow][i]);
        if(fcol != lcol)
        	for(int i = lrow - 1; i > frow; i--) ret.add(matrix[i][fcol]);
        
        compute(matrix, level + 1, ret);
    }
	
	public static void main(String[] args) {
		SpiralOrderingOf2DArray a = new SpiralOrderingOf2DArray();
//		int[][] array1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
//		List<Integer> result1 = a.compute_bf(array1);
//		DataPrinter.printList(result1);

		System.out.println();
//		int[][] array2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] array2 = { { 2 }, {4}  };
		List<Integer> result2 = a.spiralOrder(array2);
		DataPrinter.printList(result2);
	}
}
