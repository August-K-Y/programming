package kang.interview.programming.util;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.honors.Range;

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

	public static void printList(List<Integer> result) {
		result.stream().forEach(a -> System.out.print(a + " "));
	}

	public static void printSubarray(int[] array, Range range) {
		for (int i = range.begin; i <= range.end; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static List<Integer> createList(int... value) {
		List<Integer> perm = new ArrayList<>(value.length);
		for (int v : value)
			perm.add(v);
		return perm;
	}

}
