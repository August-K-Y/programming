package kang.interview.programming.string;

public class StringReverse {

	/**
	 * 
	 * @param str
	 * @return
	 */
	public String reverse(String str) {
		char[] chars = str.toCharArray();

		int back = chars.length - 1;
		int front = 0;
		reverse(chars, front, back);

		int fast = 0;
		int slow = 0;

		for (; fast < chars.length; fast++) {
			if (chars[fast] == ' ') {
				reverse(chars, slow, fast - 1);
				slow = fast + 1;
			} 
			// corner case: the last word
			else if (fast == chars.length - 1) {
				reverse(chars, slow, fast);
				fast++;
				slow = fast + 1;
			}
		}

		return new String(chars);
	}

	private void reverse(char[] chars, int front, int back) {
		while (front <= back) {
			swap(chars, front, back);
			front++;
			back--;
		}
	}

	private void swap(char[] chars, int front, int back) {
		char temp = chars[front];
		chars[front] = chars[back];
		chars[back] = temp;
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		StringReverse ora = new StringReverse();
		String end = ora.reverse("Alice likes Bob");
		System.out.println(end);
		end = ora.reverse("beautiful so are you");
		System.out.println(end);
	}
}
