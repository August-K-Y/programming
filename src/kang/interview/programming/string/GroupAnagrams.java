package kang.interview.programming.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * LeetCode 49. Group Anagrams:
 * https://leetcode.com/problems/group-anagrams/#/description
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ 
 * 	["ate", "eat","tea"], 
 *  ["nat","tan"], 
 *  ["bat"] 
 * ]
 *   
 * Note: All inputs will be in lower-case.
 * 
 * @author Yan Kang
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new LinkedList<>();
		if(strs == null || strs.length == 0)
			return result;
		
		Map<String, List<String>> map = new LinkedHashMap<>();
		
		for(String str : strs) {
			String code = getCode(str);
			
            // if(map.containsKey(code)){
            //     map.get(code).add(str);
            // } else {
            //     List<String> list = new LinkedList<>();
            //     list.add(str);
            //     map.put(code, list);
            // }
            
            if(!map.containsKey(code)) map.put(code, new LinkedList<>());
            map.get(code).add(str);
		}
		result.addAll(map.values());
		return result;
	}
	
	private String getCode(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	
	/**
	 * From LeetCode: exactly the same algorithm as the previous one. It is
	 * shorter but not necessarily more efficient.
	 * 
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams_(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr))
				map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(s);
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	public static void main(String[] args){
		GroupAnagrams alg = new GroupAnagrams();
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		
		DataPrinter.print2DList(alg.groupAnagrams(strs));
	}
}
