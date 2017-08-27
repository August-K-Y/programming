package kang.interview.programming.graph.topologicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 269. Alien Dictionary:
 * https://leetcode.com/problems/alien-dictionary/description/
 * 
 * There is a new alien language which uses the latin alphabet. However, the
 * order among letters are unknown to you. You receive a list of non-empty words
 * from the dictionary, where words are sorted lexicographically by the rules of
 * this new language. Derive the order of letters in this language.
 * 
 * Example 1: Given the following words in dictionary,
 * 
 * [ "wrt", "wrf", "er", "ett", "rftt" ] The correct order is: "wertf".
 * 
 * Example 2: Given the following words in dictionary,
 * 
 * [ "z", "x" ] The correct order is: "zx".
 * 
 * Example 3: Given the following words in dictionary,
 * 
 * [ "z", "x", "z" ] The order is invalid, so return "".
 * 
 * Note: 
 * You may assume all letters are in lowercase. 
 * You may assume that if a is a prefix of b, then a must appear before b in the given dictionary. 
 * If the order is invalid, return an empty string. 
 * There may be multiple valid order of letters, return any one of them is fine.
 * 
 * @author Yan Kang
 *
 */
public class AlienDictionary {

	public String alienOrder(String[] words) {
		if (words == null || words.length == 0)
			return "";

		Map<Character, Set<Character>> map = new HashMap<>();
		Map<Character, Integer> indegree = new HashMap<>();

		for (String s : words) {
			for (char c : s.toCharArray()) {
				indegree.put(c, 0);
			}
		}

		/*
		 * left-aligned each word, characters in each column are sorted
		 * lexicographically
		 */
		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			int minLen = Math.min(word1.length(), word1.length());
			for (int j = 0; j < minLen; j++) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);
				if (c1 != c2) {
					Set<Character> set = null;
					if (map.containsKey(c1)) {
						set = map.get(c1);
					} else {
						set = new HashSet<>();
						map.put(c1, set);
					}
					
					//
					if (!set.contains(c2)) {
						set.add(c2);
						indegree.put(c2, indegree.get(c2) + 1);
					}
					break;
				}
			}
		}

		// topological sort
		return topologicalSort(map, indegree);
	}

	/**
	 * 
	 * @param adj
	 * @param indegree
	 * @return
	 */
	private String topologicalSort(Map<Character, Set<Character>> adj, Map<Character, Integer> indegree) {

		//
		Queue<Character> queue = new LinkedList<>();
		for (char c : indegree.keySet()) {
			if (indegree.get(c) == 0)
				queue.add(c);
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			char c = queue.poll();
			sb.append(c);

			//
			if (adj.containsKey(c)) {
				
				//
				for (char a : adj.get(c)) {
					indegree.put(a, indegree.get(a) - 1);
					if (indegree.get(a) == 0)
						queue.add(a);
				}
			}
		}
		// when all node are in the string builder, it is valid. Otherwise, it
		// is invalid since loop exists
		return sb.length() == indegree.size() ? sb.toString() : "";
	}

	public static void main(String[] args) {

		AlienDictionary alg = new AlienDictionary();
		String[] words = { "wrt", "wrf", "er", "ett", "rftt" };
		String[] words2 = { "z", "x" };
		String[] words3 = { "z", "x", "z" };
		String[] words4 = { "wrt", "wrtkj" };
		String[] words5 = { "za", "zb", "ca", "cb" };

		// List<String> list = Arrays.asList(words4);
		// List<List<Character>> lists = new LinkedList<>();
		// alg.createList(list, lists);
		// DataPrinter.print2DList(lists);

		DataPrinter.println(alg.alienOrder(words)); // wertf
		DataPrinter.println(alg.alienOrder(words2)); // zx
		DataPrinter.println(alg.alienOrder(words3)); // ""
		DataPrinter.println(alg.alienOrder(words4)); // jkrtw
		DataPrinter.println(alg.alienOrder(words5)); // azbc
	}
}
