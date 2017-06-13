package kang.interview.programming.heap.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindSmallestSubarrayCoveringAllValues {

	public static class Subarray {
		public int start;
		public int end;

		public Subarray(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	/**
	 * O(n^2)
	 * 
	 * @param paragraph
	 * @param keywords
	 * @return
	 */
	public Subarray find_withQuadraticTime(List<String> paragraph, Set<String> keywords) {

		Subarray subarray = new Subarray(-1, -1);
		Set<String> record = null;
		int minRange = Integer.MAX_VALUE;
		for (int i = 0; i < paragraph.size(); i++) {
			record = new HashSet<>(keywords);
			int j = i;
			for (; j < paragraph.size(); j++) {
				if (record.contains(paragraph.get(j)))
					record.remove(paragraph.get(j));

				if (record.isEmpty())
					break;
			}

			if (j < paragraph.size() && j - i < minRange) {
				minRange = j - i;
				subarray.start = i;
				subarray.end = j;
			}
		}
		return subarray;
	}

	/**
	 * 
	 * @param paragraph
	 * @param keywords
	 * @return
	 */
	public Subarray find_withLinearTime(List<String> paragraph, Set<String> keywords) {

		Set<String> copy = new HashSet<>(keywords);
		Map<String, Integer> tracker = new HashMap<>();
		int length = paragraph.size();
		int start = 0;
		int end = -1;
		for (int i = 0; i < length; i++) {

			String word = paragraph.get(i);
			if (copy.remove(word)) {
				tracker.put(word, 1);
			} else {
				if (tracker.containsKey(word)) {
					tracker.put(word, tracker.get(word) + 1);
				}
			}

			System.out.println("size " + copy.size());
			if (copy.isEmpty()) {
				end = i;
				System.out.println("here");
				break;
			}
		}

		if (end == -1)
			return new Subarray(-1, -1);

		Subarray subArray = new Subarray(start, end);
		int minRange = end - start;
		/*
		 * Invariant: tracker contains all the word in keywords set.
		 * 
		 * Move start and end index while maintain the invariant at the same
		 * time. More specifically, when the problem is a minimization problem,
		 * pin the end index and forward the start index. Only when the
		 * invariant is violated, forward the end index and do necessary
		 * computation to satisfy the invariant. Similarly, if the problem is a
		 * maximization problem, pin the start index and forward the end index.
		 * Only when the invariant is violated, forward start index and do the
		 * necessary computation to satisfy the invariant.
		 */
		while (end < paragraph.size()) {
			System.out.println("minRange: " + minRange);
			System.out.println("start: " + start);
			System.out.println("end: " + end);
			String word = paragraph.get(start);
			start++;
			if (keywords.contains(word)) {
				int count = tracker.get(word);
				if (count > 1) {
					tracker.put(word, tracker.get(word) - 1);
				} else {
					while (end < paragraph.size() && !paragraph.get(end).equals(word)) {
						end++;
					}
					
					//
					
				}
			}

			if (end < paragraph.size() && end - start < minRange) {
				subArray.start = start;
				subArray.end = end;
			}

		}
		return subArray;
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("apple");
		list.add("banana");
		list.add("apple");
		list.add("apple");
		list.add("dog");
		list.add("cat");
		list.add("apple");
		list.add("dog");
		list.add("banana");
		list.add("apple");
		list.add("cat");
		list.add("dog");

		List<String> list2 = new ArrayList<>();
		list2.add("cat");
		list2.add("cat");
		list2.add("cat");
		list2.add("cat");
		list2.add("banana");
		
		List<String> list3 = new ArrayList<>();
		list3.add("cat");
		list3.add("cat");
		list3.add("cat");
		list3.add("dog");
		list3.add("banana");
		list3.add("cat");

		Set<String> keywords = new LinkedHashSet<>();
		keywords.add("banana");
		keywords.add("cat");

		FindSmallestSubarrayCoveringAllValues f = new FindSmallestSubarrayCoveringAllValues();
		// Subarray subarray1 = f.find_withQuadraticTime(list, keywords);
		// print(subarray1);
		
//		 Subarray subarray2 = f.find_withLinearTime(list, keywords);
//		 print(subarray2);

//		Subarray subarray3 = f.find_withLinearTime(list2, keywords);
//		print(subarray3);
		
		Subarray subarray4 = f.find_withLinearTime(list3, keywords);
		print(subarray4);
	}

	private static void print(Subarray subarray) {
		System.out.println(subarray.start + " -> " + subarray.end);
	}
}
