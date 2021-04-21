package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/10 19:32
 */
public class Q70跳台阶 {
    int mod = (int) 1e9 + 7;
    public int numWays(int n) {
        if(n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }
        return dp[n];
    }
}
