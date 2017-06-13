package kang.interview.programming.binarytree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.binarytree.TreeNode;
import kang.interview.programming.binarytree.ZTestDataCreator;
import kang.interview.programming.sort.interval.Interval;

public class FindElementsInInterval {
	
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

		if (node.data > interval.right) {
			findElements(node.left, interval, result);
		} else if (node.data < interval.left) {
			findElements(node.right, interval, result);
		} else {
			findElements(node.left, interval, result);
			result.add(node);
			findElements(node.right, interval, result);
		}
	}
	
	public static void main(String[] arg) {
		FindElementsInInterval c = new FindElementsInInterval();
		Interval interval = new Interval(16, 31);
		List<TreeNode> result = c.findElements(ZTestDataCreator.createBinarySearchTree2(), interval);
		result.stream().forEach(a -> System.out.print(a.data + " "));
	}

}
