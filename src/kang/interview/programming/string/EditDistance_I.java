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
	
	/**
	 * There're 3 possibilities to satisfy one edit distance apart: 
	 * 
	 * 1) Replace 1 char:
	 	  s: a B c
	 	  t: a D c
	 * 2) Delete 1 char from s: 
		  s: a D  b c
		  t: a    b c
	 * 3) Delete 1 char from t
		  s: a   b c
		  t: a D b c
	 **/
	
	public boolean isOneEditDistance(String s, String t) {

		if (s.length() == t.length()) {
			// if the length is equal, check whether only one position is
			// different
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i))
					count++;
			}
			return count == 1;
		} else {
			if (t.length() > s.length()) {
				String temp = t; t = s; s = temp;
			}

			// check if there exists s's substring with one less length equals t
			for (int i = 0; i < s.length(); i++) {
				String ss = s.substring(0, i) + s.substring(i + 1);
				if (ss.equals(t))
					return true;
			}
			return false;
		}
	}
	
	public boolean isOneEditDistance_(String s, String t) {
	    for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
	    	if (s.charAt(i) != t.charAt(i)) {
	    		if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
	    			return s.substring(i + 1).equals(t.substring(i + 1));
				else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
					return s.substring(i).equals(t.substring(i + 1));	        	
				else // s is longer than t, so the only possibility is deleting one char from s
					return t.substring(i).equals(s.substring(i + 1));
	    	}
	    }       
	    //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
	    return Math.abs(s.length() - t.length()) == 1;        
	}
}
