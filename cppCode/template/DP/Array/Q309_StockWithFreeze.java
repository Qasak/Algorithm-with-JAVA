package leetcode.template.DP.Array;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/14 11:31
 */
public class Q309_StockWithFreeze {
    // 尽可能地完成更多的交易
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) {
            return 0;
        }
        // 第i天不持有的最大值
        int[] dp0 = new int[n];
        // 第i天持有的最大值
        int[] dp1 = new int[n];


        // 第0天持有
        dp1[0] = -prices[0];
        dp0[0] = 0;
        // 第1天持有：
        dp1[1] = Math.max(-prices[0], -prices[1]);
        // 第1天不持有
        dp0[1] = Math.max(-prices[0] + prices[1], 0);
        for(int i = 2; i < n; i++) {
            // 今天持有 = max(前天不持有 + 今天买入, 昨天持有)
            dp1[i] = Math.max(dp0[i - 2] - prices[i], dp1[i - 1]);
            // 今天不持有 = max(昨天持有 + 今天卖出, 昨天不持有)
            dp0[i] = Math.max(dp1[i - 1] + prices[i], dp0[i - 1]);
        }

        return dp0[n - 1];
    }
}
