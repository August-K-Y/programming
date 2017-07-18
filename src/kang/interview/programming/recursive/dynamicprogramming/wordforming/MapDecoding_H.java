package kang.interview.programming.recursive.dynamicprogramming.wordforming;

import kang.interview.programming.util.DataPrinter;

/**
 * A top secret message containing uppercase letters from 'A' to 'Z' has been
 * encoded as numbers using the following mapping:
 * 
 * 'A' -> 1 
 * 'B' -> 2 ... 
 * 'Z' -> 26 
 * 
 * You are an FBI agent and you need to
 * determine the total number of ways that the message can be decoded.
 * 
 * Since the answer could be very large, take it modulo 10^9 + 7.
 * 
 * Example
 * 
 * For message = "123", the output should be
 * 
 * mapDecoding(message) = 3.
 * 
 * "123" can be decoded as "ABC" (1 2 3), "LC" (12 3) or "AW" (1 23), so the
 * total number of ways is 3.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java)
 * 
 * [input] string message
 * 
 * A string containing only digits.
 * 
 * Guaranteed constraints:
 * 
 * 		0 <= message.length <= 105.
 * 
 * [output] integer
 * 
 * The total number of ways to decode the given message.
 * 
 * @author Yan Kang
 *
 */
public class MapDecoding_H {
	
	/**
	 * 
	 * @param message
	 * @return
	 */
	int mapDecoding(String message) {
		if (message == null)
			return 0;
		
		// empty message is also considered as a secret message
		if (message.trim().length() == 0)
			return 1;

		char[] chars = message.toCharArray();
		int[] dp = new int[chars.length + 1];
		int d = (int) Math.pow(10, 9) + 7;
		dp[1] = chars[0] == '0' ? 0 : 1;
		for (int i = 2; i < chars.length + 1; i++) {
			int x = (chars[i - 2] - '0');
			int y = (chars[i - 1] - '0');
			int num = x * 10 + y;
			
			// '01' is not allowed
			if (num > 0 && num <= 26 && x > 0) {
				dp[i] = (((i - 2) == 0 ? 1 : dp[i - 2]));
			}
			if (y > 0 && y <= 9) {
				dp[i] = (dp[i] + dp[i - 1]) % d;
			}
		}
		return dp[chars.length];
	}
	public static void main(String[] args){
		MapDecoding_H alg = new MapDecoding_H();
		DataPrinter.println(alg.mapDecoding(""));
		DataPrinter.println(alg.mapDecoding("0"));
		DataPrinter.println(alg.mapDecoding("01"));
		DataPrinter.println(alg.mapDecoding("10"));
		DataPrinter.println(alg.mapDecoding("1"));
		DataPrinter.println(alg.mapDecoding("11"));
		DataPrinter.println(alg.mapDecoding("112"));
		DataPrinter.println(alg.mapDecoding("1123"));
		DataPrinter.println(alg.mapDecoding("1126"));
		DataPrinter.println(alg.mapDecoding("1128"));
	}
}
