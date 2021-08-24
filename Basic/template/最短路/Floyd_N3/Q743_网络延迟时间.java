package leetcode.template.最短路.Floyd_N3;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/3 16:30
 */
public class Q743_网络延迟时间 {
    int INF = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }
        for(int[] p : times) {
            int u = p[0], v = p[1], w = p[2];
            g[u][v] = w;
        }
        for(int u = 1; u <= n; u++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][u] + g[u][j]);
                }
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(g[k][i], ans);
        }
        return ans == INF ? -1 : ans;
    }
}
