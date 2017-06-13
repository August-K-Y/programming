package kang.interview.programming.stack;

import java.util.Queue;
import java.util.Stack;

public class TrackingMaxQueue {
	
	private Stack<Integer> maxTracking;
	private Queue<Integer> queue;
	
	public void enqueue(int value) {
		if(value >= maxTracking.peek())
			maxTracking.push(value);
		queue.add(value); 
	}
	
	public int dequeue(){
		int top = queue.remove();
		if(top == maxTracking.peek())
			maxTracking.pop();
		return top;
	}
	
	public int max(){
		return maxTracking.peek();
	}

}
