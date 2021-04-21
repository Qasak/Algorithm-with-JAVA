package leetcode.template.Graph.Dijkstra;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/7 13:23
 */
public class Q5669_从第一个节点出发到最后一个节点的受限路径数 {
    int mod = (int) (1e9 + 7);
    int N;
    Map<Integer, List<int[]>> g;
    Map<Integer, Integer> path;
    Map<Integer, Integer> dist;
    // dijkstra单源最短路 + 记忆化搜索
    public int countRestrictedPaths(int n, int[][] edges) {
        g = new HashMap<>();
        N = n;
        for(int[] e : edges) {
            g.computeIfAbsent(e[0], k -> new ArrayList<>());
            g.computeIfAbsent(e[1], k -> new ArrayList<>());
            g.get(e[0]).add(new int[]{e[1], e[2]});
            g.get(e[1]).add(new int[]{e[0], e[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.offer(new int[]{n, 0});
        dist = new HashMap<>();
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            int u = t[0];
            int d = t[1];
            if(dist.containsKey(u)) {
                continue;
            }
            dist.put(u, d);
            if(g.containsKey(u)) {
                for(int[] e : g.get(u)) {
                    int v = e[0];
                    int d1 = e[1];
                    if(!dist.containsKey(v)) {
                        pq.offer(new int[]{v, d + d1});
                    }
                }
            }
        }
        // 每个点到n的最短距离

        // int ans = 0;
        // PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        // // (i, d[i])
        // q.add(new int[]{1, d[1]});
        // int pre = d[1];
        // while(!q.isEmpty()) {
        //     int[] cur = q.poll();
        //     int u = cur[0];
        //     int du = cur[1];
        //     if(du > pre) {
        //         return ans;
        //     }
        //     if(u == n) {
        //         ans++;
        //         if(ans >= mod) {
        //             ans -= mod;
        //         }
        //         continue;
        //     }
        //     for(int[] t : g.get(u)) {
        //         int v = t[0];

        //         if(d[v] < du) {
        //             q.offer(new int[]{v, d[v]});
        //         }
        //     }
        //     pre = du;
        // }
        path = new HashMap<>();
        path.put(n, 1);
        return dfs(1);
    }
    public int dfs(int u) {
        if(path.containsKey(u)) {
            return path.get(u);
        }
        int res = 0;
        for(int[] e : g.get(u)) {
            int v = e[0];
            if(dist.get(v) >= dist.get(u)) {
                continue;
            }
            res = (res + (dfs(v) % mod)) % mod;
        }
        path.put(u, res);
        return res;
    }
}
