package kang.interview.programming.string;

import java.util.Arrays;

public class StringAnagram {

	public boolean isAnagram_bf(String str1, String str2) {
		int[] counter1 = new int[256];
		for (char c : str1.toCharArray()) {
			counter1[c]++;
		}
		for (char c : str2.toCharArray()) {
			if (--counter1[c] < 0)
				return false;
		}
		return true;
	}
	
	public boolean isAnagramBySort(String str1, String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str1.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2); 
		return new String(chars2).equals(new String(chars1)); 
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		StringAnagram ora = new StringAnagram();
		boolean end = ora.isAnagramBySort("abcdefg", "gfedcba");
		System.out.println(end);
	}

	
}
