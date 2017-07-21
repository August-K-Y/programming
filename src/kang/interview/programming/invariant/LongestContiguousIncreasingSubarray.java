package kang.interview.programming.invariant;

import kang.interview.programming.zhe.Range;

public class LongestContiguousIncreasingSubarray {

	public Range compute(int[] array) {

		int maxLength = 0;
		Range range = new Range();

		int slow = 0;
		int fast = 0;
		while (slow < array.length) {

			int tempLength = 1;
			int prev = array[slow];
			fast = slow + 1;
			while (fast < array.length) {
				if (array[fast] <= prev)
					break;

				tempLength++;
				prev = array[fast];
				fast++;
			}

			if (tempLength > maxLength) {
				maxLength = tempLength;
				range.begin = slow;
				range.end = fast - 1;
			}
			slow = fast;
		}
		return range;
	}

	public static void main(String[] args) {

		int[] array = { 2, 11, 3, 5, 13, 7, 19, 17, 23 };
		LongestContiguousIncreasingSubarray s = new LongestContiguousIncreasingSubarray();
		Range range = s.compute(array);
		printSubarray(array, range);

		int[] array2 = { 2, 11, 3, 5, 13, 7, 19, 17, 23, 34, 35 };
		Range range2 = s.compute(array2);
		printSubarray(array2, range2);
	}

	private static void printSubarray(int[] array, Range range) {
		for (int i = range.begin; i <= range.end; i++) {
			System.out.print(array[i] + " ");
		}
	}

}
