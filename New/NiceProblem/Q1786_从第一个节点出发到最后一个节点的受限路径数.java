package leetcode.contest.NiceProblem;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/5/31 19:03
 */
public class Q1786_从第一个节点出发到最后一个节点的受限路径数 {
    // 起点： [(终点1, 权值), (终点2, 权值)]
    Map<Integer, List<int[]>> g = new HashMap<>();
    // // [点, 到源点的距离]
    // Map<Integer, Integer> dist = new HashMap<>();
    int[] dist;
    // [点, 到源点的距离]
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    // 节点u:节点u到终点的受限路径条数
    Map<Integer, Integer> path = new HashMap<>();
    static int mod = (int) 1e9 + 7;
    public int countRestrictedPaths(int n, int[][] edges) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        // 每个点到终点的最短距离
        for(int[] e : edges) {
            // g[e[0]][e[1]] = e[2];
            // g[e[1]][e[0]] = e[2];
            if(g.get(e[0]) == null) {
                g.put(e[0], new ArrayList<>());
            }
            if(g.get(e[1]) == null) {
                g.put(e[1], new ArrayList<>());
            }
            g.get(e[0]).add(new int[]{e[1], e[2]});
            g.get(e[1]).add(new int[]{e[0], e[2]});
        }
        // [节点，到源点距离]
        boolean[] vis = new boolean[n + 1];
        pq.offer(new int[]{n, 0});
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            int u = t[0], d = t[1];
            // 加入已松弛集合
            for(int[] e: g.get(u)) {
                int v = e[0];
                int u2v = e[1];
                // 未完成松弛操作的点
                if(!vis[v] && dist[v] > dist[u] + u2v) {
                    dist[v] = d + u2v;
                    vis[u] = true;
                    pq.offer(new int[]{v, d + u2v});
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        return dfs(1, n);
    }
    // 从中间的节点u出发到终点的受限路径数
    private int dfs(int u, int n) {
        if(u == n) {
            return 1;
        }
        if(path.containsKey(u)) {
            return path.get(u);
        }
        int res = 0;
        for(int[] e : g.get(u)) {
            if(dist[e[0]] >= dist[u]) {
                continue;
            }
            res += dfs(e[0], n);
            if(res >= mod) {
                res -= mod;
            }
        }
        path.put(u, res);
        return res;
    }
    public static int countRestrictedPaths1(int n, int[][] edges) {
        //key为u,value格式为[v, weight]
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
            map.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        //dis[i]表示点i到点n的最短距离
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n] = 0;
        //bfs求出每个点到n的最短距离
        //待访问的点
        Deque<Integer> points = new LinkedList<>();
        points.addLast(n);
        while (!points.isEmpty()) {
            int point = points.pollFirst();
            for (int[] e : map.get(point)) {
                if (e[1] + dis[point] < dis[e[0]]) {
                    dis[e[0]] = e[1] + dis[point];
                    points.addLast(e[0]);
                }
            }
        }

        //记忆化搜索
        //key为点的index，value为到n的受限路径数
        HashMap<Integer, Integer> paths = new HashMap<>();

        return dfs(1, n, map, dis, paths);
    }

    //i为本次搜索的起点
    private static int dfs(int i, int n, HashMap<Integer, List<int[]>> map,
                           int[] dis, HashMap<Integer, Integer> paths) {
        if (i == n) {
            return 1;
        }

        int res = 0;
        List<int[]> list = map.get(i);
        for (int[] e : list) {
            if (dis[i] <= dis[e[0]]) {
                continue;
            }
            if (!paths.containsKey(e[0])) {
                paths.put(e[0], dfs(e[0], n, map, dis, paths));
            }
            res = (res + paths.get(e[0])) % mod;
        }

        return res;
    }

    public static void main(String[] args) {
    }

    // dp 解法

}
