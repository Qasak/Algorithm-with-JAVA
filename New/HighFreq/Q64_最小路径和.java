package leetcode.HighFreq;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/30 10:19
 */
public class Q64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for(int i = 1; i < m; i++) {
            f[i][0] = grid[i][0] + f[i - 1][0];
        }
        for(int j = 1; j < n; j++) {
            f[0][j] = grid[0][j] + f[0][j - 1];

        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }
        return f[m - 1][n - 1];
    }
}
