package leetcode.SpringRecruit.Recursion;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/4/9 18:18
 */
public class Q695_岛屿的最大面积 {
    int max = 0;
    boolean[][] vis;
    int n;
    int m;
    int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j]) {
                    continue;
                }
                dfs(grid, i, j, 0);
            }
        }
        return max;
    }
    public int dfs(int[][] grid, int i, int j, int cur) {
        if(grid[i][j] == 0) {
            return 0;
        }
        int val = 1;
        vis[i][j] = true;
        for(int[] d: dir) {
            int ii = i + d[0], jj = j + d[1];
            if(ii >= 0 && ii < n && jj >= 0 && jj < m && !vis[ii][jj]) {
                val += dfs(grid, ii, jj, cur + 1);
            }
        }
        max = Math.max(max, val);
        return val;
    }
}
