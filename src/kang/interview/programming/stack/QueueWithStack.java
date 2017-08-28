package kang.interview.programming.stack;

import java.util.Stack;

public class QueueWithStack {
	private Stack<Integer> inputStack = new Stack<>();
	private Stack<Integer> outputStack = new Stack<>();

	public void push(int value) {
		inputStack.push(value);
	}

	public int pop() {
		if (!outputStack.isEmpty()) {
			return outputStack.pop();
		} else {

			// if the output stack is empty, push all elements in the input
			// stack into the output stack
			while (!inputStack.isEmpty()) {
				outputStack.push(inputStack.pop());
			}
			return outputStack.pop();
		}
	}

}
