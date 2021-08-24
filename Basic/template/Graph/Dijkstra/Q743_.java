package leetcode.template.Graph.Dijkstra;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/10 23:42
 */

// Dijkstra本质是贪心+广搜
    // 适合稠密图(边多的图)
    // 无论有无环，Dijkstra都可用，只是不能处理负权边
    // 因为它本身是贪心策略，每个点选择后就不再更新，如果碰到负边就会破坏这个贪心策略。
public class Q743_ {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] e : times) {
            if(!g.containsKey(e[0])) {
                g.put(e[0], new ArrayList<>());
            }
            g.get(e[0]).add(new int[]{e[1], e[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        q.offer(new int[]{k, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        while(!q.isEmpty()) {
            int[] t = q.poll();
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
                        q.offer(new int[]{v, d + d1});
                    }
                }
            }
        }
        if(dist.size() != n) {
            return -1;
        }
        int res = 0;
        for(int i : dist.values()) {
            res = Math.max(res, i);
        }
        return res;
    }

    // O(VlogV + E)
    public int networkDelayTime1(int[][] times, int n, int k) {
        boolean[] vis = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] e : times) {
            if(!g.containsKey(e[0])) {
                g.put(e[0], new ArrayList<>());
            }
            g.get(e[0]).add(new int[]{e[1], e[2]});
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = -1;
        dist[k] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        pq.offer(k);
        while(!pq.isEmpty()) {
            int u = pq.poll();
            if(vis[u]) {
                continue;
            }
            int d = dist[u];
            vis[u] = true;
            if(g.containsKey(u)) {
                for(int[] e : g.get(u)) {
                    int v = e[0];
                    int d1 = e[1];
                    if(!vis[v]) {
                        dist[v] = Math.min(dist[v], d + d1);
                        pq.offer(v);

                    }
                }
            }
        }
        int res = 0;
        for(int i: dist) {
            res = Math.max(res, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
