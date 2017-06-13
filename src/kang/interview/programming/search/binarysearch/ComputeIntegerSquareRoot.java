package kang.interview.programming.search.binarysearch;

public class ComputeIntegerSquareRoot {

	/**
	 * http://www.geeksforgeeks.org/square-root-of-an-integer/
	 * 
	 * @param value
	 *            the value whose integer square root to be searched
	 * @return the integer square root of the value
	 */
	public int compute(int value) {
		
		if (value == 0 || value == 1)
			return value;
		 
		int result = -1;
		int left = 1;
		int right = value;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int squre = mid * mid;
			if (value == squre) {
				return mid;
			} else if (value < squre) {
				right = mid - 1;
			} else {
				// value > square
				// record current solution and continue looking for better
				// solution (i.e., bigger number whose square is less than or
				// equal to value)
				result = mid;
				left = mid + 1;
			}
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		ComputeIntegerSquareRoot c = new ComputeIntegerSquareRoot();
		System.out.println(c.compute(11));
		System.out.println(c.compute(21));
		System.out.println(c.compute(25));
		System.out.println(c.compute(300));
	}

}
