package kang.interview.programming.graph;

import java.util.HashSet;
import java.util.Set;

public class TransformStringToAnother_M {

	private static Set<String> dic = new HashSet<>();
	private static Set<String> track = new HashSet<>();

	static {
		dic.add("cot");
		dic.add("dog");
		dic.add("dag");
		dic.add("cov");
		dic.add("cat");
		dic.add("dav");
		dic.add("ddf");
		dic.add("dat");
	}

	public int canTransform(String s, String e, Set<String> dic, Set<String> track) {

		if (s.equals(e))
			return 0;

		Set<String> neighbors = getNeighbors(s, dic);

		boolean hasPath = false;
		int result = Integer.MAX_VALUE;
		for (String n : neighbors) {
			int temp = canTransform(n, e, dic, track);
			if (temp >= 0) {
				result = Math.min(result, temp);
				hasPath = true;
			}
		}

		return hasPath ? result + 1 : -1;

	}

	final char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 
						   'g', 'h', 'i', 'j', 'k', 
						   'l', 'm', 'n', 'o', 'p', 
						   'q', 'r', 's', 't', 'u', 
						   'v', 'w', 'x', 'y', 'z' };

	private Set<String> getNeighbors(String s, Set<String> dic) {
		Set<String> neighbors = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			// replacing character at position i with each character in chars
			for (char c : chars) {
				char[] newChar = s.toCharArray();
				if (c != newChar[i]) {
					newChar[i] = c;
					String neighbor = new String(newChar);

					// Only when the dictionary contains the created neighbor,
					// it is added the neighbor set
					if (dic.remove(neighbor))
						neighbors.add(neighbor);
				}
			}
		}
		return neighbors;
	}

	public static void main(String[] args) {
		
		TransformStringToAnother_M a = new TransformStringToAnother_M();
		dic.add("dot");
		track.add("bat");
		System.out.println(a.canTransform("bat", "dot", dic, track));
	}
}
