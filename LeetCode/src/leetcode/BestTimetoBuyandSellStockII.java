package leetcode;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		BestTimetoBuyandSellStockII btbss = new BestTimetoBuyandSellStockII();
		int[] prices = { 1, 2, 3, 4, 5, 6, 7 };
		int ret = btbss.maxProfit(prices);
		System.out.println(ret);
	}
	//GREEDY
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += prices[i] - prices[i - 1];
			}
		}
		return maxProfit;
	}
}
