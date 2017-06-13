package kang.interview.programming.invariant;

public class MaximumWaterTrappedByPairOfVerticalLines {

	public double compute(int[] array) {

		double max = 0.0;
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			double square = (right - left) * Math.min(array[left], array[right]);
			max = Math.max(max, square);
			if (array[left] == array[right]) {
				left++;
				right--;
			} else if (array[left] > array[right]) {
				right--;
			} else {
				left++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 1, 3, 4, 4, 5, 6, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1 };
		MaximumWaterTrappedByPairOfVerticalLines t = new MaximumWaterTrappedByPairOfVerticalLines();
		System.out.println(t.compute(array));
	}

}
