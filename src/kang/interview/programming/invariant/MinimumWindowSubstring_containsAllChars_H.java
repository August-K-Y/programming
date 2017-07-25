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
 * Solution:
 * @see https://leetcode.com/problems/minimum-window-substring/#/discuss
 * 
 * @author Yan Kang
 *
 */
public class MinimumWindowSubstring_containsAllChars_H {
	public String minWindow(String s, String t) {
		if (s == null || s.length() == 0)
			return "";
		
		if (t == null || t.length() == 0)
			return s;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) - 1);
		}

		int LEFT = -1, RIGHT = -1;
		int l = 0, r = 0, track = -t.length();
		char[] chars = s.toCharArray();
		int min = chars.length + 1;
		while (r < chars.length) {
			char c1 = chars[r++];
			if (map.containsKey(c1)) {
				int count = map.get(c1);
				if (count < 0)
					track++;
				map.put(c1, count + 1);
			}
			
			while(track == 0) {

				if (r - l < min) {
					min = r - l;
					LEFT = l;
					RIGHT = r;
				}
				
				char c = chars[l++];
				if (map.containsKey(c)) {
					int count = map.get(c);
					if (count == 0)
						track--;
					map.put(c, count - 1);
				}
				
			}
		}
		return min == chars.length + 1 ? "" : s.substring(LEFT, RIGHT);
	}
	
	public static void main(String[] args) {
		MinimumWindowSubstring_containsAllChars_H c = new MinimumWindowSubstring_containsAllChars_H();
		String s = "zqyvbfeiee";
		String t = "ze";
		System.out.println(c.minWindow(s, t)); // zqyvbfe
		
		String s2 = "ADOBECODEBANC";
		String t2 = "ABC";
		System.out.println(c.minWindow(s2, t2)); // BANC
		
		String s3 = "abcdefghi";
		String t3 = "";
		System.out.println(c.minWindow(s3, t3)); // abcdefghi
		
		String s4 = "a";
		String t4 = "aa";
		System.out.println(c.minWindow(s4, t4)); // empty
		
		String s5 = "aa";
		String t5 = "aa";
		System.out.println(c.minWindow(s5, t5)); // aa
	}
}
