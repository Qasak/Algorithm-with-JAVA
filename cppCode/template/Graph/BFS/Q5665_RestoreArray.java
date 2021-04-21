package leetcode.template.Graph.BFS;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/31 12:32
 */
public class Q5665_RestoreArray {
    public int[] restoreArray(int[][] edges) {
        int n = edges.length + 1;
        // id : 节点值-编号
        Map<Integer, Integer> id = new HashMap<>();
        // id1 : 编号-节点值
        Map<Integer, Integer> id1 = new HashMap<>();
        int k = 0;
        for(int i = 0; i < edges.length; i++) {
            if(!id.containsKey(edges[i][0])) {
                id.put(edges[i][0], k++);
                id1.put(k - 1, edges[i][0]);

            }
            if(!id.containsKey(edges[i][1])) {
                id.put(edges[i][1], k++);
                id1.put(k - 1, edges[i][1]);
            }
        }

        List<Integer>[] g = new List[n];
        // 编号-入度
        Map<Integer, Integer> in = new HashMap<>();
        for(int i = 0 ; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            in.put(id.get(e[0]), in.getOrDefault(id.get(e[0]), 0) + 1);
            in.put(id.get(e[1]), in.getOrDefault(id.get(e[1]), 0) + 1);
            g[id.get(e[0])].add(id.get(e[1]));
            g[id.get(e[1])].add(id.get(e[0]));
        }
        int start = 0;
        for(int t : in.keySet()) {
            if(in.get(t) == 1) {
                start = t;
                break;
            }
        }

        boolean[] vis = new boolean[n];
        Deque<Integer> q = new LinkedList<>();
        // start 入度为1的点编号
        q.offer(start);
        int idx = 0;
        int[] res = new int[n];
        while(!q.isEmpty()) {
            int u = q.poll();
            vis[u] = true;
            res[idx] = id1.get(u);
            for(int v: g[u]) {
                if(!vis[v]) {
                    // System.out.println(v + " " + id1.get(v));
                    res[++idx] = id1.get(v);
                    q.offer(v);
                }
            }
        }
        return res;
    }

    public int[] restoreArray1(int[][] edges) {
        int n = edges.length + 1;
        Map<Integer, List<Integer>> g = new HashMap<>();
        Map<Integer, Integer> in = new HashMap<>();
        int k = 0;
        for(int[] e : edges) {
            if(!g.containsKey(e[0])) {
                g.put(e[0], new ArrayList<Integer>());
            }
            if(!g.containsKey(e[1])) {
                g.put(e[1], new ArrayList<Integer>());
            }
            g.get(e[1]).add(e[0]);
            g.get(e[0]).add(e[1]);
            in.put(e[0], in.getOrDefault(e[0], 0) + 1);
            in.put(e[1], in.getOrDefault(e[1], 0) + 1);
        }

        // 编号-入度
        int start = 0;
        for(int t : in.keySet()) {
            if(in.get(t) == 1) {
                start = t;
                break;
            }
        }
        Set<Integer> vis = new HashSet<>();
        Deque<Integer> q = new LinkedList<>();
        // start 入度为1的点编号
        q.offer(start);
        vis.add(start);
        int idx = 0;
        int[] res = new int[n];
        while(vis.size() < n) {
            int u = q.poll();
            res[idx] = u;
            for(int v: g.get(u)) {
                if(!vis.contains(v)) {
                    res[++idx] = v;
                    q.offer(v);
                    vis.add(v);
                    if(vis.size() == n) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
