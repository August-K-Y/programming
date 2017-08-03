package kang.interview.programming.graph.connection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode: 261. Graph Valid Tree:
 * https://leetcode.com/problems/graph-valid-tree/description/
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 * 
 * Note: you can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 * 
 * @author Yan Kang
 *
 */
public class GraphValidTree {

	public boolean validTree(int n, int[][] edges) {
		if (edges == null || edges.length == 0)
			return n == 1;

		List<Set<Integer>> list = new LinkedList<>();

		for (int[] edge : edges) {
			Set<Integer> set1 = null;
			Set<Integer> set2 = null;
			
			for (Set<Integer> set : list) {
				if (set.contains(edge[0]) && set.contains(edge[1]))
					return false;

				if (set.contains(edge[0]) || set.contains(edge[1])) {
					if (set1 == null) {
						set1 = set;
					} else {
						set2 = set;
					}
					set.add(edge[0]);
					set.add(edge[1]);
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

		return list.size() == 1 && list.get(0).size() == n;
	}

	public static void main(String[] args) {
		GraphValidTree alg = new GraphValidTree();

		int[][] edges = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 } };
		DataPrinter.println(alg.validTree(5, edges)); // true

		int[][] edges2 = { { 0, 1 }, { 2, 3 }, { 1, 2 } };
		DataPrinter.println(alg.validTree(4, edges2)); // true

		int[][] edges3 = {};
		DataPrinter.println(alg.validTree(1, edges3)); // true
		DataPrinter.println(alg.validTree(2, edges3)); // false

		int[][] edges4 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		DataPrinter.println(alg.validTree(5, edges4)); // false
	}
}
