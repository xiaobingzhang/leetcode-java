 

public class BestTimetoBuyandSellStockIII {
	public static void main(String[] args) {
		BestTimetoBuyandSellStockIII btbss = new BestTimetoBuyandSellStockIII();
		int[] prices = { 1, 2, 3 };
		int ret = btbss.maxProfit(prices);
		System.out.println(ret);
	}

	// DP
	public int maxProfit(int[] prices) {
		int ret = 0;
		if (prices.length == 0) {
			return 0;
		}
		int n = prices.length;

		// dp[] 0..i最大收益
		int[] dp = new int[n];
		dp[0] = 0;
		int low = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < n; i++) {
			maxProfit = Math.max(prices[i] - low, maxProfit);
			low = Math.min(low, prices[i]);
			dp[i] = maxProfit;
		}
		// reverseDp[] i...n-1最大利益
		int[] reverseDp = new int[n];
		reverseDp[n-1] = 0;
		int high = prices[n-1];
		maxProfit = 0;
		for(int i = n-2;i>=0;i--){
			maxProfit = Math.max(high-prices[i], maxProfit);
			high = Math.max(high, prices[i]);
			reverseDp[i] = maxProfit;
		}
		//
		for(int i=0;i<n;i++){
			int tmp = dp[i]+reverseDp[i];
			if(ret < tmp){
				ret = tmp;
			}
		}
		return ret;
	}

	
}
