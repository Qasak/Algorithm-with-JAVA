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

    // dp官方
    public int maxProfit2(int[] p) {
        /*
            未进行过任何操作；

            只进行过一次买操作；

            进行了一次买操作和一次卖操作，即完成了一笔交易；

            在完成了一笔交易的前提下，进行了第二次买操作；

            完成了全部两笔交易。
        */
        
        /*
        * 我们考虑第 i=0 天时的四个状态：buy 1 即为以 prices[0] 的价格买入股票，因此 buy 1=−prices[0]；
        * sell 1即为在同一天买入并且卖出，因此 sell1=0；
        * buy2即为在同一天买入并且卖出后再以 prices[0] 的价格买入股票，
        * 因此 buy2=−prices[0]；同理可得 sell2=0。
        * 我们将这四个状态作为边界条件，从 i=1i=1 开始进行动态规划，即可得到答案
        * 
        * */
        int buy1 = -p[0];
        int sell1 = 0;
        int buy2 = -p[0];
        int sell2 = 0;
        int n = p.length;
        for(int i = 1; i < n; i++) {
            buy1 = Math.max(buy1, -p[i]);
            sell1 = Math.max(sell1, buy1 + p[i]);
            buy2 = Math.max(buy2, sell1 - p[i]);
            sell2 = Math.max(sell2, buy2 + p[i]);
        }
        return sell2;
    }
}
