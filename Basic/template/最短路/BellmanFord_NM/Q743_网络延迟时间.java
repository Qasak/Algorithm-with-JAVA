package leetcode.template.最短路.BellmanFord_NM;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/3 17:58
 */
public class Q743_网络延迟时间 {
    int[] dist;
    int INF = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        dist[0] = 0;
        for(int i = 0; i < n; i++) {
            int[] prev = dist.clone();
            for(int[] e : times) {
                int u = e[0], v = e[1], w = e[2];
                dist[v] = Math.min(dist[v], prev[u] + w);
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }
}
