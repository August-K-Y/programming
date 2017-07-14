package kang.interview.programming.array;

public class MergeTwoSortedArraysInPlace {

	/**
	 * 
	 * @param aArray
	 * @param aLength
	 * @param bArray
	 * @param bLength
	 * @return
	 */
	public int mergeSortedArrays(int[] aArray, int aLength, int[] bArray, int bLength) {

		int writeIndex = aLength + bLength - 1;

		int i = aLength - 1;
		int j = bLength - 1;
		while (writeIndex >= 0) {

			if (aArray[i] >= bArray[j]) {
				aArray[writeIndex--] = aArray[i--];
			} else {
				aArray[writeIndex--] = bArray[j--];
			}

			if (i < 0 || j < 0)
				break;
		}

		while (i >= 0) {
			aArray[writeIndex--] = aArray[i--];
		}

		while (j >= 0) {
			aArray[writeIndex--] = bArray[j--];
		}

		return aLength + bLength;
	}

	public static void main(String[] arg) {
		System.out.println("run");
		int[] aArray = { 1, 2, 4, 6, 7, 12, 14, 16, 17, 21, 32, 44, 55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] bArray = { 1, 7, 8, 11, 12, 18, 19, 21, 22 };
		MergeTwoSortedArraysInPlace ora = new MergeTwoSortedArraysInPlace();
		int length = ora.mergeSortedArrays(aArray, 13, bArray, 9);
		System.out.println("size: " + length);
		for (int i = 0; i < length; i++) {
			System.out.print(aArray[i] + ", ");
		}
	}
}
