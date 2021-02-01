package leetcode.template.Graph.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/30 15:31
 */
public class Q778_swimInWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] dist = new int[n * n];
        boolean[] vis = new boolean[n * n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        while(!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0]; int y = p[1]; int d = p[2];
            if(x == n - 1 && y == n - 1) {
                break;
            }
            if(vis[x * n + y]) {
                continue;
            }
            vis[x * n + y] = true;
            for(int[] dd: dir) {
                int xx = x + dd[0]; int yy = y + dd[1];
                if(xx >= 0 && xx < n && yy >= 0 && yy < n && Math.max(d, grid[xx][yy]) < dist[xx * n + yy]) {
                    dist[xx * n + yy] = Math.max(d, grid[xx][yy]);
                    pq.add(new int[]{xx, yy, dist[xx * n + yy]});
                }
            }
        }
        return dist[n * n - 1];
    }
}
