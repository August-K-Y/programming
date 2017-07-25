package kang.interview.programming.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import kang.interview.programming.optimization.*;

/**
 * LeetCode: 220. Contains Duplicate III
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k. <br/>
 * 
 * <p>
 * This is a variation of the sliding window problem, referring to
 * {@link SlidingWindowMaximum_M} to check the explanation of sliding window
 * problem. One difference is that the window size is not explicitly given, it
 * is the k + 1, the maximum difference between two different position plus one.
 * </p>
 * 
 * @see ContainsDuplicate
 * @see ContainsNearbyDuplicate
 * @see {@link SlidingWindowMaximum_M}
 * @author Yan Kang
 *
 */
public class ContainsNearbyAlmostDuplicate_H {
	
	/**
	 * This algorithm is using a hash set to store elements within a window and
	 * to do the range search. This algorithm works fine with relatively small
	 * window size but it will consume a large amount of time when the window
	 * size is large since the time complexity is O(Nk) where N is the size of
	 * the array and k is the size of the window.
	 * 
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (nums == null || nums.length == 0 || k == 0 || t < 0)
			return false;

		if (k + 1 > nums.length)
			k = nums.length - 1;

		Set<Integer> set = new HashSet<>();
		int r = 0;
		int l = 0;
		for (; r < k + 1; r++) {
			// We check if there exists a value in the set such that the
			// absolute difference between this value and nums[r] is at most t,
			// before we add nums[r] to the set. The same as the one in the
			// while loop.
			if (checkWithinRange(set, nums[r], t)) {
				return true;
			}
			set.add(nums[r]);
		}
		while (r < nums.length) {
			set.remove(nums[l++]);
			if (checkWithinRange(set, nums[r], t)) {
				return true;
			}
			set.add(nums[r++]);
		}
		return false;
	}

	/**
	 * Check whether there exists a value in the specified set such that the
	 * absolute difference between this value and v is at most t,
	 * 
	 * @param set
	 * @param v
	 * @param t
	 * @return
	 */
	private boolean checkWithinRange(Set<Integer> set, int v, int t) {
		for (int s : set) {
			if (Math.abs((long) s - (long) v) <= (long) t)
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Three take-away from previous version of the algorithm:
	 * <ul>
	 * <li>Always consider overflow when doing manipulation on values of integer
	 * type</li>
	 * <li>Always consider negative value scenario when the question does not
	 * explicitly rule out this possibility</li>
	 * <li>Linear time search, as sub-problem, is usually not a good idea for a
	 * large search space (e.g., array)</li>
	 * </ul>
	 * 
	 * As mentioned in previous version of the algorithm, time complexity is
	 * O(Nk) is not feasible for a large window size. Therefore, this version
	 * algorithm will reduce the linear search time on the elements of a window
	 * to logarithmic time by using {@link TreeSet}. The total time complexity
	 * of this algorithm would be O(N*logk).
	 * 
	 * <p>
	 * Rational reason of {@link TreeSet}:</br>
	 * {@link HashSet} is a excellent choice for search a specific element
	 * (exact match). However, {@link TreeSet} is good for range search: search
	 * value(s) in a tree within given range of a given value.
	 * </p>
	 * <p>
	 * This version of the algorithm is the same as previous version except that
	 * this version using {@link TreeSet} to hold elements of a window and do
	 * the range search.
	 * </p>
	 * 
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate_(int[] nums, int k, int t) {

		if (nums == null || nums.length == 0 || k == 0 || t < 0)
			return false;

		if (k + 1 > nums.length)
			k = nums.length - 1;

		// Using TreeSet to hold elements of a window and do the range search.
		TreeSet<Integer> set = new TreeSet<>();
		int r = 0;
		int l = 0;
		for (; r < k + 1; r++) {
			if (checkWithInRange_BST(set, nums[r], t)) {
				return true;
			}
			set.add(nums[r]);
		}
		while (r < nums.length) {
			set.remove(nums[l++]);
			if (checkWithInRange_BST(set, nums[r], t)) {
				return true;
			}
			set.add(nums[r++]);
		}
		return false;
	}

	/**
	 * Math.abs(s - v) <= t can be decomposed into:</br>
	 * <ol>
	 * <li>s - v <= t when s >= v</li>
	 * <li>v - s <= t when s <= v</li>
	 * </ol>
	 * <p>
	 * Therefore, the problem of checking whether we can find a value s in the
	 * tree set such that Math.abs(s - v) <= t can be reiterated as:</br>
	 * <blockquote>Checking whether we can find a value s in the tree set such
	 * that either <b>s - v <= t when s >= t</b>, or <b>v - s <= t when s <=
	 * t</b>.</blockquote>
	 * </p>
	 * <p>
	 * To satisfy either of the two constraints, we just need to find the least
	 * element in this tree set that is greater than or equal to v or find
	 * greatest element in this tree set that is less than or equal to v.
	 * {@link TreeSet#ceiling(Object)} and {@link TreeSet#floor(Object)}
	 * perfectly suite this need.</br>
	 * </p>
	 * 
	 * @param set
	 * @param v
	 * @param t
	 * @return
	 */
	private boolean checkWithInRange_BST(TreeSet<Integer> set, int v, int t) {
		Integer floor = set.floor(v);
		Integer ceiling = set.ceiling(v);
		if (floor != null && (long) v - (long) floor <= (long) t
				|| ceiling != null && (long) ceiling - (long) v <= (long) t)
			return true;
		return false;
	}
	
	// TODO: review this algorithm
	/**
	 * From LeetCode:
	 * 
	 * As a followup question, it naturally also requires maintaining a window
	 * of size k. When t == 0, it reduces to the previous question so we just
	 * reuse the solution.
	 * 
	 * Since there is now a constraint on the range of the values of the
	 * elements to be considered duplicates, it reminds us of doing a range
	 * check which is implemented in tree data structure and would take O(LogN)
	 * if a balanced tree structure is used, or doing a bucket check which is
	 * constant time. We shall just discuss the idea using bucket here.
	 * 
	 * Bucketing means we map a range of values to the a bucket. For example, if
	 * the bucket size is 3, we consider 0, 1, 2 all map to the same bucket.
	 * However, if t == 3, (0, 3) is a considered duplicates but does not map to
	 * the same bucket. This is fine since we are checking the buckets
	 * immediately before and after as well. So, as a rule of thumb, just make
	 * sure the size of the bucket is reasonable such that elements having the
	 * same bucket is immediately considered duplicates or duplicates must lie
	 * within adjacent buckets. So this actually gives us a range of possible
	 * bucket size, i.e. t and t + 1. We just choose it to be t and a bucket
	 * mapping to be num / t.
	 * 
	 * Another complication is that negative ints are allowed. A simple num / t
	 * just shrinks everything towards 0. Therefore, we can just reposition
	 * every element to start from Integer.MIN_VALUE.
	 * 
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 * @see https://discuss.leetcode.com/topic/15199/ac-o-n-solution-in-java-
	 *      using-buckets-with-explanation
	 */
	public boolean containsNearbyAlmostDuplicate__(int[] nums, int k, int t) {
		if (k < 1 || t < 0)
			return false;
		Map<Long, Long> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
			long bucket = remappedNum / ((long) t + 1);
			if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
					|| (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
				return true;
			if (map.entrySet().size() >= k) {
				long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
				map.remove(lastBucket);
			}
			map.put(bucket, remappedNum);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsNearbyAlmostDuplicate_H d = new ContainsNearbyAlmostDuplicate_H();
		// int[] nums = { 1 };
		// System.out.println(d.containsNearbyAlmostDuplicate(nums, 1, 1));

		// int[] nums2 = { -1, -1 };
		// System.out.println(d.containsNearbyAlmostDuplicate(nums2, 1, 0) + ":
		// true");

		int[] nums3 = { 1, 3, 1 };
		System.out.println(d.containsNearbyAlmostDuplicate_(nums3, 1, 1) + ": false");

		int[] nums4 = { -1, 0, 1, 1 };
		System.out.println(d.containsNearbyAlmostDuplicate_(nums4, 1, 0) + ": true");

		int[] nums5 = { -1, Integer.MAX_VALUE };
		System.out.println(d.containsNearbyAlmostDuplicate_(nums5, 1, Integer.MAX_VALUE) + ": false");
		
		System.out.println(d.containsNearbyAlmostDuplicate(nums5, 1, Integer.MAX_VALUE) + ": false");
	}
}
