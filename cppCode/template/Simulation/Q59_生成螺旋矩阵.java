package leetcode.template.Simulation;

/**
 * @author Wangjs
 * @version 1.0
 * @date 2021/2/1 10:44
 */
public class Q59_生成螺旋矩阵 {
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
    // 模拟2
    public int[][] generateMatrix2(int n) {
        int[][] ans = new int[n][n];
        int u = 0, d = n - 1, l = 0, r = n - 1;
        int t = 1;
        while(true) {
            for(int i = u, j = l; j <= r; j++) {
                ans[i][j] = t++;
            }
            if(++u > d) {
                break;
            }
            for(int i = u, j = r; i <= d; i++) {
                ans[i][j] = t++;
            }
            if(--r < l) {
                break;
            }
            for(int i = d, j = r; j >= l; j--) {
                ans[i][j] = t++;
            }
            if(--d < u) {
                break;
            }
            for(int i = d, j = l; i >= u; i--) {
                ans[i][j] = t++;
            }
            if(++l > r) {
                break;
            }
        }
        return ans;
    }

    // DFS
    int[][] matrix;
    boolean[][] vis;
    int dir = 0;
    int cur = 1;
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] generateMatrix1(int n) {
        vis = new boolean[n][n];
        matrix = new int[n][n];
        dfs(0, 0, n);
        return matrix;
    }
    public void dfs(int i, int j, int n) {
        if(i < 0 || i >= n || j < 0 || j >= n || vis[i][j]) {
            // System.out.println(cur);
            dir++;
            cur--;
            return;
        }
        matrix[i][j] = cur;
        vis[i][j] = true;
        while(cur < n * n) {
            cur++;
            dfs(i + d[dir % 4][0], j + d[dir % 4][1], n);
        }
    }
}
