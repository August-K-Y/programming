package kang.interview.programming.array.deleteduplicates;

import kang.interview.programming.util.DataPrinter;

public class DeleteDuplicatedFromSortedArray {

	public int deleteDuplicates(int[] array) {
		//		int prev = array[0];
		//		int probeIndex = 1;
		//		int writeIndex = 1;
		//		while (writeIndex < array.length && probeIndex < array.length) {
		//			if (array[probeIndex] != prev) {
		//				prev = array[probeIndex];
		//				array[writeIndex++] = array[probeIndex++];
		//			} else {
		//				probeIndex++;
		//			}
		//		}
		//		return writeIndex;
		
		/*
		 * More clean code as before: 
		 */
		
		int writeIndex = 1; // pointing to the vacant entry to be filled
		for (int probeIndex = 1; probeIndex < array.length; probeIndex++) {
			if (array[probeIndex] != array[writeIndex - 1])
				array[writeIndex++] = array[probeIndex];
		}
		return writeIndex - 1;
	}
	
	public int deleteDuplicatesAllowAtMostTwice(int[] array) {
		int appearance = 1;
		int writeIndex = 1; // pointing to the vacant entry to be filled
		for (int probeIndex = 1; probeIndex < array.length; probeIndex++) {
			if (array[probeIndex] != array[writeIndex - 1]) {
				array[writeIndex++] = array[probeIndex];
				appearance = 1;
			} 
			else if (appearance < 2) // if already appears once
			{
				array[writeIndex++] = array[probeIndex];
				appearance++;
			} 
		}
		return writeIndex - 1;
	}
	
	public static void main(String[] arg) {
		System.out.println("run");
		int[] array = { 2, 3, 5, 5, 5, 7, 11, 11, 11,11, 13};
		
		DataPrinter.printArray(array);
		DeleteDuplicatedFromSortedArray ora = new DeleteDuplicatedFromSortedArray();
		int end = ora.deleteDuplicatesAllowAtMostTwice(array);
		System.out.println();
		DataPrinter.printArray(array, end);
	}

}
