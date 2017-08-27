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
 * @author Yan Kang
 *
 */
public class TextJustification_HH {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new LinkedList<>();
		if (words == null || words.length == 0)
			return result;

		// the index of start word for the next line
		int currStartWord = 0;
		// the total length of words and necessary empty spaces to be packed
		// into the next line
		int forwardLen = 0;
		// the length of words (only the length of words, no other characters
		// such as space) being held.
		int currWordsLen = 0;
		// the numOfWord tracks the number of words accumulated so far in
		// the forwardLen since the last time a line was created
		int numOfWord = 0;
		for (int i = 0; i < words.length; i++) {

			numOfWord++;
			String w = words[i];

			/*
			 * IMPORTANT: the forwardLen is tentatively trying to see whether
			 * the words and necessary empty spaces accumulated so far ever
			 * since last time a line has been created can be fit into the next
			 * line.
			 * 
			 * The forwardLen has two parts: (1) currWordsLen, (2) w.length(),
			 * and (3) (numOfWord - 1)
			 * 
			 * The first part is the total length of words held to be packed
			 * into one line. These words with necessary spaces can fit into one
			 * line but with extra spaces. Therefore, they are held to see if
			 * together with the tentative word (the second part), they can fit
			 * into one line.
			 * 
			 * The second part is the length of the tentative word. If the
			 * forwardLen including this tentative word can fit into one line,
			 * we create a line of it. Otherwise, we only pack the held words
			 * into one line.
			 * 
			 * The third part is the necessary empty spaces that are needed to
			 * pack into one line together with the held words and the tentative
			 * word. The numOfWord tracks the number of words. Therefore, at
			 * least numOfWord - 1 empty spaces are needed.
			 * 
			 * 
			 * If the forwardLen can just fit one line, we create a line from
			 * this forwardLen. If the forwardLen is beyond the max width of a
			 * line,
			 */
			forwardLen = currWordsLen + w.length() + (numOfWord - 1);

			if (forwardLen == maxWidth) {
				// In this case, the forwardLen including the tentative word can
				// just fit into one line.
				result.add(getLine(words, currStartWord, i, maxWidth - currWordsLen - w.length()));
				
				/*
				 * the word i is included into the line just created. Therefore,
				 * the next line is start from word i + 1.
				 */
				currStartWord = i + 1;
				numOfWord = 0;
				currWordsLen = 0;

			} else if (forwardLen > maxWidth) {
				// In this case, the forwardLen including the tentative word can
				// not fit into one line. Therefore pack only held words into a
				// line.
				result.add(getLine(words, currStartWord, i - 1, maxWidth - currWordsLen));

				/*
				 * the word i is excluded from the line just created. Therefore,
				 * the next line is start from word i.
				 */
				currStartWord = i;
				numOfWord = 1;
				currWordsLen = words[i].length();

			} else {
				// forwardLen < maxWidth. In this case, forwardLen can fit into
				// one line but with extra spaces.

				// In order to pack as many words as possible into one line, we
				// add the tentative word to current list of words and to see if
				// these words can fit into one line.
				currWordsLen += words[i].length();
			}
		}

		if (numOfWord > 0) {
			
			// If there are words left, pack these words into the last line.
			// These words are start from index curStartWord to the last word.
			StringBuilder sb = new StringBuilder(getLine(words, currStartWord, words.length - 1, numOfWord - 1));

			// Since this is the last line, it should be left justified such
			// that no extra space (i.e., only one space should inserted between
			// words) is inserted between words and all left spaces should
			// append after the last word.
			// maxWidth - currWordsLen - (numOfWord - 1) is the number of space
			// should be appended after the last word, where numOfWord - 1 is
			// the numbers of words inserted between words.
			for (int i = 0; i < maxWidth - currWordsLen - (numOfWord - 1); i++) {
				sb.append(" ");
			}
			result.add(sb.toString());
		}
		return result;
	}

	/**
	 * 
	 * @param words
	 *            the array of words
	 * @param start
	 *            the index of the start word
	 * @param end
	 *            the index of the end word
	 * @param spaceLen
	 *            the length of the empty spaces. The number of spaces should be
	 *            inserted between words if there are multiple words in this
	 *            line or the number spaces should append the word if there are
	 *            only one word in this line.
	 * @return String representing a line
	 */
	private String getLine(String[] words, int start, int end, int spaceLen) {
		StringBuilder sb = new StringBuilder();
		int numOfWord = end - start + 1;

		/*
		 * If there is only one word, all the spaces will be put after this
		 * word.
		 * 
		 * If there are multiple words, all the spaces will be distributed as
		 * evenly as possible amount the gaps between these words.
		 */

		for (int i = start; i < end; i++) {
			sb.append(words[i]);
			numOfWord--;
		
			/*
			 * IMPORTANT: compute how many spaces should be put in front of the
			 * next word.
			 * 
			 * If only one word left, all the spaces will be put in front of the
			 * left word. If multiple words left, the spaces will be distributed
			 * as evenly as possible.
			 * 
			 * numOfWord is the amount of words left, spaceLen is the amount of
			 * spaces left.
			 * 
			 * (spaceLen / numofWord) is to distribute spaces between words as
			 * evenly as possible.
			 * 
			 * Math.ceil() is to satisfy the requirement that "If the number of
			 * spaces on a line do not divide evenly between words, the empty
			 * slots on the left will be assigned more spaces than the slots on
			 * the right"
			 */
			int numSpace = (int) Math.ceil((double) spaceLen / numOfWord);
			for (int j = 0; j < numSpace; j++) {
				sb.append(" ");
			}
			
			spaceLen -= numSpace;
		}
		
		sb.append(words[end]);
		
		for (int i = 0; i < spaceLen; i++) {
			sb.append(" ");
		}

		return sb.toString();
	}
}
