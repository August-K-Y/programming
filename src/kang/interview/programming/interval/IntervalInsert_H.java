package kang.interview.programming.interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given a sorted list of non-overlapping intervals e.g. <2,5>, <7,9>, <12,15>,
 * <17,20> and new interval e.g. <8,10>, insert new interval into existing
 * intervals and keep list sorted and non-overlapping. Output: <2,5>,
 * <7,10> <12,15> <17,20>
 * 
 * 
 * Some more examples: 1. New interval : <8,14> Existing: <2,5>, <7,9>, <12,15>,
 * <17,20> Output: <2,5>, <7,15>,<17,20>
 * 
 * 2. New interval : <10,11> Existing: <2,5>, <7,9>, <12,15>, <17,20> Output:
 * <2,5>, <7,9>, <10,11>, <12,15>, <17,20>
 * 
 * 3. New interval : <11,18> Existing: <2,5>, <7,9>, <12,15>, <17,20> Output:
 * <2,5>, <7,9>, <11,20>
 * 
 * Solution:
 * @see https://discuss.leetcode.com/topic/7808/short-and-straight-forward-java-solution
 * 
 * 
 * Follow up: Do this in-place
 * 
 * @author yankang
 *
 */
public class IntervalInsert_H {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new LinkedList<>();
		if (intervals == null) {
			result.add(newInterval);
			return result;
		}

		int i = 0;

		// add all the intervals ending before newInterval starts.
		// IMPORTANT: another not quite obvious but important point here is that
		// the newInterval.start <= intervals.get(i+1).end. Otherwise, the i+1
		// interval should also be in front of the newInterval
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			result.add(intervals.get(i));
			i++;
		}

		// merge all overlapping intervals to one considering newInterval. If
		// there is no interval overlapping with the newInterval, the
		// newInterval will be stand along and added to the result list.
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			i++;
		}
		
		// add the union of intervals we got
		result.add(newInterval);

		// add all the rest
		while (i < intervals.size()) {
			result.add(intervals.get(i));
			i++;
		}

		return result;
	}

	/**
	 * In-place version
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public List<Interval> insert_(List<Interval> intervals, Interval newInterval) {
		if (intervals == null) {
			return null;
		}

		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			i++;
		}
		int insertPosition = i;

		int numToRemove = 0;
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start),
					Math.max(newInterval.end, intervals.get(i).end));
			i++;
			numToRemove++;
		}
		intervals.add(insertPosition, newInterval);

		int deletePosition = insertPosition + 1;

		while (numToRemove > 0) {
			intervals.remove(deletePosition);
			numToRemove--;
		}
		return intervals;
	}
	
	/**
	 * More compact but not obvious in-place version
	 * 
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public List<Interval> insert__(List<Interval> intervals, Interval newInterval) {
		int i = 0;
		while (i < intervals.size() && intervals.get(i).end < newInterval.start)
			i++;
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
					Math.max(intervals.get(i).end, newInterval.end));
			intervals.remove(i);
		}
		intervals.add(i, newInterval);
		return intervals;
	}
	
	public static void main(String[] args){
		IntervalInsert_H alg = new IntervalInsert_H();
		
		Interval interval1 = new Interval(2, 5);
		Interval interval2 = new Interval(7, 9);
		Interval interval3 = new Interval(12, 15);
		Interval interval4 = new Interval(17, 20);
		Interval newInv = new Interval(8, 14);
		
		List<Interval> intervals = new LinkedList<>(Arrays.asList(interval1, interval2, interval3, interval4));
		List<Interval> result = alg.insert_(intervals, newInv);

		// <2,5>, <7,15>,<17,20>
		for (Interval inv : result)
			System.out.println("[" + inv.start + ", " + inv.end + "]");
		System.out.println();
		
		Interval interval21 = new Interval(2,5);
		Interval interval22 = new Interval(7,9);
		Interval interval23 = new Interval(12,15);
		Interval interval24 = new Interval(17, 20);
		Interval newInv2 = new Interval(10,11);
		
		// <2,5>, <7,9>, <10,11>, <12,15>, <17,20>
		intervals = new LinkedList<>(Arrays.asList(interval21, interval22, interval23, interval24));
		List<Interval> result2 = alg.insert_(intervals, newInv2);
		for (Interval inv : result2)
			System.out.println("[" + inv.start + ", " + inv.end + "]");
		System.out.println();
	}
}
