package kang.interview.programming.array;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * How to rearrange array in alternating positive and negative number?
 * 
 * Given an array of positive and negative numbers, arrange them in an alternate
 * fashion such that every positive number is followed by negative and
 * vice-versa maintaining the order of appearance. (Note, you should maintain
 * the order of appearance)
 * 
 * Number of positive and negative numbers need not be equal. If there are more
 * positive numbers they appear at the end of the array. If there are more
 * negative numbers, they too appear in the end of the array.
 * 
 * This is also a difficult array problem to solve and you need lot of practice
 * to solve this kind of problems in real interviews, especially when you see it
 * first time. If you have time constraint then always attempt these kind of
 * questions once you are done with easier ones.
 * 
 * Example:
 * 
 * Input: {1, 2, 3, -4, -1, 4} Output: {-4, 1, -1, 2, 3, 4}
 * 
 * Input: {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8} output: {-5, 5, -2, 2, -8, 4, 7, 1,
 * 8, 0}
 * 
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gjUnlRXc
 * 
 * Read more:
 * http://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-
 * items-o1-extra-space/
 *
 */
public class RearrangeArrayInAlternatingPosNegNumber_M {
	
	/*
	 * TODO: Any elegant way using O(n) space???
	 */
	public int[] rearrange(int[] array) {
		
		int posN = 0;
		int negN = 0;
		for (int a : array) {
			if (a >= 0) {
				posN++;
			} else {
				negN++;
			}
		}
		int com = Math.min(posN, negN);
		
		int[] result = new int[array.length];
		int posP = 1;
		int negP = 0;
		int posC = 0, negC = 0;
		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			if (value >= 0) {
				result[posP] = value;
				posC++;

				if (posC < com)
					posP += 2;
				else
					posP += 1;
				
			} else {
				result[negP] = value;
				negC++;
				if (negC < com)
					negP += 2;
				else
					negP += 1;
			}
		}
		return result;
	}

	/**
	 * The idea is to process array from left to right. While processing,
	 * <ol>
	 * <li>find the first out of place element in the remaining unprocessed
	 * array. An element is out of place if it is negative and at odd index, or
	 * it is positive and at even index.</li>
	 * <li>Once we find an out of place element, we find the first element after
	 * it with opposite sign.</li>
	 * <li>Then, We right rotate the subarray between these two elements (including
	 * these two).</li>
	 * </ol>
	 * 
	 * @param array
	 */
	public void rearrange_(int[] array) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0 && i % 2 == 0) {
				int index = find(array, i + 1, false);
				if (index == -1)
					return;
				rotate(array, i, index);
			} else if (array[i] < 0 && i % 2 == 1) {
				int index = find(array, i + 1, true);
				if (index == -1)
					return;
				rotate(array, i, index);
			}
		}
	}
	
	/**
	 * Finds the first number with specified sign in an array start from
	 * specified index.
	 * 
	 * @param array
	 *            the array
	 * @param start
	 *            the start index
	 * @param positive
	 *            a boolean value indicating whether to find a positive number
	 *            or negative number. if this value is true, finding a positive
	 *            number. false, otherwise
	 * @return the index of the number. -1, if such number does not exist
	 */
	private int find(int[] array, int start, boolean positive) {
		for (int i = start; i < array.length; i++) {
			if (positive && array[i] >= 0 || !positive && array[i] < 0)
				return i;
		}
		return -1;
	}

	/**
	 * Rotates an array start from the specified index to the specified index.
	 * 
	 * @param array
	 *            the array
	 * @param start
	 *            the start index
	 * @param end
	 *            the end index
	 */
	private void rotate(int[] array, int start, int end) {
		int temp = array[end];
		for (int i = end - 1; i >= start; i--) {
			array[i + 1] = array[i];
		}
		array[start] = temp;
	}

	public static void main(String[] args) {
		RearrangeArrayInAlternatingPosNegNumber_M s = new RearrangeArrayInAlternatingPosNegNumber_M();
		int[] array = { 1, 2, 3, -4, -1, 4 };
		int[] result = s.rearrange(array);
		DataPrinter.printArray(result);
		System.out.println();
		int[] array2 = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
		result = s.rearrange(array2);
		DataPrinter.printArray(result);
		System.out.println("");
		System.out.println("-------------------");
		s.rearrange_(array);
		DataPrinter.printArray(array);
		System.out.println();
		s.rearrange_(array2);
		DataPrinter.printArray(array2);
	}

}
