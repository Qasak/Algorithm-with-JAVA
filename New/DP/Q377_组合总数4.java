package leetcode.SpringRecruit.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/24 10:25
 */
public class Q377_组合总数4 {
    public static int combinationSum4(int[] nums, int target) {

        return dfs(nums, target);
    }
    public static int dfs(int[] nums, int cur) {
        if(cur == 0) {
            return 1;
        }
        int cnt = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(cur - nums[i] >= 0) {
                cnt += dfs(nums, cur - nums[i]);
            }
        }
        return cnt;
    }
    // 记忆化
    // 元素是唯一的
    static class Solution {
        public static int[] dp;
        public static int combinationSum4(int[] nums, int target) {
            dp = new int[target + 1];
            Arrays.fill(dp, -1);
            dp[0] = 1;
            return dfs(nums, target);
        }
        public static int dfs(int[] nums, int cur) {
            if(dp[cur] != -1) {
                return dp[cur];
            }
            int cnt = 0;
            int n = nums.length;
            for(int i = 0; i < n; i++) {
                if(cur - nums[i] >= 0) {
                    cnt += dfs(nums, cur - nums[i]);
                }
            }
            dp[cur] = cnt;
            return dp[cur];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int target = 8;
        System.out.println(combinationSum4(nums, target));
    }
}
