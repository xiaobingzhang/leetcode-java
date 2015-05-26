 

public class BestTimetoBuyandSellStock {
	public static void main(String[] args) {
		BestTimetoBuyandSellStock btbss = new BestTimetoBuyandSellStock();
		int[] prices = { 1, 2, 3, 4, 5, 6, 7 };
		int ret = btbss.maxProfit(prices);
		System.out.println(ret);
	}
	//DP
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		int maxProfit = 0;
		int low = prices[0];
		for (int i = 1; i < prices.length; i++) {
			int profit = prices[i] - low;
			maxProfit = Math.max(maxProfit, profit);
			low = Math.min(low, prices[i]);
		}
		return maxProfit;
	}
}
