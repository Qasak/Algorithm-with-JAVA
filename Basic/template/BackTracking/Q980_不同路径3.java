package leetcode.template.BackTracking;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/3/16 15:58
 */
public class Q980_不同路径3 {
    boolean[][] vis;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int ans = 0;
    int need = 0;
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        int si = 0, sj = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    need++;
                }
                if(grid[i][j] == 1) {
                    si = i; sj = j;
                }
            }
        }
        dfs(grid, si, sj, 0);
        return ans;
    }
    public void dfs(int[][] grid, int i, int j, int cnt) {
        int n = grid.length;
        int m = grid[0].length;
        if(vis[i][j] || grid[i][j] == -1) {
            return;
        }
        if(grid[i][j] == 2 ) {
            if(cnt - 1 == need) {
                ans++;
            }
            return;
        }
        vis[i][j] = true;
        for(int[] d : dirs) {
            int ii = i + d[0], jj = j + d[1];
            if(ii < 0 || ii >= n || jj < 0 || jj >= m) {
                continue;
            }
            dfs(grid, ii, jj, cnt + 1);
        }
        vis[i][j] = false;
    }
}
