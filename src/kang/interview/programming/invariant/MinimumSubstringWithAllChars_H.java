package kang.interview.programming.invariant;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 76. Minimum Window Substring: 
 * https://leetcode.com/problems/minimum-window-substring/#/description
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author Yan Kang
 *
 */
public class MinimumSubstringWithAllChars_H {

	/**
	 * Basic idea: </br>
	 * Scan from left to right, keeping track of how many characters we have
	 * seen from t. </br>
	 * Expand until we have seen all of t, then contract until we lose one of
	 * the values from T.</br>
	 * 
	 * We keep two scan indices, neither of which can decrease. Therefore, the
	 * algorithm is O(n).
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public String minSubstringWithAllChars(String s, String t) {
		if (t == null || t.length() == 0)
			return "";

		// the map tracks how many times each character required by t appears in
		// substring of s with a specific window size
		Map<Character, Integer> map = toMap(t);
		int Left = -1;
		int Right = -1;
		char[] chars = s.toCharArray();
		int minLength = chars.length + 1;

		// This count variable tracks how many unique characters are currently
		// contained in the substring. It is increased when an new character is
		// added to the substring and is decreased when a character is
		// completely removed from (appears zero time in) the substring.
		int count = 0;
		int l = 0;
		int r = 0;
		for (; r < chars.length; r++) {

			if (map.containsKey(chars[r])) {
				int v = map.get(chars[r]);

				// a new required character come in the range of the window
				if (v == 0)
					count++;
				map.put(chars[r], v + 1);
			}

			while (count == t.length()) {

				if (r - l < minLength) {
					Right = r;
					Left = l;
					minLength = r - l;
				}

				if (map.containsKey(chars[l])) {
					int v = map.get(chars[l]);

					// a required character come out of the range of the window
					if (v == 1)
						count--;
					map.put(chars[l], v - 1);
				}

				l++;
			}
		}
		System.out.println(Left + " " + Right);
		return s.substring(Left, Right + 1);
	}

	private Map<Character, Integer> toMap(String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, 0);
		}
		return map;
	}

	// TODO: understand this
	/**
	 * From CodeFight. Interesting solution, which I do not fully understand.
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	String minSubstringWithAllChars_(String s, String t) {
		int desiredState = 0;
		for (char ch : t.toCharArray()) {
			desiredState |= (1 << (ch - 'a'));
		}

		final int len = s.length();

		int currentState = 0;
		int left = 0, right = s.length() - 1;
		for (int i = 0; i < len; i++) {
			currentState |= (1 << (s.charAt(i) - 'a'));
			int tmp = i;
			if ((currentState & desiredState) == desiredState) {

				int state = desiredState;
				int count = 0;
				while (state > 0) {
					int bit = (1 << (s.charAt(tmp) - 'a'));
					if ((state & bit) != 0) {
						state -= bit;
					}
					count++;
					tmp--;
				}
				if (count < right - left + 1) {
					right = i;
					left = i - count + 1;
				}
			}
		}
		return s.substring(left, right + 1);
	}

	public static void main(String[] args) {
		MinimumSubstringWithAllChars_H c = new MinimumSubstringWithAllChars_H();
		String s = "zqyvbfeiee";
		String t = "ze";
		System.out.println(c.minSubstringWithAllChars(s, t));
	}
}
