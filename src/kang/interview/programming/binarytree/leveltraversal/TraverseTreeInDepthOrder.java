package kang.interview.programming.binarytree.leveltraversal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import kang.interview.programming.binarytree.TreeNode;


/**
 * 
 * @author yankang
 * @see TraverseTreeLevelByLevel
 */
public class TraverseTreeInDepthOrder {
	
	public Map<Integer, List<TreeNode>> binaryTreeDepthOrder(TreeNode treeNode) {
		Map<Integer, List<TreeNode>> map = new LinkedHashMap<Integer, List<TreeNode>>();
		process(treeNode, map, 0);
		return map;

	}

	private void process(TreeNode treeNode, Map<Integer, List<TreeNode>> map, int depth) {
		if (treeNode == null)
			return;
		List<TreeNode> nodes = map.get(depth);
		if (nodes == null) {
			nodes = new ArrayList<>();
			map.put(depth, nodes);
		}
		nodes.add(treeNode);
		process(treeNode.left, map, depth + 1);
		process(treeNode.right, map, depth + 1);
	}
	
	/**
	 * Using two queues
	 * @param treeNode
	 * @return
	 */
	public List<List<Integer>> binaryTreeDepthOrderIterately(TreeNode treeNode) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> secondQ = new LinkedList<>();
		queue.add(treeNode);
		List<Integer> currentDepth = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			currentDepth.add(node.val);
			if (treeNode.left != null) {
				secondQ.add(node.left);
			}
			if (treeNode.right != null) {
				secondQ.add(node.right);
			}
			if (queue.isEmpty()) {
				queue = secondQ;
				secondQ = new LinkedList<>();
				result.add(currentDepth);
				currentDepth = new ArrayList<>();
			}
		}
		return result;
	}
	
	public List<List<Integer>> binaryTreeDepthOrderIterately2(TreeNode treeNode) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(treeNode);
		int currentLevel = 1;
		int nextLevel = 0;
		List<Integer> current = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode top = queue.remove();
			current.add(top.val);
			currentLevel--;
			if (treeNode.left != null) {
				queue.add(treeNode.left);
				nextLevel++;
			}
			if (treeNode.right != null) {
				queue.add(treeNode.right);
				nextLevel++;
			}
			if (currentLevel == 0) {
				result.add(current);
				current = new ArrayList<>();
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
		return result;
	}

}
