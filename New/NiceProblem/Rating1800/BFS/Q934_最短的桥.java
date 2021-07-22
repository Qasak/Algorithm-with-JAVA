package leetcode.contest.Rating1800.BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 10:01
 */
public class Q934_最短的桥 {
    // [[0,0,0,-2,2],
// [0,0,0,-2,-2],
// [0,0,0,0,0],
// [-1,-1,0,0,0],
// [1,-1,0,0,0]]
    private int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] vis;
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int id = 2;
        boolean flag = false;
        for(int i = 0; i < n; i++)  {
            for(int j = 0; j < n; j++) {
                // 第一组id 2：用-2围绕外圈
                if(grid[i][j] == 1) {
                    vis = new boolean[n][n];
                    change(grid, i, j, id);
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        id--;
        flag = false;
        List<int[]> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 第二组 id1：用-1围绕外圈
                if(!flag && grid[i][j] == 1) {
                    vis = new boolean[n][n];
                    change(grid, i, j, id);
                    flag = true;
                }
                // 记录所有可出发点
                if(grid[i][j] == -2) {
                    int[] t = new int[]{i ,j};
                    list.add(t);
                }
            }
        }
        // createVis(n, grid);
        // for(int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(grid[i]));
        // }
        int ans = 0x3f3f3f3f;
        for(int[] t : list) {
            // 出发的岛全部标记位已经访问
            createVis(n, grid);
            vis[t[0]][t[1]] = false;
            ans = Math.min(ans, bfs(grid, t[0], t[1]));
        }
        return ans;
    }
    private void createVis(int n, int[][] grid) {
        vis = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2 || grid[i][j] == -2) {
                    vis[i][j] = true;
                }
            }
        }
    }
    public void change(int[][] grid, int i, int j, int id) {
        int n = grid.length;
        if(vis[i][j] || grid[i][j] == 0) {
            return;
        }
        vis[i][j] = true;
        boolean flag = false;;
        for(int[] d : dir) {
            int xx = i + d[0], yy = j + d[1];
            if(xx < n && xx >= 0 && yy < n && yy >= 0) {
                if(grid[xx][yy] == 0) {
                    flag = true;
                }
            }
        }
        if(flag) {
            grid[i][j] = -id;
        } else {
            grid[i][j] = id;
        }
        for(int[] d : dir) {
            int xx = i + d[0], yy = j + d[1];
            if(xx < n && xx >= 0 && yy < n && yy >= 0 && !vis[xx][yy] ) {
                change(grid, xx, yy, id);
            }
        }
    }
    public int bfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int dist = 0;
        Deque<int[]> q = new LinkedList<>();
        int[] root = new int[]{i, j};
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] t = q.poll();
                int x = t[0], y = t[1];

                for(int[] d : dir) {
                    int xx = x + d[0], yy = y + d[1];
                    if(xx < n && xx >= 0 && yy < n && yy >= 0) {
                        if(!vis[xx][yy] && grid[xx][yy] != 2 && grid[xx][yy] != -2) {
                            // System.out.println(grid[xx][yy]);
                            if(grid[xx][yy] == -1) {
                                return dist;
                            } else {
                                vis[xx][yy] = true;
                                int[] node = new int[]{xx, yy};
                                q.offer(node);
                            }
                        }
                    }
                }
            }
            dist++;
        }
        return 0x3f3f3f3f;
    }
}
