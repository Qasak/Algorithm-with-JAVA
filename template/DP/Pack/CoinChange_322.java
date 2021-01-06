package leetcode.template.DP.Pack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2020/12/12 22:50
 *
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回-1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 */
public class CoinChange_322 {
    // dfs
    // 关于DFS与BFS的选择问题，一般来说，算路径用DFS更佳，算步数用BFS更佳
    int[] coins;
    int[] dp;
    int MAXN = 0x3f3f3f3f;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.dp = new int[amount + 1];
        Arrays.fill(dp, MAXN);
        return dfs(amount);
    }
    private int dfs(int amount) {
        if(amount == 0) {
            return 0;
        }
        if(amount < 0) {
            return -1;
        }
        if(dp[amount] < MAXN) {
            return dp[amount];
        }
        int min = MAXN;
        for(int i = 0; i < coins.length; i++) {
            int res = dfs(amount - coins[i]);
            if(res >= 0 && res < min) {
                min = res + 1;
            }
        }
        return dp[amount] = min == MAXN ? -1 : min;
    }
    // BFS
    // 从amount到0的最短路径问题
    public int coinChange2(int[] coins, int amount) {
        Queue<Integer> q = new LinkedList<>();
        if(amount == 0) {
            return 0;
        }
        boolean[] vis = new boolean[amount + 1];
        Arrays.sort(coins);
        q.offer(amount);
        int step = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            // 挨个访问当前层的节点
            for(int i = 0; i < size; i++) {
                // vis[cur] = true;
                // 看下一层是否到0，若<0, break(coins从小到大)。
                // 大于0的节点加入下一层
                int cur = q.poll();
                if(vis[cur]) {
                    continue;
                }
                vis[cur] = true;
                for(int j = 0; j < coins.length; j++) {
                    int next = cur - coins[j];
                    if(next == 0) {
                        return step;
                    }
                    if(next < 0) {
                        break;
                    } else {
                        if(!vis[next]) {
                            q.offer(next);
                        }
                    }
                }
            }
            // 当前层访问完毕，++
            step++;
        }
        return -1;
    }
    // dp
    public int coinChange1(int[] coins, int amount) {
        int[] dp = new int [amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        // dp[i] = min(dp[i], dp[i - coins[j]] + 1);
        // [1,2]
        // dp[1] = min(dp[1], dp[0] + 1) = 1
        // dp[2] = min(dp[2], min(dp[2 - 2], dp[2 - 1]) + 1)
        // dp[4] = min(dp[4], dp[0] + 1) = 1
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
