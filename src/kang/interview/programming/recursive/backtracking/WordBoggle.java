package kang.interview.programming.recursive.backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * 
 * Boggle is a popular word game in which players attempt to find words in
 * sequences of adjacent letters on a rectangular board.
 * 
 * Given a two-dimensional array board that represents the character cells of
 * the Boggle board and an array of unique strings words, find all the possible
 * words from words that can be formed on the board.
 * 
 * Note that in Boggle when you're finding a word, you can move from a cell to
 * any of its 8 neighbors, but you can't use the same cell twice in one word.
 * 
 * Example
 * 
 * For
 * 
 * board = [ 
 * 		['R', 'L', 'D'],
 * 		['U', 'O', 'E'], 
 * 		['C', 'S', 'O'] 
 * 	] 
 * and words = ["CODE", "SOLO", "RULES", "COOL"], the output should be 
 * wordBoggle(board, words) = ["CODE", "RULES"].
 * 
 * Example
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] array.array.char board
 * 
 * A two-dimensional array of uppercase English characters representing a
 * rectangular Boggle board.
 * 
 * Guaranteed constraints: 
 * 		2 <= board.length <= 4, 
 * 		2 <= board[i].length <= 4, 
 * 		'A' <= board[i][j] <= 'Z'.
 * 
 * 
 * @author Yan Kang
 *
 */
public class WordBoggle {

	private static final int[][] shifts = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 },
			{ 1, -1 }, { 1, 0 }, { 1, 1 } };
			
	private Set<String> dic;
	private Set<String> mimicTrie;

	String[] wordBoggle(char[][] board, String[] words) {

		int adjustedCapacity = (int) (words.length / 0.75f) + 1;
		mimicTrie = new HashSet<String>(adjustedCapacity);
		dic = new HashSet<>(adjustedCapacity);
		for (String word : words) {
			dic.add(word);
			for (int i = 1; i <= word.length(); i++) {
				mimicTrie.add(word.substring(0, i));
			}
		}

		Set<String> wordList = new HashSet<>();
		int[][] track = new int[board.length][board[0].length];

		StringBuilder word = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				word.append(board[i][j]);
				if (mimicTrie.contains(word.toString())) {
					track[i][j] = 1;
					findSolution(board, track, i, j, word, wordList);
					track[i][j] = 0;
				}
				word.setLength(word.length() - 1);
			}
		}
		String[] result = wordList.toArray(new String[0]);
		Arrays.sort(result);
		return result;
	}

	private void findSolution(char[][] board, int[][] track, int row, int col, StringBuilder word, Set<String> words) {
		if (row == board.length && col == board[0].length) {
			return;
		}
		if (dic.contains(word.toString())) {
			words.add(word.toString());
		}
		for (int[] shift : shifts) {
			int arow = row + shift[0];
			int acol = col + shift[1];
			if (hasPath(arow, acol, track)) {
				word.append(board[arow][acol]);
				if (mimicTrie.contains(word.toString())) {
					track[arow][acol] = 1;
					findSolution(board, track, arow, acol, word, words);
					track[arow][acol] = 0;
				}
				word.setLength(word.length() - 1);
			}
		}
	}

	private boolean hasPath(int row, int col, int[][] track) {
		return row >= 0 && row < track.length && col >= 0 && col < track[0].length && track[row][col] == 0;
	}

	public static void main(String[] args) {
		WordBoggle c = new WordBoggle();
		
		char[][] board0 = {{'A','Q','A','H'}, 
				{'A','X','V','W'}, 
				{'A','L','T','I'}, 
				{'T','T','J','I'}};
				 
		char[][] board = { { 'R', 'L', 'D' }, { 'U', 'O', 'E' }, { 'C', 'S', 'O' } };
		String[] words = { "CODE", "SOLO", "RULES", "COOL" };
		
		DataPrinter.printArray(c.wordBoggle(board, words));
	}
}
