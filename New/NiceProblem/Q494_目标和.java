package leetcode.contest.NiceProblem;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/6/7 1:25
 */
public class Q494_目标和 {
    // 1. 记忆化DFS
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // f[j] : 目标和为j时的方法数
        int sum = Arrays.stream(nums).sum();
        // 剪枝
        // (sum−neg)−neg=sum−2⋅neg=target
        // neg = (sum - target) / 2
        // neg 满足非负整数
        if(sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        int[][] f = new int[n][2001];
        return dfs(0, target + 1000, 1000, nums, f);
    }
    private int dfs( int idx, int target,int cur, int[] nums, int[][] f) {
        int n = nums.length;
        if(idx == n) {
            if(cur == target) {
                return 1;
            }
            return 0;
        }
        if(f[idx][cur] != 0) {
            return f[idx][cur];
        }
        f[idx][cur] = dfs(idx + 1, target, cur + nums[idx], nums, f) + dfs(idx + 1, target, cur - nums[idx], nums, f);
        return f[idx][cur];
    }
}
