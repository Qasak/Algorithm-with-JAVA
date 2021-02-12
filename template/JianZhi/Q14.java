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

}
