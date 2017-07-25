package kang.interview.programming.optimization;

import java.util.HashMap;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

public class LongestSubstringWithAtMost2RepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
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
			
//			System.out.println("distinct: " + distinct);
			while (distinct > 2) {
				char c2 = chars[l++];
				if (map.get(c2) == 1) {
					distinct--;
				}
				map.put(c2, map.get(c2) - 1);
			}
//			System.out.println("new distinct: " + distinct);
//			System.out.println(l + ", " + r);
			max = Math.max(max, r - l);
			
			
//			System.out.println("-----------------------");
		}
		return max;
	}
	
	public static void main(String[] args) {
		LongestSubstringWithAtMost2RepeatingCharacters alg = new LongestSubstringWithAtMost2RepeatingCharacters();

		String s = "eceba";
		DataPrinter.println(alg.lengthOfLongestSubstring(s)); //3
		
		String s2 = "abcabcabc";
		DataPrinter.println(alg.lengthOfLongestSubstring(s2)); //2
		
		String s3 = "abaccc";
		DataPrinter.println(alg.lengthOfLongestSubstring(s3)); //4
	}
}
