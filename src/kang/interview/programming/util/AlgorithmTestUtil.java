package kang.interview.programming.util;

public class AlgorithmTestUtil {
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}

	public static void printArray(int[] array, int index) {
		if (index >= array.length)
			throw new IllegalArgumentException();
		for (int i = 0; i <= index; i++) {
			System.out.print(array[i] + ", ");
		}
	}

}
