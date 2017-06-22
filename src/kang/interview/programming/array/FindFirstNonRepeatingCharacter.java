package kang.interview.programming.array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Note: Write a solution that only iterates over the string once and uses O(1)
 * additional memory, since this is what you would be asked to do during a real
 * interview. (Is this really possible for only one iterations and O(1)
 * additional memory ???)
 * 
 * Given a string s, find and return the first instance of a non-repeating
 * character in it. If there is no such character, return '_'.
 * 
 * Example
 * 
 * For s = "abacabad", the output should be firstNotRepeatingCharacter(s) = 'c'.
 * 
 * There are 2 non-repeating characters in the string: 'c' and 'd'. Return c
 * since it appears in the string first.
 * 
 * For s = "abacabaabacaba", the output should be firstNotRepeatingCharacter(s)
 * = '_'.
 * 
 * There are no characters in this string that do not repeat.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] string s
 * 
 * A string that contains only lowercase English letters.
 * 
 * Guaranteed constraints: 1 ≤ s.length ≤ 105.
 * 
 * [output] char
 * 
 * The first non-repeating character in s, or '_' if there are no characters
 * that do not repeat.
 * 
 * @author yankang
 *
 */
public class FindFirstNonRepeatingCharacter {

	/**
	 * Using hash map to track the repeating characters
	 * 
	 * @param s
	 *            the input string
	 * @return the first non-repeating character
	 */
	public char firstNotRepeatingCharacter_1(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		for (int i = 0; i < chars.length; i++) {
			int pos = i + 1;
			if (map.containsKey(chars[i])) {
				map.put(chars[i], pos < 0 ? pos : -pos);
			} else {
				map.put(chars[i], pos);
			}
		}

		for (int pos : map.values()) {
			if (pos > 0) {
				return chars[pos-1];
			}
		}

		return '_';
	}

	/**
	 * Using an additional array to track the repeating characters
	 * 
	 * @param s
	 *            the input string
	 * @return the first non-repeating character
	 */
	public char firstNotRepeatingCharacter_2(String s) {
		int[] counter = new int[26];

		for (char c : s.toCharArray())
			counter[c - 'a']++;

		for (char c : s.toCharArray()) {
			if (counter[c - 'a'] == 1)
				return c;
		}

		return '_';
	}

	/**
	 * Using String's built-in methods to find the non-repeating character
	 * 
	 * @param s
	 *            the input string
	 * @return the first non-repeating character
	 */
	public char firstNotRepeatingCharacter_3(String s) {
		char[] c = s.toCharArray();

		// This seems that we only iterate the character array only once and use
		// O(1) additional memory. However, the indexOf and lastIndexOf still
		// iterate the array once. Therefore the time complexity is actually
		// O(n^2)
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(c[i]) == s.lastIndexOf(c[i]))
				return c[i];
		}
		return '_';
	}

	public static void main(String[] args) {
		FindFirstNonRepeatingCharacter s = new FindFirstNonRepeatingCharacter();
		char result = s.firstNotRepeatingCharacter_1("abacabaabacaba");
		System.out.println(result);

	}
}
