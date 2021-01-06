package leetcode.template.DP.Stage;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/21 9:41
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class Q746_MinCostClimbing {
    // dp1
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) {
            return cost[0];
        }
        // 第n个台阶只能从第n-1或者n-2个上来。
        // dp[i] :到达i阶梯 的最小花费
        // 到达最后一个阶梯或倒数第二个阶梯就可以了
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < n ; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
    // dp2 空间优化
    public static int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        if(n == 1) {
            return cost[0];
        }
        // dp[i] :到达i阶梯 的最小花费
        int dp1 = cost[0];
        int dp2 = cost[1];
        for(int i = 2; i < n ; i++) {
            int t = dp2;
            dp2 = Math.min(dp1 + cost[i], dp2 + cost[i]);
            dp1 = t;
        }
        return Math.min(dp1, dp2);
    }
    //dp3 官方题解

    public static int minCostClimbingStairs3(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    // dp4官方空间优化
    public static int minCostClimbingStairs4(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        // cost : 6
        int[] nums = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(nums));
    }
}
