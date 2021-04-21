package leetcode.template.DP.Pack;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/12 22:59
 * 416-分割等和子集
 * 给定一个只包含正整数的非空数组。
 * 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 * 输入: [1, 5, 11, 5]
 *
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 贪心：错误
 * 思路：排序，再找
 * 23,13,11,7,6,5,5,8,6,6,4,4
 * 4,4,5,5,6,6,6,7,8,11,13,23 -> sum / 2 = 49
 * [4,4,5,5,6,6,8,11] [6,7,13,23]
 * 找出来的集合元素并不相邻
 */
public class Canpartition_416 {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if((sum & 1) == 1) {
            return false;
        }
        int V = sum / 2;
        // 从dp[V]出发，每次减去对应位置上的数字，看是否能到dp[0]
        // dp[remain] : 该容量是否已经用过，用过为可达，dp[0] == true说明可从V 到 0
        boolean[] dp = new boolean[V + 1];
        //
        Arrays.sort(nums);
        dfs(nums, 0, V, dp);
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
    //        int n = c.length;
    //        int[] dp = new int[V + 1];
    //        for(int i = 0; i < n; i++) {
    //            for(int j = V; j >= c[i]; j--) {
    //                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
    //            }
    //        }
    //        return dp[V];
    public static boolean canPartition_1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if((sum & 1) == 1) {
            return false;
        }
        int V = sum / 2;
        // 每个物品只装一次，物品的cost == value，
        // 容量为V的背包的价值是否恰好为V（物品的cost == value时，容量为V的背包的最大价值就是V（完全装满））
        // dp[V]<=V 恒成立
        int[] dp = new int[V + 1];
        for(int i = 0; i < n; i++) {
            for(int j = V; j >=nums[i]; j--) {

                // 第二个dp[j]: 前i - 1个物品，背包容量为j时的最大价值
                // dp[j]更新后为: 前i个物品，背包容量为j时的最大价值
                // dp[j - nums[i]] + nums[i]: 前i - 1个物品，背包容量为j - nums[i]时(此时才可以转移到j)的最大价值
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

            }
        }
        // 装不满：false
        return dp[V] == V;
    }
    // 官方题解
    public static boolean canPartition_2(int[] nums) {
        int n = nums.length;
        if(n <= 1) {
            return false;
        }
        int sum = 0;
        int mx = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            mx = Math.max(mx, nums[i]);
        }
        if((sum & 1) == 1) {
            return false;
        }
        int V = sum / 2;
        if(mx > V) {
            return false;
        }

        // 边界：1.
        //dp[i][j]: 数组[0,i]范围内选若干正整数(可以是0个)，是否存在一种方案
        // 使得备选正整数的和==j

        //2.当 i==0时，只有一个正整数 nums[0] 可以被选取，
        // 因此 dp[0][nums[0]]=true。
        boolean[][] dp = new boolean[n][V + 1];
        for(int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= V; j++) {
                if(j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][V];
    }
    //  * 23,13,11,7,6,5,5,8,6,6,4,4
    // * 4,4,5,5,6,6,6,7,8,11,13,23 -> sum / 2 = 49
    // 4,4...
    // 4,5...
    // ...
    // 4,23...
    // ...
    //
    private static void dfs(int[] nums, int cur, int remain, boolean[] dp) {
        dp[remain] = true;
        if(remain == 0) {
            return;
        }
        for(int i = cur; i < nums.length; i++) {
            // 减枝：若已经可达dp[0]就停止
            if(remain - nums[i] >= 0 && !dp[remain - nums[i]]&& !dp[0]) {
                dfs(nums, i + 1, remain - nums[i], dp);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,8};
        System.out.println(canPartition_1(nums));
    }
}
