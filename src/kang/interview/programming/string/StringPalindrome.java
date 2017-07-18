package kang.interview.programming.string;

public class StringPalindrome {

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
	 * Check if characters in a string is palindromic.
	 * 
	 * @param str
	 *            the input string containing only alphabetics
	 * @return true if the characters of the input string is palindromic
	 */
	public boolean isPalindromic(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0, j = chars.length - 1; i < chars.length && j > 0 && i <= j; i++, j--) {
			if (chars[i] != chars[j])
				return false;
		}
		return true;
	}
	
	/**
	 * Here a palindromic string is defined as a string which when all
	 * non-alphabetic characters are removed it reads the same front to back
	 * ignoring case.
	 * 
	 * @param str
	 *            the input string
	 * @return true if the characters of the input string is palindromic
	 */
	public boolean isPalindromic2(String str) {
		char[] chars = str.toUpperCase().toCharArray();
		for (int i = 0, j = chars.length - 1; i < chars.length && j > 0 && i <= j; i++, j--) {

			// skip non-alphanumeric characters
			while (isNotAlphenumeric(chars[i]))
				i++;
			while (isNotAlphenumeric(chars[j]))
				j--;

			if (i > j)
				break;
			
			if (chars[i] != chars[j])
				return false;
		}
		return true;
	}

	private boolean isNotAlphenumeric(char c) {
		return ! Character.isLetterOrDigit(c);
	}

	public static void main(String[] arg) {
		System.out.println("run");
		StringPalindrome ora = new StringPalindrome();
		boolean end = ora.isPalindromic2("A man, a plan, a canal, Panama.");
		System.out.println(end);
		end = ora.isPalindromic2("Ray a Ray");
		System.out.println(end);
	}
}
