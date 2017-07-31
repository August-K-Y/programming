package kang.interview.programming.binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import kang.interview.programming.util.DataPrinter;

/**
 * LeetCode 297. Serialize and Deserialize Binary Tree:
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 *    1 
 *   / \ 
 *  2   3 
 *     / \ 
 *    4   5
 * 
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself. Note: Do not use
 * class member/global/static variables to store states. Your serialize and
 * deserialize algorithms should be stateless.
 * 
 * @author Yan Kang
 *
 */
public class SerializeDeserializeBinaryTree_M {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	 
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }
    
	private TreeNode buildTree(Deque<String> queue) {
		// IMPORTANT: there is no need to check whether the queue is empty since
		// the last token should always be '#' and thus the whole recursive
		// process should end at the moment when the queue is empty.
		// if(queue.isEmpty()) return null;

		String top = queue.poll();
        if(top.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(top));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
	
	public static void main(String[] args) {
		SerializeDeserializeBinaryTree_M alg = new SerializeDeserializeBinaryTree_M();
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		node4.left = node6;
		DataPrinter.println(alg.serialize(node1));
		alg.deserialize(alg.serialize(node1));
		
		
		System.out.println(Integer.MAX_VALUE);
	}
}
