package kang.interview.programming.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * You have two integer arrays, a and b, and an integer target value v.
 * Determine whether there is a pair of numbers, where one number is taken from
 * a and the other from b, that can be added together to get a sum of v. Return
 * true if such a pair exists, otherwise return false.
 * 
 * Example
 * 
 * For a = [1, 2, 3], b = [10, 20, 30, 40], and v = 42, the output should be
 * sumOfTwo(a, b, v) = true.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] array.integer a
 * 
 * An array of integers.
 * 
 * Guaranteed constraints: 
 * 			0 <= a.length <= 10^5, 
 * 			-10^9 <= a[i] <= 10^9.
 * 
 * [input] array.integer b
 * 
 * An array of integers.
 * 
 * Guaranteed constraints: 
 * 			0 <= b.length <= 10^5, 
 * 			-109 <= b[i] <= 10^9.
 * 
 * [input] integer v
 * 
 * Guaranteed constraints: 
 * 			-10^9 <= v <= 10^9.
 * 
 * [output] boolean
 * 
 * true if there are two elements from a and b which add up to v, and false
 * otherwise.
 * 
 * @author Yan Kang
 *
 */
public class SumOfTwo {

	// The brute force is using two loop to find the solution which takes n(N^2)

	/**
	 * time complexity: Q(nlogn)
	 * 
	 * @param a
	 * @param b
	 * @param v
	 * @return
	 */
	boolean sumOfTwo(int[] a, int[] b, int v) {

		Arrays.sort(a);
		Arrays.sort(b);

		int i = 0;
		int j = b.length - 1;
		while (i < a.length && j >= 0) {

			// Two pitfall
			int temp = (a.length == 0 ? 0 : a[i]) + (b.length == 0 ? 0 : b[j]);
			if (temp == v) {
				return true;
			} else if (temp < v) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
	
	/**
	 * From CodeFight: time complex O(n) with space O(n). The format is
	 * interesting.
	 * 
	 * @param a
	 * @param b
	 * @param v
	 * @return
	 */
	boolean sumOfTwo_(int[] a, int[] b, int v) {
	    Set<Integer> hash = new HashSet<>();
	    for (int e : a) hash.add(v - e);
	    for (int e : b) if (hash.contains(e)) return true;
	    return false;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int[] b = { 10, 20, 30, 40 };
		SumOfTwo s = new SumOfTwo();
		System.out.println(s.sumOfTwo(a, b, 42));
	}

}
