package leetcode.SpringRecruit.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/2 22:35
 */
public class Q416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        // 1 100 2 99
        //
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int max = Arrays.stream(nums).max().getAsInt();
        if(max > target) {
            return false;
        }
        int n = nums.length;

        // dp[i][j] 下标i及之前的元素， 能否凑成目标j
        boolean[][] dp = new boolean[n][target + 1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= target; j++) {
                if(j - nums[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    // 空间优化
    public boolean canPartition1(int[] nums) {
        // 1 100 2 99
        //
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int max = Arrays.stream(nums).max().getAsInt();
        if(max > target) {
            return false;
        }
        int n = nums.length;

        // dp[i][j] 下标i及之前的元素， 能否凑成目标j
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        dp[nums[0]] = true;
        for(int i = 1; i < n; i++) {
            for(int j = target; j >= 1; j--) {
                if(j - nums[i] >= 0) {
                    dp[j] = dp[j] | dp[j - nums[i]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target];
    }
}
