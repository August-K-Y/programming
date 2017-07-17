package kang.interview.programming.util;

import java.util.ArrayList;
import java.util.List;

import kang.interview.programming.linkedlist.LinkedList.ListNode;
import kang.interview.programming.zhe.Range;

public class DataPrinter {
	
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
	
	public static void printArray(char[] chars, int index) {
		if (index >= chars.length)
			throw new IllegalArgumentException();
		int rows = chars.length;
		for (int x = 0; x < rows; x++) {
			System.out.print(chars[x] + "");
		}
		System.out.println();
	}
	
	public static void printArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}

	public static void printList(List<Integer> result) {
		result.stream().forEach(a -> System.out.print(a + " "));
	}

	public static void printSubarray(int[] array, Range range) {
		for (int i = range.begin; i <= range.end; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public static void print2DArray(int[][] array) {
		int lastRows = array.length - 1;

		for (int i = 0; i <= lastRows; i++) {
			int lastCols = array[i].length - 1;
			for (int j = 0; j <= lastCols; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void print2DArray(char[][] array) {
		int lastRows = array.length - 1;

		for (int i = 0; i <= lastRows; i++) {
			int lastCols = array[i].length - 1;
			for (int j = 0; j <= lastCols; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void print2DArray(String[][] array) {
		int lastRows = array.length - 1;

		for (int i = 0; i <= lastRows; i++) {
			int lastCols = array[i].length - 1;
			for (int j = 0; j <= lastCols; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void print2DList(List<List<Integer>> twoDList) {
		for (List<Integer> level : twoDList) {
			for (int value : level) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	public static void printGrid(char[][] array) {
		int rows = array.length;
		int cols = array[0].length;
		
		System.out.println("-------------------------------------");
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				System.out.print(array[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
	
	public static ListNode printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		return head;
	}

	public static List<Integer> createList(int... value) {
		List<Integer> perm = new ArrayList<>(value.length);
		for (int v : value)
			perm.add(v);
		return perm;
	}

	public static void println(int num) {
		System.out.println(num);
	}

	public static void println(int[] array, int l, int r) {
		if (l > r)
			throw new IllegalArgumentException();
		
		for (int x = l; x <= r; x++) {
			System.out.print(array[x] + " ");
		}
		System.out.println();

	}

}
