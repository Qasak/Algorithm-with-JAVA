package leetcode.contest.NiceProblem.DP技巧;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/13 22:49
 */
public class Q1690_石子游戏7 {
    // 从双端开始
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        int[][] f = new int[n][n];
        return dfs(0, n - 1, f, pre);
    }
    private int dfs(int l, int r, int[][] f, int[] pre) {
        // 选走最后一个 无法再得分
        if(l == r) {
            return 0;
        }
        // 重复子问题
        if(f[l][r] != 0) {
            return f[l][r];
        }
        // [l, r] 选左，选右
        return f[l][r] = Math.max(pre[r + 1] - pre[l + 1] - dfs(l + 1, r, f, pre),
                pre[r] - pre[l] - dfs(l, r - 1, f, pre));
    }
    // dp 1
    public int stoneGameVII1(int[] stones) {
        int n = stones.length;
        int[][] f = new int[n][n];
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(pre[j + 1] - pre[i + 1] - f[i + 1][j],
                        pre[j] - pre[i] - f[i][j - 1]);
            }
        }
        // dp 2
//        for(int len = 2; len <= n; len++) {
//            for(int i = 0; i + len - 1 < n; i++) {
//                int j = i + len - 1;
//                f[i][j] = Math.max(pre[j + 1] - pre[i + 1] - f[i + 1][j],
//                        pre[j] - pre[i] - f[i][j - 1]);
//            }
//        }

        return f[0][n - 1];
    }
}
