package leetcode.contest.NiceProblem.路径DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/15 12:30
 */
public class Q931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
            f[0][i] = matrix[0][i];
        }
        for(int i = 1; i < n ;i ++) {
            for(int j = 0; j < n; j++) {
                f[i][j] = Math.min(f[i][j], f[i - 1][j] + matrix[i][j]);
                if(j > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + matrix[i][j]);
                }
                if(j < n - 1) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j + 1] + matrix[i][j]);
                }
            }
        }
        return Arrays.stream(f[n - 1]).min().getAsInt();
    }
    // 滚动数组
    public int minFallingPathSum1(int[][] matrix) {
        int n = matrix.length;
        int[] f = new int[n];
        Arrays.fill(f, 0x3f3f3f3f);
        for(int i = 0; i < n; i++) {
            f[i] = matrix[0][i];
        }
        for(int i = 1; i < n ;i ++) {
            int[] g = f.clone();
            Arrays.fill(f, 0x3f3f3f3f);
            for(int j = n - 1; j >= 0; j--) {
                f[j] = Math.min(f[j], g[j] + matrix[i][j]);
                if(j > 0) {
                    f[j] = Math.min(f[j], g[j - 1] + matrix[i][j]);
                }
                if(j < n - 1) {
                    f[j] = Math.min(f[j], g[j + 1] + matrix[i][j]);
                }
            }
        }
        return Arrays.stream(f).min().getAsInt();
    }
}
