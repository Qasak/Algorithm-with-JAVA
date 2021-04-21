package leetcode.template.DP.LCS;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/4 21:27
 *
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Q718_FindLength {
    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int n = A.length;
        int m = B.length;

        // dp[i][j] : A长度为i的子数组和B长度为j的子数组的最长公共子数组长度
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
