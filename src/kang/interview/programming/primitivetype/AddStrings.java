package kang.interview.programming.primitivetype;

/**
 * leetCode 415. Add Strings:
 * https://leetcode.com/problems/add-strings/#/description
 * 
 * Given two non-negative integers num1 and num2 represented as string, return
 * the sum of num1 and num2.
 * 
 * Note:
 * 
 * <ol>
 * <li>The length of both num1 and num2 is < 5100.
 * <li>
 * <li>Both num1 and num2 contains only digits 0-9.
 * <li>
 * <li>Both num1 and num2 does not contain any leading zero.
 * <li>
 * <li>You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.
 * <li>
 * </ol>
 * 
 * @author Yan Kang
 *
 */
public class AddStrings {
	public String addStrings(String num1, String num2) {
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

			int res = sum % 10;
			carry = sum / 10;
			sb.append(res);
		}
		if (carry > 0)
			sb.append(carry);

		return sb.reverse().toString();
	}
}
