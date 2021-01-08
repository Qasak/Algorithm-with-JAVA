package leetcode.template.DP.Dungeon;

import java.util.Arrays;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/1/7 0:06
 */
public class Q714_CherryPick {
    // DP: 两次DP错误：
    /*
        [[1,1,1,1,0,0,0],
        [0,0,0,1,0,0,0],
        [0,0,0,1,0,0,1],
        [1,0,0,1,0,0,0],
        [0,0,0,1,0,0,0],
        [0,0,0,1,0,0,0],
        [0,0,0,1,1,1,1]]
        -> 15
        */
    private void track(int[][] path, int i, int j) {
        if(path[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        if(path[i][j] == 1) {
            if(i > 0) {
                track(path, i - 1, j);
            }
        } else {
            if(j > 0) {
                track(path, i, j - 1);
            }
        }
    }
    private boolean dfs(int i, int j) {
        if(i == n || j == n) {
            return false;
        }
        if(i == n - 1 && j == n - 1) {
            return true;
        }
        if(grid[i][j] >= 0) {
            boolean a = dfs(i + 1, j);
            boolean b = dfs(i, j + 1);
            return a || b;
        } else {
            return false;
        }
    }
    int[][] grid;
    int n;
    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        if(n == 1) {
            return grid[0][0] == 1 ? 1 : 0;
        }
        if(!dfs(0, 0)) {
            return 0;
        }
        int[][] dp = new int[n][n];
        int[][] path = new int[n][n];

        int ans = 0;
        // dp[i][j] = max()
        /*
        [[0, 1, -1],
        [1, 0, -1],
        [1, 1,  1]]
        */

        /*
        [[1,1,-1],
        [1,-1,1],
        [-1,1,1]]

        */


        /*
        [[1,1,1,1,1],
         [1,1,1,1,1],
         [1,1,-1,1,1],
         [0,-1,-1,1,1],
         [1,1,1,1,1]]

        */

        dp[0][0] = grid[0][0] <= 0 ? 0 : grid[0][0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] == -1 ? 0 : grid[0][i] + dp[0][i - 1];
            path[0][i]--;
            dp[i][0] = grid[i][0] == -1 ? 0 : grid[i][0] + dp[i - 1][0];
            path[i][0]++;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                if(grid[i][j] != -1) {
                    // 选择从左边过来的路径
                    if(dp[i - 1][j] < dp[i][j - 1]) {
                        dp[i][j] = grid[i][j] + dp[i][j - 1];
                        path[i][j]--;
                    } else {
                        // 选择从上边过来的路径
                        dp[i][j] = grid[i][j] + dp[i - 1][j];
                        path[i][j]++;
                    }
                    // dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        ans += dp[n - 1][n - 1];
        System.out.println(ans);
        track(path, n - 1, n - 1);
        grid[0][0] = 0;
        for(int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(grid[i]));
            // System.out.println(Arrays.toString(path[i]));
        }
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        dp[n - 1][n - 1] = grid[n - 1][n - 1] <= 0 ? 0 : grid[n - 1][n - 1];
        for(int i = n - 2; i >= 0; i--) {
            dp[n - 1][i] = grid[n - 1][i] == -1 ? 0 : grid[n - 1][i] + dp[n - 1][i + 1];
            dp[i][n - 1] = grid[i][n - 1] == -1 ? 0 : grid[i][n - 1] + dp[i + 1][n - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                if(grid[i][j] != -1) {
                    dp[i][j] = grid[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        // System.out.println(dp[0][0]);

        ans += dp[0][0];
        return ans;
        // System.out.println(dp[n - 1][n - 1]);
    }
    // 正确的DP:两个人同时从左上角走到右下角
    //

}
