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
 * Example 3: Input: "BBABCBCAB", Output: 7 then the output should be 7 as "BABCBAB"
 * 
 * @see {@link http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/}
 * @author Yan Kang
 *
 */
public class LongestPalindromicSubsequence_H {
	
	/**
	 * Top-Down Dynamic Programming
	 * 
	 * @param s
	 * @return
	 */
	public int LPS_topdown(String s) {
		char[] chars = s.toCharArray();
		int[][] table = new int[chars.length][chars.length];
		init(table);
		int result = LPS_topdown(chars, 0, chars.length - 1, table);
		DataPrinter.print2DArray(table); 
		return result;
	}

	private void init(int[][] table) {
		for (int i = 0; i < table.length; i++) {
			table[i][i] = 1;
		}
	}

	private int LPS_topdown(char[] chars, int i, int j, int[][] table) {

		if (table[i][j] != 0)
			return table[i][j];

		if (i == j)
			return table[i][j];

		if (i + 1 == j && chars[i] == chars[j]) {
			table[i][j] = 2;
			return table[i][j] ;
		}

		if (chars[i] == chars[j]) {
			table[i][j] = LPS_topdown(chars, i + 1, j - 1, table) + 2;
			return table[i][j];
		}
		table[i][j] = Math.max(LPS_topdown(chars, i + 1, j, table), LPS_topdown(chars, i, j - 1, table));
		return table[i][j];
	}
	
	
	
	
	/**
	 * Bottom-up Dynamic Programming
	 * 
	 * @param seq
	 * @return
	 */
    public int LPS_bottomup(String seq)
    {
       int n = seq.length();
       int i, j, cl;
       int L[][] = new int[n][n];  // Create a table to store results of subproblems
      
       // Strings of length 1 are palindrome of lentgh 1
       for (i = 0; i < n; i++)
           L[i][i] = 1;
       
        // Build the table. Note that the lower diagonal values of table are
        // useless and not filled in the process. The values are filled in a
        // manner similar to Matrix Chain Multiplication DP solution (See
        // http://www.geeksforgeeks.org/archives/15553). cl is length of
        // substring
		for (cl = 2; cl <= n; cl++) {
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (seq.charAt(i) == seq.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (seq.charAt(i) == seq.charAt(j))
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = max(L[i][j - 1], L[i + 1][j]);
			}
		}

		return L[0][n - 1];
    }
    
	static int max (int x, int y) { return (x > y)? x : y; }
	
	/* Driver program to test above functions */
	public static void main(String args[]) {
		LongestPalindromicSubsequence_H alg = new LongestPalindromicSubsequence_H();
		String seq = "GEEKSFORGEEKS";
		System.out.println("The lnegth of the lps is " + alg.LPS_topdown(seq));
	}
}
