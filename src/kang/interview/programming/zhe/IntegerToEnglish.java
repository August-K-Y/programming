package kang.interview.programming.zhe;

import java.util.HashMap;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

public class IntegerToEnglish {
	private Map<Integer, String> map = new HashMap<>();

	public String numberToWords(int num) {

		map.put(0, "Zero");
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		map.put(7, "Seven");
		map.put(8, "Eight");
		map.put(9, "Nine");

		map.put(10, "Ten");
		map.put(11, "Eleven");
		map.put(12, "Twelve");
		map.put(13, "Thirteen");
		map.put(14, "Fourteen");
		map.put(15, "Fifteen");
		map.put(16, "Sixteen");
		map.put(17, "Seventeen");
		map.put(18, "Eighteen");
		map.put(19, "Nineteen");

		map.put(20, "Twenty");
		map.put(30, "Thirty");
		map.put(40, "Forty");
		map.put(50, "Fifty");
		map.put(60, "Sixty");
		map.put(70, "Seventy");
		map.put(80, "Eighty");
		map.put(90, "Ninety");

		map.put(1000, "Thousand");
		map.put(1000000, "Million");
		map.put(1000000000, "Billion");
		StringBuilder sb = new StringBuilder();
		parseAll(num, sb);
		return sb.toString().trim();
	}

	private void parseAll(int num, StringBuilder sb) {
		if (num == 0) {
			sb.append(map.get(0));
			return;
		}

		int div = 1000000000;
		int res = num % div;
		num = num / div;
		while (num == 0) {
			div = div / 1000;
			num = res / div;
			res = res % div;
		}
		while ((res > 0 || num > 0) && div >= 1000) {
			if (num > 0) {
				parseHundred(num, sb);
				sb.append(" " + map.get(div));
			}
			div = div / 1000;
			num = res / div;
			res = res % div;
		}

		if (num > 0) {
			parseHundred(num, sb);
		}
	}

	private void parseHundred(int num, StringBuilder sb) {
		int v = num / 100;
		int r = num % 100;
		if (v >= 1)
			sb.append(" " + map.get(v) + " Hundred");

		if (r > 0)
			parse(r, sb);
	}

	private void parse(int num, StringBuilder sb) {
		int v = num / 10;
		int r = num % 10;
		if (v >= 2) {
			sb.append(" " + map.get(v * 10));
			if (r > 0) {
				sb.append(" " + map.get(r));
			}
		} else if (v == 1) {
			sb.append(" " + map.get(num));
		} else if (r > 0) {
			// v == 0 and r > 0
			sb.append(" " + map.get(r));
		}
	}
	
	
	
	private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };
	private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

	public String numberToWords_(int num) {
		if (num == 0)
			return "Zero";

		int i = 0;
		String words = "";

		while (num > 0) {
			if (num % 1000 != 0)
				words = helper(num % 1000) + THOUSANDS[i] + " " + words;
			num /= 1000;
			i++;
		}

		return words.trim();
	}

	private String helper(int num) {
		if (num == 0)
			return "";
		else if (num < 20)
			return LESS_THAN_20[num] + " ";
		else if (num < 100)
			return TENS[num / 10] + " " + helper(num % 10);
		else
			return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
	}
	
	public static void main(String[] args) {
		IntegerToEnglish alg = new IntegerToEnglish();
		DataPrinter.println(alg.numberToWords(0)); // "Zero"
		DataPrinter.println(alg.numberToWords(1000)); // "One Thousand"
		DataPrinter.println(alg.numberToWords(123)); // "One Hundred Twenty Three"
		DataPrinter.println(alg.numberToWords(12345)); // "Twelve Thousand Three Hundred Forty Five"
		DataPrinter.println(alg.numberToWords(1234567)); // "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
		DataPrinter.println(alg.numberToWords(1001)); // "One Thousand One"
		DataPrinter.println(alg.numberToWords(1000010)); // "One Million Ten"
		
	}
}
