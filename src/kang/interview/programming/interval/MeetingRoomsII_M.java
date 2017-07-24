package kang.interview.programming.interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import kang.interview.programming.util.DataPrinter;

/**
 * 253. Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/#/description
 * 
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms
 * required.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * 
 * @see https://discuss.leetcode.com/topic/20912/my-python-solution-with-explanation
 * @author Yan Kang
 *
 */
public class MeetingRoomsII_M {
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		
		Arrays.sort(intervals, (inv1, inv2) -> {
			return Integer.compare(inv1.start, inv2.start);
		});
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((end1, end2) -> {
			return Integer.compare(end1, end2);
		});

		q.add(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			int minEnd = q.remove();
			if(intervals[i].start < minEnd) {
				q.add(minEnd);
			} 
			q.add(intervals[i].end);
		}
		return q.size();
	}
	
	public static void main(String[] args) {
		MeetingRoomsII_M alg = new MeetingRoomsII_M();
		
		Interval inv1 = new Interval(2, 15);
		Interval inv2 = new Interval(36, 45);
		Interval inv3 = new Interval(9, 29);
		Interval inv4 = new Interval(16, 23);
		Interval inv5 = new Interval(4, 9);
		
		Interval[] intervals = new Interval[5];
		intervals[0] = inv1;
		intervals[1] = inv2;
		intervals[2] = inv3;
		intervals[3] = inv4;
		intervals[4] = inv5;
		
		
		Interval inv21 = new Interval(9, 14);
		Interval inv22 = new Interval(5, 6);
		Interval inv23 = new Interval(3, 5);
		Interval inv24 = new Interval(12, 19);
		
		Interval[] intervals2 = new Interval[4];
		intervals2[0] = inv21;
		intervals2[1] = inv22;
		intervals2[2] = inv23;
		intervals2[3] = inv24;
		
		DataPrinter.println(alg.minMeetingRooms(intervals)); // 2
		DataPrinter.println(alg.minMeetingRooms(intervals2));// 2
		
		
	}
}
