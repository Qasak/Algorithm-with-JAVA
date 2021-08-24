package leetcode.template.Graph.Dijkstra;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/1 12:08
 */
public class Q787 {
    // 这道题dijstra算法，如果不对每个节点的dist距离值做多次访问的处理，常规解法是很难解开的。
    // 官方示例给的 k*1000 就是很好的避开了当多次访问一个点时覆盖dist距离值的一个解决方案

    // 时间复杂度：O(E+nlogn)，其中 E 是航线的数量。
    //
    //空间复杂度：O(n)，优先级队列的大小。
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(src, 0);
        List<List<int[]>> g = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for(int[] e : flights) {
            g.get(e[0]).add(new int[]{e[1], e[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        // u/d/k
        pq.offer(new int[]{src, 0, 0});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int u = p[0];
            int d = p[1];
            int k = p[2];
            if(u == dst) {
                return d;
            }
            if(k > K) {
                continue;
            }
            for(int[] t : g.get(u)) {
                int v = t[0];
                int w = t[1];
                if(dist.get(v + 1000 * k) == null || dist.get(v + 1000 * k) > d + w ) {
                    dist.put(v + 1000 * k, d + w);
                    pq.offer(new int[]{v, d + w, k + 1});
                }
            }
        }
        return -1;
    }

    // bellman-ford
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        // dp[i][v]第i次中转后到达v时的最小花费
        int[][] dp = new int[K + 1][n];
        int INF = 0x3f3f3f3f;
        for(int i = 0; i < K + 1; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][src] = 0;
        }
        for(int i = 0; i < K + 1; i++) {
            for(int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if(i == 0) {
                    if(u == src) {
                        dp[0][v] = w;
                    }
                    continue;
                }
                if(dp[i - 1][u] != INF) {
                    dp[i][v] = Math.min(dp[i][v], dp[i - 1][u] + w);
                }
            }
        }
        return dp[K][dst] == INF ? -1 : dp[K][dst];
    }
    // BFS
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();// 航班根据起点进行分组
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], k -> new ArrayList<>()).add(flight);
        }
        int res = Integer.MAX_VALUE;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});
        for (int size; (size = queue.size()) > 0 && K >= 0; --K) {
            while (--size >= 0) {
                int[] poll = queue.poll();
                for (int[] flight : map.getOrDefault(poll[0], Collections.emptyList())) {
                    int next = flight[1], cost = poll[1] + flight[2];
                    if (cost >= res) {
                        continue;
                    }
                    if (next == dst) {
                        res = cost;
                    } else {
                        queue.offer(new int[]{next, cost});
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
