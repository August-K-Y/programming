package kang.interview.programming.recursive.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
	public Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int fib(int n) {
		Integer cache = map.get(n);
		if (cache == null) {
			if (n <= 1) {
				map.put(n, n);
			} else {
				map.put(n, fib(n - 1) + fib(n - 2));
			}
		}
		return map.get(n);
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		int n = 9;
		System.out.println("Fibonacci number is" + " " + f.fib(n));
	}

}
