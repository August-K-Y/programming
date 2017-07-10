package kang.interview.programming.array.multidimentional;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Yan Kang
 * @see kang.interview.programming.recursive.backtracking.Sudoku_resolver_H
 */
public class Sudoku_checker {
	
	/**
	 * Check if the Sudoku problem is solvable
	 * 
	 * @param grid
	 *            the grid of the Sudoku
	 * @return true is the Sudoku problem is solvable; false, otherwise
	 */
	public boolean isSolvable_backTracking(char[][] grid) {
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

		if (!isValid(grid, i, j)) {
			return false;
		}

		return isSolvable_backTracking(grid, i, j + 1);
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
		Sudoku_checker s = new Sudoku_checker();

		char[][] grid = { { '.', '.', '.', '1', '4', '.', '.', '2', '.' },
						  { '.', '.', '6', '.', '.', '.', '.', '.', '.' }, 
						  { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
						  { '.', '.', '1', '.', '.', '.', '.', '.', '.' }, 
						  { '.', '6', '7', '.', '.', '.', '.', '.', '9' },
						  { '.', '.', '.', '.', '.', '.', '8', '1', '.' }, 
						  { '.', '3', '.', '.', '.', '.', '.', '.', '6' },
						  { '.', '.', '.', '.', '.', '7', '.', '.', '.' }, 
						  { '.', '.', '.', '5', '.', '.', '.', '7', '.' } };

		System.out.println(s.isSolvable_backTracking(grid));

		char[][] grid2 = { { '.', '.', '.', '.', '2', '.', '.', '9', '.' },
						   { '.', '.', '.', '.', '6', '.', '.', '.', '.' }, 
						   { '7', '1', '.', '.', '7', '5', '.', '.', '.' },
						   { '.', '7', '.', '.', '.', '.', '.', '.', '.' }, 
						   { '.', '.', '.', '.', '8', '3', '.', '.', '.' },
						   { '.', '.', '8', '.', '.', '7', '.', '6', '.' }, 
						   { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
						   { '.', '1', '.', '2', '.', '.', '.', '.', '.' }, 
						   { '.', '2', '.', '.', '3', '.', '.', '.', '.' } };
		
		System.out.println(s.isSolvable_backTracking(grid2));
	}
}
