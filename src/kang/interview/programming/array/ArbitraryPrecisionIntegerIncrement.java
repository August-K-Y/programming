package kang.interview.programming.array;

import java.util.List;

/**
 * 
 * @author Yan Kang
 *
 */
public class ArbitraryPrecisionIntegerIncrement {

	public List<Integer> plusOne(List<Integer> input) {

		int last = input.size() - 1;
		input.set(last, input.get(last) + 1);

		int i = last;
		for (; i > 0 && input.get(i) == 10; i--) {
			input.set(i, 0);
			input.set(i - 1, input.get(i - 1) + 1);
		}

		// when code reach here, the i is 0
		if (input.get(0) == 0) {
			input.set(0, 0);
			// Need an additional digit since the most significant digit has a
			// carry-out
			input.add(0, 1);
		}
		return input;
	}
}
