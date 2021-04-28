package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/16 12:08
 */
public class Q312_戳气球 {
    // 区间DP
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] vals = new int[n + 2];
        vals[0] = vals[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            vals[i] = nums[i - 1];
        }
        // 最后一个戳爆的气球是K
        // 此时l k r已经是挨着的了
        for(int l = n - 1; l >= 0; l--) {
            for(int r = l + 2; r <= n + 1; r++) {
                for(int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k][r] + vals[l] * vals[k] * vals[r]);
                }
            }
        }
        return dp[0][n + 1];
    }

    // 记忆化

}
