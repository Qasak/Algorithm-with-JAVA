package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/9 10:08
 */
public class UniquePaths_62 {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int i =0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
    public static int uniquePaths1(int m, int n) {
        int[] dp = new int[m];
        for(int i =0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j =0; j < n; j++){
                if(i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
    public static int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        System.out.println(uniquePaths2(7, 3));
    }
}
