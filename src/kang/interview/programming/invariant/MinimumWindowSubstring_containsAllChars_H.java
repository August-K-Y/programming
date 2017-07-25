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

	/*
	 * For most substring (consecutive subarray) problem, we are given a string
	 * and need to find a substring of it which satisfies some constraits. A
	 * general way is to use a hashmap assisted with two pointers and two nested
	 * loops (normally while loop since you can control move the pointers more freely).
	 * 
	 * One loop: searching for the optimal result (longest/minimal
	 * substring/subarray) while the constraints are satisfied until constraints
	 * are violated
	 * 
	 * Another loop: re-satisfy constraints the while constraints violated.
	 * 
	 * Normally the outer loop tries to enlarge the substring while the inner
	 * loop tries to shrink the substring. However they have opposite purpose
	 * when they in maximization and minimization problem respectively.
	 * 
	 * Maximize (substring)
	 * 
	 * constraint 1 <= v_1
	 * constraint 2 <= v_2
	 *       .
	 * constraint 3 <= v_3
	 * (The <= does not necessarily mean less than or equal to, it means certain upper bounds)
	 * 
	 * To solve maximization problem, normally what we would do is:
	 * (1) We enlarge the substring in the outer loop while keep recording the (sub-)optimal 
	 * solutions until one of the constraints are violated. 
	 * (2) Then we try to resatisfy all the constrains by shrinking the substring in the inner loop. 
	 * When all constraints are just satisfied, we go back to step (1)
	 * 
	 * Minimize (substring)
	 * 
	 * constraint 1 >= v_1
	 * constraint 2 >= v_2
	 *       .
	 * constraint 3 >= v_3
	 * (The >= does not necessarily mean larger than or equal to, it means certain lower bounds)
	 * 
	 * To solve minimization problem, normally what we would do is:
	 * (1) We enlarge the substring in the outer loop until all constraints are just satisfied. 
	 * (2) Then we search for (sub-)optimal solutions by shrinking the substring in the inner loop 
	 * until one of the constraint is violated. Then we go back to step (1)
	 * 
	 * Then the core/hard part left is:
	 * Find a way to track whether constraints are satisfied/violated while enlarging/shrinking 
	 * the two loops by using certain searching data structure such as hash map/set.
	 * 
	 * 
	 * 
	 * One thing needs to be mentioned is that when asked to find maximum substring, we should 
	 * update maximum after the inner while loop to guarantee that the substring is valid. On 
	 * the other hand, when asked to find minimum substring, we should update minimum inside 
	 * the inner while loop.
	 * 
	 * The template is given below.
	 */
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
