package kang.interview.programming.string.calculator;

import java.util.Stack;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "1 + 1" = 2
 * 
 * " 2-1 + 2 " = 3
 * 
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 
 * 
 */
public class BasicCalculator_II {
	public int calculate(String s) {

		Stack<String> stack = new Stack<>();
		char[] chars = s.toCharArray();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (Character.isWhitespace(c)) {
				continue;
			} else if (Character.isDigit(c)) {
				sb.append(c);
			} else{ 
				String str = sb.toString();
				if (!str.isEmpty())
					stack.push(sb.toString());
				sb.setLength(0);
				
				if (c == ')') {
					
					int sum = calcuateSum(stack);
					
					stack.push(String.valueOf(sum));

				} else {
					stack.push(Character.toString(c));
				}
			}
		}
		
		String str = sb.toString();
		if (!str.isEmpty())
			stack.push(sb.toString());
		sb.setLength(0);
		
		return calcuateSum(stack);

	}

	private int calcuateSum(Stack<String> stack) {
		int num = 0;
		int sum = 0;
		while (!stack.isEmpty()) {
			String top = stack.pop();
			if (top.equals("(")) {
				break;
			} else if (top.equals("+")) {
				sum += num;
			} else if (top.equals("-")) {
				num *= -1;
				sum += num;
			} else {
				num = Integer.parseInt(top);
			}
		}
		sum += num;
		return sum;
	}

	public static void main(String[] args) {
		String str1 = "1 + 1";
		String str2 = " 2-1 + 2 ";
		String str3 = "(1+(4+5+2)-3)+(6+8)";

		BasicCalculator_II alg = new BasicCalculator_II();
		DataPrinter.println(alg.calculate(str1)); // 2
		DataPrinter.println(alg.calculate(str2)); // 3
		DataPrinter.println(alg.calculate(str3)); // 23
	}
}
