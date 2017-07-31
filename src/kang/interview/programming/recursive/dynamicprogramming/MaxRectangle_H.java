package kang.interview.programming.recursive.dynamicprogramming;

/**
 * LeetCode 85. Maximal Rectangle:
 * https://leetcode.com/problems/maximal-rectangle/description/
 * 
 * Interview Element: P502 25.22
 * 
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

	For example, given the following matrix:
	
	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0
	
	Return 6.

 * @author yankang
 *
 */
public class MaxRectangle_H {
	public class MaxHW {
		int H;
		int W;

		public MaxHW(int H, int W) {
			this.H = H;
			this.W = W;
		}
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;

		MaxHW[][] table = new MaxHW[matrix.length][matrix[0].length];

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					table[i][j] = new MaxHW(
											(i + 1) < matrix.length ? table[i + 1][j].H + 1 : 1,
											(j + 1) < matrix[0].length ? table[i][j + 1].W + 1 : 1);
				} else {
					table[i][j] = new MaxHW(0, 0);
				}
			}
		}

		int maxRec = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (matrix[i][j] == '1' && table[i][j].H * table[i][j].W > maxRec) {

					int minW = Integer.MAX_VALUE;
					for (int z = 0; z < table[i][j].H; z++) {
						minW = Math.min(minW, table[i + z][j].W);
						maxRec = Math.max(maxRec, (z + 1) * minW);
					}
				}
			}
		}
		return maxRec;

	}
}
