package kang.interview.programming.invariant;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @see Leetcode
 * @author Yan Kang
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.isEmpty()) return 0;

		Set<Character> set = new HashSet<>();
		char[] chars = s.toCharArray();
		int max = 0;
		int r = 0;
		int l = 0;
		while (r < chars.length) {
			char c = chars[r];
			if (set.contains(c)) {
				while (chars[l] != c) {
					set.remove(chars[l]);
					l++;
				}

				// Here is when chars[l] == c and c is current visiting
				// character. We need to remove the old character char[l] and
				// add the current one which is c. The end effect is that we
				// remove nothing and add nothing since they are canceled off.

				// increase the l index to skip the duplicate character
				l++;

			} else {
				set.add(c);
				max = Math.max(max, set.size());
			}
			r++;
		}
		return max;
	}
	
	public static void main(String[] args){
		String str1 = "aab";
		String str2 = "abcabcbb";
		String str3 = "pwwkew";
		
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring(str1));
		System.out.println(l.lengthOfLongestSubstring(str2));
		System.out.println(l.lengthOfLongestSubstring(str3));
	}
}
