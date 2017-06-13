package kang.interview.programming.String;

public class ReplaceAndRemove {
	
	/**
	 * <p>
	 * time complexity: O(n) </br>
	 * space complexity: O(n) </br>
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public String replaceAndRemove_bf(String str) {
		char[] chars = str.toCharArray();
		int length = calculateLength(chars);
		char[] copy = new char[length];
		
		int index = 0;
		for(char c : chars){
			if(c == 'a'){
				copy[index++] = 'd';
				copy[index++] = 'd';
			} else if (c != 'b') {
				copy[index++] = c;
			}
		} 
		return new String(copy);
	}
	
	
	/**
	 * <p>
	 * time complexity: O(n) </br>
	 * space complexity: O(1) </br>
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public String replaceAndRemove(char[] chars) {

		int count = 0;
		int slow = 0;

		for (char c : chars) {
			if (c == 'a') {
				count += 2;
				chars[slow++] = c;
			} else if (c != 'b') {
				chars[slow++] = c;
				count += 1;
			}
		}

		for (int i = slow - 1, j = count - 1; i >= 0; i--) {
			if (chars[i] == 'a') {
				chars[j--] = 'd';
				chars[j--] = 'd';
			} else {
				chars[j--] = chars[i];
			}
		}
		return new String(chars);
	}

	private int calculateLength(char[] chars) {
		int length = 0;
		for (char c : chars) {
			if (c == 'a') {
				length += 2;
			} else if (c != 'b') {
				length++;
			}
		}
		return length;
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		ReplaceAndRemove ora = new ReplaceAndRemove();
		String end = ora.replaceAndRemove_bf("acdbbca");
		System.out.println(end + ".");

		end = ora.replaceAndRemove("acdbbca      ".toCharArray());
		System.out.println(end + ".");
	}

}
