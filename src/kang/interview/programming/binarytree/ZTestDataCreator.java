package kang.interview.programming.binarytree;

public class ZTestDataCreator {

	public static TreeNode createBinarySearchTree2() {
		
		TreeNode A = new TreeNode("A", 19);
		TreeNode B = new TreeNode("B", 7);
		TreeNode C = new TreeNode("C", 3);
		TreeNode D = new TreeNode("D", 2);
		TreeNode E = new TreeNode("E", 5);
		TreeNode F = new TreeNode("F", 11);
		TreeNode G = new TreeNode("G", 17);
		TreeNode H = new TreeNode("H", 13);
		TreeNode I = new TreeNode("I", 43);
		TreeNode J = new TreeNode("J", 23);
		TreeNode K = new TreeNode("K", 37);
		TreeNode L = new TreeNode("L", 29);
		TreeNode M = new TreeNode("M", 31);
		TreeNode N = new TreeNode("N", 41);
		TreeNode O = new TreeNode("O", 47);
		TreeNode P = new TreeNode("P", 53);

		A.left = B;
		A.right = I;

		B.left = C;
		B.right = F;

		C.left = D;
		C.right = E;

		F.right = G;

		G.left = H;

		I.left = J;
		I.right = O;

		J.right = K;

		K.left = L;
		K.right = N;

		L.right = M;

		O.right = P;

		return A;
	}
	
	
	public static TreeNode L;
	public static TreeNode N;

	public static TreeNode createBinarySearchTree() {
		TreeNode A = new TreeNode("A", 8);
		TreeNode B = new TreeNode("B", 4);
		TreeNode C = new TreeNode("C", 2);
		TreeNode D = new TreeNode("D", 1);
		TreeNode E = new TreeNode("E", 3);
		TreeNode F = new TreeNode("F", 5);
		TreeNode G = new TreeNode("G", 7);
		TreeNode H = new TreeNode("H", 6);
		TreeNode I = new TreeNode("I", 14);
		TreeNode J = new TreeNode("J", 9);
		TreeNode K = new TreeNode("K", 12);
		 L = new TreeNode("L", 10);
		TreeNode M = new TreeNode("M", 11);
		 N = new TreeNode("N", 13);
		TreeNode O = new TreeNode("O", 15);
		TreeNode P = new TreeNode("P", 16);

		A.left = B;
		A.right = I;

		B.left = C;
		B.right = F;

		C.left = D;
		C.right = E;

		F.right = G;

		G.left = H;

		I.left = J;
		I.right = O;

		J.right = K;

		K.left = L;
		K.right = N;

		L.right = M;

		O.right = P;

		return A;
	}
	
	public static TreeNode createBinaryTree(){
		
		TreeNode A = new TreeNode("A", 314, 16);
		TreeNode B = new TreeNode("B", 6, 7);
		TreeNode C = new TreeNode("C", 271, 3);
		TreeNode D = new TreeNode("D", 28, 1);
		TreeNode E = new TreeNode("E", 0, 1);
		TreeNode F = new TreeNode("F", 561, 3);
		TreeNode G = new TreeNode("G", 3, 2);
		TreeNode H = new TreeNode("H", 17, 1);
		TreeNode I = new TreeNode("I", 6, 8);
		TreeNode J = new TreeNode("J", 2, 5);
		TreeNode K = new TreeNode("K", 1, 4);
		TreeNode L = new TreeNode("L", 401, 2);
		TreeNode M = new TreeNode("M", 641, 1);
		TreeNode N = new TreeNode("N", 257, 1);
		TreeNode O = new TreeNode("O", 271, 2);
		TreeNode P = new TreeNode("P", 28, 1);
		
		A.left = B;
		A.right = I;
		
		B.left = C;
		B.right = F;
		
		C.left = D;
		C.right = E;
		
		F.right = G;

		G.left = H;

		I.left = J;
		I.right = O;
		
		J.right = K;
		
		K.left = L;
		K.right=N;
		
		L.right = M;
		
		O.right = P;
		
		return A;
	}
}
