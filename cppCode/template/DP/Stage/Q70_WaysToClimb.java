package leetcode.template.DP.Stage;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/21 10:20
 */
public class Q70_WaysToClimb {
    // 第n个台阶只能从第n-1或者n-2个上来。
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        // dp[n] 到达n的方法数
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int climbStairs2(int n) {
        // dp[n] 到达n的方法数
        int dp1 = 1;
        int dp2 = 1;
        for(int i = 2; i <= n; i++) {
            int t = dp2;
            dp2 = dp1 + dp2;
            dp1 = t;
        }
        return dp2;
    }
}
