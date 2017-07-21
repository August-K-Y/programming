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
public class MapDecoding_LeetCode_II_H {
	public int numDecodings(String s) {
		return 0;
	}
}
