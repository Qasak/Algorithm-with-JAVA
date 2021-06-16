package leetcode.contest.NiceProblem;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/16 10:10
 */
public class Q486_预测赢家 {
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 1) >= 0;
    }
    public int dfs(int[] nums, int l, int r, int turn) {
        if(l == r) {
            return nums[l] * turn;
        }
        int a = nums[l] * turn + dfs(nums, l + 1, r, -turn);
        int b = nums[r] * turn + dfs(nums, l, r - 1, -turn);
        if(turn == 1) {
            return Math.max(a, b);
        } else {
            return Math.min(a, b);
        }
    }

    public boolean PredictTheWinner1(int[] nums) {
        int n = nums.length;

        // f[i][j] : 当前玩家与另一个玩家在[i, j]区间差值的最大值
        int[][] f = new int[n][n];
        for(int i = 0; i < n; i++) {
            f[i][i] = nums[i];
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                f[i][j] = Math.max(nums[i] - f[i + 1][j], nums[j] - f[i][j - 1]);
            }
        }
        return f[0][n - 1] >= 0;
    }
    // 一维
    public boolean PredictTheWinner2(int[] nums) {
        int n = nums.length;

        // f[i][j] : 当前玩家与另一个玩家在[i, j]区间差值的最大值
        int[] f = new int[n];
        for(int i = 0; i < n; i++) {
            f[i] = nums[i];
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                f[j] = Math.max(nums[i] - f[j], nums[j] - f[j - 1]);
            }
        }
        return f[n - 1] >= 0;
    }
}
