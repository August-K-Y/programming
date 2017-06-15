package kang.interview.programming.honors;

public class MaximumTrafficOverSlidingWindow {

	public double[] compute(double[] input, int weight) {

		double[] result = new double[input.length];
		for (int i = 0; i < input.length; i++) {

			double max = 0;
			for (int j = i; j >= 0 && j >= i - weight; j--) {
				max = Math.max(max, input[j]);
			}
			result[i] = max;
		}
		return result;
	}

	// TODO: backward traverse the input array to avoid using extra array
	// holding the result

	public static void main(String[] args) {

		double[] array = { 1.3, 0, 2.5, 3.7, 0, 1.4, 2.6, 0, 2.2, 1.7, 0, 0, 0, 0, 1.7 };
		MaximumTrafficOverSlidingWindow w = new MaximumTrafficOverSlidingWindow();
		double[] result = w.compute(array, 3);
		for (double d : result) {
			System.out.print(d + " ");
		}
	}
}
