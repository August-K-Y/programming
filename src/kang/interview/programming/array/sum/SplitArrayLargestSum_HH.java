package kang.interview.programming.array.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kang.interview.programming.util.DataPrinter;


/**
 * LeetCode 410. Split Array Largest Sum:
 * https://leetcode.com/problems/split-array-largest-sum/description/
 * 
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 <= n <= 1000 1 <= m <= min(50, n) Examples:
 * 
 * Input:
 * 
 * nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation:
 * 
 * There are four ways to split nums into two subarrays. The best way is to
 * split it into [7,2,5] and [10,8], where the largest sum among the two
 * subarrays is only 18.
 * 
 * @author Yan Kang
 *
 */
public class SplitArrayLargestSum_HH {
	
	/**
	 * 
	 * 
	 * The answer is between maximum value of input array numbers and sum of
	 * those numbers.
	 * 
	 * Use binary search to approach the correct answer. We have l = max value
	 * of array; r = sum of all numbers in the array;Every time we do mid = (l +
	 * r) / 2;
	 * 
	 * Use greedy to narrow down left and right boundaries in binary search. 3.1
	 * Cut the array from left. 3.2 Try our best to make sure that the sum of
	 * numbers between each two cuts (inclusive) is large enough but still less
	 * than mid. 3.3 We'll end up with two results: either we can divide the
	 * array into more than m subarrays or we cannot. <br/>
	 * 
	 * If we can, it means that the mid value we pick is too small because we've
	 * already tried our best to make sure each part holds as many non-negative
	 * numbers as we can but we still have numbers left. So, it is impossible to
	 * cut the array into m parts and make sure each parts is no larger than
	 * mid. We should increase m. This leads to l = mid + 1; <br/>
	 * 
	 * If we can't, it is either we successfully divide the array into m parts
	 * and the sum of each part is less than mid, or we used up all numbers
	 * before we reach m. Both of them mean that we should lower mid because we
	 * need to find the minimum one. This leads to r = mid - 1;
	 */
	public int splitArray(int[] nums, int m) {

		// The answer is between maximum value of input array numbers and sum of
		// those numbers.
		long sum = 0;
		int max = 0;
		for (int n : nums) {
			sum += n;
			max = Math.max(max, n);
		}

		// If only one split, the largest sum is the sum of the whole array
		if (m == 1)
			return (int) sum;

		long min = sum;
		long l = max, r = sum;
		while (l <= r) {
			long mid = l + (r - l) / 2;
			if (valid(nums, mid, m)) {
				r = mid - 1;
				min = Math.min(min, mid);
			} else {
				l = mid + 1;
			}
		}
		return (int) min;
	}

	/**
	 * @param nums
	 * @param ub upper boundary
	 * @param sb split boundary
	 * @return
	 */
	private boolean valid(int[] nums, long ub, int sb) {
		long total = 0;
		int splits = 1;
		for (int num : nums) {
			total += num;
			if (total > ub) {
				total = num;
				splits++;
				if (splits > sb) {
					return false;
				}
			}
		}
		return true;
	}
	
	private Map<String, Integer> mem;
	public int splitArray_(int[] nums, int m) {

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
