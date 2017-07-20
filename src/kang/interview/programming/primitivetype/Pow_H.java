package kang.interview.programming.primitivetype;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 50. Pow(x, n): https://leetcode.com/problems/powx-n/#/description
 * 
 * Implement pow(x, n).
 * 
 * @author Yan Kang
 *
 */
public class Pow_H {

	double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
	
	public static void main(String[] args) {
		
		Pow_H alg = new Pow_H();
		
		DataPrinter.println(alg.myPow(1, 2));
		DataPrinter.println(alg.myPow(2, 0));
		DataPrinter.println(alg.myPow(2, 2));
		DataPrinter.println(alg.myPow(2, 3));
		
		DataPrinter.println(alg.myPow(1, -2));
		DataPrinter.println(alg.myPow(2, -2));
		DataPrinter.println(alg.myPow(2, -3));
		
	}
}
