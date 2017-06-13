package kang.interview.programming.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * How find the first repeating element in an array of integers?
 * 
 * Given an array of integers, find the first repeating element in it. We need
 * to find the element that occurs more than once and whose index of the first
 * occurrence is smallest.
 * 
 * Examples:
 * 
 * Input: input [] = {10, 5, 3, 4, 3, 5, 6} Output: 5 [5 is the first element
 * that repeats]
 * 
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gdiCQMfd
 * 
 * http://www.geeksforgeeks.org/find-first-repeating-element-array-integers/
 *
 */
public class FindFirstRepeatingElement {

	// brute-force: two nested for-loops with time complexity O(n^2)

	/**
	 * Finds the first repeating element in an array.
	 * 
	 * @param array
	 *            the integer array
	 * @return the index of the first repeating element; -1, if repeating
	 *         element does not exit
	 */
	public int findFirstRepeatingElement_left_to_right(int[] array) {

		// Iterate from left to right, we need to track the position of each
		// element on the way since the element found repeating itself first not
		// necessary the first repeating element. 
		
		// map element to it corresponding position (i.e. index)
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				// We make an element's position negative to represent the
				// element repeating itself. No matter how many time it repeats,
				// we always keep it negative since what we only care about is
				// element repeating itself not how many time it repeats.
				int pos = map.get(array[i]);
				map.put(array[i], pos <= 0 ? pos : -pos);
			} else {
				map.put(array[i], i);
			}
		}

		int pos = array.length;
		for (int v : map.values()) {
			// Finds the position that is negative (i.e., repeating element) and
			// the absolute value of which if the smallest (i.e., the first
			// repeating element)
			if (v < 0 && -v < pos) {
				pos = -v;
			}
		}
		return pos < array.length ? pos : -1;
	}

	// More clearer way to the iterate the array from right to left: In such
	// way, we need not to keep tracking the position of every element since the last
	// element found repeats itself is the first repeating element from the left
	// to right.
	/**
	 * Finds the first repeating element in an array.
	 * 
	 * @param array
	 *            the integer array
	 * @return the index of the first repeating element; -1, if repeating
	 *         element does not exit
	 */
	public int findFirstRepeatingElement_right_to_left(int[] array) {
		
		Set<Integer> track = new HashSet<>();
		
		int pos = -1;
		for (int i = array.length - 1; i >= 0; i--) {
			if (track.contains(array[i])) {
				pos = i;
			} else {
				track.add(array[i]);
			}

		}
		return pos;
	}

	public static void main(String[] args) {
		FindFirstRepeatingElement s = new FindFirstRepeatingElement();
		int[] array = { 10, 1, 3, 4, 3, 5, 6 };
		int newLength = s.findFirstRepeatingElement_left_to_right(array);
		System.out.println(newLength);

		newLength = s.findFirstRepeatingElement_right_to_left(array);
		System.out.println(newLength);
	}

}
