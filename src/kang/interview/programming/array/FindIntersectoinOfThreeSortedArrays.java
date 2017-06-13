package kang.interview.programming.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kang.interview.programming.util.AlgorithmTestUtil;

public class FindIntersectoinOfThreeSortedArrays {
	
	public List<Integer> findIntersection(int[] array1, int[] array2, int[] array3) {

		List<Integer> rec = new ArrayList<>();
		int idx1 = 0;
		int idx2 = 0;
		int idx3 = 0;
		while (idx1 < array1.length && idx2 < array2.length && idx3 < array3.length) {
			if (array1[idx1] == array2[idx2] && array2[idx2] == array3[idx3]) {
				rec.add(array1[idx1]);
				idx1++;
			} else if (array1[idx1] <= array2[idx2] && array1[idx1] <= array3[idx3]) {
				idx1++;
			} else if (array2[idx2] <= array1[idx1] && array2[idx2] <= array3[idx3]) {
				idx2++;
			} else {
				idx3++;
			}
		}
		return rec;
	}
	
	public List<Integer> findIntersection(List<Integer> array1, List<Integer> array2, List<Integer> array3) {

		List<Integer> merged = findIntersection(array1, array2);
		merged = findIntersection(merged, array3);
		return merged;
	}
	
	private List<Integer> findIntersection(List<Integer> array1, List<Integer> array2) {

		List<Integer> rec = new ArrayList<>();
		int idx1 = 0;
		int idx2 = 0;
		while (idx1 < array1.size() && idx2 < array2.size()) {
			if (array1.get(idx1) == array2.get(idx2)) {
				rec.add(array1.get(idx1));
				idx1++;
			} else if (array1.get(idx1) < array2.get(idx2)) {
				idx1++;
			} else {
				idx2++;
			}
		}
		return rec;
	}

	public static void main(String[] args) {
		FindIntersectoinOfThreeSortedArrays s = new FindIntersectoinOfThreeSortedArrays();

		int[] input1 = { 1, 15, 10, 20, 40, 80 };
		int[] input2 = { 6, 7, 15, 20, 80, 100 };
		int[] input3 = { 3, 4, 15, 20, 30, 70, 80, 120 };

		List<Integer> result = s.findIntersection(input1, input2, input3);
		AlgorithmTestUtil.printList(result);
		result = s.findIntersection(Arrays.stream(input1).boxed().collect(Collectors.toList()), 
				Arrays.stream(input2).boxed().collect(Collectors.toList()),
				Arrays.stream(input3).boxed().collect(Collectors.toList()));
		System.out.println();
		AlgorithmTestUtil.printList(result);
	}
}
