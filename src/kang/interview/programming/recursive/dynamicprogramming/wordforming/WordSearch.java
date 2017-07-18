package kang.interview.programming.recursive.dynamicprogramming.wordforming;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 79. Word Search:
 * https://leetcode.com/problems/word-search/#/description
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board =
 * 
 * [ 
 * 	 ['A','B','C','E'], 
 *   ['S','F','C','S'], 
 *   ['A','D','E','E'] 
 * ] 
 *   
 *   word = "ABCCED", -> returns true, 
 *   word = "SEE", -> returns true, 
 *   word = "ABCB", -> returns false.
 * 
 * @author Yan Kang
 *
 */
public class WordSearch {

	/*
	 * This problem is not solved by DP. I put it here because it is to the topic.
	 */
	
	private final int[][] shifts = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	private int[][] track;
	
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		
		track = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					track[i][j] = 1;
					boolean found = search(board, i, j, word, 1);
					track[i][j] = 0;
					if (found)
						return true;
				}
			}
		}

		return false;
	}

	private boolean search(char[][] board, int i, int j, String word, int index) {

		// If code reach this point, it means that the word exists in the board.
		if (index >= word.length())
			return true;
		
		for(int[] shift : shifts) {
			int row = i + shift[0];
			int col = j + shift[1];

			// DO NOT forget checking the boundary of the indices
			if (row >= 0 && row < board.length 
					&& col >= 0 && col < board[0].length
					&& track[row][col] == 0
					&& board[row][col] == word.charAt(index)) {
				track[row][col] = 1;
				boolean found = search(board, row, col, word, index + 1);
				track[row][col] = 0;
				if (found)
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };

		String word1 = "ABCCED"; // -> returns true,
		String word2 = "SEE";// -> returns true,
		String word3 = "ABCB";// -> returns false.

		WordSearch alg = new WordSearch();
		DataPrinter.println(alg.exist(board, word1));
		DataPrinter.println(alg.exist(board, word2));
		DataPrinter.println(alg.exist(board, word3));
	}
}
