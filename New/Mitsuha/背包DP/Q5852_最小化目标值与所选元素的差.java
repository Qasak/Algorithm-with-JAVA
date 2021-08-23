package Mitsuha.背包DP;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/23 18:45
 */
public class Q5852_最小化目标值与所选元素的差 {
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

}
