package kang.interview.programming.invariant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	/**
	 * O(n*nlogn)
	 * @param input
	 * @param value
	 * @return
	 */
	public boolean hasThreeSum_unsorted_duplicateAllowed(List<Integer> input, int value) {
		List<Integer> copiedInput = new ArrayList<>(input);
		Collections.sort(copiedInput);

		for (int e : input) {
			return hasTwoSum(copiedInput, value - e);
		}
		return false;
	}
	
	public boolean hasThreeSum_unsorted_duplicateNotAllowed(List<Integer> input, int value) {
		// TODO:
		return false;
	}

	private boolean hasTwoSum(List<Integer> copiedInput, int value) {
		int left = 0;
		int right = copiedInput.size() - 1;
		while (left <= right) {
			int sum = copiedInput.get(left) + copiedInput.get(right);
			if (sum == value) {
				return true;
			} else if (sum < value) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(2);
		list.add(5);
		list.add(7);
		list.add(3);

		ThreeSum t = new ThreeSum();
		System.out.println(t.hasThreeSum_unsorted_duplicateAllowed(list, 21));
		System.out.println(t.hasThreeSum_unsorted_duplicateAllowed(list, 22));
	}

}
