package kang.interview.programming.recursive.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 17. Letter Combinations of a Phone Number:
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/tabs/description
 * 
 * Given a digit string, return all possible letter combinations that the number
 * could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below.
 * 
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd",
 * "ce", "cf"].
 * 
 * Note: Although the above answer is in lexicographical order, your answer
 * could be in any order you want.
 * 
 * 
 * @author Yan Kang
 *
 */
public class LetterCombinationsofPhoneNumbers {

	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	/**
	 * Recursive approach
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> result = new LinkedList<>();
		if (digits == null || digits.length() == 0)
			return result;
		char[] ds = digits.toCharArray();

		// using map
		
		// Since we know how the path could be, we are using char array rather
		// than StringBuilder. char array is faster and easier to use.
		char[] path = new char[digits.length()];
		find(ds, 0, path, result);
		return result;
	}

	private void find(char[] ds, int index, char[] path, List<String> result) {
		if (index == ds.length) {
			result.add(new String(path));
			return;
		}

		// do not iterate the ds array for each recursion
		for (char l : KEYS[ds[index] - '0'].toCharArray()) {
			path[index] = l;
			find(ds, index + 1, path, result);
		}
	}
	
	/**
	 * TODO: understand this
	 * Iterative approach
	 * 
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations_(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		LetterCombinationsofPhoneNumbers alg = new LetterCombinationsofPhoneNumbers();
		DataPrinter.printList(alg.letterCombinations("23"));
		System.out.println();
		DataPrinter.printList(alg.letterCombinations("22"));
	}
}
