package leetcode.template.DP.Interval;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/13 11:50
 *
 * 爱丽丝先开始 。
 *
 * 有 n 块石子排成一排。每个玩家的回合中，
 * 可以从行中 移除 最左边的石头或最右边的石头
 * 并获得与该行中剩余石头值之 和 相等的得分
 *
 *
 * stones[i] 表示 从左边开始 的第 i 个石头的值
 * 如果爱丽丝和鲍勃都 发挥出最佳水平
 * 请返回他们 得分的差值 。
 *
 * 输入：stones = [5,3,1,4,2]
 * 输出：6
 * 解释：
 * - 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
 * - 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
 * - 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
 * - 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
 * - 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
 * 得分的差值 18 - 12 = 6 。
 *
 */
public class Stone_VII {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        // dp[i][j]: stone[i, j] 上两人得分的最大差值
        int[][] dp = new int[n][n];
        // 获得剩余石头值之 和  -> 记录前缀和
        // 前缀和: stones = [5,3,1,4,2]
        // pre = [0, 5, 8, 9, 13, 15]
        // 对于区间[1,2]
        // 移走左边元素：
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        // 区间DP
        // 进行到最后一步时剩两个元素
        for(int len = 2; len <= n; len++) {
            // i, j ：左右端点
            for(int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                // 求区间[0, n - 1]的和： pre[n] - pre[0]
                // pre[r + 1] - pre[l]

                // pre[n] - pre[1], pre[n - 1] - pre[0]
                // pre[j + 1] - pre[i + 1] : 移除左端点元素后的和
                // pre[j] - pre[i]: 移除右端点元素后的和
                dp[i][j] = Math.max(pre[j + 1] - pre[i + 1] - dp[i + 1][j], pre[j] - pre[i] - dp[i][j - 1]);
            }
        }
        return dp[0][n -1];
    }
    public int stoneGameVII_1(int[] stones) {
        int n = stones.length;
        // dp[i][j]: stone[i, j] 区间上两人得分的最大差值
        int[][] dp = new int[n][n];
        int[] pre = new int[n + 1];
        for(int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + stones[i];
        }
        return dfs(0, n - 1, pre, dp);

    }
    private int dfs(int l, int r, int[] pre, int[][] dp) {
        if(l == r) {
            return 0;
        }
        if(dp[l][r] != 0) {
            return dp[l][r];
        }
        // pre[r + 1] - pre[l + 1] 去掉左端点
        // pre[r] - pre[l] 去掉右端点
        return dp[l][r] = Math.max(pre[r + 1] - pre[l + 1] - dfs(l + 1, r, pre, dp), pre[r] - pre[l] - dfs(l, r - 1, pre, dp));
    }
}
