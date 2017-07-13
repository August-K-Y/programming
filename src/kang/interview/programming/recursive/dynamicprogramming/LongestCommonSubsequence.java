package kang.interview.programming.recursive.dynamicprogramming;

import kang.interview.programming.util.DataPrinter;

/**
 * LCS Problem Statement: Given two sequences, find the length of longest
 * subsequence present in both of them. A subsequence is a sequence that appears
 * in the same relative order, but not necessarily contiguous. For example,
 * “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * 
 * It is a classic computer science problem, the basis of diff (a file
 * comparison program that outputs the differences between two files), and has
 * applications in bioinformatics.
 * 
 * Examples: LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * 
 * @see {@link http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/}
 * @author Yan Kang
 *
 */
public class LongestCommonSubsequence {

	public int LCS_bottomup(String str1, String str2) {

		char[] A = str1.toCharArray();
		char[] B = str2.toCharArray();
		int[][] table = new int[A.length + 1][B.length + 1];
		
		for (int j = 0; j < A.length + 1; j++) {
			table[j][0] = 0;
		}

		for (int j = 0; j < B.length + 1; j++) {
			table[0][j] = 0;
		}

		// table[i][j] represents the longest common subsequence of A[0...i] and
		// B[0...j]
		for (int i = 1; i < A.length + 1; i++) {
			for (int j = 1; j < B.length + 1; j++) {
				if (A[i - 1] == B[j - 1]) {
					table[i][j] = table[i - 1][j - 1] + 1;
				} else {
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		
		DataPrinter.print2DArray(table);
		return table[A.length][B.length];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		System.out.println("Length of LCS is" + " " + lcs.LCS_bottomup(s1, s2));
	}

}
