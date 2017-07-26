package kang.interview.programming.string.parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * LeetCode 20. Valid Parentheses:
 * https://leetcode.com/problems/valid-parentheses/#/description
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * 
 * @author Yan Kang
 *
 */
public class ValidParentheses {
    public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '('); map.put(']', '['); map.put('}', '{');

		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				if(stack.isEmpty()) return false;
				if(map.get(chars[i]) != stack.pop()) return false;
			} else 
				stack.push(chars[i]);
		}
		return stack.isEmpty() ? true : false;
	}
    
	/**
	 * TODO: understand this
	 * 
	 * @param s
	 * @return
	 */
	public boolean isValid_(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}
