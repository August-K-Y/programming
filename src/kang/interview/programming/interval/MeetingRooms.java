package kang.interview.programming.interval;

import java.util.Arrays;

/**
 * LeetCode 252. Meeting Rooms:
 * https://leetcode.com/problems/meeting-rooms/#/description
 * 
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
 * meetings.
 * 
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 * 
 * @see https://leetcode.com/problems/meeting-rooms/#/solution
 * @author Yan Kang
 *
 */
public class MeetingRooms {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;

		Arrays.sort(intervals, (a, b) -> a.start - b.start);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end)
				return false;
		}

		return true;
	}
}
