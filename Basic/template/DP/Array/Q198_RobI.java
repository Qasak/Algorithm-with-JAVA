package leetcode.template.DP.Array;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/13 23:46
 */
public class Q198_RobI {
    // dp 1
    // 都是从前面转移到当前位置


    // dp[i] : 在i的最大值 = max(偷了i, 没偷i)
    // dp[i] = max(dp[i-2]+nums[i], dp[i-1])
    public int rob(int[] nums) {
        // dp[i] = max(dp[i-2]+nums[i], dp[i-1])
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    // dp2
    public int rob2(int[] nums) {
        // [2,1,1,2] 4 : 0, 3 最后偷了最后一家
        // [1,2,3,1] 4 : 0, 2 最后没偷最后一家

        // 最终答案 = max(最后偷了最后一家的最大值， 最后没偷最后一家最大值)
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        // dp0[i] :没偷i家的最大值
        int[] dp0 = new int[n];
        // dp1[i] :偷了i家的最大值
        int[] dp1 = new int[n];
        dp0[0] = 0;
        dp1[0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp1[i - 1]);
            dp1[i] = nums[i] + dp0[i - 1];
        }
        return Math.max(dp0[n - 1], dp1[n - 1]);
    }
    // 空间优化
    public int rob1(int[] nums) {
        // [2,1,1,2]
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for(int i = 1; i < n; i++) {
            int t = dp0;
            dp0 = Math.max(dp0, dp1);
            dp1 = nums[i] + t;
        }
        return Math.max(dp0, dp1);
    }
}
