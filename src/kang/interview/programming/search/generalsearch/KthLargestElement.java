package kang.interview.programming.search.generalsearch;

import java.util.Arrays;

public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
}
