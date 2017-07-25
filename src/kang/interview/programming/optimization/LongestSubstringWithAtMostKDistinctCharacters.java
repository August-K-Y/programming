package kang.interview.programming.optimization;

import java.util.HashMap;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * 
 * Given a string, find the length of the longest substring T that contains at
 * most k distinct characters.
 * 
 * For example, Given s = “eceba” and k = 2,
 * 
 * T is "ece" which its length is 3.
 * 
 * 
 * @author Yan Kang
 *
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.isEmpty())
			return 0;

		Map<Character, Integer> map = new HashMap<>();

		int l = 0, r = 0;
		int max = 0;
		char[] chars = s.toCharArray();
		int distinct = 0;
		while (r < chars.length) {
			char c = chars[r++];
			
			if (map.get(c) == null || map.get(c) == 0) {
				distinct++;
			}
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			while (distinct > k) {
				char c2 = chars[l++];
				if (map.get(c2) == 1) {
					distinct--;
				}
				map.put(c2, map.get(c2) - 1);
			}
			max = Math.max(max, r - l);
		}
		return max; 
    }
    
	public static void main(String[] args) {
		LongestSubstringWithAtMostKDistinctCharacters alg = new LongestSubstringWithAtMostKDistinctCharacters();

		String s = "eceba";
		DataPrinter.println(alg.lengthOfLongestSubstringKDistinct(s, 2)); //3
		
		String s2 = "abcabcabc";
		DataPrinter.println(alg.lengthOfLongestSubstringKDistinct(s2, 2)); //2
		
		String s3 = "abaccc";
		DataPrinter.println(alg.lengthOfLongestSubstringKDistinct(s3, 2)); //4
	}
}
