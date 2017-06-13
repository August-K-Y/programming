package kang.interview.programming.heap.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FindNearestRepeatedEntriesInArray {
	
	public String find(String[] array) {

		Map<String, Integer> record = new HashMap<>();

		int min = array.length;
		String elem = array[0];
		record.put(elem, 0);
		for (int pos = 1; pos < array.length; pos++) {
			if (record.containsKey(array[pos])) {
				int dist = pos - record.get(array[pos]);
				if (dist < min) {
					min = dist;
					elem = array[pos];
				}
			}
			record.put(array[pos], pos);
		}

		return elem;

	}

}
