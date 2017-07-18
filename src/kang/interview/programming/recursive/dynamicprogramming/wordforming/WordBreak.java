package kang.interview.programming.recursive.dynamicprogramming.wordforming;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 139 Word Break {@link https://leetcode.com/problems/word-break/#/description}:
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
 * 
 * 
 * @author Yan Kang
 *
 */
public class WordBreak {

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
		d = new boolean[str.length()];
		return wordBreak(str, 0, dict);
	}
	
	private boolean wordBreak(String str, int index, List<String> dict) {

		if (index >= str.length())
			return true;

		if (d[index])
			return true;

		for (int i = index; i < str.length(); i++) {
			String ss = str.substring(index, i + 1);

			boolean breakable = dict.contains(ss);
			breakable &= wordBreak(str, i + 1, dict);

			if (breakable) {
				d[index] = true;
				return true;
			}
		}

		d[index] = false;
		return false;
	}
	
	private boolean[] d;
	
	
	/**
	 * Bottom-up Dynamic Programming
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak_(String s, List<String> wordDict) {
		boolean[] t = new boolean[s.length() + 1];

		t[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= i; j++) {
				// i = i - 1 + 1
				if (t[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
					t[i] = true;
					break;
				}
			}
		}
		return t[s.length()];
	}
	

	public static void main(String[] args) {
		WordBreak alg = new WordBreak();
		String str = "leetcode";
		List<String> dict = new ArrayList<>();
		dict.add("leet");
		dict.add("code");

		System.out.println(alg.wordBreak(str, dict));
		System.out.println(alg.wordBreak_(str, dict));

	}

}
