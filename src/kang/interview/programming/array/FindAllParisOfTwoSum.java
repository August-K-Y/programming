package kang.interview.programming.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * How to find all pairs on integer array whose sum is equal to given number?
 * 
 * This is an intermediate level of array coding question, its neither too easy
 * nor too difficult. You have given an integer array and a number, you need to
 * write a program to find all elements in array whose sum is equal to the given
 * number. Remember, array may contain both positive and negative numbers, so
 * your solution should consider that. Don't forget to write unit test though,
 * even if interviewer is not asked for it, that would separate you from lot of
 * developers. Unit testing is always expected from a professional developer.
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gdEGqMY1
 * 
 * http://javarevisited.blogspot.sg/2014/08/how-to-find-all-pairs-in-array-of-
 * integers-whose-sum-equal-given-number-java.html
 * 
 * @see {@link FindAllPairsOfTwoDifference_M}
 */
public class FindAllParisOfTwoSum {

	private class Pair {
		public Pair(int num1, int num2) {
			number1 = num1;
			number2 = num2;
		}

		public int number1;
		public int number2;
	}

	/**
	 * Not quite sure if this is 100% right
	 * @param array
	 * @param sum
	 * @return
	 */
	public List<Pair> findAllTwoSum(int[] array, int sum) {
		// the map tracks integer that has a partner to form pair whose sum
		// equals to the given number.
		Map<Integer, Boolean> track = new HashMap<>();
		for (int a : array) {
			if (track.containsKey(a)) {
				//
				track.put(a, true);
			} else {
				// Start tracking the other part of a pair if it has not been
				// tracked yet. If it has already been tracked, we do not want
				// to overwrite it's value.
				if (!track.containsKey(sum - a)) {
					track.put(sum - a, false);
				}
			}
		}

		List<Pair> pairs = new ArrayList<>();
		for (int key : track.keySet()) {
			if (track.get(key)) {
				Pair pair = new Pair(sum - key, key);
				pairs.add(pair);
			}
		}
		return pairs;
	}

	public static void main(String[] args) {
		FindAllParisOfTwoSum s = new FindAllParisOfTwoSum();
		int[] array = { 0, 5, 3, 4, 2 };
		int[] array2 = { 0, 5, 0, 5, 2, 3};

		List<Pair> res1 = s.findAllTwoSum(array, 5);
		List<Pair> res2 = s.findAllTwoSum(array2, 5);

		for (Pair p : res1) {
			System.out.println(p.number1 + ", " + p.number2);
		}
		System.out.println();
		for (Pair p : res2) {
			System.out.println(p.number1 + ", " + p.number2);
		}
	}

}
