package leetcode.contest.NiceProblem.DP技巧;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/7 18:37
 */
public class Q718_最长重复子数组 {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        // A中前i个元素与B中前j个元素的最长公共子数组
        // 不是子序列
        int ans = 0;
        int[][] f = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(A[i - 1] == B[j - 1]) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }
}
