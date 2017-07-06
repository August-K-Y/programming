package kang.interview.programming.hashtable;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.binarytree.TreeNode;

public class FindLCA {
	
	public TreeNode findLCA(TreeNode node1, TreeNode node2) {
		
		Set<Integer> track = new HashSet<>();
		while (node1 != null || node2 != null) {

			if (node1 != null) {
				if (!track.add(node1.data)) {
					return node1;
				}
				node1 = node1.parent;

			}
			if (node2 != null) {
				if (!track.add(node2.data)) {
					return node2;
				}
				node2 = node2.parent;
			}
		}
		return null;

	}

}
