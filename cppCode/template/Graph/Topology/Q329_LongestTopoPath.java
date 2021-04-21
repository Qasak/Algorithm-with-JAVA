package leetcode.template.Graph.Topology;

import java.util.*;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/12 9:06
 */
public class Q329_LongestTopoPath {
    // 拓扑排序：可以想象矩阵中符合题意的路径组成了一个有向无环图，即可通过拓扑排序求解有向无环图的最长路径(BFS)。
    // 暴力DFS拓扑 超时
    List<Integer>[] g;
    boolean[] vis;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int ans = 0;
        int m = matrix[0].length;
        g = new List[n * m];

        for(int i = 0; i < n * m; i++) {
            g[i] = new ArrayList<>();
        }
        // in
        Map<Integer, Integer> map = new HashMap<>();
        // build graph
        for(int i = 0;  i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
                    int v = m * (i - 1) + j;
                    g[m * i + j].add(v);
                    map.put(v, map.getOrDefault(v, 0) + 1);
                }
                if(i + 1 < n && matrix[i + 1][j] > matrix[i][j]) {
                    int v = m * (i + 1) + j;
                    g[m * i + j].add(v);
                    map.put(v, map.getOrDefault(v, 0) + 1);


                }
                if(j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
                    int v = m * i + (j - 1);
                    g[m * i + j].add(v);
                    map.put(v, map.getOrDefault(v, 0) + 1);

                }
                if(j + 1 < m && matrix[i][j + 1] > matrix[i][j]) {
                    int v = m * i + (j + 1);
                    g[m * i + j].add(v);
                    map.put(v, map.getOrDefault(v, 0) + 1);

                }
            }
        }
        for(int i = 0; i < n * m; i++) {
            if(map.get(i) == null) {
                vis = new boolean[n * m];
                ans = Math.max(ans, dfs(i, 1));
            }
        }
        return ans;
    }
    int dfs(int u, int len) {
        vis[u] = true;
        int mx = len;
        for(int v : g[u]) {
            if(!vis[v]) {
                mx = Math.max(mx, dfs(v, len + 1));
            }
        }
        vis[u] = false;

        return mx;
    }

    // BFS:从最大的点倒推
    // 拓扑顺序的终点一定是出度为0的点
    // O(V + E)
    // V = m * n E = 4 * m * n
    // O(m * n)
    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int longestIncreasingPath1(int[][] matrix) {
        int n = matrix.length;
        if(n == 0 ){
            return 0;
        }
        int m = matrix[0].length;
        int[][] out = new int[n][m];
        for(int i = 0; i < n ; i++ ) {
            for(int j = 0; j < m; j++) {
                for(int[] d: dir) {
                    int x = i + d[0];
                    int y = j + d[1];
                    // 当前位置ij向四个方向走, 有比他大的，入°就++
                    if(x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                        out[i][j]++;
                    }
                }
            }
        }
        Deque<int[]> q = new LinkedList<>();
        for(int i = 0; i < n ; i++ ) {
            for(int j = 0; j < m; j++) {
                // 出度为0的点就是值最大的点
                if(out[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int i = 0 ; i < size; i++) {
                int[] t = q.poll();
                int x = t[0], y = t[1];
                for(int[] d : dir) {
                    int xx = x + d[0], yy = y + d[1];
                    // 往值小的方向走
                    if(xx >= 0 && xx < n && yy >= 0 && yy < m && matrix[x][y] > matrix[xx][yy]) {
                        out[xx][yy]--;
                        if(out[xx][yy] == 0) {
                            q.offer(new int[]{xx, yy});
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
