package kang.interview.programming.interval;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MostOverlappingPoint_I {
	
	/**
	 * O(n^2) can do it better? yes
	 * 
	 * @param intervals
	 * @return
	 */
	public int find(List<Interval> intervals) {

		Collections.sort(intervals, (a, b) -> a.start - b.start);

		int max = Integer.MIN_VALUE;
		int count = 0;
		int ret = intervals.get(0).start;
		for (int i = 1; i < intervals.size(); i++) {
			count = 1;
			for (int j = 0; j < i; j++) {
				if (intervals.get(i).start <= intervals.get(j).end) {
					if (++count > max) {
						max = count;
						ret = intervals.get(i).start;
					}
				}
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		// { (0,2), (3, 7), (4,6), (7,8), (1,5) }
		Interval inv1 = new Interval(0, 2);
		Interval inv2 = new Interval(3, 7);
		Interval inv3 = new Interval(4, 6);
		Interval inv4 = new Interval(7, 8);
		Interval inv5 = new Interval(1, 5);
		List<Interval> list = new LinkedList<>();
		list.addAll(Arrays.asList(inv1, inv2, inv3, inv4, inv5));
		MostOverlappingPoint_I alg = new MostOverlappingPoint_I();
		int ret = alg.find(list);
		System.out.println(ret);
	}
}
