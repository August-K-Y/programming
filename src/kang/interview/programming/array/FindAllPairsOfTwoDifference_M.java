package kang.interview.programming.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * Given an integer array and a positive integer k, count all distinct pairs
 * with difference equal to k. A number can appears in more than one pair 
 * and duplicate pairs are not allowed
 * 
 * Input: arr[] = {1, 5, 3, 4, 2}, k = 3 
 * Output: 2 
 * There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2}
 * 
 * Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4 
 * Output: 5 
 * There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
 * 
 * @see {@link FindAllParisOfTwoSum}
 * @see http://www.geeksforgeeks.org/count-pairs-difference-equal-k/
 * @see http://www.geeksforgeeks.org/find-a-pair-with-the-given-difference/
 * @author yankang
 *
 */
public class FindAllPairsOfTwoDifference_M {
	
	
	/**
	 * For question essentially asks: for certain element in an array, find
	 * other distinct elements in the same array that have certain mathematical
	 * relationship with that element.
	 * 
	 * two pitfalls: </br>
	 * (1) How to deal with duplicates? Probably need hash map/set to avoid
	 * duplicates </br>
	 * (2) How to deal with the scenario that there might be M-to-M mathematical
	 * relationship between two elements. In this case, you should be careful
	 * when using hash table</br>
	 * 
	 * There are several ways to do this with different time complexity and
	 * space complexity:
	 * <ul>
	 * <li>(1) Brute force with two loops, which has time complex O(N^2) and
	 * space complex O(1)</li>
	 * <li>(2) Using Hash Map, which has time complex O(N) and space complex
	 * O(N)</li>
	 * <li>(3) Using Binary Search, which has time complex O(lgN) and space
	 * complex O(1) or O(N)</li>
	 * <li>(4) By sorting first, which has time complex O(lgN) and space complex
	 * O(N)</li>
	 * </ul>
	 * 
	 */

	/**
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public int findAllPairs_twoLoops(int[] array, int k) {
		int n = array.length;
		int count = 0;

		// This set tracks elements have already been paired to avoid duplicate
		// pair.
		Set<Integer> set = new HashSet<>();

		// Pick all elements one by one
		for (int i = 0; i < n; i++) {
			// See if there is a pair of this picked element
			for (int j = i + 1; j < n; j++)
				if ((array[i] - array[j] == k || array[j] - array[i] == k) && !set.contains(array[i])) {

					// This picked element has already been paired with element
					// before it and/or element after it. To avoid duplicate
					// pair, we add it to the set to indicate that this picked
					// element has already been paired.
					set.add(array[i]);
					count++;
				}
		}
		return count;
	}

	/**
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public int findAllPairs_ByHash(int[] array, int k) {
		Map<Integer, Boolean> tracker = new HashMap<>();

		for (int e : array) {
			tracker.put(e, true);
		}

		int count = 0;
		for (int e : array) {

			// Pitfall: here we are using Boolean class rather than boolean
			// primitive type since if track.get(v) returns null and we are
			// using boolean primitive type, an NullPointerException will be
			// thrown.
			Boolean t = tracker.get(e + k);
			if (t != null && t) {
				count++;
			}
			t = tracker.get(e - k);
			if (t != null && t) {
				count++;
			}

			// This step is important since each element can be paired with
			// at most two other distinct elements. We have already checked if
			// current element e is paired with other two elements (e + k or e -
			// k) and updated the count variable accordingly. The other elements
			// it (i.e., e) may be paired are all duplicates. To avoid
			// duplicates, we map e to false.
			tracker.put(e, false);
		}
		return count;
	}

	public static void main(String[] args) {
		FindAllPairsOfTwoDifference_M s = new FindAllPairsOfTwoDifference_M();
		
	
		int[] array = { 0, 5, 11, 8, 14, 5 };
//		System.out.println(s.findAllPairs(array, 3));
		
		System.out.println(s.findAllPairs_ByHash(array, 3));
		System.out.println(s.findAllPairs_twoLoops(array, 3));
	}
}
