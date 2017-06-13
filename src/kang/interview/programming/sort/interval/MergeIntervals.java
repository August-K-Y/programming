package kang.interview.programming.sort.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

	public List<Interval> mergeIntervals(List<Interval> intervals, Interval newInterval) 
	{
		
		List<Interval> result = new ArrayList<>();
		Collections.sort(intervals); 

		int i = 0;
		while (i < intervals.size() && newInterval.left > intervals.get(i).right) {
				result.add(intervals.get(i));
				i++;
		}
		
		while (i < intervals.size() && newInterval.right >= intervals.get(i).left) {
			int left = Math.min(intervals.get(i).left, newInterval.left);
			int right = Math.max(intervals.get(i).right, newInterval.right);
			newInterval = new Interval(left, right);
			i++;
		}
		result.add(newInterval);
		

		result.addAll(intervals.subList(i, intervals.size()));
		return result;
		
	}
}
