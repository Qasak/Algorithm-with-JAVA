package leetcode.template.Greedy;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/9 10:35
 */
public class Q45_跳跃游戏2 {
    // 1. 朴素DP n^2
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[n - 1] = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(i + nums[i] >= n - 1) {
                dp[i] = 1;
                continue;
            }
            for(int j = i + 1; j <= i + nums[i] && j < n; j++) {
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0];
    }
    // 贪心 n
    public int jump1(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        int r = 0;
        int end = 0;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            r = Math.max(r, i + nums[i]);

            if(i == end) {
                end = r;
                ans++;
            }
            if(end >= n - 1) {
                return ans;
            }
        }
        return ans;
    }
}
