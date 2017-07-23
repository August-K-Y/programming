package kang.interview.programming.sort.interval;

public class Interval implements Comparable<Interval> {
	public int start;
	public int end;

	public Interval() {
		start = 0;
		end = 0;
	}

	public Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public int compareTo(Interval interval) {
		return Integer.compare(this.start, interval.end);
	}
}