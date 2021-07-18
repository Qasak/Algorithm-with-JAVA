package leetcode.JianZhi;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/12 21:44
 */
public class Q14 {
    public int cuttingRope(int n) {
        // dp[i] : 将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积
        int[] dp = new int[n + 1];
        for(int i = 2 ; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
    // 优化DP
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }
    // 数学
    public int integerBreak1(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }


}
