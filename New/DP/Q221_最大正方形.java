package leetcode.SpringRecruit.DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/12 18:30
 */
public class Q221_最大正方形 {
    /*
[["1","0","1","0"],
["1","0","1","1"],
["1","0","1","1"],
["1","1","1","1"]]
*/
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') {
                    continue;
                }
                if(i > 0 && j > 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])  + 1;
                } else {
                    dp[i][j] = 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
