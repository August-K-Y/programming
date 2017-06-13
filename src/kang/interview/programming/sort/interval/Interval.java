package kang.interview.programming.sort.interval;

public class Interval implements Comparable<Interval> {
	public int left;
	public int right;

	public Interval(int left, int right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int compareTo(Interval interval) {
		return Integer.compare(this.left, interval.left);
	}
}