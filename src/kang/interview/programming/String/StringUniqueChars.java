package kang.interview.programming.String;

public class StringUniqueChars {

	public boolean compute_bf(String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i + 1; j < chars.length; j++) {
				if (chars[i] == chars[j])
					return false;
			}
		}
		return true;
	}

	public boolean compute(String str) {
		char[] chars = str.toCharArray();
		int[] counter = new int[256]; // all elements are initialized to zero
		for (int i = 0; i < chars.length; i++) {
			counter[chars[i]]++;
			if (counter[chars[i]] > 1)
				return false;
		}
		return true;
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		StringUniqueChars ora = new StringUniqueChars();
		boolean end = ora.compute("abcdefg");
		System.out.println(end);
		
		end = ora.compute("abcdefcg");
		System.out.println(end);
	}

}
