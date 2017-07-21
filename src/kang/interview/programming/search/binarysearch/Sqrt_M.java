package kang.interview.programming.search.binarysearch;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * 
 * LeetCode 69. Sqrt(x):
 * https://leetcode.com/problems/sqrtx/#/description
 * 
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author Yan Kang
 *
 */
public class Sqrt_M {
	public int mySqrt(int x) {
		if (x <= 0)
			return 0;

		int l = 1;
		int r = x;
		int max = -1;
		while (l <= r) {

			int mid = l + (r - l) / 2;

			// IMPORTANT: 
			if (x / mid == mid) {
				return mid;
			} else if (x / mid < mid) {
				r = mid - 1;
			} else {
				max = Math.max(max, mid);
				l = mid + 1;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Sqrt_M alg = new Sqrt_M();
		DataPrinter.println(alg.mySqrt(0));
		DataPrinter.println(alg.mySqrt(1));
		DataPrinter.println(alg.mySqrt(2));
		DataPrinter.println(alg.mySqrt(3));
		DataPrinter.println(alg.mySqrt(4));
		DataPrinter.println(alg.mySqrt(5));
		DataPrinter.println(alg.mySqrt(6));
		DataPrinter.println(alg.mySqrt(7));
		DataPrinter.println(alg.mySqrt(8));
		DataPrinter.println(alg.mySqrt(9));
		DataPrinter.println(alg.mySqrt(2147395599));
	}
}
