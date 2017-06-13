package kang.interview.programming.heap.hashtable;

import java.util.HashMap;

public class ConstructibleAnonymousLetter {

	/**
	 * Three passes
	 * 
	 * @param letter
	 * @param magazine
	 * @return
	 */
	public boolean isAnonymousLetterConstrutible(String letter, String magazine) {

		HashMap<Character, Integer> count = new HashMap<>();

		for (char c : magazine.toCharArray()) {
			if (count.containsKey(c)) {
				count.put(c, count.get(c) + 1);
			} else {
				count.put(c, 1);
			}
		}

		for (char c : letter.toCharArray()) {
			if (count.containsKey(c)) {
				count.put(c, count.get(c) - 1);
			} else {
				count.put(c, -1);
			}
		}

		for (int value : count.values()) {
			if (value < 0)
				return false;
		}
		return true;
	}

	public boolean isAnonymousLetterConstrutible_two_passes(String letter, String magazine) {

		//
		return true;
	}

	public static void main(String[] arg) {
		ConstructibleAnonymousLetter c = new ConstructibleAnonymousLetter();
		System.out.println(c.isAnonymousLetterConstrutible("i love you", "ii lovelove you you"));

	}

}
