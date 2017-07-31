package kang.interview.programming.string;

/**
 * 
 * LeetCode 161. One Edit Distance:
 * https://leetcode.com/problems/one-edit-distance/description/
 * 
 * 
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 * 
 * @author Yan Kang
 *
 */
public class EditDistance_I {
	public boolean isOneEditDistance(String s, String t) {

		if (s.length() == t.length()) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) count++;
			}
			return count == 1;
		} else {
			if (t.length() > s.length()) {
				String temp = t; t = s; s = temp;
			}

			for (int i = 0; i < s.length(); i++) {
				String ss = s.substring(0, i) + s.substring(i + 1);
				if (ss.equals(t)) return true;
			}
			return false;
		}
	}
}
