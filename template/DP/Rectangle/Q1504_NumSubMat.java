package leetcode.template.DP.Rectangle;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/7 22:29
 */
public class Q1504_NumSubMat {
    // 1: dp
    // 结论1：当只有一行1的时候，有多少个1，就能组成多少个矩形
    //
    public int numSubmat(int[][] g) {
        int n = g.length;
        int m = g[0].length;
        // dp[i][j] : 第i行的某位置j之前的连续长度
        int[][] dp = new int[n][m];
        //
        int ans = 0;
        /*
            0, 1, 1
            1, 1, 1

            1 + 2 + 1 + (2 + 1) + (3 + 2)
        */

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(g[i][j] == 1) {
                    dp[i][j] = j == 0 ? 1 : 1 + dp[i][j - 1];
                    int d = dp[i][j];
                    for(int k = i; k >= 0; k--) {
                        d = Math.min(d, dp[k][j]);
                        ans += d;
                    }
                }
            }
        }
        return ans;
    }
    // 2: 单调栈

}
