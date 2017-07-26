package kang.interview.programming.recursive.dynamicprogramming.wordforming;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 139 Word Break:
 * {@link https://leetcode.com/problems/word-break/#/description}:
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of
 * strings (instead of a set of strings). Please reload the code definition to
 * get the latest changes.
 * 
 * @author Yan Kang
 *
 */
public class WordBreak_I_Basic {

	/**
	 * This version of dynamic programming is in form of top-down approach. But,
	 * it is actually bottom-up approach, since the value is calculated from the
	 * bottom and bubbled up.
	 * 
	 * @param str
	 * @param dict
	 * @return
	 */
	public boolean wordBreak(String str, List<String> dict) {
		// dp[i] indicates that whether substring from index 0 to index i of
		// string str is work-breakable
		dp = new boolean[str.length()];
		return wordBreak(str, 0, dict);
	}
	
	private boolean wordBreak(String str, int index, List<String> dict) {

		if (index >= str.length())
			return true;

		if (dp[index])
			return true;

		for (int i = index; i < str.length(); i++) {

			// get substring from position index to i of string str
			String ss = str.substring(index, i + 1);

			boolean breakable = dict.contains(ss);
			breakable &= wordBreak(str, i + 1, dict);

			if (breakable) {
				dp[index] = true;
				return true;
			}
		}

		dp[index] = false;
		return false;
	}
	
	private boolean[] dp;
	
	
	/**
	 * Bottom-up (composite up) Dynamic Programming
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak_(String s, List<String> wordDict) {

		// dp[i] indicates whether substring of string s from the first
		// character to ith character is word-breakable.
		boolean[] dp = new boolean[s.length() + 1];

		dp[0] = true;

		// NOTE: i, j are not index of the string s, but 1-based indices of
		// the dynamic programming table.
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= i; j++) {
				// dp[i] is breakable only if dp[j - 1] is breakable and
				// substring from jth char to ith char of string s is a word
				// contained in the dictionary.

				// Should be careful here: s.substring(j - 1, i) actually
				// returns jth char to ith char of the string s.
				if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		WordBreak_I_Basic alg = new WordBreak_I_Basic();
		String str = "leetcode";
		List<String> dict = new ArrayList<>();
		dict.add("leet");
		dict.add("code");

		System.out.println(alg.wordBreak(str, dict));
		System.out.println(alg.wordBreak_(str, dict));
	}
}
