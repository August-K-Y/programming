package kang.interview.programming.recursive.dynamicprogramming;


/**
 * LeetCode 265. Paint House II:
 * https://leetcode.com/problems/paint-house-ii/description/
 * 
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note: All costs are positive integers.
 * 
 * Follow up: Could you solve it in O(nk) runtime?
 * 
 * @author Yan Kang
 *
 */
public class PaintHouse_II_H {

	/**
	 * O(N*K*K)
	 * @param costs
	 * @return
	 */
	public int minCostII(int[][] costs) {

		if (costs == null || costs.length == 0)
			return 0;

		int[][] dp = new int[costs.length][costs[0].length];
		for (int i = 0; i < costs[0].length; i++) {
			dp[0][i] = costs[0][i];
		}
		for (int i = 1; i < costs.length; i++) {
			for (int j = 0; j < costs[0].length; j++) {
				int min = Integer.MAX_VALUE;

				// For each house, iterate all colors to find the one with
				// minimal cost so far.
				for (int z = 0; z < costs[0].length; z++) {
					if (z != j)
						min = Math.min(min, dp[i - 1][z]);
				}
				dp[i][j] = min + costs[i][j];
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < costs[0].length; i++)
			min = Math.min(min, dp[dp.length - 1][i]);
		return min;
	}
	
	/**
	 * Solution;
	 * https://leetcode.com/problems/paint-house-ii/discuss/
	 * 
	 * The idea is similar to the problem Paint House I, for each house and each
	 * color, the minimum cost of painting the house with that color should be
	 * the minimum cost of painting previous houses, and make sure the previous
	 * house doesn't paint with the same color.
	 * 
	 * We can use min1 and min2 to track the indices of the 1st and 2nd smallest
	 * cost till previous house, if the current color's index is same as min1,
	 * then we have to go with min2, otherwise we can safely go with min1.
	 * 
	 * The code below modifies the value of costs[][] so we don't need extra
	 * space.
	 * 
	 * @param costs
	 * @return
	 */
    public int minCostII_(int[][] costs) {

        if(costs == null || costs.length == 0)
            return 0;

		// Why need track the 1st and 2nd smallest cost so far? Because the
		// color of current house can not be the same as that of previous house.
		// If the current color's index is same as min1, then we have to go with
		// min2, otherwise we can safely go with min1.
		int min1 = -1, min2 = -1;
		for (int i = 0; i < costs.length; i++) {

			// prev1 and prev2 are the 1st and 2nd smallest cost till previous
			// house, i.e., i-1.
			int prev1 = min1, prev2 = min2;
			
			// Initialize min1 and min2, which will track the 1st and 2nd
			// smallest cost of current house.
			min1 = -1;
			min2 = -1;

			for (int j = 0; j < costs[0].length; j++) {
				// If color j is the same as prev1, compute the cost based on
				// prev1. Otherwise, compute cost based prev2.
				if (j != prev1) {
					costs[i][j] += prev1 < 0 ? 0 : costs[i - 1][prev1];
				} else {
					costs[i][j] += prev2 < 0 ? 0 : costs[i - 1][prev2];
				}

				// Record the colors that lead to the 1st and 2nd smallest cost
				if (min1 < 0 || costs[i][j] < costs[i][min1]) {
					min2 = min1;
					min1 = j;
				} else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
					min2 = j;
				}

				// It worth noting that the initial value of min1, min2, prev1
				// and prev2 are -1, which means that these values have not been
				// calculated yet and it is a clear way to avoid checking out of
				// array exception of index i and j
			}
		}
		return costs[costs.length - 1][min1];
	}
}
