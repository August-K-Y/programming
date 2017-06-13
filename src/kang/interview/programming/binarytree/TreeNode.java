package kang.interview.programming.binarytree;

public class TreeNode {
	public String Id;
	public TreeNode left;
	public TreeNode right;
	public int data;
	public int size;
	public TreeNode parent;
	public TreeNode rightSibling;

	public TreeNode(String Id, int data, int size) {
		this.Id = Id;
		this.data = data;
		this.size = size;
	}

	public TreeNode(String Id, int data) {
		this.Id = Id;
		this.data = data;
	}

}
