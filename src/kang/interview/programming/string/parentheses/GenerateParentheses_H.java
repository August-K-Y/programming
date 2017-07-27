package kang.interview.programming.string.parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 22. Generate Parentheses:
 * https://leetcode.com/problems/generate-parentheses/#/description
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

	For example, given n = 3, a solution set is:
	
	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]


 * @author yankang
 *
 */
public class GenerateParentheses_H {

	/**
	 * From LeetCode, very brilliant solution
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		backtrack(list, "", 0, 0, n);
		return list;
	}

	public void backtrack(List<String> list, String str, int open, int close, int max) {

		if (str.length() == max * 2) {
			list.add(str);
			return;
		}

		/**
		 * Are solutions found valid?
		 * The number of open parenthese is bounded by the input n;
		 * The number of close parenthese is bounded the number of open parenthese.
		 * Therefore the solutions, if any, are guaranteed to be valid.
		 * 
		 * Can all solutions be found?
		 * The next question is that this approach can find all solutions:
		 * 
		 * 
		 */
		if (open < max)
			backtrack(list, str + "(", open + 1, close, max);
		if (close < open)
			backtrack(list, str + ")", open, close + 1, max);
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis_(int n) {

		Set<String> set0 = new LinkedHashSet<>();
		set0.add("");
		mem.put(0, set0);
		return new ArrayList<>(generate(n));
	}

	private Set<String> generate(int len) {
		if (mem.containsKey(len))
			return mem.get(len);

		Set<String> set = new LinkedHashSet<>();
		for (int i = 1; i < len; i++) {
			Set<String> res1 = generate(i);
			Set<String> res2 = generate(len - i);

			Set<String> res = combine(res1, res2, len);
			set.addAll(res);
		}

		Set<String> set2 = mem.get(len - 1);
		for (String s : set2) {
			set.add("(" + s + ")");
		}

		mem.put(len, set);
		return set;
	}

	private Set<String> combine(Set<String> res1, Set<String> res2, int len) {
		Set<String> result = new LinkedHashSet<>();
		for (String r1 : res1) {
			for (String r2 : res2) {
				result.add(r1 + r2);
			}
		}
		return result;
	}
	
	private Map<Integer, Set<String>> mem = new HashMap<>();

	public static void main(String[] arg) {
		GenerateParentheses_H alg = new GenerateParentheses_H();
		DataPrinter.printList(alg.generateParenthesis(4));
	}
}
