package kang.interview.programming.zhe;

public class TrappingWater {

	public int compute(int[] array) {

		int highestIndex = findHighestIndex(array);

		int sum = 0;
		int left = 0;
		for (int i = 1; i <= highestIndex; i++) {
			if (array[left] < array[i]) {
				left = i;
			} else {
				sum += array[left] - array[i];
			}
		}

		int right = array.length;
		for (int i = array.length - 1; i >= highestIndex; i--) {
			if (array[right] < array[i]) {
				right = i;
			} else {
				sum += array[right] - array[i];
			}
		}
		return sum;
	}

	private int findHighestIndex(int[] array) {
		int max = array[0];
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		return index;
	}

}
