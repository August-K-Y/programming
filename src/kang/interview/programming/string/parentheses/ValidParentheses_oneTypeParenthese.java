package kang.interview.programming.string.parentheses;

import kang.interview.programming.util.DataPrinter;

/**
 * A string is a valid parentheses of one type, it must satisfy:
 * 
 * <blockquote> Every open parenthesis must have a distinct close parenthesis
 * appearing later to pair with, and every close parenthesis must have a
 * distinct open parenthesis appearing earlier to pair with. </blockquote>
 * 
 * Put it another way. what makes the string a invalid parentheses:
 * 
 * <blockquote>Anyone of the open parenthesis has no matching close parenthesis
 * appearing later or anyone of the close parenthesis has no matching open
 * parenthesis appearing earlier.</blockquote>
 * 
 * The <em>distinct</em> means two parentheses have different position in the
 * string
 */
public class ValidParentheses_oneTypeParenthese {

	public boolean isValid(String s) {
		
		// NOTE: when the input string is empty, this function will return true.
		
		char[] chars = s.toCharArray();
		int count = 0;
		/*
		 * The counter will increase when it is ‘(‘ and decrease when it is ‘)’.
		 * Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the
		 * prefix.
		 */
		for (char c : chars) {
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}
		
		// all ( and ) should be matched as pair
		return count == 0;
	}
	
	public static void main(String[] args) {
		ValidParentheses_oneTypeParenthese alg = new ValidParentheses_oneTypeParenthese();
		DataPrinter.println(alg.isValid("()())()")); // false
		DataPrinter.println(alg.isValid("()()()")); // true
	}
}
