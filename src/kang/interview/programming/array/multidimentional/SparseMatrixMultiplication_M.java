package kang.interview.programming.array.multidimentional;

import java.util.HashMap;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 311. Sparse Matrix Multiplication
 * https://leetcode.com/problems/sparse-matrix-multiplication/#/description
 * 
 * Given two sparse matrices A and B, return the result of AB.
   You may assume that <strong>A's column number is equal to B's row number</strong>.
	
	Example:
	
	A = [
	  [ 1, 0, 0],
	  [-1, 0, 3]
	]
	
	B = [
	  [ 7, 0, 0 ],
	  [ 0, 0, 0 ],
	  [ 0, 0, 1 ]
	]
	
	
	     |  1 0 0 |   | 7 0 0 0|   |  7 0 0 0|
	AB = | -1 0 3 | x | 0 0 0 0| = | -7 0 3 3|
	                  | 0 0 1 1|
	                  
    <blockquote>
    A sparse matrix can be represented as a sequence of rows, each of which is 
    a sequence of (column-number, value) pairs of the nonzero values in the row.
    </blockquote>
    
	A =	
		[ 2.0,  -1.0,  0, 	 0  ]
		[-1.0,	 2.0, -1.0,	 0  ]
		[ 0,     0,    0,    0]
		[ 0,	-1.0,  2.0, -1.0]
		[ 0,	 0,	  -1.0,	 2.0]
	
	is represented in this way as
	
	A = [[(0, 2.0), (1, -1.0)],
	     [(0, -1.0), (1, 2.0), (2, -1.0)],
	     []
	     [(1, -1.0), (2, 2.0), (3, -1.0)],
	     [(2, -1.0), (3, 2.0)]]
	     
     
   @see https://leetcode.com/problems/sparse-matrix-multiplication/#/discuss
   @see http://www.cs.cmu.edu/~scandal/cacm/node9.html
 * @author Yan Kang
 *
 */
public class SparseMatrixMultiplication_M {
	
	
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] multiply(int[][] A, int[][] B) {
		
		int[][] result = new int[A.length][B[0].length];
		if(A == null || A.length == 0)
			return result;
		
		if(B == null || B.length == 0)
			return result;
		
		Map<Integer, Map<Integer, Integer>> mapA = new HashMap<>();
		Map<Integer, Map<Integer, Integer>> mapB = new HashMap<>();
		
		for (int rowN = 0; rowN < A.length; rowN++) {
			Map<Integer, Integer> row = new HashMap<>();
			boolean hasValue = false;
			for (int colN = 0; colN < A[0].length; colN++) {
				if (A[rowN][colN] != 0) {
					hasValue = true;
					row.put(colN, A[rowN][colN]);
				}
			}
			if (hasValue) {
				mapA.put(rowN, row);
			}
		}
		
		for (int colN = 0; colN < B[0].length; colN++) {
			Map<Integer, Integer> col = new HashMap<>();
			boolean hasValue = false;
			for (int rowN = 0; rowN < B.length; rowN++) {
				if (B[rowN][colN] != 0) {
					hasValue = true;
					col.put(rowN, B[rowN][colN]);
				}
			}
			if (hasValue) {
				mapB.put(colN, col);
			}
		}
		
		for (int rowN : mapA.keySet()) {
			Map<Integer, Integer> row = mapA.get(rowN);
			for (int colN : mapB.keySet()) {
				Map<Integer, Integer> col = mapB.get(colN);
				int sum = 0;
				for (int index : row.keySet()) {
					if (col.containsKey(index)) {
						sum += row.get(index) * col.get(index);
					}
				}
				result[rowN][colN] = sum;
			}
		}
		return result;
	}

	public int[][] multiply_BEST(int[][] A, int[][] B) {

		int[][] result = new int[A.length][B[0].length];
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			Map<Integer, Integer> row = new HashMap<>();
			boolean hasRow = false;
			for (int j = 0; j < A[0].length; j++) {
				// A[i][j] != 0 is important for performance boosting for sparse
				// matrix since all 0 values are ruled out.
				if (A[i][j] != 0) {
					hasRow = true;
					row.put(j, A[i][j]);
				}
			}
			if (hasRow)
				map.put(i, row);
		}

		for (int m : map.keySet()) {
			Map<Integer, Integer> row = map.get(m);
			for (int k : row.keySet()) {
				for (int n = 0; n < B[0].length; n++) {
					if (B[k][n] != 0) {
						result[m][n] += row.get(k) * B[k][n];
					}
				}

			}
		}
		return result;
    }

	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
    public int[][] multiply_(int[][] A, int[][] B) {
		int m = A.length, n = A[0].length, nB = B[0].length;
		int[][] C = new int[m][nB];

		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < nB; j++) {
						if (B[k][j] != 0)
							C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}
		return C;
	}
    
    
	public static void main(String[] args) {
		SparseMatrixMultiplication_M alg = new SparseMatrixMultiplication_M();
		int[][] A = { { 1, 0, 0 }, { -1, 0, 3 } };
		int[][] B = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		DataPrinter.print2DArray(alg.multiply(A, B));
	}
}
