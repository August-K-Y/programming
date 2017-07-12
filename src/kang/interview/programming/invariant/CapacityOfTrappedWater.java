package kang.interview.programming.invariant;

/**
 * 
 * @see {@link MaximumWaterTrappedByPairOfVerticalLines}
 * @author Yan Kang
 *
 */
public class CapacityOfTrappedWater {
	
	public double compute(double[] array) {
		if (array == null || array.length == 0 || array.length == 1)
			return 0;
		
		double capacity = 0;

		int maxIndex = getIndexOfMax(array);
		double left = array[0];
		for (int i = 1; i < maxIndex; i++) {
			if (array[i] >= left) {
				left = array[i];
			} else {
				capacity += left - array[i];
			}
		}

		double right = array[array.length - 1];
		for (int i = array.length - 2; i > maxIndex; i--) {
			if (array[i] >= right) {
				right = array[i];
			} else {
				capacity += right - array[i];
			}
		}
		return capacity;
	}

	private int getIndexOfMax(double[] array) {
		int index = -1;
		double max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
				index = i;
			}
		}
		return index;
	}

}
