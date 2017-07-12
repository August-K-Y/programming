package kang.interview.programming.array.multidimentional;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * Question 6.19 on Page 92
 * 
 * 
 *          1
 *         1 1
 *        1 2 1
 *       1 3 3 1
 *      1 4 6 4 1
 *
 *         |
 *         V
 *
 *      1 
 *      1 1
 *      1 2 1
 *      1 3 3 1
 *      1 4 6 4 1
 *         
 * @author Yan Kang
 *
 */
public class PascalTriangle {

	/**
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> compute(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> curr = new ArrayList<>();
			for (int j = 0; j <= i; j++) {

				// This is core part of the algorithm:
				// for each cell (i, j) in a row, if it is neither the first
				// column nor the last column, It is the sum of cell (i - 1, j -
				// 1) and cell (i - 1, j). Otherwise, it should be 1.
				curr.add((j > 0 && j < i) ? result.get(i - 1).get(j - 1) + result.get(i - 1).get(j) : 1);
			}
			result.add(curr);
		}
		return result;
	}

	/**
	 * Get the Nth row of the Pascal Triangle.
	 * 
	 * @param nth
	 *            the number representing the nth row
	 * @return the nth row in the form of a list
	 */
	public List<Integer> compute_NthRow(int nth) {
		List<Integer> prevRow = new ArrayList<>(nth);
		List<Integer> curr = new ArrayList<>(nth);
		for (int i = 0; i < nth; i++) {
			curr.clear();
			if (prevRow.isEmpty()) {
				curr.add(1);
			} else {
				for (int j = 0; j <= i; j++) {
					curr.add((j > 0 && j < i) ? prevRow.get(j - 1) + prevRow.get(j) : 1);
				}
			}
			copy(prevRow, curr);
		}
		return prevRow;
	}

	private void copy(List<Integer> des, List<Integer> src) {
		des.clear();
		for (int v : src) {
			des.add(v);
		}
	}

	public static void main(String[] args) {
		PascalTriangle p = new PascalTriangle();

		List<List<Integer>> result2 = p.compute(5);
		DataPrinter.print2DList(result2);

		System.out.println();
		List<Integer> result3 = p.compute_NthRow(5);
		DataPrinter.printList(result3);
	}
}
