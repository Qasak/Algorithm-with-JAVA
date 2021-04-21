package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/21 13:58
 */
public class Q1014_最佳观光组合 {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] dp = new int[n];
        int ans = values[0];
        dp[0] = values[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], values[i] + i);
            ans = Math.max(ans, dp[i - 1] + values[i] - i);
        }
        return ans;
    }
    // 空间优化
    public int maxScoreSightseeingPair1(int[] values) {
        int n = values.length;
        int pre = values[0];
        int ans = 0;
        for(int i = 1; i < n; i++) {
            ans = Math.max(ans, pre + values[i] - i);
            pre = Math.max(pre, values[i] + i);
        }
        return ans;
    }
}
