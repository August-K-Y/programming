package kang.interview.programming.array;

/**
 * How to remove duplicates from array in place?
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * Read more:
 * http://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-
 * and-answers.html#ixzz4gYA83DDi
 * 
 * @author YK044346
 *
 */
public class RemoveDuplicatesInPlace {

	public int removeDuplicates(int[] array) {

		if (array.length == 1)
			return 1;

		int prev = array[0];
		int pos = 1; // pointer point to the position to be filled
		for (int i = 1; i < array.length; i++) {

			// if current element is equal to previous element, skip current
			// element. Otherwise, put this element to the position specified by
			// pos.
			if (array[i] != prev) {
				array[pos++] = array[i];
				prev = array[i];
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		RemoveDuplicatesInPlace s = new RemoveDuplicatesInPlace();
		int[] array = { 1, 1, 2, 2, 2, 2, 3, 4, 5, 5 };
		int newLength = s.removeDuplicates(array);
		System.out.println(newLength);

		for (int i = 0; i < newLength; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
