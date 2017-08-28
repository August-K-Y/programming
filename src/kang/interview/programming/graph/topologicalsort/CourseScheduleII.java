package kang.interview.programming.graph.topologicalsort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 210. Course Schedule II:
 * https://leetcode.com/problems/course-schedule-ii/description/
 * 
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented. You may
 * assume that there are no duplicate edges in the input prerequisites. click to
 * show more hints.
 * 
 * Hints: 
 * 1. This problem is equivalent to finding the topological order in a
 * directed graph. If a cycle exists, no topological ordering exists and
 * therefore it will be impossible to take all courses. 
 * 2. Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic
 * concepts of Topological Sort. 
 * 3. Topological sort could also be done via BFS.
 * 
 * @author YK044346
 *
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] pre) {
		if (numCourses <= 0)
			return new int[0];

		if (pre == null || pre.length == 0) {
			int[] res = new int[numCourses];
			for (int i = 0; i < res.length; i++)
				res[i] = i;
			return res;
		}

		Map<Integer, Set<Integer>> adj = new HashMap<>();
		Map<Integer, Integer> indegree = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			indegree.put(i, 0);
		}

		for (int[] edge : pre) {
			indegree.put(edge[0], indegree.get(edge[0]) + 1);
			Set<Integer> set = adj.get(edge[1]);
			if (set == null) {
				set = new HashSet<>();
				adj.put(edge[1], set);
			}
			set.add(edge[0]);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int key : indegree.keySet()) {
			if (indegree.get(key) == 0)
				q.add(key);
		}
		int[] result = new int[indegree.size()];
		int i = 0;
		while (!q.isEmpty()) {
			int top = q.poll();
			result[i++] = top;
			if (adj.containsKey(top)) {
				for (int a : adj.get(top)) {
					int count = indegree.get(a);
					if (--count == 0)
						q.add(a);
					indegree.put(a, count);
				}
			}
		}
		return numCourses == i ? result : new int[0];
	}

	public static void main(String[] args) {
		CourseScheduleII alg = new CourseScheduleII();

		int[][] edges = { { 1, 0 } };
		DataPrinter.printArray(alg.findOrder(2, edges));

		int[][] edges2 = { { 0, 1 }, { 1, 0 } };
		DataPrinter.printArray(alg.findOrder(2, edges2));
		//
		// int[][] edges3 = {};
		// DataPrinter.println(alg.validTree(1, edges3)); // true
		// DataPrinter.println(alg.validTree(2, edges3)); // false
		//
		// int[][] edges4 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 }
		// };
		// DataPrinter.println(alg.validTree(5, edges4)); // false
	}
}
