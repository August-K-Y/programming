package kang.interview.programming.array.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;

public class SplitArrayLargestSum_HH {
	
//	public int splitArray___(int[] nums, int m) {
//		
//		
//		int[] bucket = new int[m];
//		Arrays.sort(nums);
//		
//		int j = 0;
//		boolean flip = true;
//		for (int i = nums.length - 1; i >= 0; i--) {
//            
//			if (flip) {
//				bucket[j++] += nums[i];
//			} else {
//				bucket[j--] += nums[i];
//			}
//
//			if (j == m) {
//				flip = !flip;
//				j = m - 1;
//			}
//
//			if (j == -1) {
//				flip = !flip;
//				j = 0;
//			}
//
//		}
//		DataPrinter.printArray(bucket);
//		
//		System.out.println();
//		int max = 0;
//		for(int val : bucket)
//			max = Math.max(max, val);
//		
//		return max;
//	}
//	
	
	
	
	
	
//	
//	public int splitArray_(int[] nums, int m) {
//
//		min = Integer.MAX_VALUE;
//		int[] sums = new int[nums.length + 1];
//		sums[0] = 0;
//		for (int i = 0; i < nums.length; i++) {
//			sums[i + 1] = sums[i] + nums[i];
//		}
//
//		split_(1, sums, m, 0);
//		return min;
//
//	}
//	
//	private int min;
//
//	private void split_(int index, int[] sums, int m, int maxVal) {
//
//		if (m == 1) {
//			maxVal = Math.max(maxVal, sums[sums.length - 1] - sums[index - 1]);
//			min = Math.min(min, maxVal);
//		} else {
//			for (int i = index; i < sums.length - m + 1; i++) {
//				maxVal = Math.max(sums[i] - sums[index - 1], maxVal);
//				split_(i + 1, sums, m - 1, maxVal);
//			}
//		}
//	}
	
	
	/**
	 * 
	 */
	
	
	
	private Map<String, Integer> mem;
	
	public int splitArray(int[] nums, int m) {

		mem = new HashMap<String, Integer>();
		int[] sums = new int[nums.length + 1];
		sums[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}

		return split(1, sums, m);

	}

	private int split(int index, int[] sums, int groups) {
		String key = index + ":" + groups;
		if(mem.containsKey(key)){
			System.out.println("hit");
			return mem.get(key);
		}
		int min = Integer.MAX_VALUE;
		if (groups == 1) {
//			System.out.println(index + " --- " + (sums.length - 1));
			min = sums[sums.length - 1] - sums[index - 1];
			
//			System.out.println();
		} else {
			for (int i = index; i < sums.length - groups + 1; i++) {
//				System.out.println(index + " --- " + i + " | " + (i + 1) + " --->");
				
				int temp = Math.max(sums[i] - sums[index - 1], split(i + 1, sums, groups - 1));
				min = Math.min(min, temp);
				
			}
		}
		mem.put(index + ":" + groups, min);
		return min;
	}
	
	public static void main(String[] arg) {
		SplitArrayLargestSum_HH alg = new SplitArrayLargestSum_HH();
		int[] nums1 = { 7, 2, 5, 10, 8 };
		int m1 = 2;

		int[] nums2 = { 2, 3, 1, 2, 4, 3 };
		int m2 = 5;

		 DataPrinter.println(alg.splitArray(nums1, m1)); // 18
		DataPrinter.println(alg.splitArray(nums2, m2)); // 4

	}
}
