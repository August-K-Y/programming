package kang.interview.programming.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;


public class AlienDictionary {
	
	public static class Edge {
		char s;
		char e;

		public Edge(char s, char e) {
			this.s = s;
			this.e = e;
		}
	}
	public String alienOrder(String[] words) {

		List<List<Character>> lists = new LinkedList<>();
		createList(new LinkedList<String>(Arrays.asList(words)), lists);

//		DataPrinter.print2DList(lists);
//		System.out.println();
		
		// topological sort
		
		List<Edge> edges = new LinkedList<>();
		Set<Character> all = new HashSet<>();
		Set<String> edgeTracker = new HashSet<>();
		int[] indegree = new int[26]; // more general case, would use map
		for (List<Character> list : lists) {
			for (int i = 0; i < list.size(); i++) {
				all.add(list.get(i));
				
				if (i < list.size() - 1) {
					String edgeCode = list.get(i) + ":" + list.get(i + 1);
					if (!edgeTracker.contains(edgeCode)) {
						edgeTracker.add(edgeCode);
						edges.add(new Edge(list.get(i), list.get(i + 1)));
					}
				}
			}
		}

//		List<Set<Character>> edges = new ArrayList<Set<Character>>(Collections.nCopies(26, new HashSet<>()));
		List<Set<Character>> adj = new ArrayList<Set<Character>>(26);
		for(int i = 0; i< 26; i++){
			adj.add(i, new HashSet<>());
		}
		
		for (Edge edge : edges) {
			adj.get(edge.s - 'a').add(edge.e);
			indegree[edge.e - 'a']++;
		}
		
//		Set<Character> all = new HashSet<>();
//		Set<String> edgeTracker = new HashSet<>();
//		int[] indegree = new int[26]; // more general case, would use map
//		for (List<Character> list : lists) {
//			for (int i = 0; i < list.size(); i++) {
//				all.add(list.get(i));
//				int index = list.get(i) - 'a';
//				if (i + 1 < list.size()) {
//					String edge = list.get(i) + ":" + list.get(i + 1);
//					if (!edgeTracker.contains(edge)) {
//						edgeTracker.add(edge);
//						adj.get(index).add(list.get(i + 1));
//					}
//				}
//				if (i > 0)
//					indegree[index]++;
//			}
//		}
		
//		for (int i = 0; i < edges.size(); i++) {
//			System.out.println((char)(i + 'a'));
//			for (char e : edges.get(i)) {
//				System.out.println("---> " + e);
//			}
//		}

//		System.out.println("node count: " + all.size());
//		DataPrinter.printArray(indegree);

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0 && all.contains((char)(i + 'a')))
				queue.add(i);
		}
		
		int count = 0;
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int index = queue.poll();
			sb.append((char) (index + 'a'));

			for (char c : adj.get(index)) {
				if (--indegree[c - 'a'] == 0)
					queue.add(c - 'a');
			}
			count++;
		}
		return count == all.size() ? sb.toString() : "";
	}

	private void createList(List<String> list, List<List<Character>> lists) {

		if(list.size() ==0)
			return;
		
		List<Character> clist = new LinkedList<>();
		List<String> subList = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			String w = list.get(i);
			if (i == 0) {
				clist.add(w.charAt(0));
				if (w.length() > 1)
					subList.add(w.substring(1));
				continue;
			}

			if (w.charAt(0) == list.get(i - 1).charAt(0)) {
				if (w.length() > 1)
					subList.add(w.substring(1));
			} else {
//				if (subList.size() > 0)
					createList(subList, lists);
				subList = new LinkedList<>();
				if (w.length() > 1)
					subList.add(w.substring(1));
				clist.add(w.charAt(0));
			}
		}

//		if (subList.size() > 0)
			createList(subList, lists);
		
//		if (clist.size() > 1)
			lists.add(clist);
	}
	
	public static void main(String[] args){
		
		
		AlienDictionary alg = new AlienDictionary();
		String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
		String[] words2 = {"z", "x"};
		String[] words3 = {"z", "x", "z"};
		String[] words4 = {"wrt","wrtkj"};
		String[] words5 = {"za","zb","ca","cb"};
		
		
//		List<String> list = Arrays.asList(words4);
//		List<List<Character>> lists = new LinkedList<>();
//		alg.createList(list, lists);
//		DataPrinter.print2DList(lists);
		
		DataPrinter.println(alg.alienOrder(words)); // wertf
		DataPrinter.println(alg.alienOrder(words2)); // zx
		DataPrinter.println(alg.alienOrder(words3)); // ""
		DataPrinter.println(alg.alienOrder(words4)); // jkrtw
		DataPrinter.println(alg.alienOrder(words5)); // azbc
	}
}
