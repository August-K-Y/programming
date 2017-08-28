package kang.interview.programming.string;

/**
 * LeetCode 125. Valid Palindrome:
 * https://leetcode.com/problems/valid-palindrome/tabs/description
 * 
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example,
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * 
 * "race a car" is not a palindrome.
 * 
 * Note: 
 * Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

	/**
	 * Check whether characters in a string can be permuted to form a string
	 * that is palindromic.
	 * 
	 * <p>
	 * A string of characters can be permuted to form palindromic if and only if
	 * each character appears an even number of times, with possibly a single
	 * exception.
	 * </p>
	 * 
	 * @param str
	 *            the input string containing only alphabetics
	 * @return true if the characters of input string can be permuted to form
	 *         palindromic
	 */
	public boolean canPermuteToPalindromic(String str) {
		int[] count = new int[256];
		char[] chars = str.toCharArray();
		int oddCharCount = 0;
		for (char c : chars) {
			count[c]++;
		}
		for (int c : count) {
			if (c % 2 == 1)
				oddCharCount++;
		}

		return oddCharCount <= 1;
	}

	/**
	 * Here a palindromic string is defined as a string which when all
	 * non-alphabetic characters are removed it reads the same front to back
	 * ignoring case.
	 * 
	 * @param s
	 *            the input string
	 * @return true if the characters of the input string is palindromic
	 */
	public boolean isPalindrome(String s) {

		if (s == null)
			return false;
		if (s.trim().isEmpty())
			return true;

		char[] chars = s.toLowerCase().toCharArray();
		int l = 0;
		int r = chars.length - 1;
		while (l < r) {
			
			// IMPORTANT: need to check if l < r while updating l and/or r
			while (l < r && !Character.isLetterOrDigit(chars[l]))
				l++;
			while (l < r && !Character.isLetterOrDigit(chars[r]))
				r--;

			if (chars[l] != chars[r])
				return false;

			l++;
			r--;
		}
		return true;
	}
	   

	public static void main(String[] arg) {
		System.out.println("run");
		ValidPalindrome ora = new ValidPalindrome();
		boolean end = ora.isPalindrome("A man, a plan, a canal, Panama.");
		System.out.println(end);
		end = ora.isPalindrome("Ray a Ray");
		System.out.println(end);
	}
}
