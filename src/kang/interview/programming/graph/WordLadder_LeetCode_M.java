package kang.interview.programming.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * LeetCode: 127. Word Ladder:
 * https://leetcode.com/problems/word-ladder/#/description
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * <ol>
 * <li>Only one letter can be changed at a time.</li>
 * <li>Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.</li>
 * </ol>
 * 
 * For example,
 * 
 * Given: beginWord = "hit" endWord = "cog"
 * 
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * <ul>
 * <li>Return 0 if there is no such transformation sequence.</li>
 * <li>All words have the same length.</li>
 * <li>All words contain only lowercase alphabetic characters.</li>
 * <li>You may assume no duplicates in the word list.</li>
 * <li>You may assume beginWord and endWord are non-empty and are not the same.
 * </li>
 * </ul>
 * UPDATE (2017/1/20): The wordList parameter had been changed to a list of
 * strings (instead of a set of strings). Please reload the code definition to
 * get the latest changes.
 * 
 * @author Yan Kang
 *
 */
public class WordLadder_LeetCode_M {
	
	/**
	 * Breadth First Search 
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Map<String, Boolean> map = new HashMap<>();  // Point 1
		for (String w : wordList) {
			map.put(w, true);
		}
		Queue<String> q = new LinkedList<>();
		getNeighbors(beginWord, map, q);
		int level = 2;
		int cn = q.size();
		int nn = 0;
		while(!q.isEmpty()){
			String word = q.remove();
			cn--;
			if(map.get(word)) { // Point 2
				map.put(word, false);  // Point 3
				if(word.equals(endWord)) {
					return level;
				} else {
					nn += getNeighbors(word, map, q);
				}
			}
			
			if (cn == 0) {
				cn = nn;
				nn = 0;
				level++;
			}
		}
		return 0;
	}

	private int getNeighbors(String word, Map<String, Boolean> map, Queue<String> queue) {
		int numOfN = 0;
		for (int j = 0; j < word.length(); j++) {
			for (int i = 0; i < 26; i++) {
				char r = (char) (i + 'a');
				if (word.charAt(j) != r) { // Point 4
					char[] chars = word.toCharArray();
					chars[j] = r;
					String neighbor = new String(chars);
					
					// Only when the dictionary contains the created neighbor,
					// it is added the neighbor set
					if (map.containsKey(neighbor)) { // Point 5
						numOfN++;
						queue.add(neighbor);
					}
				}
			}
		}
		return numOfN;
	}
	
	
	
	private Integer len = Integer.MAX_VALUE;
	/**
	 * Depth First Search. Passed Time Limit
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public int ladderLength_DFS(String beginWord, String endWord, List<String> wordList) {
		Set<String> words = new HashSet<>(wordList);
		find(beginWord, endWord, words, 1);
		return len == Integer.MAX_VALUE ? 0 : len;
	}

	private void find(String word, String endWord, Set<String> words, int l) {
		if (word.equals(endWord)) {
			len = Math.min(len, l);
			return;
		}

		for (String w : getNeighbors_(word, words)) {
			words.remove(w);
			find(w, endWord, words, l + 1);
			words.add(w);
		}
	}

	private List<String> getNeighbors_(String word, Set<String> words) {

		List<String> ret = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < word.length(); j++) {
				char c = (char) (i + 'a');
				if (c != word.charAt(j)) {
					
					//
					char[] chars = word.toCharArray();
					chars[j] = c;
					String str = new String(chars);
					if (words.contains(str)) {
						ret.add(str);
					}
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		WordLadder_LeetCode_M a = new WordLadder_LeetCode_M();
		
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		System.out.println(a.ladderLength("hit", "cog", wordList));
		
		List<String> wordList2 = Arrays.asList("a","b","c","lot","log","cog");
		System.out.println(a.ladderLength("a", "c", wordList2));
	}
}
