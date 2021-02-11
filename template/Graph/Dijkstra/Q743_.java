package leetcode.template.Graph.Dijkstra;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/10 23:42
 */
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
}
