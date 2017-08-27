package kang.interview.programming.recursive.dynamicprogramming.wordforming;

import java.util.ArrayList;
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
public class WordBoggle_HH {
	
	/**
	 * The hard part for this problem is time efficiency.
	 */

	private static final int[][] shifts = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 },
			{ 1, -1 }, { 1, 0 }, { 1, 1 } };
			
	private Set<String> dic;
	private Set<String> mimicTrie;

	/**
	 * @param board
	 * @param words
	 * @return
	 */
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
		WordBoggle_HH c = new WordBoggle_HH();
		
		char[][] board0 = {{'A','Q','A','H'}, 
				{'A','X','V','W'}, 
				{'A','L','T','I'}, 
				{'T','T','J','I'}};
				 
		char[][] board = { { 'R', 'L', 'D' }, { 'U', 'O', 'E' }, { 'C', 'S', 'O' } };
		String[] words = { "CODE", "SOLO", "RULES", "COOL" };
		
		DataPrinter.printArray(c.wordBoggle(board, words));
	}
	
	

	/**
	 * From CodeFight
	 * 
	 * @param board
	 * @param words
	 * @return
	 */
	String[] wordBoggle_(char[][] board, String[] words) {
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> w = new ArrayList<String>();
		for (String word : words)
			w.add(word);
		int rows = board.length;
		int cols = board[0].length;

		boolean[][] visited = new boolean[rows][cols];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				formWords(w, set, 0, board, visited, row, col);
			}
		}

		int n = set.size();
		String[] result = new String[n];
		int index = 0;
		for (String word : set) {
			result[index++] = word;
		}
		Arrays.sort(result);

		return result;
	}

	void formWords(ArrayList<String> words, HashSet<String> set, int index, char[][] board, boolean[][] visited,
			int row, int col) {
		if (words.size() == 0)
			return;

		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				if (isValid(board, row + dr, col + dc) && !visited[row + dr][col + dc]) {
					ArrayList<String> newWords = new ArrayList<String>();
					for (String word : words) {
						if (word.length() > index + 1 && word.charAt(index) == board[row + dr][col + dc]) {
							newWords.add(word);
						} else if (word.length() == index + 1 && word.charAt(index) == board[row + dr][col + dc]) {
							set.add(word);
						}
					}

					visited[row + dr][col + dc] = true;
					formWords(newWords, set, index + 1, board, visited, row + dr, col + dc);
					visited[row + dr][col + dc] = false;
				}
			}
		}
	}
	
	boolean isValid(char[][] board, int row, int col) {
		return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
	}
	
	/**
	 * From CodeFight: Using dynamic programming
	 * @param board
	 * @param words
	 * @return
	 */
	String[] wordBoggle__(char[][] board, String[] words) {
		int h = board.length;
		int w = board[0].length;

		HashSet<String> ans = new HashSet<>();

		for (String word : words) {
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					if (word.charAt(0) == board[i][j]) {
						boolean[][] visited = new boolean[h][w];
						visited[i][j] = true;
						if (dp(visited, word, board, i, j, 1))
							ans.add(word);
					}
				}
			}
		}
		String[] ret = new String[ans.size()];
		ret = ans.toArray(ret);
		Arrays.sort(ret);
		return ret;
	}

	private boolean dp(boolean[][] v, String word, char[][] board, int r, int c, int idx) {
		if (idx == word.length())
			return true;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (r + i < 0 || r + i >= board.length || c + j < 0 || c + j >= board[0].length || v[r + i][c + j])
					continue;
				if (board[r + i][c + j] != word.charAt(idx))
					continue;
				v[r + i][c + j] = true;
				boolean ret = dp(v, word, board, r + i, c + j, idx + 1);
				if (ret)
					return true;
				v[r + i][c + j] = false;
			}
		}
		return false;
	}

}
