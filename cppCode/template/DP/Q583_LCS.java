package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/4 17:20
 */
public class Q583_LCS {
    public int minDistance(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        // a : [0:] ~ [n:]
        // dp[n][m] = 0
        for(int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + 1;
        }
        for(int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + 1;
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1] + 1,
                            dp[i + 1][j] + 1);
                }
            }
        }
        return dp[0][0];
    }

    // 总长度 - 2 * LCS = 要删除的字符总个数
    public int minDistance1(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return m + n - 2 * dp[0][0];
    }

}
