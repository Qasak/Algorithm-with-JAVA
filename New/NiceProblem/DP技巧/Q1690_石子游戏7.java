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
}
