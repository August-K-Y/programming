package kang.interview.programming.recursive.backtracking;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

public class Sudoku_practice_1 {

	public boolean isSolvable_backtracking(char[][] grid) {
		return isSolvable_backTracking(grid, 0, 0);
	}

	private boolean isSolvable_backTracking(char[][] grid, int i, int j) {
		int rows = grid.length;
		int cols = grid[0].length;

		if (j == cols) {
			j = 0;
			if (++i == rows) {
				return true;
			}
		}

		if (grid[i][j] == '.') {

			for (int d = 1; d <= 9; d++) {
				grid[i][j] = Character.forDigit(d, 10);
				if (isValid(grid, i, j)) {

					if (isSolvable_backTracking(grid, i, j + 1)) {
						return true;
					}
				}
			}

			grid[i][j] = '.';
			return false;
		} else {
			return isSolvable_backTracking(grid, i, j + 1);
		}
	}

	private boolean isValid(char[][] grid, int i, int j) {

		Set<Character> track = new HashSet<>();
		for (int z = 0; z < 9; z++) {
			if (grid[z][j] != '.') {
				char c = grid[z][j];
				if (track.contains(c)) {
					return false;
				}
				track.add(c);
			}
		}

		track = new HashSet<>();
		for (int z = 0; z < 9; z++) {
			if (grid[i][z] != '.') {
				char c = grid[i][z];
				if (track.contains(c)) {
					return false;
				}
				track.add(c);
			}
		}

		track = new HashSet<>();
		int startRow = i / 3 * 3;
		int startCol = j / 3 * 3;
		for (int x = startRow; x < startRow + 3; x++) {
			for (int y = startCol; y < startCol + 3; y++) {
				if (grid[x][y] != '.') {
					char c = grid[x][y];
					if (track.contains(c)) {
						return false;
					}
					track.add(c);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] arg) {
		Sudoku_practice_1 s = new Sudoku_practice_1();

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

		char[][] grid2 = { { '.', '.', '.', '.', '3', '.', '.', '9', '.' },
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
