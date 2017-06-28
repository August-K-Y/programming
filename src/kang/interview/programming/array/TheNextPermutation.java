package kang.interview.programming.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kang.interview.programming.util.DataPrinter;

public class TheNextPermutation {

	/**
	 * brute-force
	 * @param array
	 */
	public void nextPermutation_bf(int[] array) {

		Set<Integer> track = new HashSet<>();

		init(track, array);
		
		// find the position at which the number needs to increase
		int index = -1;
		int nextValue = -1;
		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[i];
			track.remove(temp);
			int bigger = getNext(track, temp);
			if (bigger >= 0) {
				index = i;
				nextValue = bigger;
			}
		}

		if (index < 0) {
			// if no index found, there is no next permutation
			for (int i = 0; i < array.length; i++)
				array[i] = -1;
		} else {

			// 
			init(track, array);

			for (int i = 0; i < index; i++) {
				int temp = array[i];
				track.remove(temp);
			}

			track.remove(nextValue);
			array[index] = nextValue;

			for (int i = index + 1; i < array.length; i++) {
				array[i] = min(track);
				track.remove(array[i]);
			}
		}
	}

	private void init(Set<Integer> track, int[] array) {
		track.clear();
		for (int a : array)
			track.add(a);
	}

	private int min(Set<Integer> track) {
		int min = Integer.MAX_VALUE;
		for (int v : track) {
			if (v < min) {
				min = v;
			}
		}
		return min;
	}

	private int getNext(Set<Integer> track, int temp) {
		int min = Integer.MAX_VALUE;
		boolean hasnext = false;
		for (int v : track) {
			if (v > temp && v < min) {
				min = v;
				hasnext = true;
			}
		}
		return hasnext ? min : -1;
	}

	/**
	 * 
	 * @param perm
	 */
	public void nextPermutation(List<Integer> perm) {
		
		int index = -1;
		for (int i = perm.size() - 1; i > 0; i--) {
			if (perm.get(i) > perm.get(i - 1)) {
				index = i - 1;
				break;
			}
		}

		if (index < 0) {
			// if no index found, there is no next permutation
			for (int i = 0; i < perm.size(); i++)
				perm.set(i, -1);
		} else {
			int min = perm.get(index + 1);
			int minIndex = index + 1;
			for (int i = index + 2; i < perm.size(); i++) {
				if (perm.get(i) > perm.get(index) && perm.get(i) < min) {
					min = perm.get(i);
					minIndex = i;
				}
			}
			Collections.swap(perm, index, minIndex);
			
			Collections.reverse(perm.subList(index + 1, perm.size())); 
		}
	}

	public static void main(String[] args) {
		TheNextPermutation t = new TheNextPermutation();
		
		int[] array = { 1,0,3,2 };
		t.nextPermutation_bf(array);
		if (array.length > 0) {
			DataPrinter.printArray(array);
		} else {
			System.out.println("no next");
		}

		List<Integer> perm = DataPrinter.createList(1, 0, 2, 3);
		t.nextPermutation(perm);
		DataPrinter.printList(perm);
	}

}
