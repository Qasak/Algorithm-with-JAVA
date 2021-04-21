package leetcode.template.DP.MaxSubArr;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/16 18:19
 *
 *
 * dp(i) 代表以第 i 个数结尾的「连续子数组的最大和」
 */
public class MaxSubArr {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for(int i = 1; i < n; i++) {
            // 对当前数，选或者不选
            // 如果不选，
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 最大和不一定在最后
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return ans;
    }


    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        // dp :           [-2, 1, -2, 4, 3, 5, 6, 1, 5]
        System.out.println(maxSubArray(a));
    }
}
