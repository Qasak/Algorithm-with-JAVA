package leetcode.template.DP;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/5 11:03
 */
public class Q53_最大子序和 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int maxSubArray1(int[] nums) {
        int sum = nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        // dp[i] : [0, i]
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
