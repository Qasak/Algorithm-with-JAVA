package leetcode.template.DP.Pack;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/12 21:40
 *「力扣」上的 0-1 背包问题：
 *
 * 「力扣」第 416 题：分割等和子集（中等）；
 * 「力扣」第 474 题：一和零（中等）；
 * 「力扣」第 494 题：目标和（中等）；
 * 「力扣」第 879 题：盈利计划（困难）；
 * 「力扣」上的 完全背包问题：
 *
 * 「力扣」第 322 题：零钱兑换（中等）；
 * 「力扣」第 518 题：零钱兑换 II（中等）；
 * 「力扣」第 1449 题：数位成本和为目标值的最大数字（困难）。
 *
 *
 * 有 n 个物品和容量为 V 的背包，第 i 件物品的体积为 c[i]，价值为 w[i]。
 * 现在的目标是确定要将哪些物体放入背包，以保证在体积 不超过背包容量 的前提下，背包内的 总价值最高？
 */
public class Pack_01 {
    /**
     * 约束条件：每种物品数量为 1，可以选择放或不放
     * 定义dp[i][j] 为前[0, i]个物品中，体积恰好为j时的最大价值
     * result = max(dp[n][0~V])
     * dp[i][v] = max(dp[i - 1][v], dp[i - 1][v - c[i]] + w[i])
     * */

    public static int pack_01(int[] c, int[] w, int V) {
        int n = c.length;
        int[][] dp = new int[n + 1][V + 1];
        // j: 当前背包体积
        // 初始化：是否将第一个物品装入
        for(int j = 0; j <= V; j++) {
            if(c[0] <= j) {
                dp[0][j] = w[0];
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = c[i]; j <= V; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + w[i]);
            }
        }
        return dp[n - 1][V];
    }
    // dp[i]: 背包容量为i时，能放入物品的最大价值
    public static int pack_01_1(int[] c, int[] w, int V) {
        int n = c.length;
        int[] dp = new int[V + 1];
//        for(int j = 0; j <= V; j++) {
//            if(c[0] <= j) {
//                dp[j] = w[0];
//            }
//        }
        for(int i = 0; i < n; i++) {
            for(int j = V; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[V];
    }
    /**
     * //01背包
     * for (int i = 0; i < n; i++) {
     *     for (int j = V; j >= c[i]; j--) {
     *         f[j] = max(f[j], f[j-c[i]] + W[i]);
     *     }
     * }
     * //完全背包
     * for (int i = 0; i < n; i++) {
     *     for (int j = c[i]; j <= V; j++) {
     *         f[j] = max(f[j], f[j-c[i]] + w[i]);
     *     }
     * }
     * */
    public static void main(String[] args) {
        // 2,2,6,5,4
        // 6,3,5,4,6
        // 10 -> 15
        // 3,5,1,2,2
        // 4,5,2,1,3
        // 8 -> 10
//        int[] c = new int[]{2,2,6,5,4};
        int[] c = new int[]{6,3,5,4,6};
        int[] w = new int[]{6,3,5,4,6};
        int V = 10;
        System.out.println(pack_01_1(c, w, V));
    }
}
