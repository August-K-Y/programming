package kang.interview.programming.string;

public class LookAndSay_M {

	/**
	 * e.g., 1, 11, 21, 1211, 111221,312211,13112221,1113213211
	 * 
	 * @param val
	 * @return
	 */
	public String lookAndSayRecursively(int val) {
		if (val <= 0)
			return "";
		char[] chars = "1".toCharArray();
		return doWork(chars, val - 1);
	}

	private String doWork(char[] chars, int nth) {
		if (nth == 0) {
			return new String(chars);
		} 
		
		String v = null;
		if (chars.length == 1) {
			// corner case: only one digit
			v = "1" + chars[0];
		} else {
			int count = 1;
			char prev = chars[0];
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < chars.length; i++) {
				if (chars[i] == prev) {
					count++;
					prev = chars[i];
				} else {
					// Change Point : when number changed
					sb.append(count).append(prev);
					count = 1;
					prev = chars[i];
				}
			}
			// corner case: the last group of digit
			sb.append(count).append(prev);
			v = sb.toString();
		}

		return doWork(v.toCharArray(), nth - 1);
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		LookAndSay_M ora = new LookAndSay_M();
		String end = ora.lookAndSayRecursively(1);
		System.out.println(end);
		end = ora.lookAndSayRecursively(8);
		System.out.println(end);
		end = ora.lookAndSayRecursively(12);
		System.out.println(end);
	}
}
