package Mitsuha.背包DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/28 9:52
 */
public class Q494_目标和 {
}
class Solution1 {
    int n;
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        dfs(0, target, nums);
        return ans;
    }
    void dfs(int i, int cur, int[] nums) {
        if(i == n) {
            if(cur == 0) {
                ans++;
            }
            return;
        }
        dfs(i + 1, cur + nums[i], nums);
        dfs(i + 1, cur - nums[i], nums);
    }
}
class Solution2 {
    int n;
    int ans = 0;
    int[][] f;
    int INF = 0x3f3f3f3f;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        sum = Arrays.stream(nums).sum();
        f = new int[n][2 * (sum + 1)];
        for(int i = 0; i < n; i++) {
            Arrays.fill(f[i], INF);
        }
        return dfs(0, 0, target, nums);
    }
    int dfs(int i, int cur, int target, int[] nums) {
        if(i == n) {
            if(cur == target) {
                return 1;
            }
            return 0;
        }
        if(f[i][cur + sum] != INF) {
            return f[i][cur + sum];
        }
        int ret = dfs(i + 1, cur + nums[i], target, nums) + dfs(i + 1, cur - nums[i], target, nums);
        return f[i][cur + sum] = ret;
    }
}

class Solution3 {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(target > sum || target < -sum) {
            return 0;
        }
        // 前i个元素，目标和为j的方法数
        int[][] f = new int[n + 1][2 * (sum + 1)];
        f[0][sum] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = -sum; j <= sum; j++) {
                if(-nums[i - 1] + j + sum >= 0)
                    f[i][j + sum] += f[i - 1][-nums[i - 1] + j + sum];
                if(nums[i - 1] + j + sum < 2 * sum + 1)
                    f[i][j + sum] += f[i - 1][nums[i - 1] + j + sum];
            }
        }
        return f[n][target + sum];
    }
}