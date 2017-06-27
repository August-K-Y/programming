package kang.interview.programming.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * How to find first non-repeating element in array of integers?
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4giVqgvaT
 *
 */
public class FindFirstNonRepeatingNumber {

	public int findFirstNonRepeatingElement(int[] array) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int pos = i + 1;
			if (map.containsKey(array[i])) {
				map.put(array[i], pos < 0 ? pos : -pos);
			} else {
				map.put(array[i], pos);
			}
		}

		int min = array.length + 1;
		for (int pos : map.values()) {
			if (pos > 0 && pos < min) {
				min = pos;
			}
		}

		return min == array.length + 1 ? -1 : min - 1;
	}

	public static void main(String[] args) {
		FindFirstNonRepeatingNumber s = new FindFirstNonRepeatingNumber();
		int[] array = { 10, 1, 3, 4, 3, 5, 10};
		int newLength = s.findFirstNonRepeatingElement(array);
		System.out.println(newLength);
	}
}
