package kang.interview.programming.graph.topologicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

public class CourseSchedule {
	public boolean canFinish(int n, int[][] pre) {
		if (pre == null || pre.length == 0)
			return true;

		Map<Integer, Set<Integer>> adj = new HashMap<>();
		Map<Integer, Integer> indegree = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			indegree.put(i, 0);
		}
		
		for(int[] edge : pre) {
            indegree.put(edge[0], indegree.getOrDefault(edge[0], 0) + 1);			
			Set<Integer> set = null;
			if(adj.containsKey(edge[1])) {
				set = adj.get(edge[1]);
			} else {
				set = new HashSet<>();
				adj.put(edge[1], set);
			}
			set.add(edge[0]);
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int k : indegree.keySet()) {
			int count = indegree.get(k);
			if (count == 0)
				q.add(k);
		}
		
		int node = 0;
		while(!q.isEmpty()){
			
			int top = q.poll();
			node++;
			
			for(int a : adj.get(top)) {
				int count = indegree.get(a);
				if(--count == 0) {
					q.add(a);
				}
				indegree.put(a, count);
			}
		}
		
		return node == indegree.size();
	}
	
	public static void main(String[] args) {
		CourseSchedule alg = new CourseSchedule();

		int[][] edges = { { 0, 1 }, { 0, 1 } };
		DataPrinter.println(alg.canFinish(2, edges)); // true

//		int[][] edges2 = { { 0, 1 }, { 2, 3 }, { 1, 2 } };
//		DataPrinter.println(alg.validTree(4, edges2)); // true
//
//		int[][] edges3 = {};
//		DataPrinter.println(alg.validTree(1, edges3)); // true
//		DataPrinter.println(alg.validTree(2, edges3)); // false
//
//		int[][] edges4 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
//		DataPrinter.println(alg.validTree(5, edges4)); // false
	}
}
