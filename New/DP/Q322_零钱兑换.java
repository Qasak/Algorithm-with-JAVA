package leetcode.SpringRecruit.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/2 11:26
 */
public class Q322_零钱兑换 {
    // 完全背包
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int c : coins) {
                dp[i] = i - c >= 0 ? Math.min(dp[i], dp[i - c] + 1) : dp[i];
            }
        }
        return dp[amount] == 0x3f3f3f3f ? -1 : dp[amount];
    }
}
