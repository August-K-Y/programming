package kang.interview.programming.string;

/**
 * LeetCode: 38. Count and Say: https://leetcode.com/problems/count-and-say/description/
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
	
	1.     1
	2.     11
	3.     21
	4.     1211
	5.     111221
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth term of the count-and-say sequence.
	
	Note: Each term of the sequence of integers will be represented as a string.
	
	Example 1:
	
	Input: 1
	Output: "1"
	Example 2:
	
	Input: 4
	Output: "1211"

 * @author Yan Kang
 *
 */
public class LookAndSay_M {

	public String countAndSay(int n) {
		if (n == 0) return "";
		if (n == 1) return "1";

		String str = "1";
		for (int i = 2; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j) == str.charAt(j - 1)) {
					count++;
				} else {
					sb.append(count);
					sb.append(str.charAt(j - 1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(str.charAt(str.length() - 1));

			str = sb.toString();
		}
		return str;
	}
    
	/**
	 * e.g., 1, 11, 21, 1211, 111221,312211,13112221,1113213211
	 * 
	 * @param val
	 * @return
	 */
	public String lookAndSayRecursively(int val) {
		if (val <= 0)
			return "";
		char[] chars = "1".toCharArray();
		return doWork(chars, val - 1);
	}

	private String doWork(char[] chars, int nth) {
		if (nth == 0) {
			return new String(chars);
		} 
		
		String v = null;
		if (chars.length == 1) {
			// corner case: only one digit
			v = "1" + chars[0];
		} else {
			int count = 1;
			char prev = chars[0];
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < chars.length; i++) {
				if (chars[i] == prev) {
					count++;
					prev = chars[i];
				} else {
					// Change Point : when number changed
					sb.append(count).append(prev);
					count = 1;
					prev = chars[i];
				}
			}
			// corner case: the last group of digit
			sb.append(count).append(prev);
			v = sb.toString();
		}

		return doWork(v.toCharArray(), nth - 1);
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		LookAndSay_M ora = new LookAndSay_M();
		String end = ora.lookAndSayRecursively(1);
		System.out.println(end);
		end = ora.lookAndSayRecursively(8);
		System.out.println(end);
		end = ora.lookAndSayRecursively(12);
		System.out.println(end);
	}
}
