package kang.interview.programming.string;

public class FindFirstOccurenceOfASubstring {
	
	/**
	 * Finds the position of a specified character in an array of characters
	 * from the specified position.
	 * 
	 * @param chars an array of characters
	 * @param c the character
	 * @param start the start index
	 * @return the index of the character
	 */
	public int findCharacter(char[] chars, char c, int start) {
		while (start < chars.length) {
			if (chars[start] == c) {
				return start;
			} else {
				start++;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @param text the text
	 * @param ss the substring to be searched
	 * @return the index of the first occurrence of ss
	 */
	public int findFirstOccurence_bf(String text, String ss) {
		for (int i = 0; i < text.length(); i++) {

			int j = 0;
			int z = i;
			while (j < ss.length() && z < text.length()) {
				if (ss.charAt(j) != text.charAt(z)) {
					break;
				}
				j++;
				z++;
			}

			if (j == ss.length()) {
				return i;
			}

		}
		return -1;
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		FindFirstOccurenceOfASubstring ora = new FindFirstOccurenceOfASubstring();
		int result = ora.findFirstOccurence_bf("you are so beautiful", "so");
		System.out.println(result);
	}

}
