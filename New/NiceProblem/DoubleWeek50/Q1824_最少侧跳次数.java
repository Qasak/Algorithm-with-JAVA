package leetcode.contest.DoubleWeek50;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/9 16:29
 */
public class Q1824_最少侧跳次数 {
    public int minSideJumps(int[] obstacles) {
        // dp
        //f[i][j] : 到达i点第j跑到的的最少跳跃数
        int n = obstacles.length;
        int[][] f = new int[3][n];
        for(int i = 0; i < 3; i++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
        }
        f[0][0] = 1;
        f[1][0] = 0;
        f[2][0] = 1;
        for(int i = 1; i < n; i++) {
            if(obstacles[i] != 1) {
                f[0][i] = f[0][i - 1];
            }
            if(obstacles[i] != 2) {
                f[1][i] = f[1][i - 1];
            }
            if(obstacles[i] != 3) {
                f[2][i] = f[2][i - 1];
            }


            if(obstacles[i] != 1) {
                f[0][i] = Math.min(f[0][i], Math.min(f[1][i], f[2][i]) + 1);
            }
            if(obstacles[i] != 2) {
                f[1][i] = Math.min(f[1][i], Math.min(f[0][i], f[2][i]) + 1);
            }
            if(obstacles[i] != 3) {
                f[2][i] = Math.min(f[2][i], Math.min(f[0][i], f[1][i]) + 1);
            }
// [1, x, 1, 1, 1]
// [0, 0, x, 2, 2]
// [1, 1, 1, x, 2]
        }
        return Math.min(f[0][n - 1], Math.min(f[1][n - 1], f[2][n - 1]));
    }
}
