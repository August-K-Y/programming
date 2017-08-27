package kang.interview.programming.array.buysellstock;

/**
 * LeetCode 121. Best Time to Buy and Sell Stock:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * Example 1: Input: [7, 1, 5, 3, 6, 4] Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
 * than buying price) 
 * 
 * Example 2: Input: [7, 6, 4, 3, 1] Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @author Yan Kang
 *
 */
public class BuyAndSellStockOnce {

	public int buyAndSellStockOnce(int[] prices) {
		int minsofar = prices[0];
		int maxprofits = 0;
		for (int i = 1; i < prices.length; i++) {
			maxprofits = Math.max(maxprofits, prices[i] - minsofar);
			minsofar = Math.min(minsofar, prices[i]);
		}
		return maxprofits;
	}

	public static void main(String[] arg) {
		System.out.println("run");
		int[] array = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 };

		BuyAndSellStockOnce ora = new BuyAndSellStockOnce();
		int profit = ora.buyAndSellStockOnce(array);
		System.out.println(profit);

		int[] array2 = { 12, 11, 13, 9, 12, 8, 14, 13, 15 };

		int profit2 = ora.buyAndSellStockOnce(array2);
		System.out.println(profit2);
	}
}
