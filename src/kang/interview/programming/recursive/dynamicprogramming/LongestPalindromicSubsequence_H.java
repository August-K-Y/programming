package kang.interview.programming.recursive.dynamicprogramming;

import kang.interview.programming.util.DataPrinter;

/**
 * 516. Longest Palindromic Subsequence
 * 
 * Given a string s, find the longest palindromic subsequence's length in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * Example 1: Input: "bbbab" Output: 4 One possible longest palindromic
 * subsequence is "bbbb".
 * 
 * Example 2: Input: "cbbd" Output: 2 One possible longest palindromic
 * subsequence is "bb".
 * 
 * Example 3: Input: "BBABCBCAB", Output: 7 then the output should be 7 as
 * “BABCBAB”
 * 
 * @see {@link http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/}
 * @author Yan Kang
 *
 */
public class LongestPalindromicSubsequence_H {


	
	
	/**
	 * Dynamic Programming
	 * @param s
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
		char[] chars = s.toCharArray();
		int[][] table = new int[chars.length][chars.length];
		init(table);
		int result = LPS(chars, 0, chars.length - 1, table);
		DataPrinter.print2DArray(table); 
		return result;
	}

	private void init(int[][] table) {
		for (int i = 0; i < table.length; i++) {
			table[i][i] = 1;
		}
	}

	private int LPS(char[] chars, int i, int j, int[][] table) {

		if (table[i][j] != 0)
			return table[i][j];

		if (i == j)
			return table[i][j];

		if (i + 1 == j && chars[i] == chars[j]) {
			table[i][j] = 2;
			return table[i][j] ;
		}

		if (chars[i] == chars[j]) {
			table[i][j] = LPS(chars, i + 1, j - 1, table) + 2;
			return table[i][j];
		}
		table[i][j] = Math.max(LPS(chars, i + 1, j, table), LPS(chars, i, j - 1, table));
		return table[i][j];
	}
	
	/* Driver program to test above functions */
	public static void main(String args[]) {
		LongestPalindromicSubsequence_H alg = new LongestPalindromicSubsequence_H();
		String seq = "GEEKSFORGEEKS";
		System.out.println("The lnegth of the lps is " + alg.longestPalindromeSubseq(seq));
	}
}
