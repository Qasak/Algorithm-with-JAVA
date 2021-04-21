package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/4 17:37
 */
public class Q1143_LCS {
    public int longestCommonSubsequence(String a, String b) {
        int n = a.length();
        int m = b.length();

        // dp[i][j] : a[i, n) b[j, m)
        // 两个空的字符串 LCS == 0
        // dp[n][m] : a[n, n) b[m, m)  == 0

        // 返回dp[0][0] : a[0, n) b[0, m)
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
        return dp[0][0];
    }

    public int longestCommonSubsequence1(String a, String b) {
        int n = a.length();
        int m = b.length();

        // dp[i][j] : a[0, i) b[0, j)
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    // 记忆化DFS
    int[][] dp;
    public int longestCommonSubsequence3(String a, String b) {
        int n = a.length();
        int m = b.length();
        dp = new int[n + 1][m + 1];
        return dfs(a, b, n, m);
    }

    // a[0, i)
    // b[0, j)
    public int dfs(String a, String b, int i, int j) {
        int n = a.length();
        int m = b.length();
        if(i == 0 || j == 0) {
            return 0;
        }
        if(dp[i][j] > 0) {
            return dp[i][j];
        }
        if(a.charAt(i - 1) == b.charAt(j - 1)) {
            dp[i][j] = 1 + dfs(a, b, i - 1, j - 1);
        } else {
            dp[i][j] = Math.max(dfs(a, b, i, j - 1), dfs(a, b, i - 1, j));
        }
        return dp[i][j];
    }
    // 时间复杂度：O(m*n)O(m∗n)。大小为 m * nm∗n 的 memomemo 数组每个元素最多会被赋值一次。 mm 和 nn 分别是 s1s1 和 s2s2 字符串的长度。
    //
    //空间复杂度：O(m*n)O(m∗n)。 memomemo 数组大小为 $m * n。同时递归树的深度最多为 \text{max}(m,n)max(m,n)。

}
