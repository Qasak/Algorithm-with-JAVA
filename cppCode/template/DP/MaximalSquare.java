package leetcode.template.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/10 17:48
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 */
public class MaximalSquare {
    /**
     dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
     dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
     */
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int ret = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                        ret = Math.max(ret, dp[i][j]);
                    }
                }
            }
        }
        return ret;
    }
}
