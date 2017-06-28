package kang.interview.programming.array.multidimentional;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * Question 6.19 on Page 92
 * 
 * @author Yan Kang
 *
 */
public class PascalTriangle {

	/**
	 * 
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> compute_bf(int numRows) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		List<Integer> prevRow = null;
		for (int level = 1; level <= numRows; level++) {
			List<Integer> curr = new ArrayList<Integer>();
			if (prevRow == null) {
				prevRow = new ArrayList<>();
				curr.add(1);
			} else {
				for (int j = 0; j < level; j++) {

					// curr[index] = prev[index] + prev[index-1]
					// But, should deal with corner cases when index at current
					// level is index = 0 and index = level - 1
					int firstH = j - 1 >= 0 ? prevRow.get(j - 1) : 0;
					int secH = j < level - 1 ? prevRow.get(j) : 0;
					int value = firstH + secH;
					curr.add(value);
				}
			}
			result.add(curr);
			prevRow = curr;
		}
		return result;
	}
	
	/**
	 * Optimized version of compute_bf
	 * 
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> compute(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> curr = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
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
		List<List<Integer>> result = p.compute_bf(5);
		DataPrinter.print2DList(result);
		
		System.out.println();
		List<List<Integer>> result2 = p.compute(5);
		DataPrinter.print2DList(result2);
		
		System.out.println();
		List<Integer> result3 = p.compute_NthRow(5);
		DataPrinter.printList(result3);
	}
}
