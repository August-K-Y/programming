package kang.interview.programming.optimization;

import java.util.HashMap;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 424. Longest Repeating Character Replacement
 * 
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2
 * 
 * Output: 4
 * 
 * Explanation: Replace the two 'A's with two 'B's or vice versa. Example 2:
 * 
 * Input: s = "AABABBA", k = 1
 * 
 * Output: 4
 * 
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * @author Yan Kang
 *
 */
public class LongestRepeatingCharacterReplacement_M {

	/**
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacement(String s, int k) {

		Map<Character, Integer> map = new HashMap<>();

		int l = 0, r = 0;
		int max = 0;
		char[] chars = s.toCharArray();
		while (r < chars.length) {

			char c = chars[r++];
			map.put(c, map.getOrDefault(c, 0) + 1);

			while (!isValid(map, k)) {
				char cc = chars[l++];
				map.put(cc, map.get(cc) - 1);
			}
			max = Math.max(max, r - l);
		}

		return max;
	}

	private boolean isValid(Map<Character, Integer> map, int k) {
		int max = 0;
		int sum = 0;
		for (int val : map.values()) {
			sum += val;
			max = Math.max(max, val);
		}
		int diff = sum - max;
		if (diff <= k)
			return true;
		
		return false;
	}

	/**
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacement_(String s, int k) {
		int len = s.length();
		int[] count = new int[26];
		int start = 0, maxCount = 0, maxLength = 0;
		for (int end = 0; end < len; end++) {
			maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
			while (end - start + 1 - maxCount > k) {
				count[s.charAt(start) - 'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement_M alg = new LongestRepeatingCharacterReplacement_M();
		
		String s = "ABAB";
		int k = 2; // 4
		String s2 = "AABABBA";
		int k2 = 1; // 4

		DataPrinter.println(alg.characterReplacement(s, k));
		DataPrinter.println(alg.characterReplacement(s2, k2));

	}
}
