package kang.interview.programming.array.ksum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumOfSortedArray {
	
	/**
	 * 
	 * @param input
	 * @param value
	 * @return
	 */
	public boolean hasTwoSum_sorted(List<Integer> input, int value) 
	{
		int left = 0;
		int right = input.size() - 1;
		while (left < right) {
			int sum = input.get(left) + input.get(right);
			if (sum == value) {
				return true;
			}

			if (sum > value) {
				right--;
			} else {
				left++;
			}

		}
		return false;
	}
	
	public boolean hasTwoSum_unsorted(List<Integer> input, int value) 
	{
		Set<Integer> track = new HashSet<Integer>();
		for(int e : input) {
			if(track.contains(e)){
				return true;
			} else {
				track.add(value - e);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(-2);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(7);
		list.add(11);

		TwoSumOfSortedArray t= new TwoSumOfSortedArray();
		System.out.println(t.hasTwoSum_sorted(list, 6));
		System.out.println(t.hasTwoSum_unsorted(list, 6));
	}
}
