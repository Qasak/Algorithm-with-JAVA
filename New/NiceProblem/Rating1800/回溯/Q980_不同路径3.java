package leetcode.contest.Rating1800.回溯;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/7/19 10:06
 */
public class Q980_不同路径3 {
    int need = 0;
    boolean[][] vis;
    int ans = 0;
    int n;
    int m;
    int[][] dir = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
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
        vis[si][sj] = true;
        dfs(si, sj, 0, grid);
        return ans;

    }
    private void dfs(int i, int j, int cur, int[][] grid) {
        if(grid[i][j] == 2) {
            if(cur > need) {
                ans++;
            }
            return;
        }
        for(int[] d : dir) {
            int xx = i + d[0], yy = j + d[1];
            if(xx >= 0 && xx < n && yy >= 0 && yy < m && !vis[xx][yy] && grid[i][j] != -1) {
                vis[xx][yy] = true;
                dfs(xx, yy, cur + 1, grid);
                vis[xx][yy] = false;
            }
        }
    }
}
