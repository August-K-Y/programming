package kang.interview.programming.search.binarysearch;

/**
 * LeetCode 367. Valid Perfect Square: 
 * https://leetcode.com/problems/valid-perfect-square/description/
 * 
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

	Note: Do not use any built-in library function such as sqrt.
	
	Example 1:
	
	Input: 16
	Returns: True
	Example 2:
	
	Input: 14
	Returns: False

 * @author Yan Kang
 *
 */
public class Sqrt_perfect_M {
	public boolean isPerfectSquare(int x) {
		if (x == 0)
			return true;

		int l = 1;
		int r = x;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			// IMPORTANT: x % mid == 0
			if (x % mid == 0 && x / mid == mid) {
				return true;
			} else if (x / mid < mid) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return false;
	}
}
