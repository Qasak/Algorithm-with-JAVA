package leetcode.SpringRecruit.DP;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/15 11:51
 */
public class Q265_粉刷房子2 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        if(n == 1) {
            return Arrays.stream(costs[0]).min().getAsInt();
        }
        int[][] dp = new int[n][k];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
//        int[] dp0 = new int[k];


        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < k; j++) {
                for(int p = 0; p < k; p++) {
                    if(p == j) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][p] + costs[i][j]);
                }
            }
        }
        return  Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    // 滚动数组，空间优化
    class Solution {
        public int minCostII(int[][] costs) {
            int n = costs.length;
            int k = costs[0].length;
            if(n == 1) {
                return Arrays.stream(costs[0]).min().getAsInt();
            }
            int[] dp = new int[k];
            for(int i = 0; i < k; i++) {
                dp[i] = costs[0][i];
            }
            int[] dp0 = new int[k];
            for(int i = 1; i < n; i++) {
                dp0 = Arrays.copyOf(dp, k);
                Arrays.fill(dp, Integer.MAX_VALUE);
                for(int j = 0; j < k; j++) {
                    // O(1) 拿到最小值 Queue
                    for(int p = 0; p < k; p++) {
                        if(p == j) {
                            continue;
                        }
                        dp[j] = Math.min(dp[j], dp0[p] + costs[i][j]);
                    }

                }
            }
            return  Arrays.stream(dp).min().getAsInt();
        }
    }


    // 优先队列
    // nklogk
    class Solution1 {
        public int minCostII(int[][] costs) {
            int n = costs.length;
            int k = costs[0].length;
            if(n == 1) {
                return Arrays.stream(costs[0]).min().getAsInt();
            }
            int[] dp = new int[k];
            for(int i = 0; i < k; i++) {
                dp[i] = costs[0][i];
            }
            for(int i = 1; i < n; i++) {
                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
                for(int idx = 0; idx < k; idx++) {
                    pq.offer(new int[]{idx, dp[idx]});
                }
                Arrays.fill(dp, Integer.MAX_VALUE);
                for(int j = 0; j < k; j++) {
                    int[] pre = new int[2];
                    boolean flag = false;
                    if(pq.peek()[0] == j) {
                        pre = pq.poll();
                        flag = true;
                    }
                    if(!pq.isEmpty()) {
                        dp[j] = Math.min(dp[j], costs[i][j] + pq.peek()[1]);
                    }
                    if(flag) {
                        pq.offer(pre);
                    }
                }

            }
            return  Arrays.stream(dp).min().getAsInt();
        }
    }
}
