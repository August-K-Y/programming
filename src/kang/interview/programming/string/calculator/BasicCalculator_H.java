package kang.interview.programming.string.calculator;

import kang.interview.programming.util.DataPrinter;

/**
 * leetCode 227. Basic Calculator II:
 * https://leetcode.com/problems/basic-calculator-ii/#/description
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * 
 * "3+2*2" = 7
 * 
 * " 3/2 " = 1
 * 
 * " 3+5 / 2 " = 5
 * 
 * Note: Do not use the eval built-in library function.
 * 
 * @author Yan Kang
 *
 */
public class BasicCalculator_H {
    public int calculate(String s) {
    	if(s == null || s.isEmpty())
    		return 0;

    	int ac = 0;
		char[] tokens = s.toCharArray();
		int n = 0;

		int hold = 0;
		char rev = '#';
		for (int i = 0; i < tokens.length + 1; i++) {
			char c = i < tokens.length ? tokens[i] : '#';
			if (Character.isWhitespace(c)) {
				continue;
			} else if (Character.isDigit(c)) {
				n = n * 10 + tokens[i] - '0';
			} else {

				if (rev == '#') {
					hold = n;
				}
				if (rev == '+') {
					ac += hold;
					hold = n;
				}
				if (rev == '-') {
					ac += hold;
					hold = -n;
				}
				if (rev == '*') {
					hold *= n;
				}
				if (rev == '/') {
					hold /= n;
				}
				rev = c;
				n = 0;
			}
		}
		return ac + hold;
    }
    
    public static void main(String[] args) {
    	String str1 = "3+2*2";
    	String str2 = " 3/2 ";
    	String str3 = " 3+5 / 2 ";
    	
    	BasicCalculator_H alg = new BasicCalculator_H();
    	DataPrinter.println(alg.calculate(str1)); // 7
    	DataPrinter.println(alg.calculate(str2)); // 1
    	DataPrinter.println(alg.calculate(str3)); // 5
    }
}
