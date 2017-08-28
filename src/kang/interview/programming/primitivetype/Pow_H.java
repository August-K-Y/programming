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
		
		// NOTE, deal with scenario when n is smaller than 0
		if (n < 0) {
			
			if (n == Integer.MIN_VALUE) {
				// change n to valid integer (i.e., Integer.MAX_VALUE), However,
				// the n is smaller by 1 than directly flipping the sign of
				// original value. Therefore, we multiple extra x with myPow(x, n);
				++n;
				n = -n;
				x = 1 / x;
				return x * myPow(x, n);
			}

			n = -n;
			x = 1 / x;
		}
		
		// if n%2 == 0,  x ^ n == (x ^ 2) ^ (n/2)
		// if n%2 != 0,  x ^ n == x * (x ^ 2) ^ (n/2)
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
	
	public static void main(String[] args) {
		
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
		
		Pow_H alg = new Pow_H();
		
//		DataPrinter.println(alg.myPow(1, 2));
//		DataPrinter.println(alg.myPow(2, 0));
//		DataPrinter.println(alg.myPow(2, 2));
//		DataPrinter.println(alg.myPow(2, 3));
//		
//		DataPrinter.println(alg.myPow(1, -2));
//		DataPrinter.println(alg.myPow(2, -2));
//		DataPrinter.println(alg.myPow(2, -3));
		
		DataPrinter.println(alg.myPow(2, -2147483648));
		
	}
}
