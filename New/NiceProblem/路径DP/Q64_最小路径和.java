package leetcode.contest.NiceProblem.路径DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/15 11:57
 */
public class Q64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] f = new int[n][m];
        f[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < m; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < n; i++ ) {
            for(int j = 1; j < m; j++ ){
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[n - 1][m - 1];
    }
}
