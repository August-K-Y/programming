package kang.interview.programming.binarytree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;
import kang.interview.programming.interval.Interval;

public class FindElementsInRange {
	
	public List<TreeNode> findElements(TreeNode node, Interval interval) 
	{
		List<TreeNode> result = new ArrayList<>();
		findElements(node, interval, result);
		return result;
	} 

	private void findElements(TreeNode node, Interval interval, List<TreeNode> result) {
		if(node == null) {
			return;
		}

		if (node.val > interval.end) {
			findElements(node.left, interval, result);
		} else if (node.val < interval.start) {
			findElements(node.right, interval, result);
		} else {
			// Node is between the interval/range and add it the the result
			// list. Since the left node and right node of current node are both
			// possible in the range, we should explore both sizes of current
			// node.
			findElements(node.left, interval, result);
			result.add(node);
			findElements(node.right, interval, result);
		}
	}

	public static void main(String[] arg) {
		FindElementsInRange c = new FindElementsInRange();
		Interval interval = new Interval(16, 31);
		List<TreeNode> result = c.findElements(ZTestDataCreator.createBinarySearchTree2(), interval);
		result.stream().forEach(a -> System.out.print(a.val + " "));
	}

}
