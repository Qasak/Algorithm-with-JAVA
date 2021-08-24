package leetcode.template.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/12 20:57
 *
 * 给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 * (结果可能会很大，你需要将结果模上1000000007)
 *
 */
public class Coins_08_11 {
    public int waysToChange(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        // dp[i]: 凑成i块钱的方法数
        int[] dp = new int[n + 1];
        final int mod = (int)1e9 + 7;
        dp[0] = 1;
        for(int i = 0; i < 4; i++) {
            for(int j = coins[i]; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) & mod;
            }
        }
        return dp[n];
    }
}
