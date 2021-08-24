package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/17 10:12
 */
public class Q115_不同的子序列 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    public int numDistinct1(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n < m) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        //[0, i)
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
