package leetcode.template.DP.stock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/28 10:14
 */
public class Q188_StockIV {
    public int maxProfit(int k, int[] p) {
        if (p.length == 0) {
            return 0;
        }

        int n = p.length;
        k = Math.min(k, n / 2);
        int[][] dp1 = new int[n][k + 1];
        // dp0[i][k]:在第i天，已经进行过k次交易(包含无效交易)，并且不持有股票的最大利润
        int[][] dp0 = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // 第一天可以进行1到k次交易，即当天买进当天卖出.0次交易始终为0
                // 不论进行几次交易，在第一天之后持有股票时现金都是-prices[0]，不持有股票时现金都是0
                if(i == 0) {
                    dp1[i][j] = -p[0];
                    dp0[i][j] = 0;
                    continue;
                }
                dp0[i][j] = Math.max(dp0[i - 1][j], dp1[i - 1][j] + p[i]);
                dp1[i][j] = Math.max(dp1[i - 1][j], dp0[i - 1][j - 1] - p[i]);
            }
        }
        return dp0[n - 1][k];
    }

    public static int maxProfit1(int k, int[] p) {
        if (p.length == 0) {
            return 0;
        }

        int n = p.length;
        k = Math.min(k, n / 2);
        // 第i天已经进行过k次交易，持有股票的收益
        int[] dp1 = new int[k + 1];
        // 第i天已经进行过k次交易，不持有股票的收益
        int[] dp0 = new int[k + 1];
        // 天数
        for (int i = 0; i < n; i++) {
            // 次数
            for (int j = 1; j <= k; j++) {
                if(i == 0) {
                    dp1[j] = -p[0];
                    dp0[j] = 0;
                    continue;
                }
                dp1[j] = Math.max(dp1[j], dp0[j - 1] - p[i]);

                dp0[j] = Math.max(dp0[j], dp1[j] + p[i]);
            }
            System.out.println(Arrays.toString(dp1));
        }
        return dp0[k];
    }

    public int maxProfit2(int k, int[] p) {
        if (p.length == 0) {
            return 0;
        }

        int n = p.length;
        k = Math.min(k, n / 2);
        int[][] dp1 = new int[n][k + 1];
        // buy[i][j]指的是恰好进行j次交易，这里面不包含无效交易
        int[][] dp0 = new int[n][k + 1];

        dp1[0][0] = -p[0];
        dp0[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            // 交易[1, k]次时
            dp1[0][i] = dp0[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            dp1[i][0] = Math.max(dp1[i - 1][0], dp0[i - 1][0] - p[i]);
            for (int j = 1; j <= k; ++j) {
                dp1[i][j] = Math.max(dp1[i - 1][j], dp0[i - 1][j] - p[i]);
                // 卖的时候算一次交易
                dp0[i][j] = Math.max(dp0[i - 1][j], dp1[i - 1][j - 1] + p[i]);
            }
        }

        return Arrays.stream(dp0[n - 1]).max().getAsInt();
    }


    public int maxProfit3(int k, int[] p) {
        //
        int n = p.length;
        if(n == 0) {
            return 0;
        }
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for(int i = 1; i <= k; i++) {
            buy[i] = -p[0];
            sell[i] = 0;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= k; j++) {
                // buy[j] : 买入j 次
                // sell[j] : 卖出j 次
                buy[j] = Math.max(buy[j], sell[j - 1] - p[i]);
                sell[j] = Math.max(sell[j], buy[j] + p[i]);
            }
        }
        return sell[k];
    }
    public static void main(String[] args) {
        System.out.println(maxProfit1(2, new int[]{2,4,1}));
    }
}
