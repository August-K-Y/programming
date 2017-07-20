package kang.interview.programming.recursive.backtracking;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110 
 * 11010 
 * 11000 
 * 00000 
 * 
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000 
 * 11000 
 * 00100 
 * 00011 
 * 
 * Answer: 3
 * 
 * 
 * @author yankang
 *
 */
public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		
		int[][] t = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				t[i][j] = (grid[i][j] == '1' ? 1 : 0);
			}
		}

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (t[i][j] == 1) {
					count++;
					t[i][j] = 0;
					explore(grid, t, i, j);
				}
			}
		}
		return count;
	}

	int[][] shifts = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	private void explore(char[][] grid, int[][] t, int i, int j) { 
		for(int[] shift : shifts) {
			int r = i + shift[0];
			int c = j + shift[1];
			if (r >= 0 && r < t.length && c >= 0 && c < t[0].length && t[r][c] == 1) {
				t[r][c] = 0;
				explore(grid, t, r, c);
			}
		}
	}
	
	public static void main(String[] args) {
		NumberOfIslands alg = new NumberOfIslands();
		char[][] grid = { "11110".toCharArray(), 
						  "11010".toCharArray(), 
						  "11000".toCharArray(), 
						  "00000".toCharArray() };
		
		char[][] grid2 = { "11110".toCharArray(), 
				  		   "11000".toCharArray(), 
				  		   "00100".toCharArray(), 
				  		   "00011".toCharArray() };
		
		DataPrinter.println(alg.numIslands(grid));
		DataPrinter.println(alg.numIslands(grid2));
	}
}
