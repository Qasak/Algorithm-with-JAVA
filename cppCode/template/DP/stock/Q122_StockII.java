package leetcode.template.DP.stock;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/28 11:21
 */
public class Q122_StockII {
    // 尽可能地完成更多的交易
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            // 贪心：只要第二天比第一天多，就要卖出
            ans += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return ans;
    }
    public int maxProfit1(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for(int i = 0; i < n - 1; i++) {
            if(prices[i] < prices[i + 1]) {
                ans += prices[i + 1] - prices[i];
            }
        }
        return ans;
    }
}
