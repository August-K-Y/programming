package kang.interview.programming.array;

/**
 * 
 * 
 * Note: Write a solution with O(n) time complexity and O(1) additional space
 * complexity, since this is what you would be asked to do during a real
 * interview.
 * 
 * Given an array a that contains only numbers in the range from 1 to a.length,
 * find the first duplicate number for which the second occurrence has the
 * minimal index. In other words, if there are more than 1 duplicated numbers,
 * return the number for which the second occurrence has a smaller index than
 * the second occurrence of the other number does. If there are no such
 * elements, return -1.
 * 
 * Example
 * 
 * For a = [2, 3, 3, 1, 5, 2], the output should be firstDuplicate(a) = 3.
 * 
 * There are 2 duplicates: numbers 2 and 3. The second occurrence of 3 has a
 * smaller index than than second occurrence of 2 does, so the answer is 3.
 * 
 * For a = [2, 4, 3, 5, 1], the output should be firstDuplicate(a) = -1.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] array.integer a
 * 
 * @author yankang
 *
 */
public class FindFirstDuplicate {

	/**
	 * 
	 * @param a
	 *            an array a that contains only numbers in the range from 1 to
	 *            a.length,
	 * @return
	 */
	public int firstDuplicate(int[] a) {
		if (a == null || a.length == 0)
			return -1;

		// IMPROTANT: Math.abs()
		// Math.abs(a[i]) - 1 is the index where stores the indicator indicating
		// if the a[i] has already appeared in the array
		for (int i = 0; i < a.length; i++) {
			if (a[Math.abs(a[i]) - 1] < 0) {
				return Math.abs(a[i]);
			} else {
				a[Math.abs(a[i]) - 1] *= -1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FindFirstDuplicate s = new FindFirstDuplicate();
		int[] array = { 2, 3, 3, 1, 5, 2 };
		int result = s.firstDuplicate(array);
		System.out.println(result);
	}

}
