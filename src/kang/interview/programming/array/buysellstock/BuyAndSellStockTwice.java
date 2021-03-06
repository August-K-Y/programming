package kang.interview.programming.array.buysellstock;

public class BuyAndSellStockTwice {
	
	/**
	 * brute-force: O(N^2) time complexity
	 * 
	 * @param prices
	 * @return
	 */
	public int buyAndSellStockTwice(int[] prices) {
		int minPriceSoFar = prices[0];
		int maxProfits = 0;
		int maxProfits1 = 0;
		for (int i = 1; i < prices.length; i++) {
			maxProfits1 = Math.max(maxProfits1, prices[i] - minPriceSoFar);
			minPriceSoFar = Math.min(minPriceSoFar, prices[i]);
			if (i + 1 < prices.length) {
				int minPriceSoFar2 = prices[i + 1];
				int maxProfits2 = 0;
				for (int j = i + 2; j < prices.length; j++) {
					maxProfits2 = Math.max(maxProfits2, prices[j] - minPriceSoFar2);
					minPriceSoFar2 = Math.min(minPriceSoFar2, prices[j]);
				}
				maxProfits = Math.max(maxProfits, maxProfits1 + maxProfits2);
			}
		}
		return maxProfits;
	}

	/**
	 * O(N) time complexity
	 * 
	 * @param prices
	 * @return
	 */
	public int buyAndSellStockTwice_(int[] prices) {
		return 0;
	}

	public static void main(String[] arg) {
		System.out.println("run");
		int[] array = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 };

		BuyAndSellStockTwice ora = new BuyAndSellStockTwice();
		int profit = ora.buyAndSellStockTwice(array);
		System.out.println(profit);

		int[] array2 = { 12, 11, 13, 9, 12, 8, 14, 13, 15 };

		int profit2 = ora.buyAndSellStockTwice(array2);
		System.out.println(profit2);
	}
}
