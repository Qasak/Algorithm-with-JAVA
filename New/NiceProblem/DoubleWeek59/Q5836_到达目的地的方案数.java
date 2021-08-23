package leetcode.contest.DoubleWeek59;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/23 10:19
 */
public class Q5836_到达目的地的方案数 {
    int mod = (int) 1e9 + 7;
    int[] f;
    long[] dist;
    int N;
    Map<Integer, List<int[]>> map;
    Map<Integer, List<Integer>> g;

    boolean[] vis;
    public int countPaths(int n, int[][] roads) {
        N = n;
        dist = new long[n];
        // f = new HashMap<>();
        f = new int[n];
        vis = new boolean[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(f, -1);
        dist[0] = 0;
        // d, u
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> ((int)(dist[a] - dist[b])));
        map = new HashMap<>();
        for(int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(new int[]{v, w});
            map.get(v).add(new int[]{u, w});
        }
        if(map.size() == 0) {
            return 1;
        }
        q.offer(0);
        while(!q.isEmpty()) {
            int u = q.poll();
            long d = dist[u];
            for(int[] t : map.get(u)) {
                int v = t[0], w = t[1];
                if(d + w < dist[v]) {
                    q.offer(v);
                    dist[v] = d + w;
                }
            }
        }
        g = new HashMap<>();
        for(int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            if(dist[u] - dist[v] == w) {
                g.putIfAbsent(v, new ArrayList<>());
                g.get(v).add(u);
            } else if(dist[v] - dist[u] == w) {
                g.putIfAbsent(u, new ArrayList<>());
                g.get(u).add(v);
            }
        }
        return dfs(0);
    }
    int dfs(int u) {
        int ans = 0;
        if(u == N - 1) {
            return 1;
        }
        if(f[u] != -1) {
            return f[u];
        }
        List<Integer> list = g.get(u);
        if(list == null) {
            return 0;
        }
        f[u] = 0;
        for(int v : list) {
            ans = (ans + dfs(v)) % mod;
        }
        return f[u] = ans;
    }
}
