package leetcode.SpringRecruit.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/6 21:10
 */
public class Q45_跳跃游戏2 {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                dp[i] = j + nums[j] >= i ? Math.min(dp[i], dp[j] + 1) : dp[i];
            }
        }
        return dp[n - 1];
    }
}
