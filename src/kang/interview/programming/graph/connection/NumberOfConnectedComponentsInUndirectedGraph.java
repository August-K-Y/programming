package kang.interview.programming.graph.connection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 323. Number of Connected Components in an Undirected Graph:
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to find the number of connected
 * components in an undirected graph.
 * 
 * Example 1:
 * 
 * 0           3 
 * |           | 
 * 1 --- 2     4
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * 
 * Example 2:
 * 
 * 0           4 
 * |           | 
 * 1 --- 2 --- 3
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Note: You can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * @author Yan Kang
 *
 */
public class NumberOfConnectedComponentsInUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		if (edges == null || edges.length == 0)
			return n;

		List<Set<Integer>> list = new LinkedList<>();

		for (int[] edge : edges) {
			Set<Integer> set1 = null;
			Set<Integer> set2 = null;

			for (Set<Integer> set : list) {

				if (set.contains(edge[0]) || set.contains(edge[1])) {

					if (set1 == null) {
						set1 = set;
					} else {
						set2 = set;
					}
					set1.add(edge[0]);
					set1.add(edge[1]);
				}
			}

			if (set1 == null) {
				set1 = new HashSet<>();
				set1.add(edge[0]);
				set1.add(edge[1]);
				list.add(set1);
			} else if (set2 != null) {
				set1.addAll(set2);
				list.remove(set2);
			}
		}

		int count = 0;
		for (Set<Integer> set : list) {
			count += set.size();
		}
		return list.size() + n - count;

	}
}
