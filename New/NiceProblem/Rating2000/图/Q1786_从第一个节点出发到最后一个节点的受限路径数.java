package leetcode.contest.Rating2000.图;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/27 17:46
 */
public class Q1786_从第一个节点出发到最后一个节点的受限路径数 {
    // dijkstra
    int[] f;
    static int mod = (int) 1e9 + 7;
    public int countRestrictedPaths(int n, int[][] edges) {
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            // v, w
            int[] t1 = new int[2];
            // u, w
            int[] t2 = new int[2];
            t1[0] = v; t1[1] = w;
            t2[0] = u; t2[1] = w;
            map.get(u).add(t1);
            map.get(v).add(t2);
        }
        // dij

        // n到其他所有点的距离
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        // 已松弛的点，按照与源点距离排序
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        q.offer(new int[]{n, 0});
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int u = p[0], cur = p[1];
            for(int[] t : map.get(u)) {
                int v = t[0], w = t[1];
                if(dist[v] > cur + w) {
                    dist[v] = cur + w;
                    q.offer(new int[]{v, cur + w});
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        // boolean[] vis = new boolean[n + 1];
        f = new int[n + 1];
        dfs(1, n,  dist, map);

        // System.out.println(Arrays.toString(f));
        return f[1];
    }
    private int dfs(int u, int n,  int[] dist, Map<Integer, List<int[]>> map) {
        if(u == n) {
            return 1;
        }
        if(f[u] != 0) {
            return f[u];
        }
        int ans = 0;
        for(int[] edge : map.get(u)) {
            int v = edge[0];
            if(dist[u] > dist[v]) {
                ans += dfs(v, n,  dist, map);
                ans %= mod;
            }
        }
        return f[u] = ans;
    }

}
