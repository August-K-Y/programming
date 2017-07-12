package kang.interview.programming.array.buysellstock;

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
