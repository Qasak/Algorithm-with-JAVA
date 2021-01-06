package leetcode.template.DP.Pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/15 20:14
 */
public class TargetSum_494 {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0);
        return ans;
    }
    //时间复杂度：O(2^N)，其中 N 是数组 nums 的长度。
    //空间复杂度：O(N)，为递归使用的栈空间大小。
    private void dfs(int[] nums, int cur, int idx) {
        if(idx == nums.length) {
            if(cur == 0) {
                ans++;
            }
            return;
        }

        // 0 + 1
        // 0 - 1
        // 不能加for循环
        /** for循环表示：选或者不选，
         *  [1,1,1,1] S = 3
         *         for(int i = idx; i < nums.length; i++) {
         *             dfs(nums, cur + nums[i], sum, i + 1);
         *
         *             dfs(nums, cur - nums[i], sum, i + 1);
         *         }
         * */
        dfs(nums, cur + nums[idx], idx + 1);
        dfs(nums, cur - nums[idx], idx + 1);

    }
    // dp 1
    public static int findTargetSumWays1(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
        }
        if(sum < S || S < -sum){
            return 0;
        }
        int[][]dp = new int[n][2 * sum + 1];
        //数组中的数的组合和的范围为[-sum,sum],值域[0, 2 * sum] 因此创建dp数组大小为2*sum+1
        // dp[i][j] : nums[0, i] 中，和为j的组合个数
        // dp[n-1][S + sum]: nums[0, n - 1]中，和为S + sum的组合个数
        // dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]
        dp[0][-nums[0] + sum] = 1;
        dp[0][nums[0] + sum] = 1;
        System.out.println(Arrays.toString(dp[0]));
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= 2 * sum; j++){
                // +
                if(j - nums[i] >= 0){
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                // -
                if(j + nums[i] < 2 * sum + 1){
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n-1][S + sum];
    }
    public static int findTargetSumWays2(int[] nums, int s) {
        int sum = 0;
        for(int i: nums) {
            sum += i;
        }
        if(sum < s || (s + sum) % 2 == 1) {
            return 0;
        }
        // 背包容量
        int V = (s + sum) / 2;
        // dp[j] : nums[0,i] 中，前i个元素的数组，能组成和为j时的方法数
        int[] dp = new int[V + 1];
        int n = nums.length;
        dp[0] = 1;
        System.out.println(Arrays.toString(dp));
        for(int i = 0; i < n; i++) {
            for(int j = V; j >= nums[i]; j--) {
                dp[j] = dp[j] + dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[V];
    }
    // DP
    // 这道题不能只使用一个一维数组，因为在动态转移方程里，每个状态dp[i][j]不仅依赖其上一行左边的值，也依赖上一行右边的值，因此无法实现一个一维数组更新，需要两个一维数组实现滚动更新。
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 绝对值范围超过了sum的绝对值范围(全正/全负)则无法得到
        if (Math.abs(target) > Math.abs(sum)) {
            return 0;
        }

        int n = nums.length;
        //  -sum 被映射到0
        // 0被映射到 sum
        // sum 被映射到 2*sum
        int m = sum * 2;
        int[][] dp = new int[n][m + 1];
        // 初始化
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if(j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if(j + nums[i] <= m) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        return dp[n - 1][sum + target];

    }
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5};
        int s = 3;
        System.out.println(findTargetSumWays1(a, s));
    }
}
