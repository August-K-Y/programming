package kang.interview.programming.string;

import java.util.HashMap;
import java.util.Map;

public class RomanDecimalConverter {

	public int roman2integer(String input) {
		
		Map<Character, Integer> r2i = new HashMap<Character, Integer>();
		r2i.put('I', 1);
		r2i.put('V', 5);
		r2i.put('X', 10);
		r2i.put('L', 50);
		r2i.put('C', 100);
		r2i.put('D', 500);
		r2i.put('M', 1000);

		int sum = 0;
		for (int i = 0; i < input.length() - 1; i++) {
			if (r2i.get(input.charAt(i)) < r2i.get(input.charAt(i + 1))) {
				sum -= r2i.get(input.charAt(i));
			} else {
				sum += r2i.get(input.charAt(i));
			}
		}
		return sum + r2i.get(input.charAt(input.length() - 1));
	}
	
	
	public static void main(String[] arg) {
		System.out.println("result");
		RomanDecimalConverter ora = new RomanDecimalConverter();
		int end = ora.roman2integer("IC");
		System.out.println(end );

	}


}
