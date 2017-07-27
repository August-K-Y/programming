package kang.interview.programming.string.parentheses;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 32. Longest Valid Parentheses:
 * https://leetcode.com/problems/longest-valid-parentheses/tabs/description
 * 
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author Yan Kang
 *
 */
public class LongestValidParentheses_H {
    public int longestValidParentheses(String s) {
    	if(s == null || s.length() == 0)
    		return 0;
    	
    	int l = 0, r =0;
    	int max = 0;
    	char[] chars = s.toCharArray();
    	while(r < chars.length) {
    		r++;
    		
    		int count = isValid(chars, l, r - 1);
    		if(count == 0) {
				System.out.println("here0");
			}
    		
			if (count < 0) {
				l = r;
			} else if (count > 0 && r == chars.length) {
				l++;
				while ((count = isValid(chars, l, r - 1)) > 0) {
					l++;
				}
			}
			
			if (count > 0) {
				System.out.println(l + ", " + r);
			}

			if(count == 0) {
				System.out.println("here");
    			max = Math.max(max, r - l);
			}
    		
    	}
    	return max;
    }
    
	private int isValid(char[] chars, int l, int r) {
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (chars[i] == '(') count++;
			if (chars[i] == ')' && count-- == 0) return count;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s1 = ")()())";
		String s2 = "(()";
		String s3 = ")(((((()())()()))()(()))(";
		
		LongestValidParentheses_H alg = new LongestValidParentheses_H();
//		DataPrinter.println(alg.longestValidParentheses_(s1));
//		DataPrinter.println(alg.longestValidParentheses_(s2));
//		DataPrinter.println(alg.longestValidParentheses_(s3));
		
//		DataPrinter.println(alg.isValid(s3.toCharArray(), 2, 23));
	}
}
