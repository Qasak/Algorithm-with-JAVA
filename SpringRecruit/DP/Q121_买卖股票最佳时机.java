package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:58
 */
public class Q121_买卖股票最佳时机 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buy = 100001;
        for(int i : prices) {
            buy = Math.min(buy, i);
            ans = Math.max(ans, i - buy);
        }
        return ans;
    }
    // dp

    // [1,55,0,6]
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int buy = prices[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return dp[n - 1];
    }
}
