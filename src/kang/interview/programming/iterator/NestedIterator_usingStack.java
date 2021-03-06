package kang.interview.programming.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * A question before this is the Nested List Weight Sum, and it requires
 * recursion to solve. As it carries to this problem that we will need recursion
 * to solve it. But since we need to access each NestedInteger at a time, we
 * will use a stack to help.
 * 
 * In the constructor, we push all the nestedList into the stack from back to
 * front, so when we pop the stack, it returns the very first element. Second,
 * in the hasNext() function, we peek the first element in stack currently, and
 * if it is an Integer, we will return true and pop the element. If it is a
 * list, we will further flatten it. This is iterative version of flatting the
 * nested list. Again, we need to iterate from the back to front of the list.
 * 
 * @author yankang
 *
 */
public class NestedIterator_usingStack implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack<>();

	public NestedIterator_usingStack(List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger curr = stack.peek();
			if (curr.isInteger()) {
				return true;
			}
			stack.pop();
			for (int i = curr.getList().size() - 1; i >= 0; i--) {
				stack.push(curr.getList().get(i));
			}
		}
		return false;
	}
}
