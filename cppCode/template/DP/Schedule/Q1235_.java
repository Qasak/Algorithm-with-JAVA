package leetcode.template.DP.Schedule;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/8 17:37
 */
public class Q1235_ {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] nums = new int[n][3];
        for(int i = 0; i < n; i++) {
            nums[i][0] = startTime[i];
            nums[i][1] = endTime[i];
            nums[i][2] = profit[i];
        }
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        int[] pre = new int[n];
        Arrays.fill(pre, -1);
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j][1] > nums[i][0]) {
                    continue;
                }
                pre[i] = j;
                break;
            }
        }
        int ans = 0;
        // dp[i]前i份工作的最大收益
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[pre[i - 1] + 1] + nums[i - 1][2]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] nums = new int[n][3];
        for(int i = 0; i < n; i++) {
            nums[i][0] = startTime[i];
            nums[i][1] = endTime[i];
            nums[i][2] = profit[i];
        }
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
        int ans = 0;
        // dp[i]做i份工作的最大收益
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            int l = 0, r = i;
            while(l < r) {
                int m = (l + r) >>> 1;
                if(nums[m][1] > nums[i - 1][0]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            dp[i] = Math.max(dp[i - 1], dp[l] + nums[i - 1][2]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
