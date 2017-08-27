package kang.interview.programming.recursive.dynamicprogramming.wordforming;

/**
 * 639. Decode Ways II: https://leetcode.com/problems/decode-ways-ii/#/description
 * 
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping way:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Beyond that, now the encoded string can also
 * contain the character '*', which can be treated as one of the numbers from 1
 * to 9.
 * 
 * Given the encoded message containing digits and the character '*', return the
 * total number of ways to decode it.
 * 
 * Also, since the answer may be very large, you should return the output mod
 * 109 + 7.
 * 
 * Example 1:
 * 
 * Input: "*"
 * 
 * Output: 9
 * 
 * Explanation: The encoded message can be decoded to the string: "A", "B", "C",
 * "D", "E", "F", "G", "H", "I".
 * 
 * Example 2:
 * 
 * Input: "1*"
 * 
 * Output: 9 + 9 = 18
 * 
 * Note: 
 * 1. The length of the input string will fit in range [1, 105]. 
 * 2. The input string will only contain the character '*' and digits '0' - '9'.
 * 
 * @author yankang
 *
 */
public class MapDecoding_LeetCode_II_HH {
	   private final int MOD = 1000000007;

	/**
	 * 
	 * @param s
	 * @return
	 */
	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;

		char[] chars = s.toCharArray();
		long[] dp = new long[s.length()];

		dp[0] = ways(chars[0]);
		for (int i = 1; i < dp.length; i++) {
			int ways = ways(chars[i - 1], chars[i]);
			dp[i] = (i - 2) >= 0 ? dp[i - 2] * ways : ways;
			dp[i] = (dp[i] + dp[i - 1] * ways(chars[i])) % MOD;
		}
		return (int) dp[s.length() - 1];
	}

	private int ways(char c) {
		if (c == '*')
			return 9;
		if (c == '0')
			return 0;
		return 1;
	}

	private int ways(char prev, char curr) {
		int x = prev - '0';
		int y = curr - '0';
		int v = x * 10 + y;

		if (prev == '*' && curr == '*') {
			// both prev and curr are '*', there are totally 15 ways: 
			// the prev can only be 1 or 2; 
			// when prev is 1, the curr can only be 1 ... 9;
			// when prev is 2, the curr can be 1 ... 6
			// prev can be both 1 and 2, therefore there are totally 15 ways
			return 15;
		} else if (curr == '*') {

			// the prev (fixed) char representing a number and only one number.
			// prev can be 1 or 2 or others, and only 1 and 2 are valid.
			// when prev is 1, the curr can have 9 ways: 1 ... 9;
			// when prev is 2, the curr can have 6 ways: 1 ... 6
			if (x == 1) {
				return 9;
			} else if (x == 2) {
				return 6;
			}

		} else if (prev == '*') {
            // the curr (fixed) char representing a number and only one number.
			// prev have 2 ways if curr >= 0 and curr<=6;
			// prev can have only 1 way if curr>6
			if (y >= 0 && y <= 6) {
				return 2;
			} else {
				return 1;
			}

		} else {
			// both prev and curr representing number, see v, and thus both of them are fixed
			// when v >= 10 and v<=26, the number is valid (i.e., can be decoded)
			if (v >= 10 & v <= 26) {
				return 1;
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public int numDecodings_(String s) {
		if (s == null || s.length() == 0)
			return 0;

		char[] chars = s.toCharArray();
		long[] dp = new long[s.length()];

		dp[0] = chars[0] == '0' ? 0 : chars[0] == '*' ? 9 : 1;
		for (int i = 1; i < dp.length; i++) {
			int x = chars[i - 1] - '0';
			int y = chars[i] - '0';
			int v = x * 10 + y;

			if (chars[i] == '*' && chars[i - 1] == '*') {
				dp[i] = ((i - 2) >= 0 ? dp[i - 2] * 15 : 15);
				dp[i] = (dp[i] + dp[i - 1] * 9) % MOD;
			} else if (chars[i] == '*') {
				if (x == 1) {
					dp[i] = ((i - 2) >= 0 ? dp[i - 2] * 9 : 9);
				} else if (x == 2) {
					dp[i] = ((i - 2) >= 0 ? dp[i - 2] * 6 : 6);
				}
				dp[i] = (dp[i] + dp[i - 1] * 9) % MOD;
			} else if (chars[i - 1] == '*') {
				if (y >= 0 && y <= 6) {
					dp[i] = ((i - 2) >= 0 ? dp[i - 2] * 2 : 2);
				} else {
					dp[i] = ((i - 2) >= 0 ? dp[i - 2] : 1);
				}

				if (y >= 1 && y <= 9) {
					dp[i] = dp[i] + dp[i - 1];
				}
				dp[i] %= MOD;

			} else {

				if (v >= 10 & v <= 26) {
					dp[i] = ((i - 2) >= 0 ? dp[i - 2] : 1);
				}

				if (y >= 1 && y <= 9) {
					dp[i] = dp[i] + dp[i - 1];
				}
				dp[i] %= MOD;
			}
		}
		return (int) dp[s.length() - 1];
	}
}
