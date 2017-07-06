package kang.interview.programming.hashtable;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 
 * 
 * 
 * Given an array of integers nums and an integer k, determine whether there are
 * two distinct indices i and j in the array where nums[i] = nums[j] and the
 * absolute difference between i and j is less than or equal to k.
 * 
 * Example
 * 
 * For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be
 * containsCloseNums(nums, k) = true.
 * 
 * There are two 2s in nums, and the absolute difference between their positions
 * is exactly 3.
 * 
 * For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be
 * containsCloseNums(nums, k) = false.
 * 
 * The absolute difference between the positions of the two 2s is 3, which is
 * more than k.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) 
 * 
 * [input] array.integer nums
 * 
 * Guaranteed constraints: 
 * 		0 <= nums.length <= 55000, 
 * 		-2^31 - 1 <= nums[i] <= 2^31- 1.
 * 
 * [input] integer k
 * 
 * Guaranteed constraints: 0 <= k <= 35000.
 * 
 * [output] boolean
 * 
 * @see FindNearestRepeatedNums
 * 
 * @author Yan Kang
 *
 */
public class ContainsCloseNums {

	// Brute force way is using two loops and takes O(n^2) time
	
	/**
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	boolean containsCloseNums(int[] nums, int k) {

		/*
		 * When iterating an array, hash map is typically keyed by values
		 * rather than the index of the array.
		 */
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer d = map.get(nums[i]);
			if (d != null && i - d <= k)
				return true;
			map.put(nums[i], i);
		}
		return false;
	}
	
	/*
	 * Python code
	 */
//	def containsCloseNums(nums, k):
//	    dic = {}
//	    for i, x in enumerate(nums):
//	        if x in dic and i - dic[x] <= k:
//	            return True
//	        dic[x] = i
//	    return False


	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3, 5, 2 };
		ContainsCloseNums alg = new ContainsCloseNums();
		System.out.println(alg.containsCloseNums(nums, 2));
		System.out.println(alg.containsCloseNums(nums, 3));
	}

}
