package leetcode.template.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/16 17:04
 */
public class Q64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        dp[0][0] = grid[0][0];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    continue;
                }
                if(i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        String a = "OIJ djik, doaD";
        System.out.println(a.toLowerCase());
        Integer[] b = new Integer[]{1,2,3};
    }
}
