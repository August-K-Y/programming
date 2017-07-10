package kang.interview.programming.recursive.backtracking;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * In chess, queens can move any number of squares vertically, horizontally, or
 * diagonally. The n-queens puzzle is the problem of placing n queens on an n ×
 * n chess board so that no two queens can attack each other.
 * 
 * Given an integer n, print all possible distinct solutions to the n-queens
 * puzzle. Each solution contains distinct board configurations of the placement
 * of the n queens, where the solutions are arrays that contain permutations of
 * [1, 2, 3, .. n]. The number in the ith position of the results array
 * indicates that the ith column queen is placed in the row with that number. In
 * your solution, the board configurations should be returned in lexicographical
 * order.
 * 
 * Example
 * 
 * For n = 1, the output should be nQueens(n) = [[1]].
 * 
 * For n = 4, the output should be
 * 
 * nQueens(n) = [[2, 4, 1, 3], 
 * 				 [3, 1, 4, 2]] 
 * 
 * This diagram of the second permutation, [3, 1, 4, 2], will help you 
 * visualize its configuration:
 * 
 *     - * - -
 *     - - - *
 *     * - - -
 *     - - * -
 *     
 * The element in the 1st position of the array, 3, indicates that the queen for
 * column 1 is placed in row 3. Since the element in the 2nd position of the
 * array is 1, the queen for column 2 is placed in row 1. The element in the 3rd
 * position of the array is 4, meaning that the queen for column 3 is placed in
 * row 4, and the element in the 4th position of the array is 2, meaning that
 * the queen for column 4 is placed in row 2.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] integer n
 * 
 * The size of the board.
 * 
 * Guaranteed constraints:
 * 
 * 1 <= n <= 10.
 * 
 * [output] array.array.integer
 * 
 * All possible distinct board configurations of the placement of the n queens,
 * ordered lexicographically.
 * 
 * @author Yan Kang
 *
 */
public class NQueens {
	
	int[][] nQueens(int n) {

		int[][] board = new int[n][n];

		List<int[]> list = new ArrayList<>();
		findSolution(board, 0, list);

		int[][] result = new int[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private boolean findSolution(int[][] board, int col, List<int[]> result) {
		int rows = board.length;
		int cols = board[0].length;

		if (col == cols) {
			int[] solution = new int[rows];
			for (int x = 0; x < cols; x++) {
				for (int y = 0; y < rows; y++) {
					if (board[y][x] == 1) {
						solution[x] = y + 1;
					}
				}
			}
			result.add(solution);
			return true;
		}

		for (int i = 0; i < rows; i++) {

			// rejection criterion
			if (isFeasible(board, i, col)) {
				board[i][col] = 1;
				// if (findSolution(board, col + 1, result)) {
				// return true;
				// }
				findSolution(board, col + 1, result);
				board[i][col] = 0;
			}
		}
		return false;
	}

	private boolean isFeasible(int[][] board, int i, int j) {
		int rows = board.length;

		for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
			if (board[row][col] == 1)
				return false;
		}

		for (int row = i, col = j; row < rows && col >= 0; row++, col--) {
			if (board[row][col] == 1)
				return false;
		}

		for (int row = 0; row < rows; row++) {
			if (board[row][j] == 1)
				return false;
		}
		for (int col = 0; col < j; col++) {
			if (board[i][col] == 1)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens q = new NQueens();
		int[][] result = q.nQueens(4);
		DataPrinter.print2DArray(result);
	}
}
