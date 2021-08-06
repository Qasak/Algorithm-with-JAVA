package leetcode.contest.Rating2200.图;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/8/6 17:14
 */
public class Q847_访问所有节点的最短路径 {
    // 最短路径容易想到BFS
    // 重复访问需要记录 节点x状态，用一个状态压缩的二维数组vis表示


    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int ans = 0x3f3f3f3f;
        for(int i = 0; i < n; i++) {
            Deque<int[]> q = new LinkedList<>();
            boolean[][] vis = new boolean[n][1 << n];
            // 当前点，状态，路径长度
            q.offer(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true;
            while(!q.isEmpty()) {
                int[] t = q.poll();
                int u = t[0], stat = t[1], dist = t[2];
                if(stat == (1 << n) - 1) {
                    ans = Math.min(ans, dist);
                    break;
                }
                for(int v : graph[u]) {
                    int vStat = stat | (1 << v);
                    if(vis[v][vStat]) {
                        continue;
                    }
                    vis[v][vStat] = true;
                    q.offer(new int[]{v, vStat, dist + 1});
                }
            }
        }
        return ans;
    }
    // 也可以先将起点放进去
    // 普通BFS时间复杂度O(V + E)
    // 状态压缩O((V + E)(2 ^ n))
    // 边不确定，最坏情况n ^ 2
    // -> O(n ^ 2 * 2 ^ n)
    public int shortestPathLength1(int[][] graph) {
        int n = graph.length;
        int ans = 0x3f3f3f3f;
        Deque<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][1 << n];
        for(int i = 0; i < n; i++) {
            // 当前点，状态，路径长度
            q.offer(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true;
        }
        while(!q.isEmpty()) {
            int[] t = q.poll();
            int u = t[0], stat = t[1], dist = t[2];
            if(stat == (1 << n) - 1) {
                return dist;
            }
            for(int v : graph[u]) {
                int vStat = stat | (1 << v);
                if(vis[v][vStat]) {
                    continue;
                }
                vis[v][vStat] = true;
                q.offer(new int[]{v, vStat, dist + 1});
            }
        }
        return -1;
    }
}
