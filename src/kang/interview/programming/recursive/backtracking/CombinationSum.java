package kang.interview.programming.recursive.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given an array of integers a and an integer sum, find all of the unique
 * combinations in a that add up to sum. The same number from a can be used an
 * unlimited number of times in a combination. Elements in a combination (a1 a2
 * … ak) must be sorted in non-descending order, while the combinations
 * themselves must be sorted in ascending order. If there are no possible
 * combinations that add up to sum, the output should be the string "Empty".
 * 
 * Example
 * 
 * For a = [2, 3, 5, 9] and sum = 9, the output should be 
 * combinationSum(a, sum) = "(2 2 2 3)(2 2 5)(3 3 3)(9)".
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] array.integer a
 * 
 * An array of positive integers.
 * 
 * Guaranteed constraints: 
 * 		1 <= a.length <= 12, 
 * 		1 <= a[i] <= 9.
 * 
 * [input] integer sum
 * 
 * Guaranteed constraints: 
 * 		1 <= sum <= 30.
 * 
 * [output] string
 * 
 * All possible combinations that add up to a given sum, or "Empty" if there are
 * no possible combinations.
 * 
 * @see {@link SumSubsets)
 * @author Yan Kang
 *
 */
public class CombinationSum {
	
	String combinationSum(int[] a, int sum) {
		a = Arrays.stream(a).distinct().sorted().toArray();
//		Arrays.sort(a);
		List<List<Integer>> aggre = new LinkedList<List<Integer>>();
		LinkedList<Integer> bus = new LinkedList<>();

		findSolution(a, 0, sum, bus, aggre);

//		Set<String> set = new HashSet<>();
		StringBuilder result = new StringBuilder();
		for (List<Integer> list : aggre) {
			StringBuilder sb = new StringBuilder("(");
			for (int e : list) {
				sb.append(e + " ");
			}
//			if (set.add(sb.toString())) {
//				result.append(sb.toString().trim() + ")");
//			}
			result.append(sb.toString().trim() + ")");
		}
		return aggre.size() == 0 ? "Empty" : result.toString();
	}

	private void findSolution(int[] a, int index, int sum, LinkedList<Integer> bus, List<List<Integer>> aggre) {
		if (sum == 0) {
			aggre.add(new LinkedList<>(bus));
		}
		for (int i = index; i < a.length; i++) {
			if (sum - a[i] >= 0) {
				bus.add(a[i]);
				findSolution(a, i, sum - a[i], bus, aggre);
				bus.removeLast();
			}
		}
	}
	
	public static void main(String[] args) {
		CombinationSum c = new CombinationSum();
		int[] arr = { 2, 3, 5, 9 };
		int num = 9;
		System.out.println(c.combinationSum(arr, num));
	}
	
	
	/**
	 * 
	 * 
	 */
	final StringBuilder bld = new StringBuilder();
	final List<String> list = new ArrayList<>();

	void appendSolution(int[] counts, int[] a) {
		bld.setLength(0);
		bld.append('(');

		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				if (count++ > 0)
					bld.append(' ');
				bld.append(a[i]);
			}
		}
		bld.append(')');
		list.add(bld.toString());
	}

	void findSolution(int[] counts, int[] a, int offset, int sum) {

		if (sum < 0) {
			return;
		}

		if (sum == 0) {
			appendSolution(counts, a);
			return;
		}

		if (offset >= a.length) {
			return;
		}

		for (int i = 0; i * a[offset] <= sum; i++) {
			counts[offset] = i;
			findSolution(counts, a, offset + 1, sum - i * a[offset]);
			counts[offset] = 0;
		}
	}

	String combinationSum_(int[] a, int sum) {
		a = Arrays.stream(a).distinct().sorted().toArray();
		findSolution(new int[a.length], a, 0, sum);
		Collections.sort(list);

		if (list.size() == 0) {
			return "Empty";
		}

		return list.stream().collect(Collectors.joining());
	}
	
	
	/**
	 * JavaScript(ES6)
	 * 
	 * 
	 */
	
//	combinationSum = (a, s) => {
//	    a = [...new Set(a)]
//	    r = []
//	    b = (t, j, c) => {
//	        if (!t)
//	            return r.push('(' + c.sort().join` ` + ')')
//	        for (var i = j; e = a[i]; i++)
//	            if (t >= e) 
//	                b(t - e, i, [...c, e])
//	    }
//	    b(s, 0, [])
//	    return r.sort().join`` || 'Empty'
//	}

}
