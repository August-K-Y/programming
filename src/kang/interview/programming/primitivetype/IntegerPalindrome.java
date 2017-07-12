package kang.interview.programming.primitivetype;

/**
 * 
 * Elements of Programming P55 5.9
 * 
 * @author Yan Kang
 *
 */
public class IntegerPalindrome {

	/**
	 * By extracting least significant number. Time complexity O(n)
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPalindromNumber(int num) {
		if (num < 0)
			return false;

		if (num == 0)
			return true;

		int x = num;
		int y = 0;
		while (x != 0) {
			y = 10 * y + x % 10;
			x = x / 10;
		}
		return num == y;
	}
	
	/**
	 * 
	 * @param num
	 * @return
	 */
	public boolean isPalindromNumber_(int num) {
		if (num < 0)
			return false;

		if (num == 0)
			return true;

		// compute the number of digits of num
		int numDigits = (int) Math.floor(Math.log10(num)) + 1;

		// compute the most significant digit's mastk
		int msdMask = (int) Math.pow(10, numDigits - 1);

		while (num != 0) {
			if (num % 10 != num / msdMask)
				return false;

			// remove the most significant digit of num
			num = num % msdMask;
			// remove the least significant digit of num
			num = num / 10;
			// since the num has been removed two digits, the
			// msgMask should be also removed two digits.
			msdMask /= 100;
		}
		return true;
	}
	
	public static void main(String[] args) {
		IntegerPalindrome d = new IntegerPalindrome();
		System.out.println(d.isPalindromNumber(7));
		System.out.println(d.isPalindromNumber(0));
		System.out.println(d.isPalindromNumber(11));
		System.out.println(d.isPalindromNumber(121));
		System.out.println(d.isPalindromNumber(333));
		
		System.out.println(d.isPalindromNumber(12));
		System.out.println(d.isPalindromNumber(100));
		System.out.println(d.isPalindromNumber(-1));
		
		System.out.println("----------------");
		
		System.out.println(d.isPalindromNumber_(7));
		System.out.println(d.isPalindromNumber_(0));
		System.out.println(d.isPalindromNumber_(11));
		System.out.println(d.isPalindromNumber_(121));
		System.out.println(d.isPalindromNumber_(333));
		
		System.out.println(d.isPalindromNumber_(12));
		System.out.println(d.isPalindromNumber_(100));
		System.out.println(d.isPalindromNumber_(-1));
	}
}
