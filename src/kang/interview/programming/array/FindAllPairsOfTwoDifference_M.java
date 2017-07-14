package kang.interview.programming.array;

import java.util.HashMap;
import java.util.Map;


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
	 * This is NOT the right answer.
	 * 
	 * For example: int[] array = { 0, 5, 11, 8 }; </br>
	 * this algorithm will output 1, but it actually has 2 pairs: (5, 8) and
	 * (11, 8). one number can be paired with two other numbers. This is
	 * different from find pair that sums up to a given value.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public int findAllPairs(int[] array, int k) {

		Map<Integer, Boolean> track = new HashMap<>();

		for (int a : array) {
			
			if (track.containsKey(a)) {
				track.put(a, true);
			}
			
			if (!track.containsKey(a + k)) {
				track.put(a + k, false);
			}
			
			if (!track.containsKey(a - k)) {
				track.put(a - k, false);
			}
		}
		int count = 0;
		for (int key : track.keySet()) {
			if (track.get(key)) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		FindAllPairsOfTwoDifference_M s = new FindAllPairsOfTwoDifference_M();
		
	
		int[] array = { 0, 5, 11, 8, 14 };
		System.out.println(s.findAllPairs(array, 3));
	}
}
