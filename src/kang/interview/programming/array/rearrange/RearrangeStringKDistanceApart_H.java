package kang.interview.programming.array.rearrange;

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
	
	private int[] t;

	/**
	 * Recursive + backtracking. This algorithm is correct but not efficient.
	 * 
	 * @param s
	 * @param k
	 * @return
	 */
	public String rearrangeString_(String s, int k) {
		if (s == null || s.length() == 0)
			return "";
		
		char[] tasks = s.toCharArray();
		t = new int[tasks.length];
		StringBuilder sb = new StringBuilder();
		boolean found = compute(tasks, k, sb);
		return found ? sb.toString() : "";
	}

	private boolean compute(char[] tasks, int k, StringBuilder sb) {
		if (sb.length() == tasks.length)
			return true;

		for (int i = 0; i < tasks.length; i++) {
			if (t[i] == 0 && isValid(sb.toString().toCharArray(), tasks[i], k)) {
				sb.append(tasks[i]);
				t[i] = 1;
				boolean found = compute(tasks, k, sb);
				if (found) {
					return true;
				}
				sb.setLength(sb.length() - 1);
				t[i] = 0;
			}
		}
		return false;
	}

	private boolean isValid(char[] chars, char e, int k) {
		int l = chars.length - k + 1 >= 0 ? chars.length - k + 1 : 0;
		for (int r = chars.length - 1; r >= l; r--) {
			if (e == chars[r])
				return false;
		}
		return true;
	}
	
	/**
	 * 
	 * From LeetCode: greedy algorithm
	 * 
	 * Every time we want to find the best candidate: which is the character
	 * with the largest remaining count. Thus we will be having two arrays.
	 * <ul>
	 * <li>One array is to store the remaining count of every character.</li>
	 * <li>Another array is to keep track of the most left position that one
	 * character can appear.</li>
	 * </ul>
	 * We will iterated through these two array to find the best candidate for
	 * every position. Since the array is fixed size, it will take constant time
	 * to do this. After we find the candidate, we update two arrays.
	 * 
	 * @param str
	 * @param k
	 * @return
	 */
	public String rearrangeString(String str, int k) {
		int length = str.length();
		int[] count = new int[26];
		int[] valid = new int[26];
		for (int i = 0; i < length; i++) {
			count[str.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < length; index++) {
			int candidatePos = findValidMax(count, valid, index);
			if (candidatePos == -1)
				return "";
			count[candidatePos]--;
			valid[candidatePos] = index + k;
			sb.append((char) ('a' + candidatePos));
		}
		return sb.toString();
	}

	private int findValidMax(int[] count, int[] valid, int index) {
		int max = Integer.MIN_VALUE;
		int candidatePos = -1;
		for (int i = 0; i < count.length; i++) {
			
			// How to make sense of choose the character with max number of count 
			if (count[i] > 0 && count[i] > max && index >= valid[i]) {
				max = count[i];
				candidatePos = i;
			}
		}
		return candidatePos;
	}
	
	public static void main(String[] args) {
		RearrangeStringKDistanceApart_H alg = new RearrangeStringKDistanceApart_H();
		String str = "aabbcc";
//		DataPrinter.println(alg.compute(str.toCharArray(), 3));
		String str2 = "aaabc";
		String str3 = "aaadbbcc";
		String str4 = "bbabcaccaaabababbaaaaccbbcbacbacacccbbcaabcbcacaacc";
//		DataPrinter.println(alg.rearrangeString(str, 3));
//		DataPrinter.println(alg.rearrangeString(str2, 3));
//		DataPrinter.println(alg.rearrangeString(str3, 2));
//		DataPrinter.println(alg.rearrangeString(null, 2));
		
		DataPrinter.println(alg.rearrangeString(str4, 3));
	}

}
