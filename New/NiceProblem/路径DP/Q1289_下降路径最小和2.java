package leetcode.contest.NiceProblem.路径DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/15 11:44
 */
public class Q1289_下降路径最小和2 {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        // f[i][j] : 到达 i j 位置的最小路径和
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
            f[0][i] = arr[0][i];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(j == k) {
                        continue;
                    }
                    f[i][j] = Math.min(f[i][j], f[i - 1][k] + arr[i][j]);
                }
            }
        }
        return Arrays.stream(f[n - 1]).min().getAsInt();
    }
}
