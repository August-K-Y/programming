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
 * 218. The Skyline Problem:
 * https://leetcode.com/problems/the-skyline-problem/tabs/description
 * 
 * Solution
 * https://briangordon.github.io/2014/08/the-skyline-problem.html
 * @author Yan Kang
 *
 */
public class TheSkylineProblem_HH {


	public List<int[]> getSkyline(int[][] buildings) {
		if (buildings == null || buildings.length == 0)
			return new LinkedList<>();

		// track the critical points of all buildings. the critical point is the
		// position of left boundary or right boundary of a building
		int[] cp = new int[buildings.length * 2];

		// track the height of each critical points
		int[] h = new int[buildings.length * 2];

		// populate critical points
		int z = 0;
		for (int[] b : buildings) {
			cp[z++] = b[0];
			cp[z++] = b[1];
		}

		Arrays.sort(cp);

		// For each critical point, record the max height across all the
		// buildings sitting on this critical point skipping the building whose
		// right boundary aligned with the critical point. This is because:

		// the requirement that for recording points that are on the right
		// boundaries of buildings appearing in the sky line, its height should
		// be the height of the building that is shorter than the highest
		// building but (some part of this building) appearing in the sky line.
		for (int i = 0; i < cp.length; i++) {
			for (int j = 0; j < buildings.length; j++) {
				// skip the building whose right boundary aligned with the
				// critical point.
				if (cp[i] >= buildings[j][0] && cp[i] < buildings[j][1]) {
					h[i] = Math.max(h[i], buildings[j][2]);
				}
			}
		}

		// record the critical point and its height where the height of current
		// critical point should NOT be the same as the height of previous
		// critical point. The is because the critical point whose height
		// appearing before is not one of the critical points compose the
		// sky line.
		List<int[]> ret = new LinkedList<>();
		for (int i = 0; i < h.length; i++) {
			if (i == 0 || h[i] != h[i - 1]) {

				int[] p = new int[2];
				p[0] = cp[i];
				p[1] = h[i];
				ret.add(p);
			}

		}
		return ret;
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
