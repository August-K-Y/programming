package kang.interview.programming.honors;

import kang.interview.programming.util.AlgorithmTestUtil;

public class LongSubarrayWithInValue {

	public Range compute(int[] array, int value) {
		Range range = new Range();

		int max = 0;
		for (int i = 0; i < array.length; i++) {
			int temp = 0;
			for (int j = i; j >= 0; j--) {
				temp += array[j];
				if (temp > value)
					break;

				if (i - j + 1 > max) {
					max = i - j + 1;
					range.begin = j;
					range.end = i;
				}
			}
		}
		return range;
	}

	public static void main(String[] args) {
		int[] array = { 431, -15, 639, 342, -14, 565, -924, 635, 167, -70 };
		LongSubarrayWithInValue v = new LongSubarrayWithInValue();
		Range range = v.compute(array, 184);
		AlgorithmTestUtil.printSubarray(array, range);
	}
}
