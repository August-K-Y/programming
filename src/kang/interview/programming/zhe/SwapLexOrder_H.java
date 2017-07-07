package kang.interview.programming.zhe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * Given a string str and array of pairs that indicates which indices in the
 * string can be swapped, return the lexicographically largest string that
 * results from doing the allowed swaps. You can swap indices any number of
 * times.
 * 
 * Example
 * 
 * For str = "abdc" and pairs = [[1, 4], [3, 4]], the output should be
 * swapLexOrder(str, pairs) = "dbca".
 * 
 * By swapping the given indices, you get the strings: "cbda", "cbad", "dbac",
 * "dbca". The lexicographically largest string in this list is "dbca".
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] string str
 * 
 * A string consisting only of lowercase English letters.
 * 
 * Guaranteed constraints: 
 * 		1 <= str.length <= 104.
 * 
 * [input] array.array.integer pairs
 * 
 * An array containing pairs of indices that can be swapped in str (1-based).
 * This means that for each pairs[i], you can swap elements in str that have the
 * indices pairs[i][0] and pairs[i][1].
 * 
 * Guaranteed constraints: 
 * 		0 <= pairs.length <= 5000, 
 * 		pairs[i].length = 2.
 * 
 * [output] string
 * 
 * @see kang.interview.programming.zhe.TheNextPermutation_M
 * @see https://www.careercup.com/question?id=5652404478410752
 * @see http://www.geeksforgeeks.org/lexicographic-permutations-of-string/
 * @see https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
 * @author Yan Kang
 *
 * This is a Facebook question
 */
public class SwapLexOrder_H {

	String swapLexOrder(String str, int[][] pairs) {
		List<Set<Integer>> lists = connect(pairs);
		char[] result = str.toCharArray();
		for (Set<Integer> set : lists) {
			char[] chars = new char[set.size()];
			int i = 0;
			for (int index : set) {
				chars[i] = result[index - 1];
				i++;
			}
			Arrays.sort(chars);
			for (int index : set) {
				result[index - 1] = chars[--i];
			}
		}
		return new String(result);
	}

	/**
	 * Group numbers in pairs that are connected.</br>
	 * <p>
	 * For example:</br>
	 * [1, 2] and [2, 7] are connected via the number 2. They will be put into a
	 * set [1,2,7].</br>
	 * [1, 3] and [4, 5] are not connected. They will be put into different
	 * sets.
	 * </p>
	 * 
	 * @param pairs
	 *            an array of integer pair
	 * @return a list of sets
	 */
	public List<Set<Integer>> connect(int[][] pairs) {
		List<Set<Integer>> lists = new ArrayList<Set<Integer>>();
		for (int[] p : pairs) {
			Set<Integer> set1 = null;
			Set<Integer> set2 = null;
			for (Set<Integer> set : lists) {
				if (set.contains(p[0]) || set.contains(p[1])) {
					if (set1 == null) {
						set1 = set;
					} else {
						set2 = set;
					}
					set.add(p[0]);
					set.add(p[1]);
				}
			}
			if (set1 == null) {
				Set<Integer> set = new TreeSet<Integer>();
				set.add(p[0]);
				set.add(p[1]);
				lists.add(set);
			} else if (set2 != null) {
				set1.addAll(set2);
				lists.remove(set2);
			}
		}
		return lists;
	}

	public static void main(String[] arg) {
		SwapLexOrder_H s = new SwapLexOrder_H();
		
		int[][] pairs = {{8,5}, 
						 {10,8}, 
						 {4,18}, 
						 {20,12}, 
						 {5,2}, 
						 {17,2}, 
						 {13,25}, 
						 {29,12}, 
						 {22,2}, 
						 {17,11}};
		String o = "fixmfbhyutghwbyezkveyameoamqoi";
		String e = "fzxmybhtuigowbyefkvhyameoamqei";
		String res = s.swapLexOrder(o, pairs);
		System.out.println("exp: " + e);
		System.out.println("str: " + res);
		System.out.println("equal: " + res.equals(e));
	}
	
	
	
	String swapLexOrder_(String str, int[][] pairs) {
	    char[] chars = str.toCharArray();
	    List<Set<Integer>> pools = new ArrayList<>();
	    for( int[] pair : pairs ){
	        List<Set<Integer>> foundPools = new ArrayList<>();
	        for( Set<Integer> pool : pools ){
	            if(pool.contains(pair[0]) || pool.contains(pair[1])){
	                foundPools.add(pool);
	            }
	        }
	        if(foundPools.size() == 0){
	            Set<Integer> newPool = new TreeSet<>();
	            newPool.add(pair[0]);
	            newPool.add(pair[1]);
	            pools.add(newPool);
	        }else if(foundPools.size() == 1){
	            int i = 0;
	            Set<Integer> pool = foundPools.get(0);
	            if(pool.contains(pair[i]) || pool.contains(pair[++i])){
	                pool.add(pair[1-i]);
	            }
	        }else if(foundPools.size() == 2){
	            foundPools.get(0).addAll(foundPools.get(1));
	            pools.remove(foundPools.get(1));
	        }else throw new RuntimeException("Merge Error");
	    }    
	    
	    for( Set<Integer> pool : pools ){
	        char[] possibles = new char[pool.size()];
	        int i = 0;
	        for( int pos : pool ){
	            possibles[i++] = chars[pos-1];
	        }
	        Arrays.sort(possibles);
	        for( int pos : pool ){
	            chars[pos-1] = possibles[--i];
	        }
	    }
	    
	    return new String(chars);
	}
	
	
	String swapLexOrder__(String string, int[][] pairs) {
	    char[] s = string.toCharArray();
	    int n = s.length;
	    
	    List<Integer>[] edges = new List[n];
	    for (int i = 0; i < n; ++i) edges[i] = new ArrayList<>();
	    for (int[] pair : pairs) {
	        edges[pair[0] - 1].add(pair[1] - 1);
	        edges[pair[1] - 1].add(pair[0] - 1);
	    }
	    
	    boolean[] visited = new boolean[n];
	    for (int i = 0; i < visited.length; ++i) {
	        if (visited[i]) continue;
	        
	        List<Integer> groupIndices = new ArrayList<>();
	        generateGroup(i, edges, visited, groupIndices);
	        if (groupIndices.size() == 1) continue;
	        Collections.sort(groupIndices);
	        
	        char[] chars = new char[groupIndices.size()];
	        for (int j = 0; j < chars.length; ++j) {
	            chars[j] = s[groupIndices.get(j)];
	        }
	        Arrays.sort(chars);
	        for (int j = 0; j < chars.length / 2; ++j) {
	            char tmp = chars[j];
	            chars[j] = chars[chars.length - j - 1];
	            chars[chars.length - j - 1] = tmp;
	        }
	            
	        for (int j = 0; j < chars.length; ++j) {
	            s[groupIndices.get(j)] = chars[j];
	        }
	    }
	    
	    return new String(s);
	}

	void generateGroup(int v, List<Integer>[] edges, boolean[] visited, List<Integer> result) {
	    visited[v] = true;
	    result.add(v);
	    
	    for (int toV : edges[v]) {
	        if (!visited[toV]) {
	            generateGroup(toV, edges, visited, result);
	        }
	    }
	}

}
