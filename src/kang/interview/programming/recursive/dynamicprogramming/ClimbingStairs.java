package kang.interview.programming.recursive.dynamicprogramming;

import kang.interview.programming.util.DataPrinter;

/**
 * You are climbing a staircase that has n steps. You can take the steps either
 * 1 or 2 at a time. Calculate how many distinct ways you can climb to the top
 * of the staircase.
 * 
 * Example
 * 
 * For n = 1, the output should be climbingStairs(n) = 1;
 * 
 * For n = 2, the output should be climbingStairs(n) = 2.
 * 
 * You can either climb 2 steps at once or climb 1 step two times.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] integer n
 * 
 * Guaranteed constraints: 1 <= n <= 50.
 * 
 * [output] integer
 * 
 * It's guaranteed that the answer will fit in a 32-bit integer.
 * 
 * @author Yan Kang
 *
 */
public class ClimbingStairs {
	
	/**
	 * 
	 * d[i] represent the number of distinct ways need to climb to staircase of
	 * i steps.
	 * 
	 * optimal structure: </br>
	 * d[i] = d[i - 1] + d[i - 2]
	 * 
	 * @param n
	 */
	public int climbingStairs(int n) {
		if (n <= 2)
			return n;
		
		int[] d = new int[n + 1];
//		d[0] = 1;
		d[1] = 1;
		d[2] = 2;
		
		for (int i = 3; i < n + 1; i++) {
			d[i] = d[i-1] + d[i-2];
		}
		
		return d[n];
	}
	
	public static void main(String[] args) {
		ClimbingStairs alg = new ClimbingStairs();
		DataPrinter.println(alg.climbingStairs(1));
		DataPrinter.println(alg.climbingStairs(2));
		DataPrinter.println(alg.climbingStairs(3));
		DataPrinter.println(alg.climbingStairs(4));
		DataPrinter.println(alg.climbingStairs(5));
		DataPrinter.println(alg.climbingStairs(6));
	}

}
