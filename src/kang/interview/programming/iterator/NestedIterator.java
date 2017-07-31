package kang.interview.programming.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 341. Flatten Nested List Iterator:
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 * 
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,1,2,1,1].
 * 
 * Example 2: Given the list [1,[4,[6]]],
 * 
 * By calling next repeatedly until hasNext returns false, the order of elements
 * returned by next should be: [1,4,6].
 * 
 * @author Yan Kang
 *
 */
public class NestedIterator implements Iterator<Integer> {
	 
	private Queue<Integer> queue;
	private List<NestedInteger> lists;
	private int curr;

	public NestedIterator(List<NestedInteger> nestedList) {
		lists = nestedList;
		queue = new LinkedList<>();
		curr = 0;
		populate();
	}

	@Override
	public Integer next() {
		Integer top = queue.poll();
		populate();
		return top;
	}

	private void populate() {
		while (queue.isEmpty() && curr < lists.size()) {
			add(lists.get(curr++));
		}
	}

	private void add(NestedInteger elem) {
		if (elem.isInteger()) {
			Integer val = elem.getInteger();
			if (val != null) queue.add(val);
		} else {
			for (NestedInteger e : elem.getList()) {
				add(e);
			}
		}
	}

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); 
 * while (i.hasNext()) v[f()] = i.next();
 */
