package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/6 21:24
 */
public class Q72_编辑距离 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 不修改 / 添加一个
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                } else {
                    // 修改一个 / 添加一个
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[n][m];
    }
}
