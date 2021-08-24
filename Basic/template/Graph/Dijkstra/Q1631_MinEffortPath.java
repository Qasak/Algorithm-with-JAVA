package leetcode.template.Graph.Dijkstra;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/29 22:55
 */
public class Q1631_MinEffortPath {
    public int minimumEffortPath(int[][] matrix) {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] vis = new boolean[n * m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        int[] dist = new int[n * m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            int x = t[0]; int y = t[1]; int d = t[2];
            if(x == n - 1 && y == m - 1) {
                break;
            }
            if(vis[x * m + y]) {
                continue;
            }
            vis[x * m + y] = true;
            for(int i = 0; i < 4; i++) {
                int xx = x + dir[i][0]; int yy = y + dir[i][1];
                if(xx >= 0 && xx < n && yy >= 0 && yy < m && Math.max(d, Math.abs(matrix[x][y] - matrix[xx][yy])) < dist[xx * m + yy]) {
                    dist[xx * m + yy] = Math.max(d, Math.abs(matrix[x][y] - matrix[xx][yy]));
                    pq.offer(new int[]{xx, yy, dist[xx * m + yy]});
                }
            }
        }
        return dist[n * m - 1];
    }
}
