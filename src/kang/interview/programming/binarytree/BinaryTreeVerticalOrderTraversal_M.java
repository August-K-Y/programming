package kang.interview.programming.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 314. Binary Tree Vertical Order Traversal:
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/#/description
 * 
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
   If two nodes are in the same row and column, the order should be from left to right.

	Examples:

	Given binary tree [3,9,20,null,null,15,7],
	   3
	  /\
	 /  \
	 9  20
	    /\
	   /  \
	  15   7
	return its vertical order traversal as:
	[
	  [9],
	  [3,15],
	  [20],
	  [7]
	]
	Given binary tree [3,9,8,4,0,1,7],
	     3
	    /\
	   /  \
	   9   8
	  /\  /\
	 /  \/  \
	 4  01   7
	return its vertical order traversal as:
	[
	  [4],
	  [9],
	  [3,0,1],
	  [8],
	  [7]
	]
	Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
	     3
	    /\
	   /  \
	   9   8
	  /\  /\
	 /  \/  \
	 4  01   7
	    /\
	   /  \
	   5   2
	return its vertical order traversal as:
	[
	  [4],
	  [9,5],
	  [3,0,1],
	  [8,2],
	  [7]
	]
 * 
 * @see https://discuss.leetcode.com/topic/31954/5ms-java-clean-solution
 * @author yankang
 *
 */
public class BinaryTreeVerticalOrderTraversal_M {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	class Node{
		int vertical;
		int order;
		int val;
		
		public Node(int vertical, int order, int val) { 
			this.vertical = vertical;
			this.order = order;
			this.val = val;
		}
	}
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if(root == null)
			return result;
			
		
		List<Node> list = new LinkedList<>();
		createList(root, 0, 0, list);
		
		Collections.sort(list, new Comparator<Node>() {
			public int compare(Node node1, Node node2) {
				int val = Integer.compare(node1.vertical, node2.vertical);
				if (val == 0) {
					return Integer.compare(node1.order, node2.order);
				}
				return val;
			}
		});
		
		List<Integer> col = new LinkedList<>();
		col.add(list.get(0).val);
		result.add(col);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).vertical != list.get(i - 1).vertical) {
				col = new LinkedList<>();
				result.add(col);
			}
			col.add(list.get(i).val);
		}

		return result;
	}
	
	private void createList(TreeNode root, int vertical, int order, List<Node> list) {
		if(root == null)
			return;
		
		list.add(new Node(vertical, order, root.val));
		createList(root.left, vertical - 1, ++order, list);
		createList(root.right, vertical + 1,++order, list);
	}
	
	/**
	 * <p>
	 * The idea of previous solution is straightforward. But the
	 * comparison-based sort on tree node part is not necessary.
	 * </p>
	 * <p>
	 * We definitely need keep tree node sorted. But since they would be grouped
	 * into different columns, a better/faster sorting method for this kind of
	 * problem is bucket sort. We can treat each column as a bucket and while we
	 * are traversing the tree we can put each node to its correspondingly
	 * column/bucket. The order in each bucket/column can be maintained based on
	 * the tree traversal order.
	 * </p>
	 * <p>
	 * We keep the column number consecutive and track the left/right boundary
	 * of column numbers while traversing. Thus the column numbers would be
	 * sorted when the traversing completed.
	 * </p>
	 * <p>
	 * Since as the question stated: if two nodes are in the same row and
	 * column, the order should be from left to right, we can use BFS to
	 * maintain this order.
	 * </p>
	 * 
	 * Therefore, the algorithm goes:
	 * <ul>
	 * <li>BFS, put node, col into queue at the same time</li>
	 * <li>Every left child access col - 1 while right child col + 1. This maps
	 * node into different col buckets</li>
	 * <li>Track col boundary min and max on the fly</li>
	 * <li>Retrieve result from cols</li>
	 * </ul>
	 * Note that TreeMap version takes 9ms.
	 * 
	 * @see https://discuss.leetcode.com/topic/31954/5ms-java-clean-solution
	 * @param root
	 * @return
	 */
	public List<List<Integer>> verticalOrder_(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		// the map serves as a set of buckets that each corresponds to a column
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		// The queue and cols are synchronized. The former tracks the tree node,
		// the latter tracks the column number for that tree node
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();

		queue.add(root);
		cols.add(0);

		// minCol and MaxCol track the the min column index and max column index
		int minCol = 0;
		int maxCol = 0;

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			int col = cols.poll();

			// It this is a new column, create a new list for it.
			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				queue.add(node.left);
				cols.add(col - 1);
				minCol = Math.min(minCol, col - 1);
			}

			if (node.right != null) {
				queue.add(node.right);
				cols.add(col + 1);
				maxCol = Math.max(maxCol, col + 1);
			}
		}

		// Since the hash map is neither sorted nor ordered, we need to order it
		// by the column number. Since we tracked the range of the column
		// numbers, we can simply fetch each column/bucket from the hash map
		// based on the order of the column number and put them into a list
		// (i.e., a list of columns)

		// We can avoid this step if we use tree map, but it may take more time
		// (It will use O(nlogn) to keep the column sorted). Also, we have to
		// fetch them out of the tree map and put them to the column list
		// anyway.
		for (int i = minCol; i <= maxCol; i++) {
			res.add(map.get(i));
		}

		return res;
	}

	public static void main(String[] args) {
		BinaryTreeVerticalOrderTraversal_M alg = new BinaryTreeVerticalOrderTraversal_M();
		
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		DataPrinter.println(alg.verticalOrder(node1));
	}
}
