package kang.interview.programming.zhe;

/**
 * You have an array of integers nums and an array queries, where queries[i] is
 * a pair of indices (0-based). Find the sum of the elements in nums from the
 * indices at queries[i][0] to queries[i][1] (inclusive) for each query, then
 * add all of the sums for all the queries together. Return that number modulo
 * 109 + 7.
 * 
 * Example
 * 
 * For nums = [3, 0, -2, 6, -3, 2] and queries = [[0, 2], [2, 5], [0, 5]], the
 * output should be 
 * 		sumInRange(nums, queries) = 10.
 * 
 * The array of results for queries is [1, 3, 6], so the answer is 
 * 		1 + 3 + 6 = 10.
 * 
 * @author Yan Kang
 *
 */
public class SumInRange {
	int sumInRange(int[] nums, int[][] queries) {
		int[] re = new int[nums.length];
		
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			re[i] = sum;
		}
		
		int result = 0;
		for (int[] q : queries) {
			result += (re[q[1]] - ((q[0] - 1) >= 0 ? re[q[0] - 1] : 0));
			result = Math.floorMod(result, 1000000007);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = { 3, 0, -2, 6, -3, 2 };
		int[][] queries = { { 0, 2 }, { 2, 5 }, { 0, 5 } };
		SumInRange r = new SumInRange();
		System.out.println(r.sumInRange(nums, queries));
	}
	
//	function sumInRange(nums, queries) {
//	    'use strict';
//	    
//	    // First we build a list of prefix sums. Each index i of prefixSums
//	    // contains the sum of the numbers nums[0] to nums[i].
//	    let partialSum = 0;
//	    const prefixSums = nums.map(n => partialSum += n);
//	    
//	    // For each query, find its sum by getting the difference between the
//	    // sum of nums[0 to query[0]] and nums[0 to query[1]].
//	    const mod = 1e9 + 7;
//	    return queries.reduce((total, query) => {
//	        total += prefixSums[query[1]] - (prefixSums[query[0] - 1] || 0);
//	        // Negative modulo works differently in JavaScript than math
//	        return total < 0 ? total + mod : total % mod;
//	    }, 0);
//	}
//
//	/*
//	 * Here is another approach which actually has a better best case time
//	 * complexity and the same worst case complexity as the prefix sum
//	 * approach. Consider the example nums = [ n ] x 10^5,
//	 * queries = [ [100, 100] ]. This solution would perform one iteration
//	 * within the nums array, whereas a prefix sum approach would have to
//	 * iterate over the entire nums array, even though only one number from
//	 * the array is being queried.
//	 */
//	function sumInRangeBetter(nums, queries) {
//	    'use strict';
//	    
//	    // First we build a list to identify where the number of queries
//	    // to add changes. For example, if there was a query [ 2, 4 ],
//	    // the changes array would have a +1 at index 2 and a -1 at index 4.
//	    const changes = [];
//	    let start = Infinity,
//	        end = -Infinity;
//	    queries.forEach((query) => {
//	        changes[query[0]] = (changes[query[0]] || 0) + 1;
//	        changes[query[1] + 1] = (changes[query[1] + 1] || 0) - 1;
//	        // Keep track of the range covered by the queries because we may
//	        // not need to iterate through the entire nums array!
//	        if (query[0] < start) start = query[0];
//	        if (query[1] + 1 > end) end = query[1] + 1;
//	    });
//	    
//	    // For each value in nums, add it to the total query sum.
//	    // We keep a multiplier variable so we know how many queries include
//	    // the current index. When we come to a value in the changes array,
//	    // we update the multiplier.
//	    const mod = 1e9 + 7;
//	    let sum = 0,
//	        multiplier = 0;
//	    for (var i = start; i < end; i++) {
//	        multiplier += changes[i] || 0;
//	        sum += multiplier * nums[i];
//	        // Negative modulo works differently in JavaScript than math
//	        sum = sum < 0 ? sum + mod : sum % mod;
//	    }
//	    return sum;
//	}
}
