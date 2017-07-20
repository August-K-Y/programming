package kang.interview.programming.primitivetype;

import java.util.Arrays;

import kang.interview.programming.util.DataPrinter;

public class AddOne {
	public int[] plusOne(int[] digits) {
		int[] r = new int[digits.length + 1];
		int carry = 0;
		int i = digits.length - 1;
		for (; i >= 0; i--) {
			int sum = carry + digits[i] + ((i == digits.length - 1) ? 1 : 0);
			int res = sum % 10;
			carry = sum / 10;
			r[i + 1] = res;
		}
		if (carry > 0) {
			r[i + 1] = carry;
		}
		return carry > 0 ? r : Arrays.copyOfRange(r, 1, r.length);
	}

	public static void main(String[] arg) {
		int[] d = { 9, 9 };
		int[] d2 = { 9, 8 };
		AddOne alg = new AddOne();
		DataPrinter.printArray(alg.plusOne(d));
		System.out.println();
		DataPrinter.printArray(alg.plusOne(d2));
	}
}
