package kang.interview.programming.primitivetype;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 43. Multiply Strings:
 * https://leetcode.com/problems/multiply-strings/#/description
 * 
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * <ol>
 * <li>The length of both num1 and num2 is < 110.</li>
 * <li>Both num1 and num2 contains only digits 0-9.</li>
 * <li>Both num1 and num2 does not contain any leading zero.</li>
 * <li>You must not use any built-in BigInteger library or convert the inputs to
 * integer directly.</li>
 * </ol>
 * 
 * @author Yan Kang
 *
 */
public class MutiplyString_H {
	
	public String multiply(String num1, String num2) {
		
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		
		List<String> nums = new ArrayList<>();
		StringBuilder sb = null;
		for (int i = num1.length() - 1; i >= 0; i--) {
			sb = multiple(num2, num1.charAt(i));
			sb.reverse();
			int j = num1.length() - 1 - i;
			while (j-- > 0) {
				sb.append(0);
			}
			System.out.println(num1.charAt(i) + " * " + num2 + " = " + sb.toString());
			nums.add(sb.toString());
		}
		
		String sum = nums.get(0);
		for (int i = 1; i < nums.size(); i++) {
			sum = add(sum, nums.get(i));
		}
		return sum;
	}

	private StringBuilder multiple(String num, char c) {
		StringBuilder sb = new StringBuilder();
		int i = num.length() - 1;
		int carry = 0;
		while (i >= 0) {
			int sum = carry + (c - '0') * (num.charAt(i) - '0');
			int res = sum % 10;
			carry = sum / 10;
			sb.append(res);
			i--;
		}
		if(carry > 0)
			sb.append(carry);
		return sb;
	}

	/**
	 * Add two strings
	 * 
	 * @param num1
	 *            string representation of number 1
	 * @param num2
	 *            string representation of number 2
	 * @return string representation of sum of the two numbers
	 */
	private String add(String num1, String num2) {
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
		if(carry > 0)
			sb.append(carry);
		
		return sb.reverse().toString();
	}
	
	/**
	 * https://leetcode.com/problems/multiply-strings/#/discuss
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply_(String num1, String num2) {
		int m = num1.length(), n = num2.length();
		int[] pos = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int p1 = i + j, p2 = i + j + 1;
				int sum = mul + pos[p2];

				pos[p1] += sum / 10;
				pos[p2] = (sum) % 10;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int p : pos)
			if (!(sb.length() == 0 && p == 0))
				sb.append(p);
		return sb.length() == 0 ? "0" : sb.toString();
	}
	
	
	public static void main(String[] args) {
		MutiplyString_H alg = new MutiplyString_H();
		
		String num1 = "123";
		String num2 = "123";
		
		DataPrinter.println(alg.multiply(num1, num2));
	}
	
}
