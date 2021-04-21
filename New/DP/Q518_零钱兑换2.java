package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/2 11:27
 */


public class Q518_零钱兑换2 {
    // 完全背包
    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for(int c : coins) {
                for(int i = 1; i <= amount; i++) {
                    dp[i] = i - c < 0 ? dp[i] : dp[i] + dp[i - c];
                }
            }
            return dp[amount];
        }
    }
}
