package leetcode.template.DP.stock;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/28 11:08
 */
public class Q123_StockIII {
    // 最多可以完成 两笔 交易
    //[1,2,4,2,5,7,2,4,9,0]
    // -> 13
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }

        // 如果k超过了最大可买卖次数，那就将k置为最大买卖次数
        // 最大买卖次数就是天数的一半，如果当前卖出又买入，是没有意义的
        // k = Math.min(k, n / 2);

        // 状态标识数组，三个维度分别代表：第几天，手上是否有股票0没有1有，还剩下多少次买卖机会
        // 数组值表示当前还有多少钱
        int[][] f = new int[2][3];

        // 设置初始值，第一天手上有股票的状态，就是买入第一天价格的值
        for(int i = 0; i <= 2; i++) {
            f[1][i] = -prices[0];
        }
        for(int i = 1; i < n; i++) {
            // 枚举所有可能买卖次数的状态
            for(int j = 2; j >= 0 ; j--) {
                // 当前不持有股票的状态转移
                if(j == 0) {
                    f[0][j] = f[0][j];
                } else {
                    f[0][j] = Math.max(f[0][j], f[1][j - 1] + prices[i]);
                }
                // 当前持有股票的状态转移，要么前一天也有股票，要么当天买入了股票
                f[1][j] = Math.max(f[1][j], f[0][j] - prices[i]);
            }
        }
        return f[0][2];
    }
}
