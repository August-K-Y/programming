package kang.interview.programming.string;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 72. Edit Distance:
 * https://leetcode.com/problems/edit-distance/description/
 * 
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author yankang
 *
 */
public class EditDistance_II_M {

	/**
	 * Use dp[i][j] to represent the shortest edit distance between word1[0,i)
	 * and word2[0, j). Then compare the last character of word1[0,i) and
	 * word2[0,j), which are c and d respectively (c == word1[i-1], d ==
	 * word2[j-1]):
	 * <ol>
	 * <li>if c == d, then : dp[i][j] = dp[i-1][j-1]</li>
	 * <li>Otherwise we can use three operations to convert word1 to word2:
	 * <ol>
	 * <li>(a) if we replaced c with d: dp[i][j] = dp[i-1][j-1] + 1;</li>
	 * <li>(b) if we added d after c: dp[i][j] = dp[i][j-1] + 1;</li>
	 * <li>(c) if we deleted c: dp[i][j] = dp[i-1][j] + 1;</li>
	 * </ol>
	 * </li>
	 * </ol>
	 * 
	 * Note that dp[i][j] only depends on dp[i-1][j-1], dp[i-1][j] and
	 * dp[i][j-1], therefore we can reduce the space to O(n) by using only the
	 * (i-1)th array and previous updated element(dp[i][j-1]).
	 * 
	 * Solution:
	 * https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null)
			return 0;
		if (word1 != null && word1.length() == 0)
			return word2.length();
		if (word2 != null && word2.length() == 0)
			return word1.length();

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		dp[0][0] = 0;

		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = i;
		}

		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int temp = Math.min(dp[i - 1][j], dp[i][j - 1]);
					temp = Math.min(temp, dp[i - 1][j - 1]);
					dp[i][j] = temp + 1;
				}
			}
		}

		// DataPrinter.print2DArray(dp);

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		EditDistance_II_M alg = new EditDistance_II_M();

		DataPrinter.println(alg.minDistance("sea", "ate")); // 3
		DataPrinter.println(alg.minDistance("plasma", "altruism")); // 6
	}
}
