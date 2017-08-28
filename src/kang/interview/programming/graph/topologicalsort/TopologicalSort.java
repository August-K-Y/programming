package kang.interview.programming.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

	public static class Graph {

		/*
		 * Representation of the graph. Each element in the outer list is a
		 * vertex in the graph and its associated inner list stores the list of
		 * its neighbors.
		 * 
		 * More object oriented representation is creating a Vertex class
		 * representing each vertex in the graph, and each Vertex class defines
		 * a list of its neighbors
		 * 
		 */
		private List<List<Integer>> adj;

		public Graph(int num) {
			adj = new ArrayList<List<Integer>>();
			for (int i = 0; i < num; i++)
				adj.add(new ArrayList<>());
		}

		public void addEdge(int s, int t) {
			adj.get(s).add(t);
		}

		/**
		 * Kahn’s algorithm for Topological Sorting: Steps involved in finding
		 * the topological ordering of a DAG:</br>
		 * <p>
		 * Step-1: Compute in-degree (number of incoming edges) for each of the
		 * vertex present in the DAG and initialize the count of visited nodes
		 * as 0.</br>
		 * 
		 * Step-2: Pick all the vertices with in-degree as 0 and add them into a
		 * queue (Enqueue operation)</br>
		 * 
		 * Step-3: Remove a vertex from the queue (Dequeue operation) and
		 * then.</br>
		 * <ol>
		 * <li>Increment count of visited nodes by 1.</li>
		 * <li>Decrease in-degree by 1 for all its neighboring nodes.</li>
		 * <li>If in-degree of a neighboring nodes is reduced to zero, then add
		 * it to the queue.</li>
		 * </ol>
		 * 
		 * Step 5: Repeat Step 3 until the queue is empty.</br>
		 * 
		 * Step 6: If count of visited nodes is not equal to the number of nodes
		 * in the graph then the topological sort is not possible for the given
		 * graph.</br>
		 * </p>
		 * 
		 * @return
		 * @see http://www.geeksforgeeks.org/topological-sorting-indegree-based-
		 *      solution/
		 */
		public List<Integer> topologicalSort(){
			List<Integer> result = new ArrayList<>();
			
			// the indegree array keeps tracking the indegree of each vertex
			int[] indegree = new int[adj.size()];

			// Traverse the neighbor list of each element in the graph and fill
			// indegrees of these neighbors. This step takes O(V+E) time
			for (List<Integer> sAdj : adj) {
				for (int t : sAdj) {
					indegree[t]++;
				}
			}
			
			// the queue keeps tracking vertex with zero indegree
			Queue<Integer> q = new LinkedList<>();

			// initialize the queue with vertices that have
			// indegree of 0
			for (int i = 0; i < indegree.length; i++) {
				if (indegree[i] == 0)
					q.add(i);
			}
			
			while(!q.isEmpty()) {
				
				// Extract front of queue and add it to topological order
				int top = q.remove();
				result.add(top);
				
				// Iterate through all its neighbors nodes of dequeued node
				// called top and decrease their in-degree by 1
				for (int v : adj.get(top)) {
					// If in-degree becomes zero, add it to queue
					if (--indegree[v] == 0) {
						q.add(v);
					}
				}
			}
			return result;
		}
		
		/**
		 * 
		 * @return
		 * @see http://www.geeksforgeeks.org/topological-sorting/
		 */
		public List<Integer> topologicalSort_dfs() {
			List<Integer> result = new ArrayList<>();

			boolean[] visited = new boolean[adj.size()];
			Stack<Integer> stack = new Stack<>();

			// Recursively call the topological Sort starting from all vertices
			// one by one
			for (int i = 0; i < adj.size(); i++) {
				if (visited[i] == false)
					topologicalSort(i, visited, stack);
			}
			
			while(!stack.isEmpty()) {
				result.add(stack.pop());
			}
			return result;
		}

		private void topologicalSort(int i, boolean[] visited, Stack<Integer> stack) {
			if(visited[i])
				return;
			
			visited[i] = true;
			
			// Recursively topological sort all the neighbor of this vertex
			for (int n : adj.get(i))
				topologicalSort(n, visited, stack);
			stack.push(i);
		}
	}

	public static void main(String args[]) {
		// Create a graph given in the above diagram
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("Following is a Topological Sort");
		List<Integer> result= g.topologicalSort();
		// Print topological order
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		result= g.topologicalSort_dfs();
		// Print topological order
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}
