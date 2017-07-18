package kang.interview.programming.recursive.backtracking;

import java.util.LinkedList;

import kang.interview.programming.array.MinimalTimeScheduler_M;
import kang.interview.programming.array.RearrangeArrayInAlternatingPosNegNumber_M;
import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode : https://leetcode.com/problems/rearrange-string-k-distance-apart/
 * 
 * Given a string S, and an integer K, rearrange the string such that similar
 * characters are at least K distance apart.
 * 
 * Example:
 * 
 * S = AAABBBCC, K = 3 Result : ABCABCABC (all 'A's are 3 distance apart,
 * similarly with B's and C's)
 * 
 * S = AAABC, K=2 : Not possible. (EDIT : k=3 is not possible).
 * 
 * S = AAADBBCC, K = 3: Result: ABCABCDA
 * 
 * @see {@link RearrangeArrayInAlternatingPosNegNumber_M}
 * @see {@link MinimalTimeScheduler_M}
 * @see https://discuss.leetcode.com/topic/102/rearrange-string
 * @author Yan Kang
 */
public class RearrangeStringKDistanceApart_H {
	
	int[] t;
	public boolean compute(char[] tasks, int k) {

		t = new int[tasks.length];
		StringBuilder sb = new StringBuilder();
		boolean found = compute_(tasks, k, sb);
		
		DataPrinter.println(sb.toString());
		return found;

	}

	private boolean compute_(char[] tasks, int k, StringBuilder sb) {
		if (sb.length() == tasks.length)
			return true;

		for (int i = 0; i < tasks.length; i++) {
			if (t[i] == 0 && isValid(sb.toString().toCharArray(), tasks[i], k)) {
				sb.append(tasks[i]);
				t[i] = 1;
				boolean found = compute_(tasks, k, sb);
				if (found) {
					return true;
				}
				sb.setLength(sb.length() - 1);
				t[i] = 0;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param chars
	 * @param e
	 * @param k
	 * @return
	 */
	private boolean isValid(char[] chars, char e, int k) {
		int l = chars.length - k + 1>= 0 ? chars.length - k + 1 : 0;
		for (int r = chars.length - 1; r >= l; r--) {
			if (e == chars[r])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		RearrangeStringKDistanceApart_H alg = new RearrangeStringKDistanceApart_H();
		String str = "AAABBBCC";
//		DataPrinter.println(alg.compute(str.toCharArray(), 3));
		String str2 = "AAADBBCC";
		String str3 = "AAABC";
		DataPrinter.println(alg.compute(str.toCharArray(), 3));
		DataPrinter.println(alg.compute(str2.toCharArray(), 3));
		DataPrinter.println(alg.compute(str3.toCharArray(), 3));
	}

}
