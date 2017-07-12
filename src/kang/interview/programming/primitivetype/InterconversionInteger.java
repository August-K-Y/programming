package kang.interview.programming.primitivetype;

public class InterconversionInteger {

	public String convert(int input) {
		boolean negative = input < 0;
		input = Math.abs(input);

		StringBuilder sb = new StringBuilder();
		while (input != 0) {
			sb.append(input % 10);
			input = input / 10;
		}
		if (negative)
			sb.append("-");
		sb.reverse();
		return sb.toString();
	}
	
	public int convert(String input) {
		boolean negative = input.charAt(0) == '-';
		if(negative) input = input.substring(1);
		int y = 0;
		for (char c : input.toCharArray()) {
			y = 10 * y + (c - '0');
		}
		return negative ? -y : y;
	}
	
	public static void main(String[] args) {
		InterconversionInteger alg = new InterconversionInteger();
		System.out.println(alg.convert(123));
		System.out.println(alg.convert(-3331122));
		System.out.println(alg.convert(-1));
		System.out.println(alg.convert(7));
		
		System.out.println(alg.convert("123"));
		System.out.println(alg.convert("-3331122"));
		System.out.println(alg.convert("-1"));
		System.out.println(alg.convert("7"));
	}

}
