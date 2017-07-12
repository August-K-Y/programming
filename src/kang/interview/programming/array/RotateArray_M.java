package kang.interview.programming.array;

import kang.interview.programming.util.DataPrinter;

/**
 * 
 * Elements of Programming: P450 25.6
 * 
 * @author Yan Kang
 *
 */
public class RotateArray_M {
	
	/**
	 * O(kN)
	 * 
	 * @param rotateAmount
	 * @param A
	 */
	public void ratateArray(int rotateAmount, int[] A) {
		rotateAmount = rotateAmount % A.length;
		for (int i = 0; i < rotateAmount; i++) {
			rotateByOne(A);
		}
	}

	private void rotateByOne(int[] a) {
		int temp = a[a.length - 1];
		for (int i = a.length - 2; i >= 0; i--) {
			a[i + 1] = a[i];
		}
		a[0] = temp;
	}

	/**
	 * O(N)
	 * 
	 * @param rotateAmount
	 * @param A
	 */
	public void ratateArray_(int rotateAmount, int[] A) {
		// TODO implement this
	}

	public static void main(String[] args) {
		RotateArray_M alg = new RotateArray_M();
		
		int[] a = {1,2,3,4,5,6,7,8,9};
		alg.ratateArray(6, a);
		DataPrinter.printArray(a);
		System.out.println();
		int[] a2 = {1,2,3,4,5,6,7,8,9};
		alg.ratateArray(15, a2);
		DataPrinter.printArray(a2);
	}

}
