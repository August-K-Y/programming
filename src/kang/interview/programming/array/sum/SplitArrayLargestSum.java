package kang.interview.programming.array.sum;

import java.util.Arrays;

import kang.interview.programming.util.DataPrinter;

public class SplitArrayLargestSum {
	
	public int splitArray(int[] nums, int m) {
		
		
		int[] bucket = new int[m];
		Arrays.sort(nums);
		
		int j = 0;
		boolean flip = true;
		for (int i = nums.length - 1; i >= 0; i--) {
            
			if (flip) {
				bucket[j++] += nums[i];
			} else {
				bucket[j--] += nums[i];
			}

			if (j == m) {
				flip = !flip;
				j = m - 1;
			}

			if (j == -1) {
				flip = !flip;
				j = 0;
			}

		}
		DataPrinter.printArray(bucket);
		
		System.out.println();
		int max = 0;
		for(int val : bucket)
			max = Math.max(max, val);
		
		return max;
	}
	
	
	public int splitArray_(int[] nums, int m) {

		min = Integer.MAX_VALUE;
		int[] sums = new int[nums.length + 1];
		sums[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}

		split(1, sums, m, 0);
		return min;

	}
	
	private int min;

	private void split(int index, int[] sums, int m, int maxVal) {

		if (m == 1) {
			maxVal = Math.max(maxVal, sums[sums.length - 1] - sums[index - 1]);
			min = Math.min(min, maxVal);
		} else {
			for (int i = index; i < sums.length - m + 1; i++) {
				maxVal = Math.max(sums[i] - sums[index - 1], maxVal);
				split(i + 1, sums, m - 1, maxVal);
			}
		}
	}
	
	public static void main(String[] arg) {
		SplitArrayLargestSum alg = new SplitArrayLargestSum();
		int[] nums = { 7, 2, 5, 10, 8 };
		int m = 2;

		DataPrinter.println(alg.splitArray_(nums, m));

	}
}
