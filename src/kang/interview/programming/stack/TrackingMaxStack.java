package kang.interview.programming.stack;

import java.util.Deque;
import java.util.LinkedList;

public class TrackingMaxStack {

	private Deque<Integer> tracking;
	private Deque<Integer> storage;

	public TrackingMaxStack() {
		tracking = new LinkedList<Integer>();
		storage = new LinkedList<Integer>();
	}

	public int max() {
		return tracking.peek();
	}

	public void push(int value) {
		int max = tracking.peek();
		if(value >= max)
			tracking.push(value);
		storage.push(value); 
	}

	public int pop() {
		int top = storage.pop();
		int max = tracking.peek();
		if(top == max)
			tracking.pop();
		return top;
	}

}
