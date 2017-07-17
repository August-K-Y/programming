package kang.interview.programming.recursive.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * Leetcode: 472 Concatenated word 
 * 
 * Given a list of words (without duplicates), please write a program that
 * returns all concatenated words in the given list of words.
 * 
 * A concatenated word is defined as a string that is comprised entirely of at
 * least two shorter words in the given array.
 * 
 * Example: Input:
 * ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat",
 * "ratcatdogcat"]
 * 
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 
 * Explanation: 
 * "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat". 
 * 
 * Note: The number of elements of the given array will not exceed 10,000 The length sum of elements
 * in the given array will not exceed 600,000. All the input string will only
 * include lower case letters. The returned elements order does not matter.
 * 
 * @author Yan Kang
 *
 */
public class ConcatenatedWords_H {
	
	public int maxCount;
	public int maxL;
	
	/**
	 * correct but Not efficient
	 * @param words
	 * @return
	 */
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		LinkedList<String> result = new LinkedList<>();

		if (words == null || words.length == 0)
			return result;

		int minL = Integer.MAX_VALUE;
		maxL = 0;
		Set<String> set = new LinkedHashSet<>();
		for(String w : words) {
			if (w.trim().length() > 0) {
				minL = Math.min(minL, w.length());
				maxL = Math.max(maxL, w.length());
				set.add(w);
			}
		}
		maxCount = maxL / minL;
		
		if(maxCount == 0)
			return result;
		
		StringBuilder sb = new StringBuilder();
		find(sb, set, 0, result);
		return result;
	}

	private void find(StringBuilder sb, Set<String> set, int count, LinkedList<String> result) {
		if (count > maxCount || sb.toString().length() > maxL) return;
		count++;
		for (String token : set) {
			sb.append(token);
			if (set.contains(sb.toString()) && count >= 2) {
				result.add(sb.toString());
			}
			find(sb, set, count, result);
			sb.setLength(sb.length() - token.length());
		}
	}
	
	/**
	 * From Leetcode: using DP
	 * 
	 * Do you still remember how did you solve this problem?
	 * https://leetcode.com/problems/word-break/
	 * 
	 * If you do know one optimized solution for above question is using DP,
	 * this problem is just one more step further. We iterate through each word
	 * and see if it can be formed by using other words.
	 * 
	 * Of course it is also obvious that a word can only be formed by words
	 * shorter than it. So we can first sort the input by length of each word,
	 * and only try to form one word by using words in front of it.
	 * 
	 * @param words
	 * @return
	 */
	public static List<String> findAllConcatenatedWordsInADict_(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> preWords = new HashSet<>();
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});

		for (int i = 0; i < words.length; i++) {
			if (canForm(words[i], preWords)) {
				result.add(words[i]);
			}
			preWords.add(words[i]);
		}

		return result;
	}

	private static boolean canForm(String word, Set<String> dict) {
		if (dict.isEmpty())
			return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (!dp[j])
					continue;
				if (dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[word.length()];
	}

	public static void main(String[] args) {
		ConcatenatedWords_H alg = new ConcatenatedWords_H();

		String[] words = { "cat", "cats", "catsdogcats", "dog", "",  "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		List<String> result = alg.findAllConcatenatedWordsInADict(words);
		
		DataPrinter.printList(result);
		
	}
}
