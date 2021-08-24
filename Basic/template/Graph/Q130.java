package leetcode.template.Graph;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/6 21:13
 */
public class Q130 {
    //dfs
    char[][] gg;
    boolean[][] vis;
    int n;
    int m;
    public void solve(char[][] g) {
        gg = g;
        n = g.length;
        if(n == 0) {
            return;
        }
        m = g[0].length;

        // -1
        /*
        X X X X
        X O O X
        X X O X
        X O O X
        */

        // gg = new int[n][m];
        vis = new boolean[n][m];
        for(int i = 0; i < m; i++) {
            if(g[0][i] == 'O') {
                dfs(0, i);
            }
        }
        for(int i = 0; i < m; i++) {
            if(g[n - 1][i] == 'O') {
                dfs(n - 1, i);
            }
        }
        for(int i = 0; i < n; i++) {
            if(g[i][0] == 'O') {
                dfs(i, 0);
            }
        }
        for(int i = 0; i < n; i++) {
            if(g[i][m - 1] == 'O') {
                dfs(i, m - 1);
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!vis[i][j]) {
                    g[i][j] = 'X';
                }
            }
        }

    }
    private void dfs(int i, int j) {
        if(vis[i][j] || gg[i][j] == 'X') {
            return;
        }
        vis[i][j] = true;
        // gg[i][j] = 1;
        if(i - 1 >= 0) {
            dfs(i - 1, j);
        }
        if(i + 1 < n) {
            dfs(i + 1, j);
        }
        if(j - 1 >= 0) {
            dfs(i, j - 1);
        }
        if(j + 1 < m) {
            dfs(i, j + 1);
        }

    }
}
