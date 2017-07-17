package kang.interview.programming.recursive.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class UnConcatenateString_H {

	public static class Result {
		int min;
		String str;

		public Result(int min) {
			this.min = min;
		}
	}
	
	private Result[] R;
	/**
	 * Recursive + backtracking + dynamic programming
	 * 
	 * @param str
	 * @param dic
	 * @return
	 */
	public Result compute(String str, Set<String> dic) {
		R = new Result[str.length()];
		for (int i = 0; i < str.length(); i++) {
			R[i] = new Result(-1);
		}
		
		return compute(str, 0, dic);
	}

	private Result compute(String str, int index, Set<String> dic) {
		if (index >= str.length()) {
			return new Result(0);
		}
		
		if(R[index].min > 0) {
			return R[index];
		}
		

		int min = str.length();
		String ans = "";
		for (int i = index; i < str.length(); i++) {
			
			int count = 0;

			String token = str.substring(index, i + 1);

			if (!dic.contains(token)) {
				count += token.length();
			} 

			Result res = compute(str, i + 1, dic);
			count += res.min;
			
			if (min > count) {
				min = count;
				ans = dic.contains(token) ? concat(token, res.str) : concat(token.toUpperCase(), res.str);
			}

		}

		R[index].min = min;
		R[index].str = ans;
		return R[index];
	}

	private String concat(String token, String str) {
		return token + " " + (str == null ? "" : str);
	}

	/**
	 * 
	 * @param str
	 * @param dic
	 * @return
	 */
	public int compute_(String str, Set<String> dic) {
		d = new int[str.length()];
		for (int i = 0; i < d.length; i++) {
			d[i] = -1;
		}
		return compute_(str, 0, dic);
	}
	
	
	private int compute_(String str, int index, Set<String> dic) {
		if (index >= str.length()) {
			return 0;
		}

		if (d[index] > 0) {
			return d[index];
		}

		int min = str.length();
		for (int i = index; i < str.length(); i++) {
			int count = 0;
			String token = str.substring(index, i + 1);
			if (!dic.contains(token)) {
				count += token.length();
			}
			count += compute_(str, i + 1, dic);
			min = Math.min(min, count);
		}

		d[index] = min;
		return min;
	}
	
	private int[] d;
	
	
	
	/**
	 * TODO: using bottom up dynamic programming
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UnConcatenateString_H alg = new UnConcatenateString_H();
		String str = "jesslookedjustliketimherbrother";
		
		Set<String> dic = new HashSet<>();
		dic.add("looked");
		dic.add("just");
		dic.add("like");
		dic.add("her");
		dic.add("brother");

		Result result = alg.compute(str, dic);
		System.out.println(result.min);
		System.out.println(result.str);
		System.out.println(alg.compute_(str, dic));
		
		System.out.println("jess".toUpperCase());
	}
}
