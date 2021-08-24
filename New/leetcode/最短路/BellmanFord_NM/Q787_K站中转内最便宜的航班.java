package leetcode.template.最短路.BellmanFord_NM;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/24 14:10
 */
public class Q787_K站中转内最便宜的航班 {
    int INF = 0x3f3f3f3f;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for(int i = 0; i <= k; i++) {
            int[] prev = dist.clone();
            for(int[] e : flights) {
                int u = e[0], v = e[1], w = e[2];
                dist[v] = Math.min(dist[v], prev[u] + w);
            }
        }
        int ans = dist[dst];
        return ans == INF ? -1 : ans;
    }
}
