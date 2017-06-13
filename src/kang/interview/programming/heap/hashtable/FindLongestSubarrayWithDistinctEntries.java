package kang.interview.programming.heap.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kang.interview.programming.heap.hashtable.FindSmallestSubarrayCoveringAllValues.Subarray;

public class FindLongestSubarrayWithDistinctEntries {

	public Subarray find(List<String> list) {
		Set<String> tracker = new HashSet<>();

		Subarray subarray = new Subarray(-1, -1);
		int start = 0;
		int end = 0;
		int maxRange = 0;
		while (end < list.size()) {
			String word = list.get(end);
			if (tracker.contains(word)) {
				
				// When reach the duplicate word, the while loop stops
				while (!list.get(start).equals(word)) {
					tracker.remove(word);
					start++;
				}

				// Skip the duplicate word
				start++;

			} else {
				tracker.add(word);
			}
			if (end - start > maxRange) {
				System.out.println("(" + start + ", " + end + ")" + ": " + list.get(start) + " -> " + list.get(end)
						+ " , " + (end - start));
				subarray.start = start;
				subarray.end = end;
				maxRange = end - start;
			}
			end++;
		}
		return subarray;
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("f");
		list.add("s");
		list.add("f");
		list.add("e");
		list.add("t");
		list.add("w");
		list.add("e");
		list.add("n");
		list.add("w");
		list.add("e");

		FindLongestSubarrayWithDistinctEntries f = new FindLongestSubarrayWithDistinctEntries();
		Subarray subarray1 = f.find(list);
		print(subarray1);
	}

	private static void print(Subarray subarray) {
		System.out.println(subarray.start + " -> " + subarray.end);
	}
}
