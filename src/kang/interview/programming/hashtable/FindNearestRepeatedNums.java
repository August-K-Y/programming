package kang.interview.programming.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums, find the num that appears multiple times in
 * the array and two of which have the smallest distance in terms of index
 * 
 * Example
 * 
 * For nums = [0, 1, 2, 3, 3 2], the output should be find(nums) = 3.
 * 
 * @see ContainsCloseNums
 * 
 * @author Yan Kang
 *
 */
public class FindNearestRepeatedNums {
	
	public String find(String[] array) {

		Map<String, Integer> map = new HashMap<>();

		int min = array.length;
		String elem = null;
		for (int pos = 0; pos < array.length; pos++) {
			if (map.containsKey(array[pos])) {
				int dist = pos - map.get(array[pos]);
				if (dist < min) {
					min = dist;
					elem = array[pos];
				}
			}
			map.put(array[pos], pos);
		}

		return elem;

	}

}
