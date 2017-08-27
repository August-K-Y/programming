package kang.interview.programming.graph.topologicalsort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * @author YK044346
 *
 */
public class CourseScheduleIII_H {

	public int scheduleCourse(int[][] courses) {

		if (courses == null || courses.length == 0)
			return 0;

		// Sort the courses by their deadlines (Greedy! We have to deal with
		// courses with early deadlines first)
		Arrays.sort(courses, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);

		int time = 0;
		for (int[] c : courses) {

			time += c[0];
			// add current course to a priority queue
			q.add(c[0]);
			// If time exceeds, drop the previous course which costs the most
			// time. (That must be the best choice!)
			if (time > c[1])
				time -= q.poll();
		}

		return q.size();
	}

	/**
	 * This does not work. Can I fix it?!
	 * 
	 * @param courses
	 * @return
	 */
	public int scheduleCourse_(int[][] courses) {

		if (courses == null || courses.length == 0)
			return 0;
		Arrays.sort(courses, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		int[] end = new int[courses.length + 1];
		end[0] = 0;
		int[] dp = new int[courses.length + 1];
		dp[0] = 0;
		for (int i = 1; i <= courses.length; i++) {
			for (int j = 0; j < i; j++) {
				if (end[j] + courses[i - 1][0] <= courses[i - 1][1]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
						end[i] = end[j] + courses[i - 1][0];
					}
				} else {
					if (dp[j] > dp[i]) {
						dp[i] = dp[j];
						end[i] = end[j];
					}
				}

			}
		}
		return dp[courses.length];
	}
}
