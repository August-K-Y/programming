package kang.interview.programming.recursive.backtracking;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid
 * with numbers in such a way that each column, each row, and each of the nine 3
 * × 3 sub-grids that compose the grid all contain all of the numbers from 1 to
 * 9 one time.
 * 
 * Implement an algorithm that will check whether the given grid of numbers
 * represents a valid Sudoku puzzle according to the layout rules described
 * above. Note that the puzzle represented by grid does not have to be solvable.
 * 
 * Example
 * 
 * For
 * 
 * grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'], ['.', '.', '6', '.',
 * '.', '.', '.', '.', '.'], ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
 * ['.', '.', '1', '.', '.', '.', '.', '.', '.'], ['.', '6', '7', '.', '.', '.',
 * '.', '.', '9'], ['.', '.', '.', '.', '.', '.', '8', '1', '.'], ['.', '3',
 * '.', '.', '.', '.', '.', '.', '6'], ['.', '.', '.', '.', '.', '7', '.', '.',
 * '.'], ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
 * 
 * the output should be sudoku2(grid) = true;
 * 
 * For
 * 
 * grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'], ['.', '.', '.', '.',
 * '6', '.', '.', '.', '.'], ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
 * ['.', '7', '.', '.', '.', '.', '.', '.', '.'], ['.', '.', '.', '.', '8', '3',
 * '.', '.', '.'], ['.', '.', '8', '.', '.', '7', '.', '6', '.'], ['.', '.',
 * '.', '.', '.', '2', '.', '.', '.'], ['.', '1', '.', '2', '.', '.', '.', '.',
 * '.'], ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
 * 
 * the output should be sudoku2(grid) = false.
 * 
 * The given grid is not correct because there are two 1s in the second column.
 * Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1
 * through 9 one time.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] array.array.char grid
 * 
 * A 9 × 9 array of characters, in which each character is either a digit from
 * '1' to '9' or a period '.'.
 * 
 * [output] boolean
 * 
 * Return true if grid represents a valid Sudoku puzzle, otherwise return false.
 * 
 * References:
 * Elements of Programming Interview in JAVA: P86 6.16 and P301 16.9
 * 
 * @author Yan Kang
 * @see kang.interview.programming.array.multidimentional.Sudoku_checker
 *
 */
public class Sudoku_resolver {

	/**
	 * Check if the Sudoku problem is solvable and if it is the the specified
	 * grid will hold one solution. 
	 * 
	 * Using back tracking. Time complex is O(n!)?
	 * 
	 * @param grid
	 *            the grid of the Sudoku
	 * @return true is the Sudoku problem is solvable; false, otherwise
	 */
	public boolean isSolvable_backtracking(char[][] grid) {
		return isSolvable_backTracking(grid, 0, 0);
	}

	/**
	 * Check if the Sudoku problem is solvable and if it is the the specified
	 * grid will hold one solution.
	 * 
	 * @param grid
	 *            the grid of the Sudoku
	 * @param i
	 *            the index of the row
	 * @param j
	 *            the index of the column
	 * @return true if the Sudoku problem is solvable; false, otherwise
	 */
	private boolean isSolvable_backTracking(char[][] grid, int i, int j) {
		int rows = grid.length;
		int cols = grid[0].length;

		// This is a clear way to change the position represented by two indices
		// while traveling: if the column index j equals the size of the columns
		// of the grid, we start a new row by increasing the row index i by one,
		// and setting the column index j to zero. If the the increased i equals
		// the size of row of the grid, it means that the entire grid has been
		// filed without conflicts
		if (j == cols) {
			j = 0;
			if (++i == rows) {
				return true;
			}
		}

		if (grid[i][j] == '.') {

			// If current entry is empty, we try each value for the entry and
			// see if the updated grid is still valid. If yes, we continue to
			// search the solution.
			for (int num = 1; num <= 9; num++) {
				grid[i][j] = Character.forDigit(num, 10);
				if (isValid(grid, i, j)) {
					
					// Note that we only return true if isSolvable_backTracking
					// returned true, which means that a solution has been
					// found. If isSolvable_backTracking returned false, we will
					// try a different value for this entry and continue to
					// search the solution
					if (isSolvable_backTracking(grid, i, j + 1)) {
						return true;
					}
				}
			}

			// This is an important step of backtracking since we need to go
			// back to previous status (of the grid) to search a different
			// solution
			grid[i][j] = '.';
			return false;
		} else {
			return isSolvable_backTracking(grid, i, j+1);
		}
	}

	/**
	 * Check whether the specified entry violates the constraints.
	 * 
	 * @param grid
	 *            the grid of the Sudoku
	 * @param i
	 *            the row index
	 * @param j
	 *            the column index
	 * @return true if no violation; false otherwise
	 */
	public boolean isValid(char[][] grid, int i, int j) {
		int rows = grid.length;
		int cols = grid[0].length;

		Set<Character> track1 = new HashSet<>();
		for (int z = 0; z < cols; z++) {
			if (grid[i][z] != '.') {
				if (track1.contains(grid[i][z])) {
					return false;
				} else {
					track1.add(grid[i][z]);
				}
			}
		}

		Set<Character> track2 = new HashSet<>();
		for (int z = 0; z < rows; z++) {
			if (grid[z][j] != '.') {
				if (track2.contains(grid[z][j])) {
					return false;
				} else {
					track2.add(grid[z][j]);
				}
			}
		}

		int startRow = i / 3 * 3;
		int startCol = j / 3 * 3;
		Set<Character> track3 = new HashSet<>();
		for (int x = startRow; x < startRow + 3; x++) {
			for (int y = startCol; y < startCol + 3; y++) {
				if (grid[x][y] != '.') {
					if (track3.contains(grid[x][y])) {
						return false;
					} else {
						track3.add(grid[x][y]);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] arg) {
		Sudoku_resolver s = new Sudoku_resolver();

		char[][] grid = { { '.', '.', '.', '1', '4', '.', '.', '2', '.' },
						  { '.', '.', '6', '.', '.', '.', '.', '.', '.' }, 
						  { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
						  { '.', '.', '1', '.', '.', '.', '.', '.', '.' }, 
						  { '.', '6', '7', '.', '.', '.', '.', '.', '9' },
						  { '.', '.', '.', '.', '.', '.', '8', '1', '.' }, 
						  { '.', '3', '.', '.', '.', '.', '.', '.', '6' },
						  { '.', '.', '.', '.', '.', '7', '.', '.', '.' }, 
						  { '.', '.', '.', '5', '.', '.', '.', '7', '.' } };

		System.out.println(s.isSolvable_backtracking(grid));
		DataPrinter.printGrid(grid);

		char[][] grid2 = { { '.', '.', '.', '.', '2', '.', '.', '9', '.' },
						   { '.', '.', '.', '.', '6', '.', '.', '.', '.' }, 
						   { '7', '1', '.', '.', '7', '5', '.', '.', '.' },
						   { '.', '7', '.', '.', '.', '.', '.', '.', '.' }, 
						   { '.', '.', '.', '.', '8', '3', '.', '.', '.' },
						   { '.', '.', '8', '.', '.', '7', '.', '6', '.' }, 
						   { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
						   { '.', '1', '.', '2', '.', '.', '.', '.', '.' }, 
						   { '.', '2', '.', '.', '3', '.', '.', '.', '.' } };
		
		System.out.println(s.isSolvable_backtracking(grid2));
		DataPrinter.printGrid(grid2);
	}
}
