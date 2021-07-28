package leetcode.contest.Rating2000.图.Dijkstra模板;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/28 9:00
 */
public class Q743_网络延迟时间 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] t : times) {
            map.putIfAbsent(t[0], new ArrayList<>());
            map.get(t[0]).add(new int[]{t[1], t[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        dist[0] = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (dist[a] - dist[b]));
        q.offer(k);

        int cnt = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            List<int[]> list = map.get(u);
            if(list == null) {
                continue;
            }
            for(int[] t : map.get(u)) {
                int v = t[0], w = t[1];
                if(dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    q.offer(v);
                }
            }
        }
        int max = Arrays.stream(dist).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
