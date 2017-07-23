package kang.interview.programming.sort.interval;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * LeetCode 56. Merge Intervals:
 * https://leetcode.com/problems/merge-intervals/#/description
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * 
 * Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author Yan Kang
 *
 */
public class MergeIntervals {

	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> list = new LinkedList<>();
		if (intervals == null || intervals.size() == 0)
			return list;

		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval val1, Interval val2) {
				return Integer.compare(val1.start, val2.start);
			}
		});

		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			
			// When prev.end >= curr.start, it means that the two intervals prev
			// and curr are overlapped and they should be definitely merged as
			// one interval (It may overlap with other intervals as we go
			// through the interval list)
			if (prev.end >= curr.start) {
				prev = new Interval(Math.min(prev.start, curr.start), Math.max(prev.end, curr.end));
			} else {
				list.add(prev);
				prev = curr;
			}
		}
		list.add(prev);
		return list;
	}
	
	public static void main(String[] args) {

		// Given [1,3],[2,6],[8,10],[15,18],
		// should return [1,6],[8,10],[15,18].
		Interval inv1 = new Interval(1, 3);
		Interval inv2 = new Interval(2, 6);
		Interval inv3 = new Interval(8, 10);
		Interval inv4 = new Interval(15, 18);
		
		List<Interval> list = new LinkedList<>();
		list.addAll(Arrays.asList(inv1, inv2, inv3, inv4));
		MergeIntervals alg = new MergeIntervals();
		
		List<Interval> result = alg.merge(list);

		for (Interval inv : result)
			System.out.println("[" + inv.start + ", " + inv.end + "]");
	}

}
