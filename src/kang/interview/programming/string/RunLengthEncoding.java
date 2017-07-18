package kang.interview.programming.string;

public class RunLengthEncoding {

	/**
	 * brute-force implementation
	 * <p>
	 * time complexity O(n) </br>
	 * space complexity O(n)
	 * </p>
	 * 
	 * @param chars
	 * @return
	 */
	public String encode_bf(char[] chars)
	{
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if ((i + 1) < chars.length && chars[i] == chars[i + 1]) {
				count++;
			} else {
				sb.append(count);
				sb.append(chars[i]);
				count = 1;
			}
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public String decode(String input) {

		char[] chars = input.toCharArray();
		StringBuilder sb = new StringBuilder();

		// TODO pitfall: should consider the scenario that the count is more
		// than one digit
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (Character.isDigit(c)) {
				count = count * 10 + c - '0';
			} else {
				for (; count > 0; count--) {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Two pass run to reduce the space complexity
	 * <p>
	 * time complexity O(n) </br>
	 * space complexity O(1)
	 * </p>
	 * 
	 * @param chars
	 * @return
	 */
	public String encode(char[] chars, int length)
	{
		int count = 1;
		int numOfSingle = 0;
		
		int j = 0;
		for (int i = 0; i < length; i++) {
			if ((i + 1) < length && chars[i] == chars[i + 1]) {
				count++;
			} else {
				if (count > 1) {
					chars[j++] = (char) (count + '0');
				} else if (count == 1) {
					numOfSingle++;
				}
				chars[j++] = chars[i];
				count = 1;
			}
		}

		int newLength = j + numOfSingle;
		j = j - 1;
		int i = newLength - 1;
		for (; j >= 0; j--) {
			chars[i--] = chars[j];
			if (!Character.isDigit(chars[j]) && !Character.isDigit(chars[j - 1])) {
				chars[i--] = 1 + '0';
			}
		}
		return new String(chars, 0, newLength);
	}

	public static void main(String[] arg) {
		RunLengthEncoding ora = new RunLengthEncoding();
		String input = "aaaabcccaa                   ";
		String result = ora.encode(input.toCharArray(), input.trim().length());
		System.out.println(result);
		result = ora.encode_bf(input.trim().toCharArray());
		System.out.println(result);
		result = ora.decode(result);
		System.out.println(result);
		
		char c = 9 + '0';
		System.out.println(c);
	}
}
