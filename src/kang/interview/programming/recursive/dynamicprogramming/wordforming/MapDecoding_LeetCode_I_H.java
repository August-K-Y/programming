package kang.interview.programming.recursive.dynamicprogramming.wordforming;

import kang.interview.programming.util.DataPrinter;

/**
 * 91. Decode Ways: 
 * https://leetcode.com/problems/decode-ways/#/description
 * 
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of
 * ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author yankang
 *
 */
public class MapDecoding_LeetCode_I_H {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		char[] chars = s.toCharArray();

		// dp[i] indicates the number of ways to decode substring chars[0...i];
		int[] dp = new int[s.length()];

		dp[0] = chars[0] == '0' ? 0 : 1;

		for (int i = 1; i < dp.length; i++) {
			int x = chars[i - 1] - '0';
			int y = chars[i] - '0';
			int v = x * 10 + y;

			// Take chars[i-1] and chars[i] as whole where chars[i-1] can not be
			// '0', and calculate number of ways to decode char[0...i] based on
			// number of ways of decoding chars[0...i-2] (i.e., dp[i-2])
			if (v >= 10 & v <= 26) {
				// when chars[i-1...i] represents valid number that can be
				// decoded
				dp[i] = ((i - 2) >= 0 ? dp[i - 2] : 1);
			}

			// Take only chars[i] and calculate number of ways to decode
			// chars[0...i] based on number of ways of decoding chars[0...i-1]
			// (i.e., dp[i-1])
			if (y >= 1 && y <= 9) {
				// when chars[i] represents valid number that can be decoded
				dp[i] += dp[i - 1];
			}
		}
		return dp[dp.length - 1];
	}
	
	public static void main(String[] args) {
		MapDecoding_LeetCode_I_H alg = new MapDecoding_LeetCode_I_H();
		DataPrinter.println(alg.numDecodings(""));
		DataPrinter.println(alg.numDecodings("0"));
		DataPrinter.println(alg.numDecodings("01"));
		DataPrinter.println(alg.numDecodings("10"));
		DataPrinter.println(alg.numDecodings("1"));
		DataPrinter.println(alg.numDecodings("11"));
		DataPrinter.println(alg.numDecodings("112"));
		DataPrinter.println(alg.numDecodings("1123"));
		DataPrinter.println(alg.numDecodings("1126"));
		DataPrinter.println(alg.numDecodings("1128"));
		
		DataPrinter.println(alg.numDecodings("26"));
	}
}
