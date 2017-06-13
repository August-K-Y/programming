package kang.interview.programming.String;

public class StringNumberConverter {

	public String intToString_bf(int number) {
		StringBuilder sb = new StringBuilder();
		if(number < 0){
			number = -number;
			sb.append('-');
		} 
		
		// 
		int dominator = 10;
		while (number / dominator >= 10) {
			dominator *= 10;
		}
		
		//
		while (dominator != 0) {
			sb.append((char) ('0' + number / dominator));
			number = number % dominator;
			dominator = dominator / 10;
		}
		return sb.toString();
	}
	
	public String intToStringByReverse(int number) {
		StringBuilder sb = new StringBuilder();
		boolean isNegative = false;
		if (number < 0) {
			number = -number;
			isNegative = true;
		}

		do {
			sb.append((char) ('0' + number % 10));
			number /= 10;
		} while (number != 0);

		if (isNegative)
			sb.append('-');

		return sb.reverse().toString();
	}
	
	public String doubleToString(double number){
		return null;
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		StringNumberConverter ora = new StringNumberConverter();
		String end = ora.intToStringByReverse(-9876);
		System.out.println(end);
	}
}
