package kang.interview.programming.heap.hashtable;

/**
 * 
 * Given a string str and array of pairs that indicates which indices in the
 * string can be swapped, return the lexicographically largest string that
 * results from doing the allowed swaps. You can swap indices any number of
 * times.
 * 
 * Example
 * 
 * For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
 * swapLexOrder(str, pairs) = "dbca".
 * 
 * By swapping the given indices, you get the strings: "cbda", "cbad", "dbac",
 * "dbca". The lexicographically largest string in this list is "dbca".
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] string str
 * 
 * A string consisting only of lowercase English letters.
 * 
 * Guaranteed constraints: 
 * 		1 <= str.length <= 104.
 * 
 * [input] array.array.integer pairs
 * 
 * An array containing pairs of indices that can be swapped in str (1-based).
 * This means that for each pairs[i], you can swap elements in str that have the
 * indices pairs[i][0] and pairs[i][1].
 * 
 * Guaranteed constraints: 
 * 		0 <= pairs.length <= 5000, 
 * 		pairs[i].length = 2.
 * 
 * [output] string
 * 
 * @author Yan Kang
 *
 */
public class SwapLexOrder {

	String swapLexOrder(String str, int[][] pairs) {

		return null;
	}

}
