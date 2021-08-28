package Mitsuha.背包DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/23 18:45
 */
public class Q1981_最小化目标值与所选元素的差 {
    // 记忆化
    int diff = 0x3f3f3f3f;
    int n;
    int m;
    // f[i][j]前i行是否存在和洽为j的情况
    boolean[][] f;
    public int minimizeTheDifference(int[][] mat, int target) {
        // 记忆化
        n = mat.length;
        m = mat[0].length;
        f = new boolean[n][4901];
        dfs(0, target, 0, mat);
        return diff;
    }
    void dfs(int i, int target, int cur, int[][] mat) {
        if(i == n) {
            diff = Math.min(diff, Math.abs(cur - target));
            return;
        }
        // 剪枝
        if(f[i][cur] || cur - target > diff) {
            return;
        }

        f[i][cur] = true;
        for(int j = 0; j < m; j++) {
            dfs(i + 1, target, cur + mat[i][j], mat);
        }
    }
    // 分组背包
    // 求出可以组合出的和的类型
    // 和的类型总数是稀疏的
    public int minimizeTheDifference1(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int max = Arrays.stream(mat[i]).max().getAsInt();
            sum += max;
        }

        boolean[][] f = new boolean[n][sum + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0) {
                    f[i][mat[i][j]] = true;
                    continue;
                }
                for(int cur = mat[i][j]; cur <= sum; cur++) {
                    if(f[i - 1][cur - mat[i][j]]) {
                        f[i][cur] = true;
                    }
                }
            }
        }
        int ret = 0x3f3f3f3f;
        for(int i = 0; i <= sum; i++) {
            if(f[n - 1][i]) {
                ret = Math.min(ret, Math.abs(target - i));
            }
        }
        return ret;
    }
    // 优化
}
