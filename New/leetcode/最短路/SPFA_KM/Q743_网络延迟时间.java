package leetcode.template.最短路.SPFA_KM;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/3 18:18
 */
public class Q743_网络延迟时间 {
    // 这一算法被认为在随机的稀疏图上表现出色，并且适用于带有负边权的图
    // bf 算法扫所有边，SPFA扫当前节点邻接的边
    int INF = 0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for(int[] e : times) {
            int u = e[0], v = e[1], w = e[2];
            g.putIfAbsent(u, new ArrayList<>());
            g.get(u).add(new int[]{v, w});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        dist[0] = 0;
        // 是否在队列中
        boolean[] inQue = new boolean[n + 1];
        Deque<Integer> q = new LinkedList<>();
        inQue[k] = true;
        q.offer(k);
        while(!q.isEmpty()) {
            int u = q.pollFirst();
            inQue[u] = false;
            List<int[]> list = g.get(u);
            if(list == null) {
                continue;
            }
            for(int[] e : list) {
                int v = e[0], w = e[1];
                if(dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    if(!inQue[v]) {
                        q.offerLast(v);
                        inQue[v] = true;
                    }
                }
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        // System.out.println(Arrays.toString(dist));
        return ans == INF ? -1 : ans;
    }
}
