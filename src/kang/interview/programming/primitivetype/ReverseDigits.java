package kang.interview.programming.primitivetype;

/**
 * 
 * Elements of Programming P55 5.8
 * 
 * @author Yan Kang
 *
 */
public class ReverseDigits {

	public long reverse(int x) {

		boolean negative = x < 0;
		x = Math.abs(x);

		int y = 0;
		while (x != 0) {
			y = y * 10 + x % 10;
			x = x / 10;
		}

		return negative ? -y : y;
	}

	public static void main(String[] args) {
		ReverseDigits d = new ReverseDigits();
		System.out.println(d.reverse(0));
		System.out.println(d.reverse(-123));
		System.out.println(d.reverse(4321));
	}
}
