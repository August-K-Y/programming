package kang.interview.programming.zhe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * 
 * 218. The Skyline Problem:
 * https://leetcode.com/problems/the-skyline-problem/tabs/description
 * 
 * Solution
 * https://briangordon.github.io/2014/08/the-skyline-problem.html
 * @author Yan Kang
 *
 */
public class TheSkylineProblem_HH {

	public List<int[]> getSkyline_(int[][] buildings) {
		List<int[]> result = new LinkedList<>();
		if (buildings == null || buildings.length == 0)
			return result;

		Map<Integer, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < buildings.length; i++) {
			for (int j = buildings[i][0]; j <= buildings[i][1]; j++) {
				map.put(j, Math.max(map.getOrDefault(j, 0), buildings[i][2]));
			}
		}

		int[] prev = new int[2];
		prev[0] = -1;
		prev[1] = -1;
		for (int key : map.keySet()) {
			int height = map.get(key);

			if (prev[1] == -1) {
				prev[0] = key;
				prev[1] = height;
				result.add(prev);
			}

			if (height > prev[1]) {
				int[] curr = new int[2];
				curr[0] = key;
				curr[1] = height;
				result.add(curr);
				prev = curr;
			} else if (height == prev[1] && (map.get(key + 1) == null || map.get(key + 1) < prev[1])) {

				int[] curr = new int[2];
				curr[0] = key;
				curr[1] = map.get(key + 1) == null ? 0 : map.get(key + 1);
				result.add(curr);
				prev = curr;
			}
		}
		return result;
	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new LinkedList<>();
		if (buildings == null || buildings.length == 0)
			return result;

		int[] cp = new int[buildings.length * 2];
		int[] h = new int[buildings.length * 2];

		int i = 0;
		for (int[] building : buildings) {
			cp[i++] = building[0];
			cp[i++] = building[1];
		}

		Arrays.sort(cp);

		for (int j = 0; j < cp.length; j++) {
			for (int[] building : buildings) {
				if (cp[j] >= building[0] && cp[j] < building[1]) {
					h[j] = Math.max(h[j], building[2]);
				}
			}
		}

		for (int z = 0; z < h.length; z++) {
			if (z == 0 || h[z] != h[z - 1]) {
				int[] p = new int[2];
				p[0] = cp[z];
				p[1] = h[z];
				result.add(p);
			}
		}

		return result;
	}
	
	
	public List<int[]> getSkyline__(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<int[]> height = new ArrayList<>();
		for (int[] b : buildings) {
			height.add(new int[] { b[0], -b[2] });
			height.add(new int[] { b[1], b[2] });
		}
		Collections.sort(height, (a, b) -> {
			if (a[0] != b[0])
				return a[0] - b[0];
			return a[1] - b[1];
		});
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
		pq.offer(0);
		int prev = 0;
		for (int[] h : height) {
			if (h[1] < 0) {
				pq.offer(-h[1]);
			} else {
				pq.remove(h[1]);
			}
			int cur = pq.peek();
			if (prev != cur) {
				result.add(new int[] { h[0], cur });
				prev = cur;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
		// [[0,2147483647,2147483647]]
		TheSkylineProblem_HH alg = new TheSkylineProblem_HH();

		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		List<int[]> result = alg.getSkyline(buildings);

		System.out.println("-------");
		for (int[] l : result) {
			System.out.println(l[0] + ", " + l[1]);
		}

		System.out.println("-------");
		int[][] buildings2 = { { 0, 2147483647, 2147483647 } };
		List<int[]> result2 = alg.getSkyline(buildings2);
		for (int[] l : result2) {
			System.out.println(l[0] + ", " + l[1]);
		}
	}

}
