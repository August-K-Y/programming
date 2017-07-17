package kang.interview.programming.recursive.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class UnConcatenateString {

	private int min = Integer.MAX_VALUE;

	
	/**
	 * Recursive + backtracking
	 * 
	 * @param str
	 * @param dic
	 * @return
	 */
	public int compute(String str, Set<String> dic) {
		LinkedList<String> rec = new LinkedList<>();
		compute(str, 0, dic, rec, 0);
		rec.stream().forEach(s -> System.out.print(s + " "));
		return min;
	}

	private void compute(String str, int index, Set<String> dic, LinkedList<String> rec, int count) {
//		System.out.println("index: " + index);
		if (index >= str.length()) {
			min = Math.min(min, count);
			return;
		}

		for (int i = index; i < str.length(); i++) {
			System.out.println("index: " + index);
			String token = str.substring(index, i + 1);
			System.out.println("token: " + token);
			if (!dic.contains(token)) {
				rec.add(token.toUpperCase());
				count += token.length();
			} else {
				rec.add(token);
			}
			compute(str, i + 1, dic, rec, count);

			if (!dic.contains(token)) {
				count -= token.length();
			}
			rec.removeLast();
		}
	}
	
	public static void main(String[] args) {
		UnConcatenateString alg = new UnConcatenateString();
//		String str = "jesslookedjustliketimhebrother";
//
//		Set<String> dic = new HashSet<>();
//		dic.add("looked");
//		dic.add("just");
//		dic.add("like");
//		dic.add("her");
//		dic.add("brother");
		
		String str = "jesslookedjustlikeherbrot";

		Set<String> dic = new HashSet<>();
		dic.add("looked");
		dic.add("just");
		dic.add("like");
		dic.add("her");
		dic.add("brother");

		System.out.println(alg.compute(str, dic));
	}

}
