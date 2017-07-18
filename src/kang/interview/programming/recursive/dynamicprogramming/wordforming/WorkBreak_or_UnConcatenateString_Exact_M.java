package kang.interview.programming.recursive.dynamicprogramming.wordforming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import kang.interview.programming.recursive.dynamicprogramming.wordforming.WorkBreak_or_UnConcatenateString_Fuzzy_H.Result;
import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode: 140. Word Break II:
 * https://leetcode.com/problems/word-break-ii/#/description
 * 
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, add spaces in s to construct a sentence where each word is a
 * valid dictionary word. You may assume the dictionary does not contain
 * duplicate words.
 * 
 * Return all such possible sentences.
 * 
 * For example, given 
 * s = "catsanddog", 
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * UPDATE (2017/1/4): The wordDict parameter had been changed to a list of
 * strings (instead of a set of strings). Please reload the code definition to
 * get the latest changes.
 * 
 * 
 * @author Yan Kang
 *
 */
public class WorkBreak_or_UnConcatenateString_Exact_M {
	public static class Result {
		boolean canBreak;
		LinkedList<String> str;

		public Result(boolean canBreak) {
			this.canBreak = canBreak;
			str = new LinkedList<>();
		}
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		Result[] R = new Result[s.length() + 1];

		R[0] = new Result(true);
		R[0].str.add("");

		for (int i = 1; i <= s.length(); i++) {
			R[i] = new Result(false);
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= i; j++) {
				if (R[j - 1].canBreak && wordDict.contains(s.substring(j - 1, i))) {

					R[i].canBreak = true;
					String ss = s.substring(j - 1, i);

					for (String e : R[j - 1].str) {
						R[i].str.add(concat(e, ss));
					}
				}
			}
		}
		return R[s.length()].str;
	}

	private String concat(String e, String ss) {
		return (e + " " + ss).trim();
	}
	
	
	/**
	 * 
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public List<String> wordBreak_(String s, List<String> wordDict) {
	    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
	}       

	// DFS function returns an array including all substrings derived from s.
	List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
	    if (map.containsKey(s)) 
	        return map.get(s);
	        
	    LinkedList<String>res = new LinkedList<String>();     
	    if (s.length() == 0) {
	        res.add("");
	        return res;
	    }               
	    for (String word : wordDict) {
	        if (s.startsWith(word)) {
	            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
	            for (String sub : sublist) 
	                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
	        }
	    }       
	    map.put(s, res);
	    return res;
	}

	public static void main(String[] args) {
		WorkBreak_or_UnConcatenateString_Exact_M alg = new WorkBreak_or_UnConcatenateString_Exact_M();

		String s = "catsanddog";
		List<String> dict = new ArrayList<>();
		dict.add("cat");
		dict.add("cats");
		dict.add("and");
		dict.add("sand");
		dict.add("dog");

		DataPrinter.printList(alg.wordBreak(s, dict));
	}

}
