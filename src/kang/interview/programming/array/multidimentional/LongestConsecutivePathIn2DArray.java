package kang.interview.programming.array.multidimentional;

/**
 * Given a matrix of characters. Find length of the longest path from a given
 * character, such that all characters in the path are consecutive to each
 * other, i.e., every character in path is next to previous in alphabetical
 * order. It is allowed to move in all 8 directions from a cell.
 * 
 * Example:
 * 
 * Input: mat[][] = { {a, c, d},
                   	  {h, b, e},
                      {i, g, f}}
      Starting Point = 'e'

   Output: 5
   If starting point is 'e', then longest path with consecutive 
   characters is "e f g h i".

   Input: mat[R][C] = { {b, e, f},
                        {h, d, a},
                        {i, c, a}};
   Starting Point = 'b'

   Output: 1
   'c' is not present in all adjacent cells of 'b'

 * @see {@link http://www.geeksforgeeks.org/find-length-of-the-longest-consecutive-path-in-a-character-matrix/}
 * @author yankang
 *
 */
public class LongestConsecutivePathIn2DArray {

	private int[][] shifts = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
			{ 1, 1 } };

	private int max;

	
	/**
	 * Backtrack approach
	 * 
	 * @param mat
	 * @param s
	 * @return
	 */
	public int compute(char mat[][], char s) {
		max = 0;
		int[][] table = new int[mat.length][mat[0].length];

		int x = -1;
		int y = -1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == s) {
					x = i;
					y = j;
				}
			}
		}

		if (x < 0)
			return 0;
		
		findSolution(mat, x, y, s, table, 1);
		return max;
	}

	private void findSolution(char[][] mat, int i, int j, char prev, int[][] table, int length) {
		
		max = Math.max(max, length);
		
		for (int[] shift : shifts) {
			int row = i + shift[0];
			int col = j + shift[1];
			if (row >= 0 && row < mat.length && col >= 0 && col < mat[0].length && table[row][col] == 0
					&& mat[row][col] == prev + 1) {
				// System.out.println("--> (" + row + ", " + col + "): " +
				// mat[row][col]);
				table[row][col] = 1;
				findSolution(mat, row, col, mat[row][col], table, length + 1);
				table[row][col] = 0;
				// System.out.println("========");
			}
		}
	}
	
	/**
	 * Dynamic Programming???
	 * 
	 * @param mat
	 * @param s
	 * @return
	 */
	public int compute_(char mat[][], char s) {
		return 0;
	}
	
	public static void main(String args[]) {
		LongestConsecutivePathIn2DArray alg = new LongestConsecutivePathIn2DArray();
		char mat[][] = { { 'a', 'c', 'd' }, 
						 { 'h', 'b', 'a' }, 
						 { 'i', 'g', 'f' } };

		System.out.println(alg.compute(mat, 'a'));
		System.out.println(alg.compute(mat, 'e'));
		System.out.println(alg.compute(mat, 'b'));
		System.out.println(alg.compute(mat, 'f'));
	}

}
