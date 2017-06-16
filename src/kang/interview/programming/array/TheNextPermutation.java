package kang.interview.programming.array;

import java.util.HashSet;
import java.util.Set;

import kang.interview.programming.util.AlgorithmTestUtil;

public class TheNextPermutation {

	public void nextPermutation(int[] array) {

		Set<Integer> track = new HashSet<>();

		init(track, array);
		
		int index = -1;
		int nextValue = -1;
		for (int i = 0; i < array.length - 1; i++) {
			int temp = array[i];
			track.remove(temp);
			int bigger = getBigger(track, temp);
			if (bigger >= 0) {
				index = i;
				nextValue = bigger;
			}
		}

		if (index < 0) {
			for (int i = 0; i < array.length; i++)
				array[i] = -1;
		} else {

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

	private int getBigger(Set<Integer> track, int temp) {
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

	public static void main(String[] args) {

		int[] array = { 3,2,1,0 };
		TheNextPermutation t = new TheNextPermutation();
		t.nextPermutation(array);
		if (array.length > 0) {
			AlgorithmTestUtil.printArray(array);
		} else {
			System.out.println("no next");
		}

	}

}
