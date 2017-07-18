package kang.interview.programming.string;

import java.util.HashMap;
import java.util.Map;

public class RomanDecimalConverter {

	private static Map<Character, Integer> r2i  = new HashMap<Character, Integer>();
	
	static {
		System.out.println("here");
		r2i.put('I', 1);
		r2i.put('V', 5);
		r2i.put('X', 10);
		r2i.put('L', 50);
		r2i.put('C', 100);
		r2i.put('D', 500);
		r2i.put('M', 1000);
	}
	
	public int roman2integer(String input)
	{
		int length = input.length();

		if(length == 1)
			return -1;
		
		int i = length - 2;
		int sum = r2i.get(input.charAt(length - 1));
		for (; i >= 0; i--) {
            
			int value = r2i.get(input.charAt(i));
			int next = r2i.get(input.charAt(i+1));
			if(value < next) {
				sum -= value;
			} else {
				sum += value;
			}
		}
		return sum;
		
	}
	
	
	public static void main(String[] arg) {
		System.out.println("result");
		RomanDecimalConverter ora = new RomanDecimalConverter();
		int end = ora.roman2integer("IC");
		System.out.println(end );

	}


}
