package kang.interview.programming.zhe;

import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 68. Text Justification:
 * https://leetcode.com/problems/text-justification/description/
 * 
 * Interview Element P454 25.8
 * 
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * For example,
 * 
 * words: ["This", "is", "an", "example", "of", "text", "justification."] L: 16.
 * 
 * Return the formatted lines as:
 * 
 * [ 
 * 		"This    is    an", 
 * 		"example  of text", 
 * 		"justification.  " 
 * ]
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * Corner Cases: 
 * A line other than the last line might contain only one word. What should you do in this case? 
 * In this case, that line should be left-justified.
 * 
 * @author yankang
 *
 */
public class TextJustification_HH {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new LinkedList<>();
		if (words == null || words.length == 0)
			return result;

		int currStartWord = 0;
		int forwardlen = 0;
		int currWordsLen = 0;
		int numOfW = 0;
		for (int i = 0; i < words.length; i++) {

			numOfW++;
			String w = words[i];
			forwardlen = currWordsLen + w.length() + (numOfW - 1);

			if (forwardlen == maxWidth) {
				result.add(getLine(words, currStartWord, i, maxWidth - currWordsLen - w.length()));
				currStartWord = i + 1;
				numOfW = 0;
				currWordsLen = 0;

			} else if (forwardlen > maxWidth) {
				result.add(getLine(words, currStartWord, i - 1, maxWidth - currWordsLen));
				currStartWord = i;
				numOfW = 1;
				currWordsLen = words[i].length();

			} else {
				currWordsLen += words[i].length();
			}
		}

		if (numOfW > 0) {
			StringBuilder sb = new StringBuilder(getLine(words, currStartWord, words.length - 1, numOfW - 1));
			for (int i = 0; i < maxWidth - currWordsLen - (numOfW - 1); i++) {
				sb.append(" ");
			}
			result.add(sb.toString());
		}
		return result;
	}

	/**
	 * 
	 * @param words
	 * @param s
	 * @param e
	 * @param spaceLen
	 * @return
	 */
	private String getLine(String[] words, int s, int e, int spaceLen) {
		StringBuilder sb = new StringBuilder();
		int numOfW = e - s + 1;
		for (int i = s; i < e; i++) {
			sb.append(words[i]);
			numOfW--;
			int numSpace = (int) Math.ceil((double) spaceLen / numOfW);
			for (int j = 0; j < numSpace; j++) {
				sb.append(" ");
			}
			spaceLen -= numSpace;
		}
		sb.append(words[e]);
		for (int i = 0; i < spaceLen; i++) {
			sb.append(" ");
		}

		return sb.toString();
	}
}
