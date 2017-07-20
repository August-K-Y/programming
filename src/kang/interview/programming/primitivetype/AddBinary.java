package kang.interview.programming.primitivetype;

/**
 * LeetCode 67. Add Binary:https://leetcode.com/problems/add-binary/#/description Given two
 * 
 * binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author Yan Kang
 *
 */
public class AddBinary {
	
	public String addBinary(String num1, String num2) {
		int l1 = num1.length() - 1;
		int l2 = num2.length() - 1;

		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (l1 >= 0 || l2 >= 0) {

			int sum = carry;
			if (l1 >= 0) {
				sum += num1.charAt(l1) - '0';
				l1--;
			}

			if (l2 >= 0) {
				sum += num2.charAt(l2) - '0';
				l2--;
			}

			int res = sum % 2;
			carry = sum / 2;
			sb.append(res);
		}
		if (carry > 0)
			sb.append(carry);

		return sb.reverse().toString();
	}
}
