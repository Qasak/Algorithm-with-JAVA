package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 10:44
 */
public class Q59_GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int cur = 1;
        int end = n * n;
        int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, u = 0, b = n - 1;
        while(cur <= end) {
            for(int i = l; i <= r; i++) {
                matrix[u][i] = cur++;
            }
            u++;
            for(int i = u; i <= b; i++) {
                matrix[i][r] = cur++;
            }
            r--;
            for(int i = r; i >= l; i--) {
                matrix[b][i] = cur++;
            }
            b--;
            for(int i = b; i >= u; i--) {
                matrix[i][l] = cur++;
            }
            l++;
        }
        return matrix;
    }

    int[][] matrix;
    boolean[][] vis;
    int N;
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix1(int n) {
        if(n == 1) {
            return new int[][]{{1}};
        }
        if(n == 2) {
            return new int[][]{{1,2},{4,3}};
        }
        // 0,0 0,1 0,2 1,2 2,2 2,1 2,0 1,0 1,1
        // 0 0 0 1 2 2 2 1 1
        // 0 1 2 2 2 1 0 0 1
        N = n;
        vis = new boolean[n][n];
        matrix = new int[n][n];
        dfs(0, 0, 0, 1);
        return matrix;
    }
    public void dfs(int dir, int i, int j, int cur) {
        vis[i][j] = true;
        matrix[i][j] = cur;
        if(dir == 0) {
            if(j + 1 == N) {
                dir = (dir + 1) % 4;
                dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
            } else if(!vis[i][j + 1]) {
                dfs(dir, i, j + 1, cur + 1);
            } else if(vis[i][j + 1]) {
                dir = (dir + 1) % 4;
                if(!vis[i + d[dir][0]][j + d[dir][1]]) {
                    dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
                }
            }
        } else if(dir == 1) {
            if(i + 1 == N) {
                dir = (dir + 1) % 4;
                dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
            }
            else if(!vis[i + 1][j]) {
                dfs(dir, i + 1, j, cur + 1);
            } else if(vis[i + 1][j]) {
                dir = (dir + 1) % 4;
                if(!vis[i + d[dir][0]][j + d[dir][1]]) {
                    dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
                }
            }
        } else if(dir == 2) {
            if(j - 1 == - 1) {
                dir = (dir + 1) % 4;
                dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
            }
            else if(!vis[i][j - 1]) {
                dfs(dir, i, j - 1, cur + 1);
            } else if(vis[i][j - 1]) {
                dir = (dir + 1) % 4;
                if(!vis[i + d[dir][0]][j + d[dir][1]]) {
                    dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
                }
            }
        } else {
            if(i - 1 == - 1) {
                dir = (dir + 1) % 4;
                dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
            }
            else if(!vis[i - 1][j]) {
                dfs(dir, i - 1, j, cur + 1);
            } else if(vis[i - 1][j]) {
                dir = (dir + 1) % 4;
                if(!vis[i + d[dir][0]][j + d[dir][1]]) {
                    dfs(dir, i + d[dir][0], j + d[dir][1], cur + 1);
                }
            }
        }
    }
}
