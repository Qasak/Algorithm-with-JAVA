package leetcode.template.DP.stock;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/17 15:55
 */
public class Q714_StockWithFee {
    public int maxProfit(int[] prices, int fee) {
        // 可以无限次地完成交易
        int n = prices.length;
        // dp[i][0] : 第i天持有的最大收益
        // dp[i][1] : 第i天不持有的最大收益
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[n - 1][1];
    }
    // 空间优化
    public int maxProfit1(int[] prices, int fee) {
        int n = prices.length;
        if(n < 2) {
            return 0;
        }
        // dp1[i]第i天手上有股票时的最大收益
        int dp1 = -prices[0];;
        // dp2[i]第i天手上无股票时的最大收益
        int dp2 = 0;
        for(int i = 1; i < n; i++) {
            // dp2[i-1] - prices[i] 表示第i天买入股票
            // 两种情况：保持第i-1天不变，或者通过头一天买入股票来转移到持有股票的状态
            dp1 = Math.max(dp1, dp2 - prices[i]);
            //
            dp2 = Math.max(dp2, dp1 + prices[i] - fee);
        }
        return dp2;

    }
    // 贪心：
    public int maxProfit2(int[] prices, int fee) {
        int ret = 0 ;
        // 初始买入点prices[0]
        int buyPrice = prices[0] + fee ;
        int n = prices.length ;
        for(int i = 0 ; i < n ; ++i){
            if(prices[i] > buyPrice){
                ret += (prices[i] - buyPrice) ;
                buyPrice = prices[i] ;
            // 当前价格比原值还小，更新买入点
            }else if(prices[i] < buyPrice - fee){
                buyPrice = prices[i] + fee ;
            }
        }
        return ret ;

    }
}
