package kang.interview.programming.string.parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 301. Remove Invalid Parentheses:
 * https://leetcode.com/problems/remove-invalid-parentheses/#/description
 * 
 * Remove the minimum number of invalid parentheses in order to make the input
 * string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and
 * ).
 * 
 * Examples:
 * 
 * "()())()" -> ["()()()", "(())()"]
 * 
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * 
 * ")(" -> [""]
 * 
 * @author Yan Kang
 *
 */
public class RemoveInvalidParenthese {
	
	/**
	 * Solution from LeetCode
	 * https://discuss.leetcode.com/topic/28827/share-my-java-bfs-solution
	 * 
	 * @param s
	 * @return
	 */
	public List<String> removeInvalidParentheses_BFS(String s) {
		List<String> result = new ArrayList<>();

		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.add(s);
		
		boolean found = false;
		String top = null;
		while (!q.isEmpty()) {
			top = q.poll();

			if (isValid(top)) {
				result.add(top);
				found = true;
			}

			if (found)
				continue;

			for (int i = 0; i < s.length(); i++) {

				if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

				String str = s.substring(0, i) + s.substring(i + 1);

				if (!visited.contains(str)) {
					visited.add(str);
					q.add(str);
				}
			}
		}
		return result;
	}

	boolean isValid(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				count++;
			if (c == ')' && count-- == 0)
				return false;
		}

		return count == 0;
	}
	
	
	/**
	 * From LeetCode:
	 * https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution Not very easy to understand
	 * 
	 * TODO: understand this.
	 * 
	 * 
	 * @param s
	 * @return
	 */
	public List<String> removeInvalidParentheses_DFS(String s) {
		List<String> ans = new ArrayList<>();
		remove(s, ans, 0, 0, new char[] { '(', ')' });
		return ans;
	}

	public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
		for (int stack = 0, i = last_i; i < s.length(); ++i) {
			if (s.charAt(i) == par[0]) stack++;
			if (s.charAt(i) == par[1]) stack--;
			if (stack >= 0) continue;
			for (int j = last_j; j <= i; ++j)
				if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
					remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (par[0] == '(') // finished left to right
			remove(reversed, ans, 0, 0, new char[] { ')', '(' });
		else // finished right to left
			ans.add(reversed);
	}
	
	public static void main(String[] args){
		RemoveInvalidParenthese alg = new RemoveInvalidParenthese();
		DataPrinter.printList(alg.removeInvalidParentheses_BFS("()())()"));
	}
}
