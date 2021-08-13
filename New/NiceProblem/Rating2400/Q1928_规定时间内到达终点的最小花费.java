package leetcode.contest.Rating2400;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/12 23:51
 */
public class Q1928_规定时间内到达终点的最小花费 {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g.putIfAbsent(u, new ArrayList<>());
            g.putIfAbsent(v, new ArrayList<>());
            g.get(u).add(new int[]{v, w});
            g.get(v).add(new int[]{u, w});
        }
        int n = g.size();
        // minCost
        int[][] dist = new int[n][maxTime + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 0x3f3f3f3f);
        }
        // [cost, u, time]
        dist[0][0] = passingFees[0];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        q.offer(new int[]{passingFees[0], 0, 0});
        while(!q.isEmpty()) {
            int[] poll = q.poll();
            int c = poll[0], u = poll[1], t = poll[2];
            if(u == n - 1) {
                return c;
            }
            for(int[] e : g.get(u)) {
                int v = e[0], w = e[1];
                if(t + w <= maxTime && dist[v][t + w] > c + passingFees[v]) {
                    dist[v][t + w] = c + passingFees[v];
                    q.offer(new int[]{c + passingFees[v], v, t + w});
                }
            }
        }
        return -1;
    }
}
