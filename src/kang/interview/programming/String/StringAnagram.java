package kang.interview.programming.String;

/**
 * 
 * @author YK044346
 *
 */
public class StringAnagram {

	public boolean compute_bf(String str1, String str2) {
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

	
}
