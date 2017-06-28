package kang.interview.programming.heap.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

public class ComputeAllStringDecomposition {

	public List<Integer> compute(String sentence, List<String> words) {
		List<Integer> result = new ArrayList<Integer>();
		Map<String, Integer> track = indexWords(words);
		int stepUnit = 1;
		for (int i = 0; i <= sentence.length() - 3; i += stepUnit) {

			String substring = sentence.substring(i, i + 3);
			if (track.containsKey(substring) && track.get(substring) > 0) {
				stepUnit = 3;
				result.add(i);
				track.put(substring, track.get(substring) - 1);

				if (isEmpty(track))
					return result;

			} else {
				stepUnit = 1;
				if (!result.isEmpty()) {
					i = result.get(0);
					track = indexWords(words);
					result.clear();
				}
			}
		}

		return result;
	}

	private boolean isEmpty(Map<String, Integer> track) {
		for (int count : track.values()) {
			if (count > 0)
				return false;
		}
		return true;
	}

	private Map<String, Integer> indexWords(List<String> words) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		return map;
	}
	
	public static void main(String[] args) {
		String sentence = "amanaplanacanal";
		List<String> words = new ArrayList<>(3);
		words.add("can");
		words.add("apl");
		words.add("ana");
		
		ComputeAllStringDecomposition c = new ComputeAllStringDecomposition();
		DataPrinter.printList(c.compute(sentence, words));
		
	}

}
