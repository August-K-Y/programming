package kang.interview.programming.primitivetype;

/**
 * Coding Interview P434 P17.3
 * 
 * @author yankang
 *
 */
public class TrailingZeroInFactorial {

	/**
	 * 
	 * @param n
	 * @return
	 */
	public int compute(int n) {
		int count = 0;
		for (int i = 5; i <= n; i += 5) {
			count += factorOf5(i);
		}
		return count;
	}

	private int factorOf5(int i) {
		int count = 0;

		// if i%5 == 0, i has factor of one 5
		while (i % 5 == 0) {
			count++;
			i /= 5;
		}
		return count;
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	public int compute_(int n) {
		int count = 0;
		return count;
	}

}
