package leetcode.template.DP.Dungeon;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 23:38
 */
public class Q64_MinPathSum {
    public int minPathSum(int[][] g) {
        // dp[i][j] : 到达i,j位置的路径和最小值
        // dp[i][j] = g[i][j] + min(dp[i - 1][j], dp[i][j - 1])
        int n = g.length;
        int m = g[0].length;
        int[][] dp = new int[n + 1][m + 1];
        // Arrays.fill(dp[0], 0x3f3f3f3f);
        // for(int i = 0; i <= n; i++) {
        //     dp[i][0] = 0x3f3f3f3f;
        // }

        // 1,2
        // 1,1

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(i == 1) {
                    dp[i][j] = g[i - 1][j - 1] + dp[i][j - 1];
                } else if(j == 1) {
                    dp[i][j] = g[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = g[i - 1][j - 1] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
