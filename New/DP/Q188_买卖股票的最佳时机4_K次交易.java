package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/26 9:25
 */
public class Q188_买卖股票的最佳时机4_K次交易 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        // 最多交易: 一直头天买， 第二天卖
        k = Math.min(k, n / 2);
        int[][][] dp = new int[2][k + 1][n + 1];
        for(int i = 0; i <= k; i++) {
            dp[1][i][0] = -prices[0];
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k ; j++) {
                // dp[0][j][i] = Math.max(dp[0][j][i - 1], dp[1][j - 1][i - 1] + prices[i - 1]);
                // dp[1][j][i] = Math.max(dp[1][j][i - 1], dp[0][j][i - 1] - prices[i - 1]);
                // // 定义一次买入为一次交易
                dp[0][j][i] = Math.max(dp[0][j][i - 1], dp[1][j][i - 1] + prices[i - 1]);
                dp[1][j][i] = Math.max(dp[1][j][i - 1], dp[0][j - 1][i - 1] - prices[i - 1]);
            }
        }
        // System.out.println(Arrays.toString(dp[1][1]));
        // System.out.println(Arrays.toString(dp[0][1]));
        return dp[0][k][n];
    }
}
