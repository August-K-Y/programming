package kang.interview.programming.sort.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputeUnionIntervals {

	public List<Interval> computeUnionIntervals(List<Interval> intervals) {

		List<Interval> result = new ArrayList<>();

		Collections.sort(intervals);
		print(intervals);
		
		Interval curr = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (curr.right >= intervals.get(i).left) {
				int right = Math.max(curr.right, intervals.get(i).right);
				curr = new Interval(curr.left, right);
			} else if (curr.right < intervals.get(i).left) {
				result.add(curr);
				curr = intervals.get(i);
			}
		}
		result.add(curr);
		return result;
	}

	public static void main(String[] arg) {
		Interval interval1 = new Interval(0, 3);
		Interval interval2 = new Interval(1, 1);
		Interval interval3 = new Interval(2, 4);
		Interval interval4 = new Interval(3, 4);
		Interval interval5 = new Interval(5, 7);
		Interval interval6 = new Interval(7, 8);
		Interval interval7 = new Interval(8, 11);
		Interval interval8 = new Interval(9, 11);
		Interval interval9 = new Interval(13, 15);
		Interval interval10 = new Interval(12, 16);
		Interval interval11 = new Interval(12, 14);
		Interval interval12 = new Interval(16, 17);
		
		List<Interval> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		intervals.add(interval4);
		intervals.add(interval5);
		intervals.add(interval6);
		intervals.add(interval7);
		intervals.add(interval8);
		intervals.add(interval9);
		intervals.add(interval10);
		intervals.add(interval11);
		intervals.add(interval12);
		
		ComputeUnionIntervals c = new ComputeUnionIntervals();
		List<Interval> result = c.computeUnionIntervals(intervals);
		System.out.println();

		print(result);
	}

	private static void print(List<Interval> result) {
		result.stream().forEach(interval -> System.out.print("(" + interval.left + "," + interval.right + ")"));
	}

}
