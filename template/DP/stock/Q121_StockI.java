package leetcode.template.DP.stock;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/28 11:18
 */
public class Q121_StockI {
    // 最多只允许完成一笔交易
    // 输入: [7,1,5,3,6,0,4]
    // 输出: 5
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
//        for (int price : prices) {
//            min = Math.min(min, price);
//            ans = Math.max(ans, price - min);
//        }
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
    public int maxProfit1(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int min = prices[0];
        for(int i = 1; i < n; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }
}
