package kang.interview.programming.zhe;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array strings, determine whether it follows the sequence given in
 * the patterns array. In other words, there should be 
 * 	   NO i and j for which:
 * 	   strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which 
 *     strings[i] ≠ strings[j] and patterns[i] = patterns[j].
 * 
 * Example
 * 
 * For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], 
 * the output should be areFollowingPatterns(strings, patterns) = true; 
 * 
 * For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], 
 * the output should be areFollowingPatterns(strings, patterns) = false.
 * 
 * @author Yan Kang
 *
 */
public class FollowingPatterns_M {
	
	/**
	 * Brute force algorithm takes O(n^2)
	 * 
	 * @param strings
	 * @param patterns
	 * @return
	 */
	boolean areFollowingPatterns(String[] strings, String[] patterns) {
		for (int i = 0; i < strings.length; i++) {
			for (int j = i; j < strings.length; j++) {
				boolean p = patterns[i].equals(patterns[j]);
				if (p != strings[i].equals(strings[j]))
					return false;
			}
		}
		return true;
	}

	/**
	 * From CodeFight: this algorithm utilizes the core fact of the question:
	 * <br/>
	 * Each element in the strings array should be one-to-one matching with the
	 * element at the same position in the patterns array. By utilizing this
	 * fact, we can use two Maps to perform the one-to-one matching task, which
	 * makes this algorithm taking O(n) time
	 * 
	 * @param strings
	 * @param patterns
	 * @return
	 */
	boolean areFollowingPatterns_(String[] strings, String[] patterns) {

		HashMap<String, String> map = new HashMap<String, String>();
		HashMap<String, String> reverse = new HashMap<String, String>();

		for (int i = 0; i < strings.length; i++) {
			String pattern = patterns[i];
			if (map.containsKey(pattern)) {
				String value = map.get(pattern);
				if (!value.equals(strings[i])) {
					return false;
				}
			} else {
				if (reverse.containsKey(strings[i])) {
					if (!reverse.get(strings[i]).equals(pattern)) {
						return false;
					}
				}
			}
			
			// POINT: record the one to one matching
			map.put(pattern, strings[i]);
			reverse.put(strings[i], pattern);
		}
		return true;
	}
	
	/**
	 * This algorithm for relatively small patterns/strings, but it consumes a
	 * lot time when the strings/patterns are large. The whole using map to
	 * record pattern is not necessary.
	 * 
	 * @param strings
	 * @param patterns
	 * @return
	 */
	boolean areFollowingPatterns__(String[] strings, String[] patterns) {
		Map<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < patterns.length; i++) {
			for (int j = i; j < patterns.length; j++) {
				map.put(i + "-" + j, patterns[i].equals(patterns[j]));
			}
		}
		for (int i = 0; i < strings.length; i++) {
			for (int j = i; j < strings.length; j++) {
				if (!map.get(i + "-" + j).equals(strings[i].equals(strings[j])))
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		FollowingPatterns_M p = new FollowingPatterns_M();

		String[] strings = { "cat", "dog", "doggy" };
		String[] patterns = { "a", "b", "b" };
		System.out.println(p.areFollowingPatterns(strings, patterns));

	}
}
