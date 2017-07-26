package kang.interview.programming.binarytree;

/**
 * 
 * @see PathSum_I_RootToLeadPathWithGivenSum
 * @author Yan Kang
 *
 */
public class RootToLeafPathNumber {

	/**
	 * 
	 * @param sb the string builder
	 * @param node the tree node
	 * @param sum the sum
	 * @return true if the root to path found
	 */
	public boolean findOneRootToLeafPathOfSum(StringBuilder sb, TreeNode node, int sum) {
		
		if(node == null)
			return false;
					
		sb.append(node.Id);
		int diff = sum - node.val;
		if (node.left == null && node.right == null) {
			if (diff == 0) {
				System.out.println(sb.toString());
				return true;
			}
		}
		
		if(findOneRootToLeafPathOfSum(sb, node.left, diff))
			return true;
		
		if(findOneRootToLeafPathOfSum(sb, node.right, diff))
			return true;
		
		sb.setLength(sb.length() - 1); 
		return false;
	}
	
	/**
	 * 
	 * @param sb
	 * @param node
	 * @param sum
	 */
	public void findAllRootToLeafPathsOfSum(StringBuilder sb, TreeNode node, int sum){
		
		if(node == null)
			return;
		
		sb.append(node.Id);
//		sb += node.Id;
		int diff = sum - node.val;
		
		if(node.left == null && node.right == null) {
			if(diff == 0) 
				System.out.println(sb.toString());
		}
		
		findAllRootToLeafPathsOfSum(sb, node.left, diff);
		findAllRootToLeafPathsOfSum(sb, node.right, diff);
		
		sb.setLength(sb.length() - 1); 
	}
	
	/**
	 * 
	 * @param node
	 * @param sum
	 */
	public void findAddNodeToNodePathOfSum(TreeNode node, int sum){
		
		int height = getHeight(node);
		int[] record = new int[height + 1];
		System.out.println("height: " + height);
		findAddNodeToNodePathOfSum(record, node, sum, 0);
	}
	
	private int getHeight(TreeNode node) {
		if (node == null)
			return -1;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	private void findAddNodeToNodePathOfSum(int[] record, TreeNode node, int sum, int depth){
		if(node == null)
			return;
					
		record[depth] = node.val;
		int temp = sum;
		for (int i = depth; i >= 0; i--) {
			temp -= record[i];
			if (temp == 0) {
				print(record, i, depth);
				break;
			}
		}
		
		findAddNodeToNodePathOfSum(record, node.left, sum, depth + 1);
		findAddNodeToNodePathOfSum(record, node.right, sum, depth + 1);

		// Do not need to clean the record when return from recursion on child
		// nodes
	}

	private void print(int[] record, int start, int end) {
		System.out.println();
		for (int i = start; i <= end; i++) {
			System.out.print(record[i] + ", ");
		}
	}

	public static void main(String[] args) {
		TreeNode root = ZTestDataCreator.createBinaryTree();
		
		RootToLeafPathNumber r = new RootToLeafPathNumber();
		
		System.out.println("find: " + r.findOneRootToLeafPathOfSum(new StringBuilder(), root, 619));
		System.out.println();
		r.findAllRootToLeafPathsOfSum(new StringBuilder(), root, 619);
		System.out.println();
		r.findAddNodeToNodePathOfSum(root, 3);
	}

}
